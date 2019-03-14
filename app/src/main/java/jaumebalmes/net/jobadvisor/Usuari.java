package jaumebalmes.net.jobadvisor;

import java.util.List;

public class Usuari {

    private String nickname;
    private String email;
    private String password;


    private Integer id;

    private List<Opinio> opinions;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Opinio> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinio> opinions) {
        this.opinions = opinions;
    }
}
