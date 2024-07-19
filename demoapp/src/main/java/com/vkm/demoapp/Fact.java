package com.vkm.demoapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Fact {

    @CrossOrigin
    @GetMapping("/fact")
    public ResponseEntity<Map<String, Object>> factorial(@RequestParam int n) {
        long fact = calculateFactorial(n);
        Map<String, Object> response = new HashMap<>();
        response.put("n", n);
        response.put("factorial", fact);
        return ResponseEntity.ok(response);
    }

    private long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
