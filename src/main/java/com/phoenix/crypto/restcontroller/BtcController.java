//package com.phoenix.crypto.restcontroller;
//
//
//import com.phoenix.crypto.entity.Btc;
//import com.phoenix.crypto.output.PricesCryptoOutput;
//import com.phoenix.crypto.output.builder.PricesCryptoOutputBuilder;
//import com.phoenix.crypto.service.BtcService;
//import com.phoenix.crypto.service.PriceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
////@RestController
////@RequestMapping("/btc")
//public class BtcController {
////    @Autowired
////    BtcService btcService;
////
////
////    private PricesCryptoOutputBuilder pricesCryptoOutput;
////
////    @RequestMapping(value = "/all", method = RequestMethod.GET)
////    public List<Btc> getAllUsers() {
////        return this.btcService.getAllUBtc();
////    }
////
////
////    @RequestMapping(value = "/addbtc", method = RequestMethod.POST,
////            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
////    public Btc addBtc(@RequestBody Btc btc) {
////        btc.setId(pricesCryptoOutput.id);
////        btc.setPrice(pricesCryptoOutput.price_usd);
////        return this.btcService.addBtc(btc);
////    }
////
////
////    @RequestMapping(value = "/updatebtc", method = RequestMethod.PUT,
////            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
////    public Btc updateBtc(@RequestBody Btc btc) {
////        return this.btcService.updateBtc(btc);
////    }
////
////    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
////    public Optional<Btc> getBtc(@PathVariable int id) {
////        return this.btcService.getBtcById(id);
////    }
////
////    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
////    public void deleteAllUsers() {
////        this.btcService.deleteAllBtc();
////    }
////
////    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
////    public void deleteUser(@PathVariable int id) {
////        this.btcService.deleteBtcById(id);
////    }
////
////    @Autowired
////    MessageSource messageSource;
////
////    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
////    public String greeting() {
////        /**
////         *   @LocaleContextHolder.getLocale()
////         *  Return the Locale associated with the given user context,if any, or the system default Locale otherwise.
////         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a user-level Locale setting.
////         */
////
////        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
////    }
////
////    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
////    public String greetingWithName() {
////        String[] params = new String[]{"Aiwass", "today"};
////        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
////    }
//
//}
