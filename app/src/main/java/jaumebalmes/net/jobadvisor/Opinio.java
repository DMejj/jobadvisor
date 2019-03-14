package jaumebalmes.net.jobadvisor;

public class Opinio {

    private Boolean subcontracte;
    private double salari;
    private String periode; //Salari* (període)
    private int puntuacio; //recomanació del 1 al 10* (1 gens, 10 absolutament)
    private String contracte; //tipus de contracte*: (temporal/indefinit)
    private String duracioContracte; //duració mitjana dels contractes: (setmanes/mesos/anys)
    private int antiguitatMitjana;
    private Boolean facilitatFixe;
    private Boolean vacancesPagades;
    private String carregaFeina;
    private int proporcioDones;
    private int edatMitjana;
    private int grauTreballEquip; //grau de treball en equip: individual (competitiu) - en equip (cooperatiu)
    private String pros;
    private String contres;

    private Integer id;

    private Lloc lloc;

    private Usuari usuari;

    public Boolean getSubcontracte() {
        return subcontracte;
    }

    public void setSubcontracte(Boolean subcontracte) {
        this.subcontracte = subcontracte;
    }

    public double getSalari() {
        return salari;
    }

    public void setSalari(double salari) {
        this.salari = salari;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public String getContracte() {
        return contracte;
    }

    public void setContracte(String contracte) {
        this.contracte = contracte;
    }

    public String getDuracioContracte() {
        return duracioContracte;
    }

    public void setDuracioContracte(String duracioContracte) {
        this.duracioContracte = duracioContracte;
    }

    public int getAntiguitatMitjana() {
        return antiguitatMitjana;
    }

    public void setAntiguitatMitjana(int antiguitatMitjana) {
        this.antiguitatMitjana = antiguitatMitjana;
    }

    public Boolean getFacilitatFixe() {
        return facilitatFixe;
    }

    public void setFacilitatFixe(Boolean facilitatFixe) {
        this.facilitatFixe = facilitatFixe;
    }

    public Boolean getVacancesPagades() {
        return vacancesPagades;
    }

    public void setVacancesPagades(Boolean vacancesPagades) {
        this.vacancesPagades = vacancesPagades;
    }

    public String getCarregaFeina() {
        return carregaFeina;
    }

    public void setCarregaFeina(String carregaFeina) {
        this.carregaFeina = carregaFeina;
    }

    public int getProporcioDones() {
        return proporcioDones;
    }

    public void setProporcioDones(int proporcioDones) {
        this.proporcioDones = proporcioDones;
    }

    public int getEdatMitjana() {
        return edatMitjana;
    }

    public void setEdatMitjana(int edatMitjana) {
        this.edatMitjana = edatMitjana;
    }

    public int getGrauTreballEquip() {
        return grauTreballEquip;
    }

    public void setGrauTreballEquip(int grauTreballEquip) {
        this.grauTreballEquip = grauTreballEquip;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getContres() {
        return contres;
    }

    public void setContres(String contres) {
        this.contres = contres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lloc getLloc() {
        return lloc;
    }

    public void setLloc(Lloc lloc) {
        this.lloc = lloc;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
}
