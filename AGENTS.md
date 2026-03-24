# AGENTS.md

## Project Snapshot
- Spring Boot 3.4 + Java 17 + Maven wrapper (`pom.xml`, `mvnw.cmd`).
- Two-domain layout: `base` = local control data + sync orchestration; `emr` = external EMR view entities/repositories.
- App is backend + static admin UI (`src/main/resources/static/*.html`) served by Spring Boot.

## Architecture You Need First
- Dual JPA data sources are explicit, not auto-configured:
  - `spring.datasource-base` -> `com.clzk.epinet.base.*` via `BaseJpaConfig`.
  - `spring.datasource-view` -> `com.clzk.epinet.emr.*` via `ViewJpaConfig`.
- Incremental sync flow (main business path):
  1. `DataSyncScheduler` reads `sync.frequencies.*` and schedules entity jobs.
  2. `IncrementalSyncExecutor` reads watermark, pulls increments, handles dependencies, pushes outbound.
  3. `QueryService` runs native SQL against the **view** datasource (time field inferred by reflection).
  4. `BaseApiService` maps entity class -> outbound endpoint and calls `HttpClient.post(...)`.
- Dictionary mapping is in-memory and startup-loaded: `DictionaryInitializer` fills `FieldConvertUtil.dicMap`; outbound payload conversion depends on this map.

## Commands (verified in this repo)
```powershell
.\mvnw.cmd -q -DskipTests package
.\mvnw.cmd -q test
```
- No `src/test` directory currently exists; `test` phase succeeds with zero tests.
- Default active profile is `dev` in `src/main/resources/application.yml`.
- For prod behavior, use `-Dspring.profiles.active=prod` (Oracle view datasource + schema prefix behavior).

## Profile/DB Behavior That Affects Code
- `QueryService.getDynamicTableName(...)` changes schema by profile:
  - `dev`: table only
  - `prod`: `BSPHIS_BASE.<TABLE>`
- `ViewJpaConfig` sets Oracle dialect and session NLS init SQL; keep this in mind for time/date queries.
- Watermark default is `LocalDateTime.now()` when missing (`SyncWatermarkService`), so first run does **not** backfill historical data unless adjusted.

## API and UI Integration Points
- Static pages call backend with hardcoded `http://localhost:8080` URLs (`index.html`, `dict-edit.html`, `dept-edit.html`, `logs.html`).
- Main REST surfaces:
  - Dictionary mapping: `/emr/dic/**`
  - Dept mapping/support: `/emr/dept/**`
  - Manual sync triggers: `/emr/sync/**`
  - API call logs: `/logs/**`
- Outbound EMR target is `api.base-url`; endpoint suffixes are hardcoded in `BaseApiService.init()`.

## Project-Specific Conventions
- Entity **simple class name** is a key in multiple places:
  - `sync.frequencies.<SimpleName>`
  - watermark `entity_type`
  - scheduler order (`DataSyncScheduler.syncOrder`)
- Adding a new sync entity usually requires coordinated edits in:
  - `emr/model` (`@Table` + id/time/org fields as needed)
  - `BaseApiService` URL map
  - `DataSyncScheduler.syncOrder`
  - `application.yml` `sync.frequencies`
  - Optional dependency hooks in `IncrementalSyncExecutor` (`handleDependenciesIfNeeded`, `handleAfterIfNeeded`)
- `ApiLogAspect` logs only methods annotated with `@ApiLog` (currently `HttpClient.post`), persisted to `api_call_logs`.

## GraphQL Reality Check
- Schema files exist under `src/main/resources/graphql/**`, but runtime wiring is minimal (`GraphQLConfig` has a placeholder `Query.books`).
- Treat GraphQL as partially wired; verify resolver coverage before building new GraphQL features.

## Practical Caveats
- SQL seeds are large (`src/main/resources/sql/*.sql`); verify table names match your DB schema before running (`emr_dictionary` entity exists, while `emr_dic_init.sql` uses `emr_dic`).
- CORS is fully open in `CorsConfig`; preserve only if intended for your deployment.

