package org.sparta.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> phoneBook = new TreeMap<>();
        phoneBook.put("Yannan", 345678); // auto-boxing
        int num = phoneBook.get("Yannan"); // auto-unboxing
        System.out.println(phoneBook);
        phoneBook.put("Bahadir", 987654);
        System.out.println(phoneBook);
    }
}
