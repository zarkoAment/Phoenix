package com.phoenix.crypto.entity;


import javax.persistence.*;

@Entity
@Table (name = "CRYPTO_TABLE")
public class Crypto {
    @Column (name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column (name = "CRYPTO_NAME", nullable = true, length = 50)
    public String name;

    @Column (name = "CRYPTO_SYMBOL", nullable = true, length = 9)
    public String symbol;

    @Column (name = "CRYPTO_RANK", nullable = true, length = 200)
    public int rank;

    @Column (name = "CRYPTO_PRICE_USD", nullable = true, length = 15)
    public double price_usd;

    @Column (name = "CRYPTO_PRICE_BTC", nullable = true, length = 15)
    public double price_btc;

    @Column (name = "CRYPTO_TWENTYFOURHOUR_VOLUME_USD", nullable = true, length = 9)
    public double twentyFourHour_volume_usd;

    @Column (name = "CRYPTO_MARKET_CAP_USD", nullable = true, length = 15)
    public double market_cap_usd;

    @Column (name = "CRYPTO_AV_SUPPLY", nullable = true, length = 9)
    public double available_supply;

    @Column (name = "CRYPTO_TOT_SUPPLY", nullable = true, length = 9)
    public double total_supply;

    @Column (name = "CRYPTO_MAX_SUPPLY", nullable = true, length = 9)
    public double max_supply;

    @Column (name = "CRYPTO_PERCENT_CHANGE_HR", nullable = true, length = 5)
    public double percent_change_1h;

    @Column (name = "CRYPTO_PERCENT_CHANGE_DAY", nullable = true, length = 5)
    public double percent_change_24h;

    @Column (name = "CRYPTO_PERCENT_CHANGE_WK", nullable = true, length = 5)
    public double percent_change_7d;

    @Column (name = "CRYPTO_LAST_UPDATE", nullable = true, length = 5)
    public double last_updated;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getrank() {
        return rank;
    }

    public double getprice_usd() {
        return price_usd;
    }

    public double getprice_btc() {
        return price_btc;
    }

    public double gettwentyFourHour_volume_usd() {
        return twentyFourHour_volume_usd;
    }

    public double getmarket_cap_usd() {
        return market_cap_usd;
    }

    public double getavailable_supply() {
        return available_supply;
    }

    public double gettotal_supply() {
        return total_supply;
    }

    public double getmax_supply() {
        return max_supply;
    }

    public double getpercent_change_1h() {
        return percent_change_1h;
    }

    public double getpercent_change_24h() {
        return percent_change_24h;
    }

    public double getpercent_change_7d() {
        return percent_change_7d;
    }

    public double getlast_updated() {
        return last_updated;
    }

}
