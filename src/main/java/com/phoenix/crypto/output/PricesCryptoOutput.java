package com.phoenix.crypto.output;

import com.phoenix.crypto.output.builder.PricesCryptoOutputBuilder;

//DTO - model
public class PricesCryptoOutput {
    private String id;
    private String name;
    private String symbol;
    private int rank;
    private double price_usd;
    private double price_btc;
    private double twentyFourHour_volume_usd;
    private double market_cap_usd;
    private double available_supply;
    private double total_supply;
    private double max_supply;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;
    private double last_updated;

    public PricesCryptoOutput(PricesCryptoOutputBuilder pricesCryptoOutputBuilder){
        id = pricesCryptoOutputBuilder.id;
        name = pricesCryptoOutputBuilder.name;
        symbol = pricesCryptoOutputBuilder.symbol;
        rank = pricesCryptoOutputBuilder.rank;
        price_usd = pricesCryptoOutputBuilder.price_usd;
        price_btc = pricesCryptoOutputBuilder.price_btc;
        twentyFourHour_volume_usd = pricesCryptoOutputBuilder.twentyFourHour_volume_usd;
        market_cap_usd = pricesCryptoOutputBuilder.market_cap_usd;
        available_supply = pricesCryptoOutputBuilder.available_supply;
        total_supply = pricesCryptoOutputBuilder.total_supply;
        max_supply = pricesCryptoOutputBuilder.max_supply;
        percent_change_1h = pricesCryptoOutputBuilder.percent_change_1h;
        percent_change_24h = pricesCryptoOutputBuilder.percent_change_24h;
        percent_change_7d = pricesCryptoOutputBuilder.percent_change_7d;
        last_updated = pricesCryptoOutputBuilder.last_updated;
    }

    public PricesCryptoOutput() {

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public double getPrice_usd() {
        return price_usd;
    }
    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }
    public double getPrice_btc() {
        return price_btc;
    }
    public void setPrice_btc(double price_btc) {
        this.price_btc = price_btc;
    }
    public double getTwentyFourHour_volume_usd() {
        return twentyFourHour_volume_usd;
    }
    public void setTwentyFourHour_volume_usd(double twentyFourHour_volume_usd) {
        this.twentyFourHour_volume_usd = twentyFourHour_volume_usd;
    }
    public double getMarket_cap_usd() {
        return market_cap_usd;
    }
    public void setMarket_cap_usd(double market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }
    public double getAvailable_supply() {
        return available_supply;
    }
    public void setAvailable_supply(double available_supply) {
        this.available_supply = available_supply;
    }
    public double getTotal_supply() {
        return total_supply;
    }
    public void setTotal_supply(double total_supply) {
        this.total_supply = total_supply;
    }
    public double getMax_supply() {
        return max_supply;
    }
    public void setMax_supply(double max_supply) {
        this.max_supply = max_supply;
    }
    public double getPercent_change_1h() {
        return percent_change_1h;
    }
    public void setPercent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }
    public double getPercent_change_24h() {
        return percent_change_24h;
    }
    public void setPercent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }
    public double getPercent_change_7d() {
        return percent_change_7d;
    }
    public void setPercent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }
    public double getLast_updated() {
        return last_updated;
    }
    public void setLast_updated(double last_updated) {
        this.last_updated = last_updated;
    }
}
