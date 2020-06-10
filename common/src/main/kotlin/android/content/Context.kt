package android.content

import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.common.R

fun Context.getString(battleground: Battleground): String = getString(
    when (battleground) {
        Battleground.AlteracPass -> R.string.alterac_pass
        Battleground.BattlefieldOfEternity -> R.string.battlefield_of_eternity
        Battleground.BlackheartsBay -> R.string.blackhearts_bay
        Battleground.BraxisHoldout -> R.string.braxis_holdout
        Battleground.CursedHollow -> R.string.cursed_hollow
        Battleground.DragonShire -> R.string.dragon_shire
        Battleground.GardenOfTerror -> R.string.garden_of_terror
        Battleground.HanamuraTemple -> R.string.hanamura_temple
        Battleground.HauntedMines -> R.string.haunted_mines
        Battleground.InfernalShrines -> R.string.infernal_shrines
        Battleground.SkyTemple -> R.string.sky_temple
        Battleground.TombOfTheSpiderQueen -> R.string.tomb_of_the_spider_queen
        Battleground.TowersOfDoom -> R.string.towers_of_doom
        Battleground.VolskayaFoundry -> R.string.volskaya_foundry
        Battleground.WarheadJunction -> R.string.warhead_junction
    }
)
