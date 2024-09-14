package Model;

import java.sql.Timestamp;

public class TeamChamps {
    private int IdEquipo;
    private String nombre;
    private String pais;
    private String ciudad;
    private String estadio;
    private int fundacion;
    private String entrenador;
    private String webOficial;
    private String facebook;
    private String twitter;
    private String instagram;
    private String patrocinadorPrincipal;
    private Timestamp creadoEn;
    //Getters y setters
    //  Para IdEquipo
    public int getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.IdEquipo = idEquipo;
    }

    // Para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Para pais
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Para ciudad
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // Para estadio
    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    // Para fundacion
    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    // Para entrenador
    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    // Para webOficial
    public String getWebOficial() {
        return webOficial;
    }

    public void setWebOficial(String webOficial) {
        this.webOficial = webOficial;
    }

    // Para facebook
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    // Para twitter
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    // Para instagram
    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    // Para patrocinadorPrincipal
    public String getPatrocinadorPrincipal() {
        return patrocinadorPrincipal;
    }

    public void setPatrocinadorPrincipal(String patrocinadorPrincipal) {
        this.patrocinadorPrincipal = patrocinadorPrincipal;
    }

    // Para creadoEn
    public Timestamp getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Timestamp creadoEn) {
        this.creadoEn = creadoEn;
    }
}

