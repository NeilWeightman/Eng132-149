package com.sparta.apitest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiclient.ChuckObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class ChuckTest {
    @Test
    void checkValue(){
        ObjectMapper mapper = new ObjectMapper();
        ChuckObject joke = null;
        try {
            joke = mapper.readValue(
                    new URL("https://api.chucknorris.io/jokes/random"),
                    ChuckObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(joke.getValue());
    }
}
