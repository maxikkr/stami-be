//Stellt Transaktionen als Model da
package com.example.stami_be.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "transaktionen")
public class Transaktion {

    @Id
    private String id;
    private Date datum;
    private String kaufVerkauf;
    private String ticker;
    private int anzahl;
    private double preis;

    public Transaktion() {}

    public Transaktion(Date datum, String kaufVerkauf, String ticker, int anzahl, double preis) {
        this.datum = datum;
        this.kaufVerkauf = kaufVerkauf;
        this.ticker = ticker;
        this.anzahl = anzahl;
        this.preis = preis;
    }

    // Getter und Setter
    public String getId() { return id; }
    public Date getDatum() { return datum; }
    public String getKaufVerkauf() { return kaufVerkauf; }
    public String getTicker() { return ticker; }
    public int getAnzahl() { return anzahl; }
    public double getPreis() { return preis; }

    public void setDatum(Date datum) { this.datum = datum; }
    public void setKaufVerkauf(String kaufVerkauf) { this.kaufVerkauf = kaufVerkauf; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public void setAnzahl(int anzahl) { this.anzahl = anzahl; }
    public void setPreis(double preis) { this.preis = preis; }
}

