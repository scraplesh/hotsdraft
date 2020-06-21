include(
    ":app",
    ":data",
    ":domain",
    ":common",
    ":mviflow",
    // region features
    ":feature-selectbattleground",
    ":feature-lot",
    ":feature-draft",
    ":feature-heroes"
    // endregion
)

project(":feature-selectbattleground").projectDir = File(settingsDir, "/features/selectbattleground")
project(":feature-lot").projectDir = File(settingsDir, "/features/lot")
project(":feature-draft").projectDir = File(settingsDir, "/features/draft")
project(":feature-heroes").projectDir = File(settingsDir, "/features/heroes")
