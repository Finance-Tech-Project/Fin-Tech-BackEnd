package com.fin_tech.controller;


import com.fin_tech.dto.StockQuoteDto;
import com.fin_tech.service.StockQuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quotes/")
public class StockQuoteController {
    private final StockQuoteService stockQuoteService;

    @GetMapping("{symbol}/history")
    public List<List<StockQuoteDto>> getQuotes(@PathVariable String symbol, @RequestParam String p) {
        return null;
    }

}
