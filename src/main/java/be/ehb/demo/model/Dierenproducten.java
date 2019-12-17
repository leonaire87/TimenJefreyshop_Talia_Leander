package be.ehb.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Dierenproducten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String dierenSoort;

    @NotBlank
    private String productNaam;

    @NotBlank
    private String productOmschrijving, imgurl;

    @NotNull
    private BigDecimal prijs;


    public Dierenproducten() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDierenSoort() {
        return dierenSoort;
    }

    public void setDierenSoort(String dierenSoort) {
        this.dierenSoort = dierenSoort;
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
}
