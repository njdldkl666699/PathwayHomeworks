package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Attraction

object DataSource {
    private val landmarks = listOf(
        Attraction(
            "涩谷 Scramble Square",
            "顶层拥有可360度俯瞰东京的露天展望台“SHIBUYA SKY”，是涩谷海拔最高的新地标。",
            R.drawable.shibuya_scramble_square
        ),
        Attraction("涩谷109", "涩谷系辣妹文化的圣殿，一栋楼浓缩了日本少女时尚的变迁史。", R.drawable.shibuya_109),
        Attraction("QFRONT", "巨大十字路口旁最醒目的巨型荧幕建筑，是涩谷视觉冲击力的代名词。", R.drawable.qfront),
        Attraction(
            "涩谷Hikarie",
            "汇集剧场、创意产业与高空餐厅的复合式文化塔楼，适合雨天慢逛。",
            R.drawable.shibuya_hikarie
        )
    )

    private val memorialSpots = listOf(
        Attraction("忠犬八公像", "世界上最感人的候车点，曾是真实秋田犬日日等待主人的重逢之地。", R.drawable.hachiko),
        Attraction(
            "莫伊赖雕像",
            "由艺术家内海圣乙创作的巨大神话雕像群，是涩谷不太知名但震撼人心的能量地标。",
            R.drawable.moirai
        )
    )

    private val popCultureSpots = listOf(
        Attraction(
            "涩谷PARCO",
            "任天堂东京旗舰店与宝可梦中心所在地，二次元与潮流文化的地下地上大融合。",
            R.drawable.shibuya_parco
        ),
        Attraction("MAGNET by SHIBUYA109", "拥有“任天堂TOKYO”快闪空间与立体迷宫的十字路口侧翼。", R.drawable.magnet),
        Attraction("涩谷MODI", "更安静的文艺派商业体，常有独立展览与音乐演出。", R.drawable.shibuya_modi),
        Attraction(
            "VILLAGE VANGUARD 涩谷总店",
            "被书与玩具塞满的“游乐书铺”，贩卖恶搞与怪奇趣味。",
            R.drawable.village_vanguard
        )
    )

    private val entertainmentSpots = listOf(
        Attraction("涩谷WWW / WWW X", "地下电子乐与新锐乐团的实验场，东京夜生活的低频心跳处。", R.drawable.shibuya_www),
        Attraction(
            "TOWER RECORDS 涩谷店",
            "七层楼的唱片丛林，门口“NO MUSIC, NO LIFE.”标语已成文化宣言。",
            R.drawable.tower_records
        ),
        Attraction(
            "涩谷东急歌舞伎町塔",
            "融合电影院、Live House与酒店的新型娱乐巨塔，夜晚光影极尽绚烂。",
            R.drawable.tokyu_kabukicho_tower
        )
    )

    private val shrines = listOf(
        Attraction(
            "金王八幡宫",
            "隐匿于涩谷川遗迹之上的古老神社，每年九月例大祭会抬神轿冲下涩谷坡道。",
            R.drawable.konno_hachimangu
        ),
        Attraction("青悬神社", "藏在住宅巷弄里掌管结缘的迷你神社，因艺人参拜而悄悄走红。", R.drawable.aogake_shrine)
    )

    private val streets = listOf(
        Attraction("中心街", "年轻人夜游核心带，饮食店、卡拉OK与游戏厅的热闹狭长走廊。", R.drawable.center_gai),
        Attraction("西班牙坂", "连接PARCO与中心街的缓坡小巷，充满杂货店、可丽饼与昭和怀旧气息。", R.drawable.spain_zaka),
        Attraction("道玄坂", "从涩谷十字路口向西南延伸的醉人坡道，深夜居酒屋与俱乐部混杂交错。", R.drawable.dogenzaka),
        Attraction("宇田川町", "涩谷的文艺与音乐大本营，独立影院与唱片行散落其中。", R.drawable.udagawacho),
        Attraction("神南", "聚集大型家电量贩店与音乐设备店的半办公区，也是旧涩谷公会场遗迹。", R.drawable.jinnan)
    )

    val all = mapOf(
        "地标建筑与展望台" to landmarks,
        "忠犬八公与回忆地标" to memorialSpots,
        "流行文化与次元入口" to popCultureSpots,
        "娱乐与音乐现场" to entertainmentSpots,
        "神社与静谧角落" to shrines,
        "街道与文化地带" to streets
    )
}

