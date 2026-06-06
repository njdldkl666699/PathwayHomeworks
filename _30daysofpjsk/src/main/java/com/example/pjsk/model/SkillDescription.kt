package com.example.pjsk.model

enum class SkillDescription(val description: String) {
    Perfect("5秒内，仅在PERFECT时得分提高130%。"),
    Score("5秒内，得分提高120%。"),
    Judgement("7秒内，BAD及以上变为PERFECT，5秒内，得分提高100％。"),
    HP("恢复生命值500，5秒内，得分提高100%。"),
    CFes(
        "5秒内，发动时若生命值不满800，则得分提高90%；\n" +
                "若达到800，则得分提高120%，且生命值每增加10，得分多提高1%（最多140%)。"
    ),
    BFesNormal("5秒内，得分提高80%，并从编组中随机选择其他1名成员，提高其得分提高技能最大值的50%（最多合计提高130%）。"),
    BFesTrainedYoisakiKanade(
        "5秒内，得分提高110%，并根据“${
            Character.YoisakiKanade.chrName
        }”的角色等级再提高50%（角色等级每2级+1%，目前合计160%/最多160%）。"
    ),
    HP3("恢复生命值400，5秒内，得分提高60%。"),
    Score3("5秒内，得分提高80%。"),
    Birthday("恢复生命值850，5秒内，仅在PERFECT时得分提高80%。"),
}