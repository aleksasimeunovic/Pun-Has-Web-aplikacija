package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {

    @Column(name = "BrojSkupljenihBod")
    private int brojSkupljenihBod;

    @OneToOne()
    private TipKupca Tip;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Porudzbina> listaPorudzbina = new HashSet<>();

    public Kupac(Korisnik k, Set<Porudzbina> listaPorudzbina, int brojSkupljenihBod, TipKupca Tip){
        super(k);
        this.listaPorudzbina = listaPorudzbina;
        this.brojSkupljenihBod = brojSkupljenihBod;
        this.Tip = Tip;
    }
    public Kupac(){}

    public Kupac(String username, String password, String name, String lastName, POLOVI pol, Date date, ULOGA kupac) {
        super.username = username;
        super.password = password;
        super.name = name;
        super.lastName = lastName;
        super.Pol = pol;
        super.Datum_rodjenja = date;
        super.Uloga = kupac;
    }

    public int getBrojSkupljenihBod() {
        return brojSkupljenihBod;
    }
    public void setBrojSkupljenihBod(int brojSkupljenihBod) {
        this.brojSkupljenihBod = brojSkupljenihBod;
    }

    public TipKupca getTip() {
        return Tip;
    }

    public void setTip(TipKupca tip) {
        Tip = tip;
    }

    public Set<Porudzbina> getListaPorudzbina() {
        return listaPorudzbina;
    }

    public void setListaPorudzbina(Set<Porudzbina> listaPorudzbina) {
        this.listaPorudzbina = listaPorudzbina;
    }

}