package Model;

public class User {
    private int idUsuario;
    private String carne;
    private String nombre;
    private String correo;
    private String seccion;


    public User(int idUsuario, String carne, String nombre, String correo, String seccion) {
        this.idUsuario = idUsuario;
        this.carne = carne;
        this.nombre = nombre;
        this.correo = correo;
        this.seccion = seccion;
    }


    public User(String carne, String nombre, String correo, String seccion) {
        this.carne = carne;
        this.nombre = nombre;
        this.correo = correo;
        this.seccion = seccion;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}

