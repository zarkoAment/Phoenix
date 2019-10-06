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
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PricesRestClient pricesRestClient;

    @Autowired
    private PricesRepository pricesRepository;

//    @Autowired
//    private CryptoDao cryptoDao;

    public ResponseEntity<PricesCryptoOutput[]> getInformation(String id) {
        System.out.println("PriceService getInfo ==>> " + pricesRestClient.getCryptoInformation(id));
        return pricesRestClient.getCryptoInformation(id);
    }

//    public Crypto addCrypto(Crypto crypto){
//        return this.cryptoDao.save(crypto);
//    }


    public String enableDisableAlert(String id, double alertPrice, boolean enableDisable) {
        pricesRepository.enableDisableAlert(enableDisable);
        if(enableDisable)
            initMonitoringOfPrice(alertPrice, id);
        return new EnableDisableAlertOutput(enableDisable, new Date()).toString();
    }

    public String initMonitoringOfPrice(double alertPrice, String id) {
        System.out.println("===> Monitoring price <===");
        List<PricesCryptoOutput> info = Arrays.asList(pricesRestClient.getCryptoInformation(id).getBody());
        System.out.println("info === " + info);
        info.forEach(item->{
            System.out.println("item ===>>" + item.getPrice_usd() + "  |||  " +  item.getName());
            if(Double.parseDouble(item.getPrice_usd()) > alertPrice) {
                alertUser(Double.parseDouble(item.getPrice_usd()), id);
            }
        });
        return info.toString();
    }

    private void alertUser(double alertPrice, String id) {
        System.out.println("New price of "+id+" is "+alertPrice);
        SendMail.sendMail(alertPrice);
    }

}
