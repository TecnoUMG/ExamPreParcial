package Dao;

import Model.Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeamDao {
    private Connection connection;

    public TeamDao() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/db_telebot";
        String user = "root";
        String password = "DeLeonSar36202122";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    // Para agregar equipo
    public void add(Team equipo) throws SQLException {
        String query = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, equipo.getNombre());
            statement.setString(2, equipo.getPais());
            statement.setString(3, equipo.getCiudad());
            statement.setString(4, equipo.getEstadio());
            statement.setInt(5, equipo.getFundacion());
            statement.setString(6, equipo.getEntrenador());
            statement.setString(7, equipo.getWebOficial());
            statement.setString(8, equipo.getFacebook());
            statement.setString(9, equipo.getTwitter());
            statement.setString(10, equipo.getInstagram());
            statement.setString(11, equipo.getPatrocinadorPrincipal());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            throw e;
        }
    }


    // Para actualizar equipo
    public void update(Team equipo) throws SQLException {
        String query = "UPDATE equipos_champions SET pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE nombre = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, equipo.getPais());
            statement.setString(2, equipo.getCiudad());
            statement.setString(3, equipo.getEstadio());
            statement.setInt(4, equipo.getFundacion());
            statement.setString(5, equipo.getEntrenador());
            statement.setString(6, equipo.getWebOficial());
            statement.setString(7, equipo.getFacebook());
            statement.setString(8, equipo.getTwitter());
            statement.setString(9, equipo.getInstagram());
            statement.setString(10, equipo.getPatrocinadorPrincipal());
            statement.setString(11, equipo.getNombre());
            statement.executeUpdate();
        }
    }

    // Para eliminar equipo con el nombre
    public void deleteByNombre(String nombre) throws SQLException {
        String query = "DELETE FROM equipos_champions WHERE nombre = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.executeUpdate();
        }
    }
}
