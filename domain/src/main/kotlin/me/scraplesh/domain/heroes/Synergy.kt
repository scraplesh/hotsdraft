package me.scraplesh.domain.heroes

import me.scraplesh.domain.heroes.Hero

val Hero.synergyHeroes: List<Hero>
    get() = when (this) {
        Hero.Abathur -> listOf(
            Hero.Illidan,
            Hero.Zeratul,
            Hero.Tracer,
            Hero.Greymane,
            Hero.Genji,
            Hero.Malthael,
            Hero.Yrel,
            Hero.Sonya
        )
        Hero.Alarak -> listOf(
            Hero.Raynor,
            Hero.Jaina,
            Hero.ETC,
            Hero.Garrosh
        )
        Hero.Alexstrasza -> listOf(
            Hero.Johanna,
            Hero.Blaze,
            Hero.Kaelthas,
            Hero.Azmodan
        )
        Hero.Ana -> listOf(
            Hero.ETC,
            Hero.LiMing
        )
        Hero.Anduin -> listOf(
            Hero.Diablo,
            Hero.Garrosh,
            Hero.Jaina,
            Hero.Raynor
        )
        Hero.Anubarak -> listOf(
            Hero.Greymane,
            Hero.Jaina,
            Hero.Kaelthas,
            Hero.Kerrigan,
            Hero.Rehgar,
            Hero.TheButcher
        )
        Hero.Artanis -> listOf(
            Hero.Garrosh,
            Hero.Arthas,
            Hero.Kaelthas,
            Hero.Lunara,
            Hero.Medivh,
            Hero.Malfurion
        )
        Hero.Arthas -> listOf(
            Hero.Diablo,
            Hero.Tyrael,
            Hero.Maiev,
            Hero.Greymane,
            Hero.Raynor,
            Hero.Chromie,
            Hero.Zarya,
            Hero.Stukov,
            Hero.Rehgar
        )
        Hero.Auriel -> listOf(
            Hero.Cho,
            Hero.Gall,
            Hero.Guldan,
            Hero.Valla
        )
        Hero.Azmodan -> listOf(
            Hero.Jaina,
            Hero.Johanna,
            Hero.Maiev,
            Hero.Malfurion
        )
        Hero.Blaze -> listOf(
            Hero.Arthas,
            Hero.Kerrigan,
            Hero.Maiev,
            Hero.Malfurion
        )
        Hero.Brightwing -> listOf(
            Hero.Dehaka,
            Hero.Falstad,
            Hero.Medivh
        )
        Hero.Cassia -> listOf(
            Hero.LiLi,
            Hero.Johanna,
            Hero.Artanis,
            Hero.Thrall,
            Hero.Jaina
        )
        Hero.Chen -> listOf(
            Hero.Jaina,
            Hero.KelThuzad,
            Hero.Greymane
        )
        Hero.Cho -> listOf(
            Hero.Alexstrasza,
            Hero.Ana,
            Hero.Auriel,
            Hero.ETC,
            Hero.Rehgar,
            Hero.Uther
        )
        Hero.Chromie -> listOf(
            Hero.Johanna,
            Hero.Ana,
            Hero.Malfurion
        )
        Hero.Deathwing -> listOf(
            Hero.ETC,
            Hero.Arthas,
            Hero.Johanna,
            Hero.Muradin
        )
        Hero.Deckard -> listOf(
            Hero.Alarak,
            Hero.Arthas,
            Hero.Blaze,
            Hero.Diablo,
            Hero.Jaina,
            Hero.Johanna,
            Hero.Kerrigan,
            Hero.KelThuzad,
            Hero.Tyrael,
            Hero.Varian
        )
        Hero.Dehaka -> listOf(
            Hero.Anubarak,
            Hero.Jaina,
            Hero.Hanzo,
            Hero.Maiev
        )
        Hero.Diablo -> listOf(
            Hero.Alexstrasza,
            Hero.Deckard,
            Hero.Jaina,
            Hero.Maiev,
            Hero.Malfurion,
            Hero.Medivh,
            Hero.Thrall,
            Hero.Tyrande
        )
        Hero.DiVa -> listOf(
            Hero.ETC,
            Hero.Diablo,
            Hero.Johanna,
            Hero.Malfurion
        )
        Hero.ETC -> listOf(
            Hero.Falstad,
            Hero.Greymane,
            Hero.Jaina,
            Hero.Kaelthas,
            Hero.Nazeebo,
            Hero.Rehgar,
            Hero.TheButcher
        )
        Hero.Falstad -> listOf(
            Hero.Arthas,
            Hero.ETC,
            Hero.Tassadar,
            Hero.Uther
        )
        Hero.Fenix -> listOf(
            Hero.Johanna,
            Hero.Maiev,
            Hero.Thrall,
            Hero.Diablo
        )
        Hero.Gall -> listOf(
            Hero.Auriel,
            Hero.ETC,
            Hero.Rehgar,
            Hero.Uther
        )
        Hero.Garrosh -> listOf(
            Hero.Jaina,
            Hero.Tyrande,
            Hero.Uther,
            Hero.Malfurion
        )
        Hero.Gazlowe -> listOf(
            Hero.Diablo,
            Hero.ETC,
            Hero.Jaina,
            Hero.Johanna,
            Hero.Kaelthas,
            Hero.Malfurion
        )
        Hero.Genji -> listOf(
            Hero.Jaina,
            Hero.Uther,
            Hero.ETC
        )
        Hero.Greymane -> listOf(
            Hero.Abathur,
            Hero.ETC,
            Hero.Tassadar,
            Hero.Uther
        )
        Hero.Guldan -> listOf(
            Hero.ETC,
            Hero.Malfurion,
            Hero.Auriel
        )
        Hero.Hanzo -> listOf(
            Hero.Zeratul,
            Hero.ETC,
            Hero.Diablo,
            Hero.Blaze,
            Hero.Johanna,
            Hero.MalGanis
        )
        Hero.Illidan -> listOf(
            Hero.Abathur,
            Hero.Medivh,
            Hero.Rehgar,
            Hero.Tassadar,
            Hero.Tyrael,
            Hero.Uther,
            Hero.Zarya
        )
        Hero.Imperius -> listOf(
            Hero.Jaina,
            Hero.Fenix,
            Hero.Rehgar,
            Hero.MalGanis,
            Hero.ETC
        )
        Hero.Jaina -> listOf(
            Hero.Arthas,
            Hero.ETC,
            Hero.Johanna,
            Hero.Malfurion,
            Hero.Muradin,
            Hero.TheButcher,
            Hero.Valeera,
            Hero.Varian,
            Hero.Xul
        )
        Hero.Johanna -> listOf(
            Hero.Guldan,
            Hero.Kaelthas,
            Hero.Jaina,
            Hero.Rehgar
        )
        Hero.Junkrat -> listOf(
            Hero.ETC,
            Hero.Garrosh,
            Hero.Uther,
            Hero.Malfurion,
            Hero.Zeratul
        )
        Hero.Kaelthas -> listOf(
            Hero.ETC,
            Hero.Arthas,
            Hero.Malfurion,
            Hero.Uther
        )
        Hero.KelThuzad -> listOf(
            Hero.Anduin,
            Hero.Arthas,
            Hero.Johanna,
            Hero.Malfurion,
            Hero.TheButcher,
            Hero.Valeera,
            Hero.Varian,
            Hero.Xul
        )
        Hero.Kerrigan -> listOf(
            Hero.Tyrael,
            Hero.Uther,
            Hero.Medivh,
            Hero.Tyrande
        )
        Hero.Kharazim -> listOf(
            Hero.Garrosh,
            Hero.ETC,
            Hero.Anubarak,
            Hero.Genji
        )
        Hero.Leoric -> listOf(
            Hero.Jaina,
            Hero.Kaelthas,
            Hero.Tychus
        )
        Hero.LiLi -> listOf(
            Hero.Artanis,
            Hero.Anubarak,
            Hero.Azmodan,
            Hero.Varian,
            Hero.Falstad
        )
        Hero.LiMing -> listOf(
            Hero.Arthas,
            Hero.ETC,
            Hero.Johanna,
            Hero.Malfurion,
            Hero.Valeera,
            Hero.Varian,
            Hero.Xul
        )
        Hero.LtMorales -> listOf(
            Hero.Johanna,
            Hero.Raynor
        )
        Hero.Lucio -> listOf(
            Hero.Arthas,
            Hero.Diablo,
            Hero.Greymane,
            Hero.Valla
        )
        Hero.Lunara -> listOf(
            Hero.Arthas,
            Hero.Muradin,
            Hero.Jaina
        )
        Hero.Maiev -> listOf(
            Hero.Arthas,
            Hero.Dehaka,
            Hero.Diablo,
            Hero.ETC,
            Hero.Guldan,
            Hero.Jaina,
            Hero.Johanna,
            Hero.Kaelthas,
            Hero.Lucio,
            Hero.Stukov,
            Hero.Tyrael
        )
        Hero.Malfurion -> listOf(
            Hero.Blaze,
            Hero.Chromie,
            Hero.Guldan,
            Hero.Jaina,
            Hero.Kaelthas,
            Hero.KelThuzad,
            Hero.LiMing,
            Hero.Nazeebo,
            Hero.Ragnaros
        )
        Hero.MalGanis -> listOf(
            Hero.Jaina,
            Hero.Zeratul,
            Hero.Malfurion
        )
        Hero.Malthael -> listOf(
            Hero.ETC,
            Hero.Johanna,
            Hero.Tassadar,
            Hero.Uther
        )
        Hero.Medivh -> listOf(
            Hero.Illidan,
            Hero.Greymane,
            Hero.Genji,
            Hero.Tracer,
            Hero.Diablo,
            Hero.Stitches
        )
        Hero.Mephisto -> listOf(
            Hero.Deckard,
            Hero.ETC,
            Hero.Zarya,
            Hero.Diablo
        )
        Hero.Muradin -> listOf(
            Hero.Kerrigan,
            Hero.Tyrande,
            Hero.Jaina,
            Hero.Rehgar
        )
        Hero.Murky -> listOf(
            Hero.Abathur,
            Hero.Deckard,
            Hero.Tassadar,
            Hero.Zarya
        )
        Hero.Nazeebo -> listOf(
            Hero.Johanna,
            Hero.Raynor,
            Hero.Stukov
        )
        Hero.Nova -> listOf(
            Hero.ETC,
            Hero.Tyrael,
            Hero.Tyrande,
            Hero.Xul
        )
        Hero.Orphea -> listOf(
            Hero.Arthas,
            Hero.Diablo,
            Hero.Johanna,
            Hero.MalGanis,
            Hero.Varian,
            Hero.Xul
        )
        Hero.Probius -> listOf(
            Hero.ETC,
            Hero.Diablo,
            Hero.Anubarak,
            Hero.Arthas,
            Hero.Malfurion
        )
        Hero.Qhira -> listOf(
            Hero.Uther,
            Hero.Rehgar,
            Hero.Arthas
        )
        Hero.Ragnaros -> listOf(
            Hero.Arthas,
            Hero.Johanna,
            Hero.Malfurion,
            Hero.Muradin
        )
        Hero.Raynor -> listOf(
            Hero.ETC,
            Hero.Garrosh,
            Hero.Thrall,
            Hero.LtMorales
        )
        Hero.Rehgar -> listOf(
            Hero.Illidan,
            Hero.ETC,
            Hero.Kerrigan,
            Hero.Thrall
        )
        Hero.Rexxar -> listOf(
            Hero.Johanna,
            Hero.Jaina,
            Hero.Malfurion
        )
        Hero.Samuro -> listOf(
            Hero.Abathur,
            Hero.Deckard,
            Hero.ETC
        )
        Hero.SgtHammer -> listOf(
            Hero.ETC,
            Hero.Johanna,
            Hero.LtMorales,
            Hero.Tassadar
        )
        Hero.Sonya -> listOf(
            Hero.Jaina,
            Hero.Medivh,
            Hero.Rehgar,
            Hero.Tassadar,
            Hero.Zarya
        )
        Hero.Stitches -> listOf(
            Hero.Uther,
            Hero.Jaina,
            Hero.Malfurion,
            Hero.Tyrande
        )
        Hero.Stukov -> listOf(
            Hero.Raynor,
            Hero.ETC,
            Hero.SgtHammer
        )
        Hero.Sylvanas -> listOf(
            Hero.Diablo,
            Hero.ETC,
            Hero.Jaina,
            Hero.Tassadar,
            Hero.Tyrande,
            Hero.Valla
        )
        Hero.Tassadar -> listOf(
            Hero.Maiev,
            Hero.Johanna,
            Hero.ETC,
            Hero.Genji,
            Hero.Zeratul
        )
        Hero.TheButcher -> listOf(
            Hero.Abathur,
            Hero.Tyrande,
            Hero.Uther,
            Hero.Tyrael
        )
        Hero.TheLostVikings -> listOf(
            Hero.Zarya,
            Hero.Garrosh,
            Hero.Sylvanas,
            Hero.Raynor,
            Hero.SgtHammer
        )
        Hero.Thrall -> listOf(
            Hero.Diablo,
            Hero.Fenix,
            Hero.Chromie,
            Hero.Rehgar
        )
        Hero.Tracer -> listOf(
            Hero.Tassadar,
            Hero.Jaina,
            Hero.Guldan,
            Hero.Kaelthas,
            Hero.Malfurion,
            Hero.Anduin,
            Hero.Abathur
        )
        Hero.Tychus -> listOf(
            Hero.Garrosh,
            Hero.ETC,
            Hero.Dehaka,
            Hero.Uther
        )
        Hero.Tyrael -> listOf(
            Hero.Blaze,
            Hero.Illidan,
            Hero.Malfurion
        )
        Hero.Tyrande -> listOf(
            Hero.Diablo,
            Hero.ETC,
            Hero.Varian,
            Hero.Anubarak,
            Hero.LiMing
        )
        Hero.Uther -> listOf(
            Hero.Kerrigan,
            Hero.Illidan,
            Hero.TheButcher,
            Hero.Zuljin
        )
        Hero.Valeera -> listOf(
            Hero.Garrosh,
            Hero.ETC,
            Hero.Thrall,
            Hero.Jaina,
            Hero.Abathur
        )
        Hero.Valla -> listOf(
            Hero.Arthas,
            Hero.ETC,
            Hero.Tassadar,
            Hero.Uther
        )
        Hero.Varian -> listOf(
            Hero.ETC,
            Hero.Blaze,
            Hero.LiMing,
            Hero.Tyrande
        )
        Hero.Whitemane -> listOf(
            Hero.Johanna,
            Hero.Sonya,
            Hero.Blaze
        )
        Hero.Xul -> listOf(
            Hero.Tyrande,
            Hero.Medivh,
            Hero.LiMing,
            Hero.Falstad
        )
        Hero.Yrel -> listOf(
            Hero.Garrosh,
            Hero.Johanna,
            Hero.Maiev,
            Hero.Abathur
        )
        Hero.Zagara -> listOf(
            Hero.ETC,
            Hero.Diablo,
            Hero.Jaina
        )
        Hero.Zarya -> listOf(
            Hero.ETC,
            Hero.Muradin,
            Hero.Johanna,
            Hero.Chen
        )
        Hero.Zeratul -> listOf(
            Hero.Abathur,
            Hero.Diablo,
            Hero.Jaina,
            Hero.Uther
        )
        Hero.Zuljin -> listOf(
            Hero.Tyrael,
            Hero.ETC,
            Hero.Tassadar,
            Hero.Uther,
            Hero.Medivh,
            Hero.Arthas
        )
    }
