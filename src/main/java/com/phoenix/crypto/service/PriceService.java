package com.phoenix.crypto.service;

import com.phoenix.crypto.client.PricesRestClient;

import com.phoenix.crypto.dao.CryptoDao;

import com.phoenix.crypto.entity.Crypto;
import com.phoenix.crypto.output.EnableDisableAlertOutput;
import com.phoenix.crypto.output.PricesCryptoOutput;
import com.phoenix.crypto.repository.PricesRepository;
import com.phoenix.crypto.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PriceService {

    @Autowired
    private PricesRestClient pricesRestClient;

    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private CryptoDao cryptoDao;

//    @Autowired
//    private CryptoDao cryptoDao;

    public Optional<List<PricesCryptoOutput>> getInformation(String id) {
        System.out.println("PriceService getInfo ==>> " + pricesRestClient.getCryptoInformation(id));
        return pricesRestClient.getCryptoInformation(id);
    }

    public List<Crypto> mapCrypto(List<PricesCryptoOutput> cryptoOutputs) {

        List<Crypto> cryptos = new ArrayList<>();

        cryptoOutputs.forEach($ -> {
            Crypto crypto = new Crypto();
            crypto.price_btc = $.getPrice_btc();
            crypto.name = $.getName();
            //...

        });

        return cryptos;

    }

    private void saveCrypto(List<PricesCryptoOutput> pricesCryptoOutputs) {
        List<Crypto> cryptos = mapCrypto(pricesCryptoOutputs);
        cryptoDao.saveAll(cryptos);
    }



    public String enableDisableAlert(@NonNull String id, double alertPrice, boolean enableDisable) {
        pricesRepository.enableDisableAlert(enableDisable);
        if(enableDisable)
            initMonitoringOfPrice(alertPrice, id);
        return new EnableDisableAlertOutput(enableDisable, new Date()).toString();
    }

    public String initMonitoringOfPrice(double alertPrice, String id) {
        System.out.println("===> Monitoring price <===");

        Optional<List<PricesCryptoOutput>> pricesCryptoOutput = pricesRestClient.getCryptoInformation(id);

        pricesCryptoOutput.ifPresent(this::saveCrypto);

        // primjer mapiranja tipova pomocu optionala
        return pricesCryptoOutput.map($ -> $.get(0).getName()).orElse("no_name");
    }

    private void alertUser(double alertPrice, String id) {
        System.out.println("New price of "+id+" is "+alertPrice);
        SendMail.sendMail(alertPrice);
    }

}
