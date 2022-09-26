package com.sparta.func;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Author> result = getAuthors();
            Author authorResult = result.stream()
                            .findFirst().get();
            System.out.println(authorResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Author> getAuthors() throws IOException {
        List<Author> result = Files
                .lines(Path.of("authors.csv"))
                .skip(1)
                .map((String s) -> {
                    return s.split(",");
                })
//                .filter(e -> e[2].charAt(0) == 'M')
                .map(s -> new Author(s[1], s[2]))
                .peek(System.out::println)
                .toList();
        return result;
    }
}