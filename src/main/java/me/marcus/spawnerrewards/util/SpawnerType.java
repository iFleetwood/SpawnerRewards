package me.marcus.spawnerrewards.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SpawnerType {

    CREEPER(50),
    SKELETON(51),
    SPIDER(52),
    GIANT(53),
    ZOMBIE(54),
    SLIME(55),
    GHAST(56),
    PIG_ZOMBIE(57),
    ENDERMAN(58),
    CAVE_SPIDER(59),
    SILVERFISH(60),
    BLAZE(61),
    MAGMA_CUBE(62),
    ENDER_DRAGON(63),
    WITHER(64),
    BAT(65),
    WITCH(66),
    PIG(90),
    SHEEP(91),
    COW(92),
    CHICKEN(93),
    SQUID(94),
    WOLF(95),
    MOOSHROOM(96),
    SNOWMAN(97),
    OCELOT(98),
    IRON_GOLEM(99),
    HORSE(100);



    @Getter
    private int id;
}
