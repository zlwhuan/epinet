#!/bin/bash

# ====================== 配置与颜色 ======================
export LD_LIBRARY_PATH=/usr/lib64:$LD_LIBRARY_PATH

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

CONFIG_FILE="/home/hclient/config.properties"
DATA_FILE="/root/org.txt"
LOG_LEVEL="INFO"
REQUEST_TIMEOUT=120

# ====================== 日志函数 ======================
log_info()  { [[ "$LOG_LEVEL" == "INFO" || "$LOG_LEVEL" == "DEBUG" ]] && echo -e "${GREEN}[INFO]${NC} $1"; }
log_debug() { [[ "$LOG_LEVEL" == "DEBUG" ]] && echo -e "${YELLOW}[DEBUG]${NC} $1"; }
log_warn()  { echo -e "${YELLOW}[WARN]${NC} $1"; }
log_error() { echo -e "${RED}[ERROR]${NC} $1" >&2; }

# 安全清理临时目录（空值/不存在目录时不处理）
cleanup_temp_dir() {
    local dir="$1"
    [ -z "$dir" ] && return 0
    [ ! -d "$dir" ] && return 0
    rm -rf "$dir"
}

# ================== 请在这里完整粘贴以下函数 ==================

# 生成昨天日期 yyyy-MM-dd 格式
generate_date() {
    date -d 'yesterday' '+%Y-%m-%d'
}
# 生成 08:00:00 到 18:00:00 的随机时间
generate_random_time() {
    local start=$((8 * 3600))   # 08:00:00 转秒
    local end=$((18 * 3600))    # 18:00:00 转秒

    # 生成 start ~ end 之间的随机秒数
    local rand=$((RANDOM % (end - start + 1) + start))

    # 计算小时、分钟、秒
    local hh=$((rand / 3600))
    local mm=$(((rand % 3600) / 60))
    local ss=$((rand % 60))

    # 格式化输出 HH:mm:ss
    printf "%02d:%02d:%02d\n" "$hh" "$mm" "$ss"
}

# 根据入参时间随机增加 1-60 分钟 + 随机秒
# 入参格式：HH:mm:ss
add_random_time() {
    local input_time="$1"

    # 随机 1~60 分钟
    local add_min=$((RANDOM % 60 + 1))

    # 随机 0~59 秒
    local add_sec=$((RANDOM % 60))

    # 今天日期
    local today=$(date '+%Y-%m-%d')

    # 转换成时间戳
    local timestamp=$(date -d "${today} ${input_time}" +%s)

    # 加随机分钟和秒
    local new_ts=$((timestamp + add_min*60 + add_sec))

    # 输出时间（只要 HH:mm:ss）
    date -d "@${new_ts}" "+%H:%M:%S"
}



