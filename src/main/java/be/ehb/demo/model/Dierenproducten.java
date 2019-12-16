package be.ehb.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Dierenproducten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String productNaam;
    public String productOmschrijving;
    public BigDecimal prijs;
    public int aantal;
    public BigDecimal totaal;
    public String email;
    public String klantNaam;
    public String adres;
    public String woonplaats;
    public int postcode;

    public Dierenproducten() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getProductOmschrijving() {
        return productOmschrijving;
    }

    public void setProductOmschrijving(String productOmschrijving) {
        this.productOmschrijving = productOmschrijving;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public BigDecimal getTotaal() {
        return totaal;
    }

    public void setTotaal(BigDecimal totaal) {
        this.totaal = totaal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public void setKlantNaam(String klantNaam) {
        this.klantNaam = klantNaam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

}
