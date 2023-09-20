package com.example.project.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Kommune {
    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;
    /*
    The join to this class.
    * */
    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "kode")
    Region region;

    @ManyToOne
    @JoinColumn(name = "kommune",referencedColumnName = "kode")
    Kommune kommune;

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getKode() {
        return kode;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }
}
