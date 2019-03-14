package jaumebalmes.net.jobadvisor;

import java.util.List;

public class Sector {

    private String nom;

    private Integer id;


    private List<Empresa>  empreses;

    public Sector() {
    }

    public Sector(String nom) {
        this.nom = nom;
    }

    public Sector(String nom, List<Empresa> empreses) {
        this.nom = nom;
        this.empreses = empreses;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public List<Empresa> getEmpreses() {
        return empreses;
    }

    public void setEmpreses(List<Empresa> empreses) {
        this.empreses = empreses;
    }
}