# 生成随机手机号函数
generate_random_phone() {
    # 中国手机号段前缀（三大运营商）
    local prefixes=("130" "131" "132" "133" "134" "135" "136" "137" "138" "139"
                    "145" "147" "149" "150" "151" "152" "153" "155" "156" "157" "158" "159"
                    "165" "166" "167" "170" "171" "172" "173" "174" "175" "176" "177" "178"
                    "180" "181" "182" "183" "184" "185" "186" "187" "188" "189"
                    "191" "198" "199")

    # 随机选择前缀
    local prefix=${prefixes[$RANDOM % ${#prefixes[@]}]}

    # 生成后8位随机数字
    local suffix=$(printf "%08d" $((RANDOM % 100000000)))

    echo "${prefix}${suffix}"
}

# 智能地址搜索（简洁版）
get_region_info() {
    local code="$1"

    if [ -z "$DATA_FILE" ] || [ ! -f "$DATA_FILE" ]; then
        return 1
    fi

    # 尝试的代码列表
    local codes_to_try=("$code")

    # 添加市级代码
    if [ ${#code} -ge 6 ]; then
        codes_to_try+=("${code:0:6}000")
    fi

    # 添加省级代码
    if [ ${#code} -ge 3 ]; then
        codes_to_try+=("${code:0:3}000000")
    fi

    # echo "尝试的代码列表: ${codes_to_try[*]}" >&2

    # 按顺序尝试
    for try_code in "${codes_to_try[@]}"; do
        # echo "正在尝试代码: $try_code" >&2
        local line=$(grep "^$try_code " "$DATA_FILE" 2>/dev/null)
        # local line=$(grep "^$search_value " "$DATA_FILE" 2>/dev/null | tr -d '\r\n')

        if [ -n "$line" ]; then
            # echo "匹配成功: $try_code" >&2
            echo "$line"
            return 0
        fi
    done

    echo "所有尝试都失败" >&2
    return 1
}

# 生成随机科室函数
generate_random_dept() {
    # 常见姓氏
    local depts=("A01 预防保健科" "A02 全科医疗科" "A03 内科" "A04 外科" "A05 妇产科" "A05.01 妇科专业" "A05.02 产科专业" "A07 儿科" "A10 眼科" "A11 耳鼻咽喉科" "A12 口腔科" "A13 皮肤科" "A15 精神卫生专业" "A16 传染科" "A20 急诊医学科" "A21 康复医学科" "A26 麻醉科" "A30 医学检验科" "A30.01 临床体液、血液专业" "A30.03 临床生化检验专业" "A30.04 临床免疫、血清学专业" "A32 医学影像科" "A32.01 X 线诊断专业" "A32.05 超声诊断专业" "A32.06 心电诊断专业" "A06 妇女保健科" "A09 儿童保健科" "A23.05 职业健康监护专业" "A53 发热门诊（诊室）")

    # 随机选择
    local dept=${depts[$RANDOM % ${#depts[@]}]}

    echo "${dept}"
}

# 生成随机姓名函数
generate_random_name() {
    # 常见姓氏
    local surnames=("赵" "钱" "孙" "李" "周" "吴" "郑" "王" "冯" "陈" "褚" "卫" "蒋" "沈" "韩" "杨" "朱" "秦" "尤" "许"
              "何" "吕" "施" "张" "孔" "曹" "严" "华" "金" "魏" "陶" "姜" "戚" "谢" "邹" "喻" "柏" "水" "窦" "章"
              "云" "苏" "潘" "葛" "奚" "范" "彭" "郎" "鲁" "韦" "马" "苗" "凤" "花" "方" "俞" "任" "袁" "柳" "酆"
              "鲍" "史" "唐" "费" "廉" "岑" "薛" "雷" "贺" "倪" "汤" "滕" "殷" "罗" "毕" "郝" "邬" "安" "常" "乐")

    # 常见名字（男女通用）
    local given_names=("明" "华" "伟" "强" "磊" "军" "涛" "鹏" "杰" "超" "勇" "峰" "芳" "娜" "敏" "静" "丽" "艳" "婷" "倩"
                 "娟" "琳" "浩" "宇" "俊" "旭" "坤" "阳" "辉" "亮" "龙" "翔" "鑫" "森" "林" "波" "帆" "瑞" "哲" "诚"
                 "博" "文" "昊" "轩" "宸" "睿" "泽" "洋" "悦" "怡" "欣" "瑶" "琪" "莹" "雪" "雯" "雅" "慧" "佳" "洁"
                 "彬" "宏" "志" "建" "振" "海" "金" "国" "春" "秋" "冬" "夏" "晨" "晓" "星" "辰" "月" "雨" "风" "云"
                 # 单字名
                "伟" "芳" "娜" "敏" "静" "丽" "强" "磊" "军" "洋" "勇" "艳" "杰" "娟" "涛" "明" "超" "霞" "平" "刚"
                "文" "华" "建" "红" "鹏" "波" "涛" "浩" "宇" "宁" "健" "俊" "峰" "亮" "凯" "翔" "鑫" "博" "诚" "达"
                "飞" "光" "海" "辉" "江" "龙" "民" "山" "森" "涛" "威" "武" "祥" "旭" "阳" "毅" "勇" "宇" "云" "泽"
                "安" "彬" "斌" "昌" "超" "晨" "成" "川" "栋" "帆" "凡" "风" "峰" "钢" "国" "航" "豪" "昊" "浩" "赫"
                "宏" "虎" "华" "辉" "吉" "佳" "剑" "健" "杰" "金" "晋" "靖" "军" "君" "俊" "凯" "康" "柯" "可" "坤"
                "乐" "雷" "力" "立" "亮" "林" "琳" "麟" "龙" "马" "迈" "满" "茂" "民" "明" "铭" "宁" "鹏" "平" "奇"
                "琦" "启" "强" "清" "庆" "权" "群" "荣" "瑞" "润" "森" "山" "杉" "善" "尚" "绍" "生" "胜" "盛" "石"
                "实" "士" "书" "树" "双" "顺" "松" "泰" "涛" "腾" "田" "铁" "庭" "挺" "通" "同" "旺" "威" "为" "维"
                "伟" "卫" "文" "武" "熙" "喜" "先" "贤" "祥" "翔" "晓" "孝" "笑" "心" "新" "欣" "信" "兴" "星" "行"
                "雄" "旭" "轩" "学" "勋" "亚" "岩" "炎" "彦" "扬" "阳" "尧" "业" "烨" "一" "义" "艺" "易" "毅" "银"
                "英" "营" "勇" "友" "瑜" "宇" "羽" "雨" "玉" "元" "源" "远" "岳" "悦" "跃" "云" "允" "运" "泽" "增"
                "展" "占" "章" "钊" "昭" "兆" "哲" "真" "振" "镇" "征" "峥" "铮" "政" "之" "知" "植" "志" "智" "中"
                "忠" "钟" "仲" "舟" "洲" "周" "珠" "竹" "柱" "庄" "壮" "卓" "子" "宗" "祖" "尊" "佐" "作" "安" "邦"

                # 双字名
                "秀英" "桂英" "玉兰" "金凤" "建国" "淑珍" "秀珍" "桂兰" "桂珍" "凤英" "兰英" "桂荣" "桂芳" "玉珍" "玉英"
                "玉华" "玉梅" "玉荣" "春梅" "秋菊" "冬梅" "夏莲" "春花" "秋月" "春燕" "秋燕" "冬燕" "夏荷" "春华" "秋实"
                "冬青" "夏雨" "春雨" "秋风" "冬雪" "夏雪" "春雪" "秋雪" "冬雨" "夏风" "春风" "秋风" "冬风" "夏阳" "春阳"
                "秋阳" "冬阳" "夏云" "春云" "秋云" "冬云" "夏星" "春星" "秋星" "冬星" "夏夜" "春夜" "秋夜" "冬夜" "夏晨"
                "春晨" "秋晨" "冬晨" "夏午" "春午" "秋午" "冬午" "夏暮" "春暮" "秋暮" "冬暮" "夏曦" "春曦" "秋曦" "冬曦"
                "明辉" "光辉" "文辉" "志强" "国强" "家强" "永强" "大伟" "宏伟" "志伟" "俊杰" "英杰" "豪杰" "文杰" "智杰"
                "明杰" "志杰" "天佑" "天宇" "天翔" "天华" "天龙" "天明" "天翼" "天瑞" "天泽" "天磊" "天浩" "天昊" "天赐"
                "浩宇" "浩然" "浩瀚" "浩博" "浩轩" "浩南" "浩东" "浩洋" "浩天" "浩翔" "俊宇" "俊杰" "俊熙" "俊豪" "俊彦"
                "俊逸" "俊朗" "俊峰" "俊楠" "俊驰" "俊凯" "文博" "文轩" "文昊" "文浩" "文彬" "文斌" "文涛" "文杰" "文辉"
                "文强" "文龙" "文虎" "文豹" "文明" "文亮" "文远" "文山" "文海" "文江" "文河" "文湖" "文泉" "文渊" "文源"
                "志远" "志明" "志强" "志勇" "志刚" "志伟" "志鹏" "志高" "志宏" "志华" "志国" "志军" "志文" "志斌" "志新"
                "建国" "建华" "建军" "建平" "建明" "建强" "建文" "建斌" "建辉" "建龙" "建峰" "建民" "建新" "建宇" "建豪"
                "永强" "永胜" "永康" "永安" "永福" "永祥" "永华" "永明" "永辉" "永杰" "永刚" "永志" "永贵" "永富" "永财"
                "永发" "永旺" "永兴" "永盛" "永昌" "永宁" "永平" "永乐" "永庆" "永军" "永涛" "永波" "永浩" "永亮" "永峰"

                # 现代风格名字
                "梓轩" "梓涵" "梓睿" "梓豪" "梓晨" "梓晴" "梓萱" "梓琪" "梓欣" "梓悦" "梓妍" "梓琳" "梓婷" "梓雯" "梓萌"
                "梓玥" "梓欣" "梓怡" "梓璇" "梓瑶" "梓莹" "梓诺" "梓涵" "梓熙" "梓瑞" "梓铭" "梓航" "梓恒" "梓洋" "梓浩"
                "梓昊" "梓轩" "梓骏" "梓宸" "梓硕" "梓晨" "梓煜" "梓鑫" "梓凯" "梓杰" "梓文" "梓彬" "梓涛" "梓龙" "梓峰"
                "宇轩" "宇航" "宇涵" "宇浩" "宇辰" "宇泽" "宇翔" "宇阳" "宇宸" "宇硕" "宇昊" "宇轩" "宇豪" "宇彬" "宇哲"
                "宇鑫" "宇鹏" "宇杰" "宇峰" "宇龙" "宇涛" "宇辉" "宇明" "宇亮" "宇飞" "宇星" "宇辰" "宇晨" "宇宁" "宇安"
                "浩然" "浩宇" "浩瀚" "浩博" "浩轩" "浩南" "浩东" "浩洋" "浩天" "浩翔" "浩辰" "浩楠" "浩霖" "浩宇" "浩然"
                "浩轩" "浩博" "浩南" "浩东" "浩洋" "浩天" "浩翔" "浩辰" "浩楠" "浩霖" "思源" "思远" "思宇" "思琪" "思涵"
                "思雨" "思彤" "思怡" "思颖" "思睿" "思诚" "思明" "思文" "思杰" "思源" "思远" "思宇" "思琪" "思涵" "思雨"
                "思彤" "思怡" "思颖" "思睿" "思诚" "思明" "思文" "思杰" "欣怡" "欣然" "欣悦" "欣然" "欣妍" "欣然" "欣然"
                "欣怡" "欣然" "欣悦" "欣然" "欣妍" "欣然" "欣然" "欣然" "欣然" "欣然" "欣然" "欣然" "欣然" "欣然" "欣然"

                # 传统优雅名字
                "婉如" "婉婷" "婉容" "婉清" "婉君" "婉仪" "婉静" "婉淑" "婉华" "婉秋" "婉月" "婉星" "婉云" "婉风" "婉雪"
                "诗涵" "诗雨" "诗琪" "诗雅" "诗雯" "诗婷" "诗悦" "诗萌" "诗妍" "诗韵" "诗音" "诗梦" "诗画" "诗语" "诗琳"
                "雅婷" "雅静" "雅雯" "雅欣" "雅琪" "雅涵" "雅琴" "雅菲" "雅楠" "雅芝" "雅琳" "雅晴" "雅洁" "雅慧" "雅诗"
                "雨婷" "雨欣" "雨涵" "雨晴" "雨洁" "雨薇" "雨萱" "雨桐" "雨菲" "雨嫣" "雨珊" "雨梦" "雨露" "雨辰" "雨泽"
                "梦婷" "梦瑶" "梦琪" "梦洁" "梦雨" "梦菲" "梦涵" "梦媛" "梦颖" "梦雪" "梦云" "梦月" "梦星" "梦晨" "梦露"
                "佳琪" "佳欣" "佳慧" "佳怡" "佳悦" "佳雯" "佳琳" "佳莹" "佳妮" "佳璐" "佳瑶" "佳鑫" "佳明" "佳豪" "佳伟"
                "雪婷" "雪梅" "雪莲" "雪琴" "雪萍" "雪莹" "雪娇" "雪莉" "雪华" "雪峰" "雪松" "雪涛" "雪飞" "雪峰" "雪松"
                "晓婷" "晓雯" "晓静" "晓丽" "晓燕" "晓峰" "晓明" "晓辉" "晓东" "晓华" "晓光" "晓军" "晓波" "晓涛" "晓勇"

                # 男孩阳刚名字
                "震宇" "震霆" "震天" "震岳" "震海" "震山" "震林" "震川" "震东" "震南" "震西" "震北" "震中" "震华" "震国"
                "雄伟" "宏伟" "雄伟" "伟岸" "伟杰" "伟诚" "伟志" "伟峰" "伟民" "伟华" "伟国" "伟军" "伟文" "伟斌" "伟强"
                "英勇" "英杰" "英豪" "英俊" "英明" "英武" "英华" "英才" "英杰" "英睿" "英达" "英博" "英凯" "英勋" "英泽"
                "刚毅" "刚强" "刚健" "刚正" "刚勇" "刚豪" "刚烈" "刚锋" "刚亮" "刚明" "刚华" "刚杰" "刚文" "刚武" "刚雄"
                "智勇" "智强" "智杰" "智明" "智华" "智渊" "智博" "智鑫" "智鹏" "智宇" "智轩" "智豪" "智凯" "智辉" "智伟"
                "睿智" "睿明" "睿哲" "睿博" "睿轩" "睿涵" "睿泽" "睿渊" "睿聪" "睿达" "睿思" "睿识" "睿智" "睿明" "睿哲"

                # 女孩温柔名字
                "淑媛" "淑华" "淑娟" "淑芬" "淑芳" "淑兰" "淑珍" "淑琴" "淑英" "淑萍" "淑惠" "淑雅" "淑静" "淑贞" "淑婉"
                "惠芬" "惠芳" "惠兰" "惠珍" "惠琴" "惠英" "惠萍" "惠娟" "惠琳" "惠婷" "惠敏" "惠洁" "惠美" "惠丽" "惠雅"
                "美玲" "美华" "美芳" "美兰" "美珍" "美琴" "美英" "美萍" "美娟" "美琳" "美婷" "美惠" "美洁" "美静" "美玉"
                "丽华" "丽芳" "丽娟" "丽萍" "丽娜" "丽丽" "丽莎" "丽英" "丽珍" "丽琴" "丽君" "丽雅" "丽婷" "丽媛" "丽颖"
                "秀娟" "秀芳" "秀兰" "秀英" "秀珍" "秀琴" "秀萍" "秀华" "秀美" "秀清" "秀云" "秀峰" "秀山" "秀水" "秀林"
                "婷婷" "婷玉" "婷芳" "婷美" "婷秀" "婷雅" "婷悦" "婷丽" "婷娜" "婷雨" "婷云" "婷月" "婷星" "婷晨" "婷晚"

                # 中性名字
                "子涵" "子轩" "子睿" "子豪" "子晨" "子晴" "子萱" "子琪" "子欣" "子悦" "子妍" "子琳" "子婷" "子雯" "子萌"
                "若曦" "若涵" "若轩" "若晴" "若兰" "若雨" "若云" "若风" "若水" "若山" "若林" "若华" "若英" "若飞" "若鹏"
                "逸飞" "逸凡" "逸轩" "逸晨" "逸风" "逸云" "逸尘" "逸仙" "逸群" "逸兴" "逸致" "逸韵" "逸雅" "逸美" "逸静"
                "晨曦" "晨光" "晨星" "晨辉" "晨宇" "晨晨" "晨阳" "晨风" "晨露" "晨雾" "晨霜" "晨雪" "晨雨" "晨虹" "晨霞"
                "星辰" "星河" "星海" "星云" "星光" "星辉" "星宇" "星晨" "星月" "星雨" "星风" "星火" "星汉" "星罗" "星驰"
                "明月" "明辉" "明光" "明华" "明杰" "明睿" "明智" "明达" "明哲" "明诚" "明德" "明志" "明远" "明静" "明秀"

                # 补充更多名字
                "嘉欣" "嘉怡" "嘉悦" "嘉雯" "嘉琳" "嘉莹" "嘉妮" "嘉璐" "嘉瑶" "嘉鑫" "嘉明" "嘉豪" "嘉伟" "嘉俊" "嘉杰"
                "瑞雪" "瑞霞" "瑞云" "瑞霖" "瑞泽" "瑞祥" "瑞安" "瑞丰" "瑞华" "瑞金" "瑞银" "瑞宝" "瑞珍" "瑞珠" "瑞玉"
                "紫萱" "紫嫣" "紫菱" "紫薇" "紫霞" "紫烟" "紫云" "紫宸" "紫阳" "紫光" "紫金" "紫玉" "紫晶" "紫檀" "紫苏"
                "青霞" "青松" "青山" "青水" "青云" "青风" "青雨" "青雪" "青霜" "青露" "青雾" "青虹" "青鸾" "青凤" "青龙"
                "红梅" "红叶" "红霞" "红云" "红光" "红星" "红日" "红月" "红雨" "红雪" "红霜" "红露" "红雾" "红虹" "红鸾"
                "白云" "白雪" "白露" "白霜" "白雾" "白虹" "白龙" "白虎" "白鹤" "白鸽" "白鹭" "白杨" "白桦" "白松" "白梅"
                "金光" "金辉" "金鑫" "金玉" "金珠" "金宝" "金凤" "金龙" "金虎" "金豹" "金狮" "金鹰" "金鹏" "金蝉" "金鱼"
                "银光" "银辉" "银鑫" "银玉" "银珠" "银宝" "银凤" "银龙" "银虎" "银豹" "银狮" "银鹰" "银鹏" "银蝉" "银鱼"
                "玉龙" "玉虎" "玉豹" "玉狮" "玉鹰" "玉鹏" "玉蝉" "玉鱼" "玉凤" "玉凰" "玉燕" "玉雀" "玉鸽" "玉鹭" "玉鹤"
                "宝珠" "宝玉" "宝珍" "宝钗" "宝琴" "宝瑟" "宝鼎" "宝炉" "宝瓶" "宝镜" "宝剑" "宝刀" "宝弓" "宝箭" "宝盾"

                # 现代创新名字
                "昊然" "昊宇" "昊明" "昊辉" "昊天" "昊辰" "昊阳" "昊轩" "昊睿" "昊洋" "昊东" "昊南" "昊西" "昊北" "昊中"
                "宸宇" "宸轩" "宸睿" "宸阳" "宸辉" "宸光" "宸星" "宸月" "宸风" "宸雨" "宸雪" "宸露" "宸霜" "宸雾" "宸虹"
                "梓宸" "梓睿" "梓豪" "梓轩" "梓洋" "梓浩" "梓昊" "梓晨" "梓煜" "梓鑫" "梓凯" "梓杰" "梓文" "梓彬" "梓涛"
                "诺涵" "诺轩" "诺言" "诺诚" "诺信" "诺亚" "诺依" "诺心" "诺思" "诺梦" "诺雨" "诺云" "诺风" "诺雪" "诺露"
                "依诺" "依琳" "依婷" "依娜" "依静" "依柔" "依美" "依云" "依风" "依雨" "依雪" "依露" "依霜" "依雾" "依虹"
                "梦瑶" "梦琪" "梦婷" "梦洁" "梦雨" "梦菲" "梦涵" "梦媛" "梦颖" "梦雪" "梦云" "梦月" "梦星" "梦晨" "梦露"
                "诗瑶" "诗琪" "诗婷" "诗洁" "诗雨" "诗菲" "诗涵" "诗媛" "诗颖" "诗雪" "诗云" "诗月" "诗星" "诗晨" "诗露"
                "雨瑶" "雨琪" "雨婷" "雨洁" "雨薇" "雨萱" "雨桐" "雨菲" "雨嫣" "雨珊" "雨梦" "雨露" "雨辰" "雨泽" "雨风"
                "雪瑶" "雪琪" "雪婷" "雪洁" "雪薇" "雪萱" "雪桐" "雪菲" "雪嫣" "雪珊" "雪梦" "雪露" "雪辰" "雪泽" "雪风"

                # 地域特色名字
                "京生" "京华" "京辉" "京宇" "京鹏" "京龙" "京虎" "京豹" "京狮" "京鹰" "京鹏" "京鹤" "京燕" "京雀" "京鸽"
                "沪生" "沪华" "沪辉" "沪宇" "沪鹏" "沪龙" "沪虎" "沪豹" "沪狮" "沪鹰" "沪鹏" "沪鹤" "沪燕" "沪雀" "沪鸽"
                "粤生" "粤华" "粤辉" "粤宇" "粤鹏" "粤龙" "粤虎" "粤豹" "粤狮" "粤鹰" "粤鹏" "粤鹤" "粤燕" "粤雀" "粤鸽"
                "川生" "川华" "川辉" "川宇" "川鹏" "川龙" "川虎" "川豹" "川狮" "川鹰" "川鹏" "川鹤" "川燕" "川雀" "川鸽"
                "湘生" "湘华" "湘辉" "湘宇" "湘鹏" "湘龙" "湘虎" "湘豹" "湘狮" "湘鹰" "湘鹏" "湘鹤" "湘燕" "湘雀" "湘鸽"
                "闽生" "闽华" "闽辉" "闽宇" "闽鹏" "闽龙" "闽虎" "闽豹" "闽狮" "闽鹰" "闽鹏" "闽鹤" "闽燕" "闽雀" "闽鸽"

                # 四季名字
                "春生" "春华" "春辉" "春宇" "春鹏" "春龙" "春虎" "春豹" "春狮" "春鹰" "春鹏" "春鹤" "春燕" "春雀" "春鸽"
                "夏生" "夏华" "夏辉" "夏宇" "夏鹏" "夏龙" "夏虎" "夏豹" "夏狮" "夏鹰" "夏鹏" "夏鹤" "夏燕" "夏雀" "夏鸽"
                "秋生" "秋华" "秋辉" "秋宇" "秋鹏" "秋龙" "秋虎" "秋豹" "秋狮" "秋鹰" "秋鹏" "秋鹤" "秋燕" "秋雀" "秋鸽"
                "冬生" "冬华" "冬辉" "冬宇" "冬鹏" "冬龙" "冬虎" "冬豹" "冬狮" "冬鹰" "冬鹏" "冬鹤" "冬燕" "冬雀" "冬鸽"

                # 五行名字
                "金生" "金旺" "金辉" "金宇" "金鹏" "金龙" "金虎" "金豹" "金狮" "金鹰" "金鹏" "金鹤" "金燕" "金雀" "金鸽"
                "木生" "木旺" "木辉" "木宇" "木鹏" "木龙" "木虎" "木豹" "木狮" "木鹰" "木鹏" "木鹤" "木燕" "木雀" "木鸽"
                "水生" "水旺" "水辉" "水宇" "水鹏" "水龙" "水虎" "水豹" "水狮" "水鹰" "水鹏" "水鹤" "水燕" "水雀" "水鸽"
                "火生" "火旺" "火辉" "火宇" "火鹏" "火龙" "火虎" "火豹" "火狮" "火鹰" "火鹏" "火鹤" "火燕" "火雀" "火鸽"
                "土生" "土旺" "土辉" "土宇" "土鹏" "土龙" "土虎" "土豹" "土狮" "土鹰" "土鹏" "土鹤" "土燕" "土雀" "土鸽"

                # 数字名字
                "一鸣" "一帆" "一凡" "一飞" "一航" "一鸣" "一山" "一水" "一林" "一木" "一石" "一铁" "一金" "一银" "一铜"
                "二龙" "二虎" "二豹" "二狮" "二鹰" "二鹏" "二鹤" "二燕" "二雀" "二鸽" "二凤" "二凰" "二龙" "二虎" "二豹"
                "三强" "三勇" "三杰" "三英" "三雄" "三豪" "三伟" "三光" "三辉" "三明" "三亮" "三华" "三国" "三军" "三民"
                "四海" "四洋" "四洲" "四宇" "四维" "四方" "四平" "四安" "四宁" "四静" "四和" "四谐" "四美" "四全" "四喜"
                "五福" "五禄" "五寿" "五喜" "五财" "五金" "五木" "五水" "五火" "五土" "五谷" "五果" "五蔬" "五药" "五宝"
                 )

    # 随机选择
    local surname=${surnames[$RANDOM % ${#surnames[@]}]}
    local given_name=${given_names[$RANDOM % ${#given_names[@]}]}

    echo "${surname}${given_name}"
}

# 生成随机小区名字加门牌号
generate_random_address() {
    # 小区常见名称前缀
    local community_prefixes=("阳光" "金色" "幸福" "和谐" "平安" "温馨" "美丽" "绿色" "山水" "江南"
                             "东方" "南方" "西方" "北方" "中央" "国际" "世纪" "城市" "现代" "未来"
                             "万科" "恒大" "碧桂园" "保利" "中海" "华润" "绿地" "龙湖" "融创" "世茂"
                             "锦绣" "华府" "名苑" "花园" "家园" "公寓" "别墅" "山庄" "公馆" "小区"
                             "春晓" "夏威夷" "秋实" "冬韵" "四季" "星辰" "月亮湾" "太阳城" "凤凰" "麒麟")

    # 小区常见名称后缀
    local community_suffixes=("花园" "家园" "小区" "公寓" "华庭" "名苑" "华府" "公馆" "别墅" "山庄"
                             "新城" "广场" "中心" "国际" "大厦" "街区" "里" "坊" "院" "巷")

    # 随机生成小区名
    local prefix=${community_prefixes[$RANDOM % ${#community_prefixes[@]}]}
    local suffix=${community_suffixes[$RANDOM % ${#community_suffixes[@]}]}
    local community_name="${prefix}${suffix}"

    # 随机生成楼栋号（1-30栋）
    local building=$((RANDOM % 30 + 1))

    # 随机生成单元号（1-4单元）
    local unit=$((RANDOM % 4 + 1))

    # 随机生成门牌号（1-30层，每层1-6户）
    local floor=$((RANDOM % 30 + 1))
    local room=$((RANDOM % 6 + 1))

    # 随机选择地址格式
    local format=$((RANDOM % 4))

    case $format in
        0)
            # 格式1: 小区名 X栋X单元XXX室
            echo "${community_name}${building}栋${unit}单元${floor}${room}室"
            ;;
        1)
            # 格式2: 小区名 X号楼 X单元 XXX室
            echo "${community_name}${building}号楼${unit}单元${floor}${room}室"
            ;;
        2)
            # 格式3: 小区名 X-X-XXX
            echo "${community_name}${building}-${unit}-${floor}${room}"
            ;;
        3)
            # 格式4: 小区名 X幢X单元XXX号
            echo "${community_name}${building}幢${unit}单元${floor}${room}号"
            ;;
    esac
}

# 根据身份证号生成生日（格式：1997-12-12）
generate_birthday_from_id() {
    local id_card="$1"

    if [ ${#id_card} -ne 18 ]; then
        echo "错误: 身份证号长度应为18位" >&2
        return 1
    fi

    # 提取生日部分（第7-14位）
    local birthday_part="${id_card:6:8}"  # 从第7位开始取8位

    # 格式化为 yyyy-MM-dd
    local year="${birthday_part:0:4}"
    local month="${birthday_part:4:2}"
    local day="${birthday_part:6:2}"

    echo "${year}-${month}-${day}"
}

# 生成随机工作单位函数
generate_random_work_unit() {
    # 常见公司类型
    local company_types=("科技" "信息" "技术" "电子" "软件" "网络" "数据" "智能" "数字" "云计算"
                         "医疗" "健康" "生物" "医药" "医院" "诊所" "康复" "检验"
                         "教育" "培训" "学校" "学院" "大学" "研究院" "教育科技"
                         "金融" "银行" "证券" "保险" "投资" "信托" "基金" "财务"
                         "制造" "工业" "机械" "设备" "汽车" "化工" "材料" "能源"
                         "贸易" "商贸" "商业" "零售" "批发" "供应链" "物流" "仓储"
                         "建筑" "工程" "设计" "规划" "房地产" "物业" "装饰"
                         "文化" "传媒" "广告" "影视" "娱乐" "游戏" "体育"
                         "服务" "咨询" "管理" "法律" "会计" "人力资源" "餐饮" "旅游")

    # 常见公司后缀
    local company_suffixes=("有限公司" "股份有限公司" "集团公司" "有限责任公司" "分公司"
                           "研究院" "研究所" "中心" "事务所" "工作室" "厂" "店")

    # 常见地名前缀
    local location_prefixes=("北京" "上海" "广州" "深圳" "杭州" "南京" "武汉" "成都" "重庆" "天津"
                           "西安" "沈阳" "哈尔滨" "长春" "济南" "青岛" "厦门" "福州" "长沙" "郑州"
                           "河北" "山西" "辽宁" "吉林" "黑龙江" "江苏" "浙江" "安徽" "福建" "江西"
                           "山东" "河南" "湖北" "湖南" "广东" "海南" "四川" "贵州" "云南" "陕西"
                           "甘肃" "青海" "内蒙古" "广西" "宁夏" "新疆" "西藏")

    # 随机公司名
    local random_names=("华为" "腾讯" "阿里巴巴" "百度" "字节跳动" "京东" "美团" "拼多多" "网易" "小米"
                       "中兴" "联想" "海尔" "格力" "美的" "中国移动" "中国联通" "中国电信"
                       "工商银行" "建设银行" "农业银行" "中国银行" "交通银行"
                       "平安保险" "中国人寿" "太平洋保险" "泰康保险"
                       "清华大学" "北京大学" "复旦大学" "上海交通大学" "浙江大学"
                       "人民医院" "中心医院" "第一医院" "协和医院" "妇幼保健院")

    # 随机选择生成方式（三种方式随机选择一种）
    local method=$((RANDOM % 2))

    case $method in
        0)
            # 方式1：地名 + 类型 + 后缀
            local location=${location_prefixes[$RANDOM % ${#location_prefixes[@]}]}
            local type=${company_types[$RANDOM % ${#company_types[@]}]}
            local suffix=${company_suffixes[$RANDOM % ${#company_suffixes[@]}]}
            echo "${location}${type}${suffix}"
            ;;
        1)
            # 方式2：随机公司名 + 类型/后缀
            local name=${random_names[$RANDOM % ${#random_names[@]}]}
            if [ $((RANDOM % 2)) -eq 0 ]; then
                local suffix=${company_suffixes[$RANDOM % ${#company_suffixes[@]}]}
                echo "${name}${suffix}"
            else
                local type=${company_types[$RANDOM % ${#company_types[@]}]}
                echo "${name}${type}公司"
            fi
            ;;
    esac
}

# 生成有效格式的身份证号函数
generate_valid_id_card() {
    # 前6位行政区划代码（随机选择几个常见的）
    local area_codes=("110101" "110102" "110105" "310101" "310104" "440301" "440303" "510104" "510105" "330102")

    # 出生日期（生成18-60岁之间的随机出生日期）
    local current_year=$(date +%Y)
    local birth_year=$((current_year - ($RANDOM % 43 + 18)))
    local birth_month=$(printf "%02d" $((RANDOM % 12 + 1)))
    local birth_day=$(printf "%02d" $((RANDOM % 28 + 1)))

    # 顺序码（3位）
    local sequence=$(printf "%03d" $((RANDOM % 1000)))

    # 前17位
    local prefix="${area_codes[$RANDOM % ${#area_codes[@]}]}${birth_year}${birth_month}${birth_day}${sequence}"

    # 计算校验码
    local weight_sum=0
    local weights=(7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2)
    local validate_codes=("1" "0" "X" "9" "8" "7" "6" "5" "4" "3" "2")

    for i in {0..16}; do
        local digit=${prefix:$i:1}
        weight_sum=$((weight_sum + digit * weights[i]))
    done

    local mod_val=$((weight_sum % 11))
    local validate_code=${validate_codes[$mod_val]}

    echo "${prefix}${validate_code}"
}

# ====================== 执行CURL函数 ======================
execute_curl() {
    local req_num=$1
    local desc=$2
    local url=$3
    local json_data=$4
    local temp_dir=$5

    log_debug "[请求${req_num}] ${desc} 开始"

    local tmpfile="${temp_dir}/req_${req_num}.json"
    echo "$json_data" > "$tmpfile"

    local response=$(timeout ${REQUEST_TIMEOUT} curl --location "$url" \
        --header 'Content-Type: application/json' \
        --data-binary "@$tmpfile" \
        --connect-timeout 30 --max-time 60 \
        --verbose --show-error \
        --write-out "\nHTTP状态码: %{http_code}\n总耗时: %{time_total}秒" 2>&1)

    rm -f "$tmpfile"

    local http_code=$(echo "$response" | grep -o "HTTP状态码: [0-9]*" | grep -o "[0-9]*" | tail -1)

    local business_failed=0
    if echo "$response" | grep -Eq '"result"[[:space:]]*:[[:space:]]*false'; then
        business_failed=1
    fi

    # 从返回内容中提取常见错误字段（兼容带空格的 JSON）
    local resp_msg=$(echo "$response" | sed -n 's/.*"msg"[[:space:]]*:[[:space:]]*"\([^"]*\)".*/\1/p' | tail -1)
    local resp_desc=$(echo "$response" | sed -n 's/.*"desc"[[:space:]]*:[[:space:]]*"\([^"]*\)".*/\1/p' | tail -1)
    local resp_error_code=$(echo "$response" | sed -n 's/.*"errorCode"[[:space:]]*:[[:space:]]*"\([^"]*\)".*/\1/p' | tail -1)
    local resp_error_name=$(echo "$response" | sed -n 's/.*"errorName"[[:space:]]*:[[:space:]]*"\([^"]*\)".*/\1/p' | tail -1)

    if [[ -n "$http_code" && "$http_code" =~ ^2[0-9][0-9]$ && $business_failed -eq 0 ]]; then
        log_info "✓ [请求${req_num}] ${desc} 成功 (HTTP ${http_code})"
    else
        if [[ $business_failed -eq 1 ]]; then
            log_error "✗ [请求${req_num}] ${desc} 失败 (HTTP ${http_code:-未知}, 业务返回 result=false)"
        else
            log_error "✗ [请求${req_num}] ${desc} 失败 (HTTP ${http_code:-未知})"
        fi

        # 失败时直接打印接口返回错误详情，方便排查
        if [[ -n "$resp_error_code" || -n "$resp_error_name" || -n "$resp_msg" || -n "$resp_desc" ]]; then
            log_error "接口错误详情: errorCode=${resp_error_code:-空}, errorName=${resp_error_name:-空}, msg=${resp_msg:-空}, desc=${resp_desc:-空}"
        fi

        log_debug "响应内容: ${response}"
    fi
    sleep 0.5  # 短暂休息避免请求过快
}

# ====================== 主处理函数 ======================
execute_api_calls() {
    local org_code=$1
    local org_name=$2
    local app_ip=$3

    echo -e "\n${GREEN}========================================${NC}"
    echo -e "${GREEN}处理机构: ${org_name} (${org_code})${NC}"

    local base_url="http://${app_ip}:8881"
    local global_date=$(generate_date)
    local temp_dir=$(mktemp -d)
    trap 'cleanup_temp_dir "$temp_dir"' RETURN
    local req_num=0

    # 公共数据
    local dept_line=$(generate_random_dept)
    local dept_code="${dept_line%% *}"
    local dept_name="${dept_line#* }"

    # ================== 患者1：入院 + 检验 ==================
    local lc_name=$(generate_random_name)

    # 生成第一组数据
    local patient_name1=$(generate_random_name)
    local id_card1=$(generate_valid_id_card)
    local birth_day1=$(generate_birthday_from_id "$id_card1")
    local tel1=$(generate_random_phone)
    local contacts1=$(generate_random_name)
    local contacts_tel1=$(generate_random_phone)
    local work_unit1=$(generate_random_work_unit)
    local address1=$(generate_random_address)
    local time1=$(generate_random_time)
    local time11=$(add_random_time ${time1})
    # 获取地址信息
    local region_line
    local addr=""
    local addrDetail=""
    if region_line=$(get_region_info "$org_code"); then
        read -r region_code region_name full_address <<< "$region_line"
        # 清理各个字段（防止字段内部有空格等特殊字符）
        region_name=$(echo "$region_name" | sed 's/[\r\n]*$//;s/^[[:space:]]*//;s/[[:space:]]*$//')
        full_address=$(echo "$full_address" | sed 's/[\r\n]*$//;s/^[[:space:]]*//;s/[[:space:]]*$//')
        addr="$region_name"
        addrDetail="$full_address"

        echo "使用地址: $addr"
        echo "详细地址: $addrDetail"
    else
        # 使用默认值
        addr="潞州区不详镇"
        addrDetail="山西省长治市潞州区不详镇"
        echo "使用默认地址: $addr"
    fi


    echo -e "${GREEN}患者1 (入院 + 检验): ${patient_name1} (${id_card1})${NC}"

    ((req_num++))
    # 1. 患者信息1
    execute_curl "$req_num" "患者信息1" "${base_url}/hclient/emr/receive/emrPatientInfo" "{
        \"id\": \"${id_card1}\",
        \"patientName\": \"${patient_name1}\",
        \"idCardTypeCode\": \"01\",
        \"idCardTypeName\": \"居民身份证\",
        \"idCard\": \"${id_card1}\",
        \"genderCode\": \"2\",
        \"genderName\": \"女\",
        \"birthDate\": \"${birth_day1}\",
        \"nationalityCode\": \"156\",
        \"nationalityName\": \"中国\",
        \"nationCode\": \"01\",
        \"nationName\": \"汉族\",
        \"permanentAddrCode\": \"${org_code}\",
        \"permanentAddrName\": \"${addr}\",
        \"permanentAddrDetail\": \"${address1}\",
        \"currentAddrCode\": \"${org_code}\",
        \"currentAddrName\": \"${addr}\",
        \"currentAddrDetail\": \"${address1}\",
        \"workUnit\": \"${work_unit1}\",
        \"maritalStatusCode\": \"10\",
        \"maritalStatusName\": \"未婚\",
        \"educationCode\": \"20\",
        \"educationName\": \"大学本科\",
        \"nultitudeTypeCode\": \"18\",
        \"nultitudeTypeName\": \"家务及待业\",
        \"tel\": \"${tel1}\",
        \"contacts\": \"${contacts1}\",
        \"contactsTel\": \"${contacts_tel1}\",
        \"orgCode\": \"${org_code}\",
        \"orgName\": \"${org_name}\",
        \"operatorId\": \"lc${org_code}\",
        \"operationTime\": \"${global_date} ${time1}\"
    }" "$temp_dir"

    ((req_num++))
    # 6. 活动信息1（使用第一组数据）
    execute_curl "$req_num" "活动信息1" "${base_url}/hclient/emr/receive/emrActivityInfo" "{
        \"ID\": \"${id_card1}\",
        \"PATIENT_ID\": \"${id_card1}\",
        \"ACTIVITY_TYPE_CODE\": \"5\",
        \"ACTIVITY_TYPE_NAME\": \"入院\",
        \"SERIAL_NUMBER\": \"${id_card1}\",
        \"ACTIVITY_TIME\": \"${global_date} ${time11}\",
        \"PATIENT_NAME\": \"${patient_name1}\",
        \"ID_CARD_TYPE_CODE\": \"01\",
        \"ID_CARD_TYPE_NAME\": \"居民身份证\",
        \"ID_CARD\": \"${id_card1}\",
        \"CHIEF_COMPLAINT\": \"流行性感冒\",
        \"PRESENT_ILLNESS_HIS\": null,
        \"PHYSICAL_EXAMINATION\": null,
        \"STUDIES_SUMMARY_RESULT\": null,
        \"DIAGNOSE_TIME\": \"${global_date} ${time11}\",
        \"DISEASE_CODE\": \"FR001\",
        \"DISEASE_NAME\": \"发热，咳嗽\",
        \"WM_DISEASE_CODE\": \"FR001\",
        \"WM_DISEASE_NAME\": \"发热，咳嗽\",
        \"TCM_DISEASE_CODE\": null,
        \"TCM_DISEASE_NAME\": null,
        \"TCM_SYNDROME_CODE\": null,
        \"TCM_SYNDROME_NAME\": null,
        \"FILL_DOCTOR\": \"${lc_name}\",
        \"DEPT_CODE\": \"${dept_code}\",
        \"DEPT_NAME\": \"${dept_name}\",
        \"ORG_CODE\": \"${org_code}\",
        \"ORG_NAME\": \"${org_name}\",
        \"OPERATOR_ID\": \"lc${org_code}\",
        \"OPERATION_TIME\": \"${global_date} ${time11}\"
    }" "$temp_dir"


    # 2. 入院信息
    ((req_num++))
    execute_curl "$req_num" "入院信息" "${base_url}/hclient/emr/receive/emrAdmissionInfo" \
        "{
            \"id\": \"${id_card1}\",
            \"patientId\": \"${id_card1}\",
            \"serialNumber\": \"${id_card1}\",
            \"wardName\": \"内科二区\",
            \"wardNo\": \"201\",
            \"bedNo\": \"B201\",
            \"patientName\": \"${patient_name1}\",
            \"idCardTypeCode\": \"01\",
            \"idCardTypeName\": \"居民身份证\",
            \"idCard\": \"${id_card1}\",
            \"admissionDate\": \"${global_date} ${time11}\",
            \"chiefComplaint\": \"发热，咳嗽\",
            \"presentIllnessHis\": \"持续发热三天，伴有咳嗽\",
            \"wmInitalDiagnosisName\": \"乙型肝炎\",
            \"wmInitalDiagnosisCode\": \"B15.0\",
            \"wmConfirmedDiagnosisName\": \"乙型肝炎\",
            \"wmConfirmedDiagnosisCode\": \"B15\",
            \"confirmedDiagnosisDate\": \"${global_date} ${time11}\",
            \"orgCode\": \"${org_code}\",
            \"orgName\": \"${org_name}\",
            \"deptCode\": \"${dept_code}\",
            \"deptName\": \"${dept_name}\",
            \"operatorId\": \"lc${org_code}\",
            \"operationTime\": \"${global_date} ${time11}\"
        }" "$temp_dir"

    # 3. 检验主表
    ((req_num++))
    execute_curl "$req_num" "检验主表" "${base_url}/hclient/emr/receive/emrExLab" \
        "{
            \"id\": \"${id_card1}\",
            \"patientId\": \"${id_card1}\",
            \"activityTypeCode\": \"5\",
            \"activityTypeName\": \"入院\",
            \"serialNumber\": \"${id_card1}\",
            \"patientName\": \"${patient_name1}\",
            \"idCardTypeCode\": \"01\",
            \"idCardTypeName\": \"居民身份证\",
            \"idCard\": \"${id_card1}\",
            \"wardNo\": \"101\",
            \"wardName\": \"内科一病区\",
            \"bedNo\": \"101-01\",
            \"specimenCategoryCode\": \"1\",
            \"specimenCategoryName\": \"血\",
            \"specimenSamplingDate\": \"${global_date} ${time11}\",
            \"examinationDate\": \"${global_date} ${time11}\",
            \"orgCode\": \"${org_code}\",
            \"orgName\": \"${org_name}\",
            \"deptCode\": \"${dept_code}\",
            \"deptName\": \"${dept_name}\",
            \"operatorId\": \"lc${org_code}\",
            \"operationTime\": \"${global_date} ${time11}\"
        }" "$temp_dir"

    # 4. 检验子表1 (HBsAg)
    ((req_num++))
    execute_curl "$req_num" "检验子表1 (HBsAg)" "${base_url}/hclient/emr/receive/emrExLabItem" \
        "{
            \"id\": \"${id_card1}1\",
            \"exLabId\": \"${id_card1}\",
            \"itemCode\": \"57\",
            \"itemName\": \"乙型肝炎表面抗原定性(HBsAg)测定\",
            \"examinationResultCode\": \"01\",
            \"examinationResultName\": \"阳性\",
            \"operationTime\": \"${global_date} ${time11}\",
            \"operatorId\": \"lc${org_code}\"
        }" "$temp_dir"

    # 5. 检验子表2 (ALT)
    ((req_num++))
    execute_curl "$req_num" "检验子表2 (ALT)" "${base_url}/hclient/emr/receive/emrExLabItem" \
        "{
            \"id\": \"${id_card1}2\",
            \"exLabId\": \"${id_card1}\",
            \"itemCode\": \"33\",
            \"itemName\": \"谷丙转氨酶\",
            \"examinationQuantification\": \"55.6\",
            \"examinationQuantificationUnit\": \"u/ml\",
            \"examinationQuantificationUpper\": \"50.0\",
            \"examinationQuantificationRi\": \"2\",
            \"operationTime\": \"${global_date} ${time11}\",
            \"operatorId\": \"lc${org_code}\"
        }" "$temp_dir"

    # ================== 患者2：出院 + 医嘱 ==================
    # 生成第二组数据
    local patient_name2=$(generate_random_name)
    local id_card2=$(generate_valid_id_card)
    local birth_day2=$(generate_birthday_from_id "$id_card2")
    local tel2=$(generate_random_phone)
    local contacts2=$(generate_random_name)
    local contacts_tel2=$(generate_random_phone)
    local work_unit2=$(generate_random_work_unit)
    local address2=$(generate_random_address)
    local time2=$(generate_random_time)
    local time22=$(add_random_time ${time2})

    echo -e "${GREEN}患者2 (出院 + 医嘱): ${patient_name2} (${id_card2})${NC}"

    # 6. 患者信息2
    ((req_num++))

    execute_curl "$req_num" "患者信息2" "${base_url}/hclient/emr/receive/emrPatientInfo" "{
        \"id\": \"${id_card2}\",
        \"patientName\": \"${patient_name2}\",
        \"idCardTypeCode\": \"01\",
        \"idCardTypeName\": \"居民身份证\",
        \"idCard\": \"${id_card2}\",
        \"genderCode\": \"1\",
        \"genderName\": \"男\",
        \"birthDate\": \"${birth_day2}\",
        \"nationalityCode\": \"156\",
        \"nationalityName\": \"中国\",
        \"nationCode\": \"01\",
        \"nationName\": \"汉族\",
        \"permanentAddrCode\": \"${org_code}\",
        \"permanentAddrName\": \"${addr}\",
        \"permanentAddrDetail\": \"${address2}\",
        \"currentAddrCode\": \"${org_code}\",
        \"currentAddrName\": \"${addr}\",
        \"currentAddrDetail\": \"${address2}\",
        \"workUnit\": \"${work_unit2}\",
        \"maritalStatusCode\": \"10\",
        \"maritalStatusName\": \"未婚\",
        \"educationCode\": \"20\",
        \"educationName\": \"大学本科\",
        \"nultitudeTypeCode\": \"18\",
        \"nultitudeTypeName\": \"家务及待业\",
        \"tel\": \"${tel2}\",
        \"contacts\": \"${contacts2}\",
        \"contactsTel\": \"${contacts_tel2}\",
        \"orgCode\": \"${org_code}\",
        \"orgName\": \"${org_name}\",
        \"operatorId\": \"lc${org_code}\",
        \"operationTime\": \"${global_date} ${time2}\"
    }" "$temp_dir"

    # 7. 活动信息2（使用第二组数据）
    ((req_num++))
    execute_curl "$req_num" "活动信息2" "${base_url}/hclient/emr/receive/emrActivityInfo" "{
        \"ID\": \"${id_card2}\",
        \"PATIENT_ID\": \"${id_card2}\",
        \"ACTIVITY_TYPE_CODE\": \"9\",
        \"ACTIVITY_TYPE_NAME\": \"出院\",
        \"SERIAL_NUMBER\": \"${id_card2}\",
        \"ACTIVITY_TIME\": \"${global_date} ${time22}\",
        \"PATIENT_NAME\": \"${patient_name2}\",
        \"ID_CARD_TYPE_CODE\": \"01\",
        \"ID_CARD_TYPE_NAME\": \"居民身份证\",
        \"ID_CARD\": \"${id_card2}\",
        \"CHIEF_COMPLAINT\": \"流行性感冒\",
        \"PRESENT_ILLNESS_HIS\": null,
        \"PHYSICAL_EXAMINATION\": null,
        \"STUDIES_SUMMARY_RESULT\": null,
        \"DIAGNOSE_TIME\": \"${global_date} ${time22}\",
        \"DISEASE_CODE\": \"J11\",
        \"DISEASE_NAME\": \"流行性感冒\",
        \"WM_DISEASE_CODE\": \"J11\",
        \"WM_DISEASE_NAME\": \"流行性感冒\",
        \"TCM_DISEASE_CODE\": null,
        \"TCM_DISEASE_NAME\": null,
        \"TCM_SYNDROME_CODE\": null,
        \"TCM_SYNDROME_NAME\": null,
        \"FILL_DOCTOR\": \"${lc_name}\",
        \"DEPT_CODE\": \"${dept_code}\",
        \"DEPT_NAME\": \"${dept_name}\",
        \"ORG_CODE\": \"${org_code}\",
        \"ORG_NAME\": \"${org_name}\",
        \"OPERATOR_ID\": \"lc${org_code}\",
        \"OPERATION_TIME\": \"${global_date} ${time22}\"
    }" "$temp_dir"

    # 7. 出院信息
    ((req_num++))
    execute_curl "$req_num" "出院信息" "${base_url}/hclient/emr/receive/emrDischargeInfo" \
        "{
            \"id\": \"${id_card2}\",
            \"patientId\": \"${id_card2}\",
            \"serialNumber\": \"${id_card2}\",
            \"wardName\": \"内科二区\",
            \"wardNo\": \"201\",
            \"bedNo\": \"B201\",
            \"patientName\": \"${patient_name2}\",
            \"idCardTypeCode\": \"01\",
            \"idCardTypeName\": \"居民身份证\",
            \"idCard\": \"${id_card2}\",
            \"admissionDate\": \"${global_date} ${time2}\",
            \"dischargeDate\": \"${global_date} ${time22}\",
            \"dischargeDiagnosisName\": \"乙型肝炎\",
            \"dischargeDiagnosisCode\": \"B15\",
            \"diseaseProgressionName\": \"好转\",
            \"treatmentDesc\": \"对症治疗，予以退热药物和抗病毒药物\",
            \"orgCode\": \"${org_code}\",
            \"orgName\": \"${org_name}\",
            \"deptCode\": \"${dept_code}\",
            \"deptName\": \"${dept_name}\",
            \"operatorId\": \"lc${org_code}\",
            \"operationTime\": \"${global_date} ${time22}\"
        }" "$temp_dir"

    # 8. 医嘱主表
    ((req_num++))
    execute_curl "$req_num" "医嘱主表" "${base_url}/hclient/emr/receive/emrOrder" \
        "{
            \"id\": \"${id_card2}\",
            \"patientId\": \"${id_card2}\",
            \"activityTypeCode\": \"5\",
            \"activityTypeName\": \"入院\",
            \"serialNumber\": \"${id_card2}\",
            \"patientName\": \"${patient_name2}\",
            \"idCardTypeCode\": \"01\",
            \"idCardTypeName\": \"居民身份证\",
            \"idCard\": \"${id_card2}\",
            \"prescriptionNo\": \"RX0001\",
            \"prescriptionIssuanceDate\": \"${global_date} ${time22}\",
            \"orgCode\": \"${org_code}\",
            \"orgName\": \"${org_name}\",
            \"deptCode\": \"${dept_code}\",
            \"deptName\": \"${dept_name}\",
            \"operatorId\": \"lc${org_code}\",
            \"operationTime\": \"${global_date} ${time22}\"
        }" "$temp_dir"

    # 9. 医嘱子表
    ((req_num++))
    execute_curl "$req_num" "医嘱子表" "${base_url}/hclient/emr/receive/emrOrderItem" \
        "{
            \"id\": \"${id_card2}1\",
            \"orderId\": \"${id_card2}\",
            \"drugCode\": \"001\",
            \"drugName\": \"阿司匹林\",
            \"drugSpecifications\": \"0.5g x 100片/盒\",
            \"drugDosageTotal\": \"30\",
            \"drugDosageUnitName\": \"片\",
            \"operatorId\": \"lc${org_code}\",
            \"operationTime\": \"${global_date} ${time22}\"
        }" "$temp_dir"

    # 可选：活动信息（如果你需要，可以继续添加）

    cleanup_temp_dir "$temp_dir"
    trap - RETURN
    echo -e "${GREEN}机构 ${org_name} 处理完成！${NC}"
}

# ====================== 主程序 ======================
main() {
    echo -e "${GREEN}========================================${NC}"
    echo -e "${GREEN}      EMR接口批量测试脚本（纯Bash优化版 v2）${NC}"
    echo -e "${GREEN}========================================${NC}"

    read -p "请输入机构编码（逗号分隔，例如 140403013,140403075）： " org_input
    org_input=$(echo "$org_input" | tr -d '[:space:]')

    if [ -z "$org_input" ]; then
        log_error "机构编码不能为空！"
        exit 1
    fi

    # 获取服务器IP
    app_ip=$(grep -E "^app\.server\.ip=" "$CONFIG_FILE" 2>/dev/null | cut -d'=' -f2 | tr -d '[:space:]')
    DATA_FILE=$(grep -E "^region\.data\.file=" "$CONFIG_FILE" 2>/dev/null | cut -d'=' -f2- | tr -d '\r' | xargs)
    if [ -z "$DATA_FILE" ]; then
        DATA_FILE="/home/hclient/region_data.txt"
    fi
    if [ -z "$app_ip" ]; then
        read -p "配置文件中未找到IP，请手动输入服务器IP: " app_ip
    fi
    echo "使用服务器IP: ${app_ip}"
    if [ ! -f "$DATA_FILE" ]; then
        log_warn "地区数据文件不存在，地址将使用默认值: ${DATA_FILE}"
    else
        log_info "使用地区数据文件: ${DATA_FILE}"
    fi

    IFS=',' read -ra org_array <<< "$org_input"

    for code in "${org_array[@]}"; do
        [ -z "$code" ] && continue
        execute_api_calls "$code" "机构_${code}" "$app_ip"
        sleep 1
    done

    echo -e "${GREEN}所有机构处理完成！${NC}"
}

# 运行主程序
main "$@"