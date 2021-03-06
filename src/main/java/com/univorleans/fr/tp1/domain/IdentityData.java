package com.univorleans.fr.tp1.domain;

public class IdentityData {

    private Long id;
    private String nom;
    private String prenom;

    public IdentityData(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
