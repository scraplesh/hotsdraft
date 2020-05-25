package me.scraplesh.domain.draft.heroes

import me.scraplesh.domain.Hero

val Hero.counteredBy: List<Hero>
    get() = when (this) {
        Hero.Abathur -> listOf(
            Hero.Dehaka,
            Hero.Falstad,
            Hero.Ragnaros,
            Hero.Zarya,
            Hero.Sylvanas,
            Hero.SgtHammer
        )
        Hero.Alarak -> listOf(
            Hero.ETC,
            Hero.Johanna,
            Hero.Deathwing,
            Hero.Medivh
        )
        Hero.Alexstrasza -> listOf(
            Hero.Anubarak,
            Hero.Yrel,
            Hero.Kaelthas,
            Hero.Sylvanas,
            Hero.Ana
        )
        Hero.Ana -> listOf(
            Hero.Anubarak,
            Hero.Zeratul,
            Hero.Hanzo,
            Hero.Lucio
        )
        Hero.Anduin -> listOf(
            Hero.Ana,
            Hero.Illidan,
            Hero.Tracer,
            Hero.Diablo,
            Hero.Falstad
        )
        Hero.Anubarak -> listOf(
            Hero.Leoric,
            Hero.Malthael,
            Hero.Tracer,
            Hero.Valla,
            Hero.Varian,
            Hero.Zuljin
        )
        Hero.Artanis -> listOf(
            Hero.ETC,
            Hero.Arthas,
            Hero.Varian,
            Hero.Jaina,
            Hero.Lunara,
            Hero.LiLi
        )
        Hero.Arthas -> listOf(
            Hero.Garrosh,
            Hero.Sonya,
            Hero.Tracer,
            Hero.Raynor,
            Hero.Jaina,
            Hero.Ana
        )
        Hero.Auriel -> listOf(
            Hero.TheButcher,
            Hero.Tyrande,
            Hero.Kerrigan
        )
        Hero.Azmodan -> listOf(
            Hero.Artanis,
            Hero.Anubarak,
            Hero.Diablo,
            Hero.Leoric,
            Hero.Malthael,
            Hero.Muradin,
            Hero.Sonya,
            Hero.TheButcher
        )
        Hero.Blaze -> listOf(
            Hero.Leoric,
            Hero.Lunara,
            Hero.Malthael,
            Hero.Nova,
            Hero.Tracer,
            Hero.Valla
        )
        Hero.Brightwing -> listOf(
            Hero.Anubarak,
            Hero.Johanna,
            Hero.Deathwing,
            Hero.ETC,
            Hero.Fenix
        )
        Hero.Cassia -> listOf(
            Hero.Kaelthas,
            Hero.Guldan,
            Hero.SgtHammer,
            Hero.ETC,
            Hero.MalGanis,
            Hero.Johanna
        )
        Hero.Chen -> listOf(
            Hero.Anubarak,
            Hero.Muradin,
            Hero.Johanna,
            Hero.Varian
        )
        Hero.Cho -> listOf(
            Hero.Anubarak,
            Hero.Greymane,
            Hero.Kharazim,
            Hero.Leoric,
            Hero.MalGanis,
            Hero.Malthael,
            Hero.Raynor
        )
        Hero.Chromie -> listOf(
            Hero.Illidan,
            Hero.Diablo,
            Hero.Zeratul,
            Hero.Tracer
        )
        Hero.Deathwing -> listOf(
            Hero.Tychus,
            Hero.Greymane,
            Hero.Valla,
            Hero.Zeratul,
            Hero.Tracer
        )
        Hero.Deckard -> listOf(
            Hero.Alarak,
            Hero.Diablo,
            Hero.Kerrigan,
            Hero.Tracer,
            Hero.Samuro
        )
        Hero.Dehaka -> listOf(
            Hero.Valla,
            Hero.Raynor,
            Hero.ETC,
            Hero.SgtHammer,
            Hero.Lucio
        )
        Hero.Diablo -> listOf(
            Hero.Leoric,
            Hero.Malthael,
            Hero.Raynor,
            Hero.Tychus
        )
        Hero.DiVa -> listOf(
            Hero.Alarak,
            Hero.Jaina,
            Hero.Zeratul,
            Hero.Tychus
        )
        Hero.ETC -> listOf(
            Hero.Auriel,
            Hero.Brightwing,
            Hero.Johanna,
            Hero.Leoric,
            Hero.Malthael,
            Hero.Raynor,
            Hero.Tyrande,
            Hero.Valla
        )
        Hero.Falstad -> listOf(
            Hero.Genji,
            Hero.Greymane,
            Hero.Illidan,
            Hero.Nova,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.Fenix -> listOf(
            Hero.Varian,
            Hero.ETC,
            Hero.Genji,
            Hero.Zeratul,
            Hero.Lucio
        )
        Hero.Gall -> listOf(
            Hero.Anubarak,
            Hero.Greymane,
            Hero.Kharazim,
            Hero.Leoric,
            Hero.Malthael,
            Hero.Raynor
        )
        Hero.Garrosh -> listOf(
            Hero.Malthael,
            Hero.Tychus,
            Hero.Valla,
            Hero.Arthas
        )
        Hero.Gazlowe -> listOf(
            Hero.Greymane,
            Hero.Guldan,
            Hero.Kaelthas,
            Hero.Nazeebo,
            Hero.Nova
        )
        Hero.Genji -> listOf(
            Hero.Varian,
            Hero.Malfurion,
            Hero.Lunara
        )
        Hero.Greymane -> listOf(
            Hero.Arthas,
            Hero.Brightwing,
            Hero.Johanna,
            Hero.Muradin,
            Hero.TheButcher,
            Hero.Uther,
            Hero.Xul
        )
        Hero.Guldan -> listOf(
            Hero.Illidan,
            Hero.Greymane,
            Hero.Kerrigan,
            Hero.Tracer
        )
        Hero.Hanzo -> listOf(
            Hero.Genji,
            Hero.Illidan,
            Hero.Zeratul
        )
        Hero.Illidan -> listOf(
            Hero.Arthas,
            Hero.Brightwing,
            Hero.ETC,
            Hero.LiLi,
            Hero.Johanna,
            Hero.Muradin,
            Hero.Sonya,
            Hero.Uther,
            Hero.Varian
        )
        Hero.Imperius -> listOf(
            Hero.Jaina,
            Hero.Raynor,
            Hero.SgtHammer,
            Hero.Zuljin,
            Hero.ETC,
            Hero.Lucio
        )
        Hero.Jaina -> listOf(
            Hero.Alarak,
            Hero.Anubarak,
            Hero.Chen,
            Hero.Genji,
            Hero.Nova,
            Hero.Tracer,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.Johanna -> listOf(
            Hero.Varian
        )
        Hero.Junkrat -> listOf(
            Hero.Illidan,
            Hero.Tracer,
            Hero.Zeratul,
            Hero.Tyrael,
            Hero.Genji
        )
        Hero.Kaelthas -> listOf(
            Hero.Illidan,
            Hero.Zeratul,
            Hero.Kerrigan,
            Hero.Tracer
        )
        Hero.KelThuzad -> listOf(
            Hero.Anubarak,
            Hero.Chen,
            Hero.Genji,
            Hero.Nova,
            Hero.Samuro,
            Hero.Tracer,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.Kerrigan -> listOf(
            Hero.Tyrael,
            Hero.ETC,
            Hero.Garrosh,
            Hero.Uther,
            Hero.Medivh,
            Hero.Auriel
        )
        Hero.Kharazim -> listOf(
            Hero.Johanna,
            Hero.Auriel,
            Hero.Medivh,
            Hero.Uther
        )
        Hero.Leoric -> listOf(
            Hero.Illidan,
            Hero.Tracer,
            Hero.Valla
        )
        Hero.LiLi -> listOf(
            Hero.Alarak,
            Hero.Anubarak,
            Hero.ETC,
            Hero.Jaina
        )
        Hero.LiMing -> listOf(
            Hero.Anubarak,
            Hero.Chen,
            Hero.Genji,
            Hero.Samuro,
            Hero.Tracer,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.LtMorales -> listOf(
            Hero.Garrosh,
            Hero.Chen,
            Hero.Chromie,
            Hero.Lunara,
            Hero.Auriel
        )
        Hero.Lucio -> listOf(
            Hero.Varian,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.Lunara -> listOf(
            Hero.Illidan,
            Hero.Genji,
            Hero.Malfurion,
            Hero.Stukov
        )
        Hero.Maiev -> listOf(
            Hero.Arthas,
            Hero.Diablo,
            Hero.ETC,
            Hero.Lucio
        )
        Hero.Malfurion -> listOf(
            Hero.Alarak,
            Hero.Anubarak,
            Hero.Artanis,
            Hero.Jaina,
            Hero.Kerrigan,
            Hero.LiMing,
            Hero.Tracer
        )
        Hero.MalGanis -> listOf(
            Hero.Garrosh,
            Hero.Hanzo,
            Hero.Zeratul,
            Hero.Malfurion
        )
        Hero.Malthael -> listOf(
            Hero.Falstad,
            Hero.LiMing,
            Hero.Lunara,
            Hero.Tracer,
            Hero.Valla
        )
        Hero.Medivh -> listOf(
            Hero.Guldan,
            Hero.Lunara,
            Hero.Garrosh,
            Hero.Malfurion
        )
        Hero.Mephisto -> listOf(
            Hero.Illidan,
            Hero.Artanis,
            Hero.Varian,
            Hero.Sonya,
            Hero.Kaelthas,
            Hero.KelThuzad,
            Hero.Junkrat
        )
        Hero.Muradin -> listOf(
            Hero.Tychus,
            Hero.Alarak,
            Hero.Jaina,
            Hero.Malthael
        )
        Hero.Murky -> listOf(
            Hero.Genji,
            Hero.LiMing,
            Hero.Nova,
            Hero.Tychus,
            Hero.Tracer,
            Hero.Zarya
        )
        Hero.Nazeebo -> listOf(
            Hero.ETC,
            Hero.Sylvanas
        )
        Hero.Nova -> listOf(
            Hero.Chen,
            Hero.Illidan,
            Hero.Johanna,
            Hero.Muradin,
            Hero.Tassadar,
            Hero.Tyrael,
            Hero.Zarya
        )
        Hero.Orphea -> listOf(
            Hero.Anubarak,
            Hero.Chen,
            Hero.Genji,
            Hero.Lunara,
            Hero.Muradin,
            Hero.Nova,
            Hero.Tracer
        )
        Hero.Probius -> listOf(
            Hero.Kerrigan,
            Hero.Alarak,
            Hero.Zeratul,
            Hero.Tracer
        )
        Hero.Qhira -> listOf(
            Hero.Lucio,
            Hero.Muradin,
            Hero.ETC
        )
        Hero.Ragnaros -> listOf(
            Hero.Chen,
            Hero.Lunara,
            Hero.Nova,
            Hero.Tracer
        )
        Hero.Raynor -> listOf(
            Hero.Johanna,
            Hero.Artanis,
            Hero.Cassia
        )
        Hero.Rehgar -> listOf(
            Hero.Muradin,
            Hero.Varian,
            Hero.Ana,
            Hero.Tracer
        )
        Hero.Rexxar -> listOf(
            Hero.Qhira,
            Hero.Zeratul
        )
        Hero.Samuro -> listOf(
            Hero.Alarak,
            Hero.Junkrat,
            Hero.Kaelthas,
            Hero.Zarya
        )
        Hero.SgtHammer -> listOf(
            Hero.Artanis,
            Hero.Chromie,
            Hero.KelThuzad,
            Hero.LiMing,
            Hero.Stitches
        )
        Hero.Sonya -> listOf(
            Hero.Brightwing,
            Hero.ETC,
            Hero.Lunara,
            Hero.Malthael,
            Hero.Muradin,
            Hero.Uther
        )
        Hero.Stitches -> listOf(
            Hero.Leoric,
            Hero.Anubarak,
            Hero.Tychus,
            Hero.Murky
        )
        Hero.Stukov -> listOf(
            Hero.Anubarak,
            Hero.Genji,
            Hero.Uther
        )
        Hero.Sylvanas -> listOf(
            Hero.Chen,
            Hero.Diablo,
            Hero.Genji,
            Hero.Nova,
            Hero.TheButcher,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.Tassadar -> listOf(
            Hero.Tracer,
            Hero.Greymane,
            Hero.Zeratul,
            Hero.Anubarak,
            Hero.Kerrigan
        )
        Hero.TheButcher -> listOf(
            Hero.Johanna,
            Hero.ETC,
            Hero.Brightwing,
            Hero.Uther
        )
        Hero.TheLostVikings -> listOf(
            Hero.Zagara,
            Hero.Sonya,
            Hero.Zeratul,
            Hero.Nova,
            Hero.Falstad,
            Hero.Dehaka,
            Hero.LiMing
        )
        Hero.Thrall -> listOf(
            Hero.Johanna,
            Hero.Arthas,
            Hero.Kaelthas,
            Hero.Lunara,
            Hero.Malfurion
        )
        Hero.Tracer -> listOf(
            Hero.Varian,
            Hero.Diablo,
            Hero.Medivh,
            Hero.Raynor,
            Hero.SgtHammer
        )
        Hero.Tychus -> listOf(
            Hero.Anubarak,
            Hero.Johanna,
            Hero.Lucio
        )
        Hero.Tyrael -> listOf(
            Hero.Garrosh,
            Hero.ETC,
            Hero.Zeratul,
            Hero.Greymane
        )
        Hero.Tyrande -> listOf(
            Hero.Anubarak,
            Hero.Murky,
            Hero.Zeratul,
            Hero.Maiev,
            Hero.Fenix,
            Hero.Lunara
        )
        Hero.Uther -> listOf(
            Hero.Guldan,
            Hero.Lunara,
            Hero.Malthael,
            Hero.Nazeebo,
            Hero.Sylvanas,
            Hero.Zagara
        )
        Hero.Valeera -> listOf(
            Hero.ETC,
            Hero.Arthas,
            Hero.Medivh,
            Hero.Lucio
        )
        Hero.Valla -> listOf(
            Hero.Greymane,
            Hero.Illidan,
            Hero.Nova,
            Hero.TheButcher,
            Hero.Valeera,
            Hero.Zeratul
        )
        Hero.Varian -> listOf(
            Hero.ETC,
            Hero.Arthas,
            Hero.Lunara,
            Hero.Medivh,
            Hero.Rehgar
        )
        Hero.Whitemane -> listOf(
            Hero.Alarak,
            Hero.LiMing,
            Hero.Raynor
        )
        Hero.Xul -> listOf(
            Hero.ETC,
            Hero.Johanna,
            Hero.Jaina,
            Hero.SgtHammer,
            Hero.Auriel
        )
        Hero.Yrel -> listOf(
            Hero.ETC,
            Hero.Lucio,
            Hero.Raynor,
            Hero.Johanna
        )
        Hero.Zagara -> listOf(
            Hero.Illidan,
            Hero.Falstad,
            Hero.Chen,
            Hero.Zeratul
        )
        Hero.Zarya -> listOf(
            Hero.Alarak,
            Hero.Illidan,
            Hero.Sylvanas,
            Hero.Jaina
        )
        Hero.Zeratul -> listOf(
            Hero.Artanis,
            Hero.Arthas,
            Hero.Brightwing,
            Hero.Cho,
            Hero.Johanna,
            Hero.Sonya,
            Hero.Uther,
            Hero.Varian
        )
        Hero.Zuljin -> listOf(
            Hero.ETC,
            Hero.Dehaka,
            Hero.Diablo,
            Hero.TheButcher,
            Hero.Zeratul
        )
    }
