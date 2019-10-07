package com.phoenix.crypto.utils;

import com.phoenix.crypto.repository.PricesRepository;
import com.phoenix.crypto.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulingTasks {

    @Autowired
    private PriceService priceService;

    @Autowired
    private PricesRepository pricesRepository;

    private final long SECONDS = 1000;
    private final long MINUTES = SECONDS * 60;

    @Scheduled(fixedDelay = MINUTES)
    public void reportPrice() {
        if(pricesRepository.getValueAlert().isStatus()) {
            priceService.initMonitoringOfPrice(pricesRepository.getValueAlert().getPrice(), pricesRepository.getValueAlert().getId());
        }
    }

//    @Scheduled(fixedDelay = MINUTES)
//    public void savePrice() {
//        priceService.initPrice(pricesRepository.getValueAlert().getId());
//    }
}
