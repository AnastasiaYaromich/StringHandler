package com.yaromich.demo.services;

import com.yaromich.demo.exceptions.StringFormatException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringService {

    public Map<Character, Integer> findCharsFrequency(String str) {
        Map<Character, Integer> frequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> y,
                        LinkedHashMap::new));
        return frequency;
    }

}
