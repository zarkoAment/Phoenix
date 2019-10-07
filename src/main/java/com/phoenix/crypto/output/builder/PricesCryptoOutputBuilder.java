package com.phoenix.crypto.output.builder;

import com.phoenix.crypto.output.PricesCryptoOutput;

public class PricesCryptoOutputBuilder {
    public String id;
    public String name;
    public String symbol;
    public int rank;
    public double price_usd;
    public double price_btc;
    public double twentyFourHour_volume_usd;
    public double market_cap_usd;
    public double available_supply;
    public double total_supply;
    public double max_supply;
    public double percent_change_1h;
    public double percent_change_24h;
    public double percent_change_7d;
    public double last_updated;

    public PricesCryptoOutputBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PricesCryptoOutputBuilder name(String name) {
        this.name = name;
        return this;
    }


    public PricesCryptoOutputBuilder symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public PricesCryptoOutputBuilder rank(int rank) {
        this.rank = rank;
        return this;
    }

    public PricesCryptoOutputBuilder price_usd(double price_usd) {
        this.price_usd = price_usd;
        return this;
    }

    public PricesCryptoOutputBuilder price_btc(double price_btc) {
        this.price_btc = price_btc;
        return this;
    }

    public PricesCryptoOutputBuilder twentyFourHour_volume_usd(double twentyFourHour_volume_usd) {
        this.twentyFourHour_volume_usd = twentyFourHour_volume_usd;
        return this;
    }

    public PricesCryptoOutputBuilder market_cap_usd(double market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
        return this;
    }

    public PricesCryptoOutputBuilder available_supply(double available_supply) {
        this.available_supply = available_supply;
        return this;
    }

    public PricesCryptoOutputBuilder total_supply(double total_supply) {
        this.total_supply = total_supply;
        return this;
    }

    public PricesCryptoOutputBuilder max_supply(double max_supply) {
        this.max_supply = max_supply;
        return this;
    }

    public PricesCryptoOutputBuilder percent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
        return this;
    }

    public PricesCryptoOutputBuilder percent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
        return this;
    }

    public PricesCryptoOutputBuilder percent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
        return this;
    }

    public PricesCryptoOutputBuilder last_updated(double last_updated) {
        this.last_updated = last_updated;
        return this;
    }

    public PricesCryptoOutput build() {
        return new PricesCryptoOutput(this);
    }
}
