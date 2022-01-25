package com.univorleans.fr.tp1.domain;


public class Student {

    private Long id;
    private String numeroEtu;
    private String nom;
    private String prenom;

    public Student(Long id, String numeroEtu, String nom, String prenom) {
        this.id = id;
        this.numeroEtu = numeroEtu;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroEtu() {
        return numeroEtu;
    }

    public void setNumeroEtu(String numeroEtu) {
        this.numeroEtu = numeroEtu;
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
}
