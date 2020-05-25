include(
    ":app",
    ":domain",
    // region features
    ":feature-selectbattleground"
//    ":feature-draft"
    // endregion
)

project(":feature-selectbattleground").projectDir = File(settingsDir, "/features/selectbattleground")
