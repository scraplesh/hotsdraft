include(
    ":app",
    ":domain",
    ":common",
    // region features
    ":feature-selectbattleground",
    ":feature-lot"
    // endregion
)

project(":feature-selectbattleground").projectDir = File(settingsDir, "/features/selectbattleground")
project(":feature-lot").projectDir = File(settingsDir, "/features/lot")
