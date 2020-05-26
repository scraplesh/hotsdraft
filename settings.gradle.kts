include(
    ":app",
    ":domain",
    ":common",
    // region features
    ":feature-selectbattleground",
    ":feature-lot",
    ":feature-draft"
    // endregion
)

project(":feature-selectbattleground").projectDir = File(settingsDir, "/features/selectbattleground")
project(":feature-lot").projectDir = File(settingsDir, "/features/lot")
project(":feature-draft").projectDir = File(settingsDir, "/features/draft")
