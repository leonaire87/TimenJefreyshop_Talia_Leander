package be.ehb.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Dierenproduct {

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

    public Dierenproduct() {
    }

    public Dierenproduct(@NotBlank String dierenSoort, @NotBlank String productNaam, @NotBlank String productOmschrijving, @NotBlank String imgurl, @NotNull BigDecimal prijs) {
        this.dierenSoort = dierenSoort;
        this.productNaam = productNaam;
        this.productOmschrijving = productOmschrijving;
        this.imgurl = imgurl;
        this.prijs = prijs;
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

    @Override
    public String toString() {
        return "Dierenproducten{" +
                "id=" + id +
                ", dierenSoort='" + dierenSoort + '\'' +
                ", productNaam='" + productNaam + '\'' +
                ", productOmschrijving='" + productOmschrijving + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
