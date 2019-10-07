package com.phoenix.crypto.client;

import com.phoenix.crypto.output.PricesCryptoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PricesRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<PricesCryptoOutput[]> getCryptoInformation(String id) {
        System.out.println("API CoinMarketCap");
        System.out.println("restTemplate ==>> "+ restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/"+id, PricesCryptoOutput[].class));

        return restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/"+id, PricesCryptoOutput[].class);
   }
}
