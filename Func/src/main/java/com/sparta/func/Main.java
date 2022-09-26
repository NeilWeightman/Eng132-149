package com.sparta.func;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> result = Files
                    .lines(Path.of("authors.csv"))
                    .skip(1)
                    .map(s -> s.split(","))
                    .filter(e -> e[2].charAt(0) == 'M')
                    .map(s -> s[1] + " " + s[2])
                    .toList();
//                    .forEach(s -> System.out.println(s[1] + " " + s[2])); // terminal operation (doesn't result in a Stream)
            result = new ArrayList<>(result);
            System.out.println(result.getClass());
            result.add("Pavitar Singh");
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}