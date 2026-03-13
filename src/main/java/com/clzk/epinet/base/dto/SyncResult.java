package com.clzk.epinet.base.dto;

/**
 * 单次增量同步的结果
 */
public class SyncResult {

    private final boolean success;      // 是否全部成功
    private final int total;            // 本次查询到的总条数
    private final int successCount;     // 成功同步的条数
    private final String message;       // 简要说明（可选）

    // 静态工厂方法，便于创建

    public static SyncResult noData() {
        return new SyncResult(true, 0, 0, "无增量数据");
    }

    public static SyncResult success(int successCount, int total) {
        return new SyncResult(true, total, successCount, "全部成功: " + successCount + "/" + total);
    }

    public static SyncResult partial(int successCount, int total) {
        return new SyncResult(false, total, successCount, "部分成功: " + successCount + "/" + total);
    }

    public static SyncResult failed(int total, String reason) {
        return new SyncResult(false, total, 0, "同步失败: " + reason);
    }

    // 私有构造
    private SyncResult(boolean success, int total, int successCount, String message) {
        this.success = success;
        this.total = total;
        this.successCount = successCount;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getTotal() {
        return total;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getFailedCount() {
        return total - successCount;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SyncResult{" +
                "success=" + success +
                ", total=" + total +
                ", successCount=" + successCount +
                ", message='" + message + '\'' +
                '}';
    }
}