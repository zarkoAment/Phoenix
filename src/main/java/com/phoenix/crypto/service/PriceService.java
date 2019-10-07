package com.phoenix.crypto.service;

import com.phoenix.crypto.client.PricesRestClient;
import com.phoenix.crypto.dao.CryptoDao;
import com.phoenix.crypto.entity.Crypto;
import com.phoenix.crypto.output.PricesCryptoOutput;
import com.phoenix.crypto.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PricesRestClient pricesRestClient;

//    @Autowired
//    private PricesRepository pricesRepository;

    @Autowired
    private CryptoDao cryptoDao;

    public ResponseEntity<PricesCryptoOutput[]> getInformation(String id) {
        return pricesRestClient.getCryptoInformation(id);
    }


    public List<Crypto> mapCrypto(List<PricesCryptoOutput> cryptoOutputs) {

        List<Crypto> cryptos = new ArrayList<>();

        cryptoOutputs.forEach(item -> {
            Crypto crypto = new Crypto();

            crypto.price_btc = item.getPrice_btc();
            crypto.name = item.getName();
            crypto.name = item.getName();
            crypto.symbol = item.getSymbol();
            crypto.rank = item.getRank();
            crypto.price_usd = item.getPrice_usd();
            crypto.price_btc = item.getPrice_btc();
            crypto.twentyFourHour_volume_usd = item.getTwentyFourHour_volume_usd();
            crypto.market_cap_usd = item.getMarket_cap_usd();
            crypto.available_supply = item.getAvailable_supply();
            crypto.total_supply = item.getTotal_supply();
            crypto.max_supply = item.getMax_supply();
            crypto.percent_change_1h = item.getPercent_change_1h();
            crypto.percent_change_7d = item.getPercent_change_7d();
            crypto.percent_change_24h = item.getPercent_change_24h();
            crypto.last_updated = item.getLast_updated();

            cryptos.add(crypto);
        });

        return cryptos;
    }

    private void saveCrypto(List<PricesCryptoOutput> pricesCryptoOutputs) {
        List<Crypto> cryptos = mapCrypto(pricesCryptoOutputs);
        System.out.println("cryptos" + cryptos);
        cryptoDao.saveAll(cryptos);
        System.out.println("=====>>>>>>> cryptoDao persisted");
    }

    public void initPrice(String id) {
        List<PricesCryptoOutput> pricesCryptoOutput = Arrays.asList(pricesRestClient.getCryptoInformation(id).getBody());
        System.out.println("pricesCryptoOutput ===   " + pricesCryptoOutput.get(0).toString());
        saveCrypto(pricesCryptoOutput);
    }

//    public String enableDisableAlert(String id, double alertPrice, boolean enableDisable) {
////        pricesRepository.enableDisableAlert(enableDisable);
//        if(enableDisable)
//            initMonitoringOfPrice(alertPrice, id);
//        return new EnableDisableAlertOutput(enableDisable, new Date()).toString();
//    }

//    public String initMonitoringOfPrice(double alertPrice, String id) {
//        System.out.println("===> Monitoring price <===");
//        List<PricesCryptoOutput> pricesCryptoOutput = Arrays.asList(pricesRestClient.getCryptoInformation(id).getBody());
//        System.out.println("pricesCryptoOutput ===   " + pricesCryptoOutput.get(0).toString());
//        saveCrypto(pricesCryptoOutput);
//
//        pricesCryptoOutput.forEach(item->{
//            System.out.println("item ===>>" + item.getPrice_usd() + "  |||  " +  item.getName());
//            if(item.getPrice_usd() > alertPrice) {
//                alertUser(item.getPrice_usd(), id);
//            }
//        });
//
//        return pricesCryptoOutput.toString();
//    }

    private void alertUser(double alertPrice, String id) {
        System.out.println("New price of "+id+" is "+alertPrice);
        SendMail.sendMail(alertPrice);
    }
}
