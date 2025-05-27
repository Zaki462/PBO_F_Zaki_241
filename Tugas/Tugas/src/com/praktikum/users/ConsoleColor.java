package com.praktikum.users;

public class ConsoleColor {
    // Warna teks
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    // Warna latar belakang (opsional)
    private static final String BG_RED = "\u001B[41m";
    private static final String BG_GREEN = "\u001B[42m";
    private static final String BG_YELLOW = "\u001B[43m";
    private static final String BG_BLUE = "\u001B[44m";
    private static final String BG_PURPLE = "\u001B[45m";
    private static final String BG_CYAN = "\u001B[46m";
    private static final String BG_WHITE = "\u001B[47m";

    // Reset & efek teks
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";

    // Fungsi pembungkus warna teks
    public static String black(String text) { return BLACK + text + RESET; }
    public static String red(String text) { return RED + text + RESET; }
    public static String green(String text) { return GREEN + text + RESET; }
    public static String yellow(String text) { return YELLOW + text + RESET; }
    public static String blue(String text) { return BLUE + text + RESET; }
    public static String purple(String text) { return PURPLE + text + RESET; }
    public static String cyan(String text) { return CYAN + text + RESET; }
    public static String white(String text) { return WHITE + text + RESET; }

    // Fungsi pembungkus latar belakang (opsional)
    public static String bgRed(String text) { return BG_RED + text + RESET; }
    public static String bgGreen(String text) { return BG_GREEN + text + RESET; }
    public static String bgYellow(String text) { return BG_YELLOW + text + RESET; }
    public static String bgBlue(String text) { return BG_BLUE + text + RESET; }
    public static String bgPurple(String text) { return BG_PURPLE + text + RESET; }
    public static String bgCyan(String text) { return BG_CYAN + text + RESET; }
    public static String bgWhite(String text) { return BG_WHITE + text + RESET; }

    // Efek teks tambahan
    public static String bold(String text) { return BOLD + text + RESET; }
    public static String underline(String text) { return UNDERLINE + text + RESET; }
}