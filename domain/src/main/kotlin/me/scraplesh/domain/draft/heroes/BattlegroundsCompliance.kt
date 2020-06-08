package me.scraplesh.domain.draft.heroes

import me.scraplesh.domain.Battleground
import me.scraplesh.domain.heroes.Hero

enum class BattlegroundCompliance { Strong, Average, Weak, Unknown }

private val Pair<Hero, Battleground>.battleGroundCompliance: BattlegroundCompliance
    get() = when (this.first) {
        Hero.Abathur -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Weak
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Weak
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Alarak -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Alexstrasza -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Weak
            Battleground.GardenOfTerror -> BattlegroundCompliance.Weak
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Weak
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Ana -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Weak
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Weak
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Anduin -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Anubarak -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Artanis -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Weak
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Weak
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Weak
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Weak
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Arthas -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Weak
            Battleground.GardenOfTerror -> BattlegroundCompliance.Weak
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Auriel -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Azmodan -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Blaze -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Brightwing -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Cassia -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Chen -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Cho -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Weak
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Chromie -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Deathwing -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Deckard -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Weak
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Dehaka -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Weak
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Diablo -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.DiVa -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.ETC -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Falstad -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Fenix -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Gall -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Weak
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Garrosh -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Gazlowe -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Genji -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Greymane -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Guldan -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Hanzo -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity-> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Illidan -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Weak
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Weak
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Imperius -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Jaina -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Johanna -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Junkrat -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Kaelthas -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.KelThuzad -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Weak
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Kerrigan -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Kharazim -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Leoric -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.LiLi -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.LiMing -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.LtMorales -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Weak
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Weak
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Lucio -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Lunara -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Maiev -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Malfurion -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.MalGanis -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Malthael -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Medivh -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Mephisto -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Muradin -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Murky -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Weak
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Nazeebo -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Nova -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Weak
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Orphea -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Probius -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Qhira -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Ragnaros -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Raynor -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Rehgar -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Rexxar -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Samuro -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.SgtHammer -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Weak
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Sonya -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Stitches -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Stukov -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Sylvanas -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Tassadar -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Weak
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.TheButcher -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.TheLostVikings -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Thrall -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Tracer -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Tychus -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Weak
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Tyrael -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Tyrande -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Uther -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Weak
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Valeera -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Valla -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Strong
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Varian -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Weak
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Whitemane -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Weak
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Xul -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Weak
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Strong
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Yrel -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Strong
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Strong
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Zagara -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Strong
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Strong
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Strong
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Strong
        }
        Hero.Zarya -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Strong
            Battleground.CursedHollow -> BattlegroundCompliance.Strong
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Strong
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Strong
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Strong
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Weak
        }
        Hero.Zeratul -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Strong
            Battleground.BraxisHoldout -> BattlegroundCompliance.Weak
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Weak
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Weak
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
        Hero.Zuljin -> when (this.second) {
            Battleground.AlteracPass -> BattlegroundCompliance.Average
            Battleground.BattlefieldOfEternity -> BattlegroundCompliance.Average
            Battleground.BlackheartsBay -> BattlegroundCompliance.Average
            Battleground.BraxisHoldout -> BattlegroundCompliance.Average
            Battleground.CursedHollow -> BattlegroundCompliance.Average
            Battleground.DragonShire -> BattlegroundCompliance.Average
            Battleground.GardenOfTerror -> BattlegroundCompliance.Average
            Battleground.HanamuraTemple -> BattlegroundCompliance.Average
            Battleground.HauntedMines -> BattlegroundCompliance.Unknown
            Battleground.InfernalShrines -> BattlegroundCompliance.Average
            Battleground.SkyTemple -> BattlegroundCompliance.Average
            Battleground.TombOfTheSpiderQueen -> BattlegroundCompliance.Average
            Battleground.TowersOfDoom -> BattlegroundCompliance.Average
            Battleground.VolskayaFoundry -> BattlegroundCompliance.Average
            Battleground.WarheadJunction -> BattlegroundCompliance.Average
        }
    }

val Battleground.strongHeroes: List<Hero>
    get() = Hero.values()
        .filter { hero -> (hero to this).battleGroundCompliance == BattlegroundCompliance.Strong }

val Battleground.averageHeroes: List<Hero>
    get() = Hero.values()
        .filter { hero -> (hero to this).battleGroundCompliance == BattlegroundCompliance.Average }

val Battleground.weakHeroes: List<Hero>
    get() = Hero.values()
        .filter { hero -> (hero to this).battleGroundCompliance == BattlegroundCompliance.Weak }

