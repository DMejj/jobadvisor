package jaumebalmes.net.jobadvisor;

import java.util.List;

public class Empresa {

    private String nom;
    private String adreca;
    private String poblacio;
    private String societat;

    private Sector sector;

    private int numtreballadors;

    private Integer id;

    private List<Lloc> llocs;

    public void addLloc(Lloc lloc){
        llocs.add(lloc);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getSocietat() {
        return societat;
    }

    public void setSocietat(String societat) {
        this.societat = societat;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public int getNumtreballadors() {
        return numtreballadors;
    }

    public void setNumtreballadors(int numtreballadors) {
        this.numtreballadors = numtreballadors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Lloc> getLlocs() {
        return llocs;
    }

    public void setLlocs(List<Lloc> llocs) {
        this.llocs = llocs;
    }
}
