package com.yaromich.demo.controllers;

import com.yaromich.demo.exceptions.StringFormatException;
import com.yaromich.demo.services.StringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/string")
@RequiredArgsConstructor
@Tag(name = "Строки", description = "Методы работы со строками")
public class StringController {

    private final StringService stringService;


    @Operation(
            summary = "Запрос на обработку строки",
            responses = {
                    @ApiResponse(
                            description = "Строка успешно обработана", responseCode = "202"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<Character, Integer> getCharsFrequency(@RequestBody String str) {
        return stringService.findCharsFrequency(str);
    }


}
