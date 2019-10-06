package com.phoenix.crypto.client;

import com.phoenix.crypto.output.PricesCryptoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class PricesRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<List<PricesCryptoOutput>> getCryptoInformation(String id) {
        System.out.println("API CoinMarketCap");
        System.out.println("restTemplate ==>> "+ restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/"+id, PricesCryptoOutput[].class));

        ResponseEntity<PricesCryptoOutput[]> response =
                restTemplate.getForEntity(
                        "https://api.coinmarketcap.com/v1/ticker/"+id,
                        PricesCryptoOutput[].class
                );

        HttpStatus status = response.getStatusCode();

        if (response.getBody() != null && status == HttpStatus.OK) {
            return Optional.of(Arrays.asList(response.getBody()));
        } else {
            // log
            return Optional.empty();
        }


    }
}
