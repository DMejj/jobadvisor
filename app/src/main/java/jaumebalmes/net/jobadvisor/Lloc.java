package jaumebalmes.net.jobadvisor;

import java.util.List;

public class Lloc {

    private String nom;

    private Integer id;

    private Empresa empresa;

    private List<Opinio> opinions;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Opinio> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinio> opinions) {
        this.opinions = opinions;
    }
}
