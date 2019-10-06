package com.phoenix.crypto.restcontroller;

import com.phoenix.crypto.entity.Crypto;
import com.phoenix.crypto.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@RestController
@RequestMapping("/query/prices/crypto")
public class PricesCoinMarketCapRest {

    @Autowired
    private PriceService priceService;

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getPrices(@PathVariable String id){
        System.out.println("RestControler ===>> " + ResponseEntity.ok(priceService.getInformation(id).getBody()));
        return ResponseEntity.ok(priceService.getInformation(id).getBody());
    }

    @PostMapping(value="alert/{id}")
    public ResponseEntity<?> enableAlertPrices(@PathVariable String id, @RequestParam Double valueAlert, @RequestParam Boolean enableDisable){
        return ResponseEntity.ok(priceService.enableDisableAlert(id, 20.00, enableDisable));
    }

}
