package com.github.ysbbbbbb.kaleidoscopetavern.util;

import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagMod;
import com.google.common.collect.Maps;
import net.minecraft.ChatFormatting;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class ColorUtils {
    public static final String[] COLORS = new String[]{
            "white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow",
            "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink"
    };

    public static final Map<TagKey<Item>, ChatFormatting> COCKTAIL_INGREDIENT_COLORS = Util.make(Maps.newHashMap(), colors -> {
        colors.put(TagMod.COCKTAIL_INGREDIENT_BLACK, ChatFormatting.BLACK);
        colors.put(TagMod.COCKTAIL_INGREDIENT_DARK_BLUE, ChatFormatting.DARK_BLUE);
        colors.put(TagMod.COCKTAIL_INGREDIENT_DARK_GREEN, ChatFormatting.DARK_GREEN);
        colors.put(TagMod.COCKTAIL_INGREDIENT_DARK_AQUA, ChatFormatting.DARK_AQUA);
        colors.put(TagMod.COCKTAIL_INGREDIENT_DARK_RED, ChatFormatting.DARK_RED);
        colors.put(TagMod.COCKTAIL_INGREDIENT_DARK_PURPLE, ChatFormatting.DARK_PURPLE);
        colors.put(TagMod.COCKTAIL_INGREDIENT_GOLD, ChatFormatting.GOLD);
        colors.put(TagMod.COCKTAIL_INGREDIENT_GRAY, ChatFormatting.GRAY);
        colors.put(TagMod.COCKTAIL_INGREDIENT_DARK_GRAY, ChatFormatting.DARK_GRAY);
        colors.put(TagMod.COCKTAIL_INGREDIENT_BLUE, ChatFormatting.BLUE);
        colors.put(TagMod.COCKTAIL_INGREDIENT_GREEN, ChatFormatting.GREEN);
        colors.put(TagMod.COCKTAIL_INGREDIENT_AQUA, ChatFormatting.AQUA);
        colors.put(TagMod.COCKTAIL_INGREDIENT_RED, ChatFormatting.RED);
        colors.put(TagMod.COCKTAIL_INGREDIENT_LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE);
        colors.put(TagMod.COCKTAIL_INGREDIENT_YELLOW, ChatFormatting.YELLOW);
        colors.put(TagMod.COCKTAIL_INGREDIENT_WHITE, ChatFormatting.WHITE);
    });

    @SuppressWarnings("deprecation")
    public static final Function<Item, ChatFormatting> ITEM_COLOR_CACHE = Util.memoize(item -> {
        for (var entry : COCKTAIL_INGREDIENT_COLORS.entrySet()) {
            if (item.builtInRegistryHolder().is(entry.getKey())) {
                return entry.getValue();
            }
        }
        return ChatFormatting.RESET;
    });

    public static int mixColors(List<ChatFormatting> colors) {
        return mixColors(colors.toArray(new ChatFormatting[0]));
    }

    public static int mixColors(ChatFormatting... colors) {
        int red = 0;
        int green = 0;
        int blue = 0;
        int count = 0;
        if (colors != null) {
            for (ChatFormatting format : colors) {
                Integer color = color(format);
                if (format != ChatFormatting.RESET && color != null) {
                    red += color >> 16 & 0xFF;
                    green += color >> 8 & 0xFF;
                    blue += color & 0xFF;
                    count++;
                }
            }
        }
        return count == 0 ? 0xFFFFFF : (red / count << 16) | (green / count << 8) | blue / count;
    }

    public static String name(ChatFormatting formatting) {
        return formatting.name().toLowerCase(Locale.ROOT);
    }

    public static int serializedId(ChatFormatting formatting) {
        return formatting.ordinal();
    }

    public static ChatFormatting bySerializedId(int id) {
        ChatFormatting[] values = ChatFormatting.values();
        return 0 <= id && id < values.length ? values[id] : null;
    }

    public static Integer color(ChatFormatting formatting) {
        if (formatting == null) {
            return null;
        }
        return switch (formatting) {
            case BLACK -> 0x000000;
            case DARK_BLUE -> 0x0000AA;
            case DARK_GREEN -> 0x00AA00;
            case DARK_AQUA -> 0x00AAAA;
            case DARK_RED -> 0xAA0000;
            case DARK_PURPLE -> 0xAA00AA;
            case GOLD -> 0xFFAA00;
            case GRAY -> 0xAAAAAA;
            case DARK_GRAY -> 0x555555;
            case BLUE -> 0x5555FF;
            case GREEN -> 0x55FF55;
            case AQUA -> 0x55FFFF;
            case RED -> 0xFF5555;
            case LIGHT_PURPLE -> 0xFF55FF;
            case YELLOW -> 0xFFFF55;
            case WHITE -> 0xFFFFFF;
            default -> null;
        };
    }
}
