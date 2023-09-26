package com.yaromich.demo;

import com.yaromich.demo.services.StringService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = StringService.class)
public class StringServiceTests {
    @Autowired
    private StringService stringService;

    @Test
    public void jsonStringIsCorrectlyHandled() throws Exception {
        String str = "aabbbcccc";
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 4);

        String str1 = "abbbcccc";

        assertEquals(map, stringService.findCharsFrequency(str));
        assertNotEquals(map, stringService.findCharsFrequency(str1));
    }
}
