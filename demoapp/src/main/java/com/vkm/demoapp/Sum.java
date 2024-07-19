package com.vkm.demoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Sum {

    @GetMapping("/sum")
    public ResponseEntity<Map<String, Object>> sumOfN(@RequestParam int n) {
        int sum = calculateSum(n);
        Map<String, Object> response = new HashMap<>();
        response.put("n", n);
        response.put("sum", sum);
        return ResponseEntity.ok(response);
    }

    private int calculateSum(int n) {
        return n * (n + 1) / 2; // Using the formula for the sum of the first n natural numbers
    }
}
