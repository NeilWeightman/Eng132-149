package org.sparta.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>(Set.of("Abdullah", "Goncalo", "Andrei"));
        mySet.add("Luca");
        mySet.add("Eve");
        mySet.add("Abdullah");
        System.out.println(mySet);
    }
}
