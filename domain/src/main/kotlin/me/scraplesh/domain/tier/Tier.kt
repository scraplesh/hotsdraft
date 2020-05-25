package me.scraplesh.domain.tier

import me.scraplesh.domain.Hero

enum class Tier { S, A, B, C, D }

val Tier.heroes: List<Hero>
    get() = when (this) {
        Tier.S -> listOf(Hero.Deathwing, Hero.Kaelthas)
        Tier.A -> listOf(
            Hero.Ana,
            Hero.Anduin,
            Hero.Blaze,
            Hero.Chen,
            Hero.Dehaka,
            Hero.ETC,
            Hero.Garrosh,
            Hero.Guldan,
            Hero.Hanzo,
            Hero.Imperius,
            Hero.Johanna,
            Hero.Lunara,
            Hero.Raynor,
            Hero.Fenix,
            Hero.Leoric,
            Hero.Malfurion,
            Hero.Muradin,
            Hero.Tassadar,
            Hero.Tychus
        )
        Tier.B -> listOf(
            Hero.Abathur,
            Hero.Alarak,
            Hero.Alexstrasza,
            Hero.Anubarak,
            Hero.Arthas,
            Hero.Auriel,
            Hero.Cassia,
            Hero.Deckard,
            Hero.Diablo,
            Hero.Falstad,
            Hero.Genji,
            Hero.Greymane,
            Hero.Jaina,
            Hero.Junkrat,
            Hero.Kerrigan,
            Hero.LiLi,
            Hero.LiMing,
            Hero.Lucio,
            Hero.Maiev,
            Hero.MalGanis,
            Hero.Malthael,
            Hero.Mephisto,
            Hero.Orphea,
            Hero.Qhira,
            Hero.Ragnaros,
            Hero.Rehgar,
            Hero.Rexxar,
            Hero.Stitches,
            Hero.Stukov,
            Hero.Sonya,
            Hero.Sylvanas,
            Hero.Thrall,
            Hero.Uther,
            Hero.Whitemane,
            Hero.Yrel,
            Hero.Zarya,
            Hero.Zeratul,
            Hero.Zuljin
        )
        Tier.C -> listOf(
            Hero.Artanis,
            Hero.Azmodan,
            Hero.Brightwing,
            Hero.Chromie,
            Hero.DiVa,
            Hero.Illidan,
            Hero.Kharazim,
            Hero.KelThuzad,
            Hero.LtMorales,
            Hero.Medivh,
            Hero.Nazeebo,
            Hero.Nova,
            Hero.Samuro,
            Hero.SgtHammer,
            Hero.TheLostVikings,
            Hero.Tracer,
            Hero.Tyrael,
            Hero.Tyrande,
            Hero.Valeera,
            Hero.Valla,
            Hero.Varian,
            Hero.Xul,
            Hero.Zagara
        )
        Tier.D -> listOf(
            Hero.Cho,
            Hero.Gall,
            Hero.Gazlowe,
            Hero.Murky,
            Hero.Probius,
            Hero.TheButcher
        )
    }
