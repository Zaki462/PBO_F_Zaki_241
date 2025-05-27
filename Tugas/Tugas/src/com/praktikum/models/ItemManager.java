package com.praktikum.models;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static List<Item> reportedItems = new ArrayList<>();

    static {
        reportedItems.add(new Item("Kunci Motor", "Gantungan warna biru", "Parkiran Utama", "Reported"));
        reportedItems.add(new Item("Dompet", "Dompet coklat berisi KTP", "Kantin Teknik", "Reported"));
        reportedItems.add(new Item("Flashdisk", "16GB warna hitam", "Lab AB", "Reported"));
    }
}