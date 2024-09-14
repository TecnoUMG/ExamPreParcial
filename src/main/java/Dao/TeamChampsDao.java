package Dao;

import Model.Team;
import Model.TeamChamps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamChampsDao {
    private Connection connection;

    public TeamChampsDao(Connection connection) {
        this.connection = connection;
    }

    // Crear nuevo registro
    public void add(Team equipo) throws SQLException {
        String query = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getPais());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.setInt(5, equipo.getFundacion());
            stmt.setString(6, equipo.getEntrenador());
            stmt.setString(7, equipo.getWebOficial());
            stmt.setString(8, equipo.getFacebook());
            stmt.setString(9, equipo.getTwitter());
            stmt.setString(10, equipo.getInstagram());
            stmt.setString(11, equipo.getPatrocinadorPrincipal());
            stmt.executeUpdate();
        }
    }

    // Leer registro por ID
    public TeamChamps get(int idEquipo) throws SQLException {
        String query = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idEquipo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TeamChamps equipo = new TeamChamps();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setPais(rs.getString("pais"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setEstadio(rs.getString("estadio"));
                equipo.setFundacion(rs.getInt("fundacion"));
                equipo.setEntrenador(rs.getString("entrenador"));
                equipo.setWebOficial(rs.getString("web_oficial"));
                equipo.setFacebook(rs.getString("facebook"));
                equipo.setTwitter(rs.getString("twitter"));
                equipo.setInstagram(rs.getString("instagram"));
                equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
                equipo.setCreadoEn(rs.getTimestamp("creado_en"));
                return equipo;
            }
            return null;
        }
    }

    // Leer registros
    public List<TeamChamps> getAll() throws SQLException {
        List<TeamChamps> equiposList = new ArrayList<>();
        String query = "SELECT * FROM equipos_champions";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TeamChamps equipo = new TeamChamps();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setPais(rs.getString("pais"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setEstadio(rs.getString("estadio"));
                equipo.setFundacion(rs.getInt("fundacion"));
                equipo.setEntrenador(rs.getString("entrenador"));
                equipo.setWebOficial(rs.getString("web_oficial"));
                equipo.setFacebook(rs.getString("facebook"));
                equipo.setTwitter(rs.getString("twitter"));
                equipo.setInstagram(rs.getString("instagram"));
                equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
                equipo.setCreadoEn(rs.getTimestamp("creado_en"));
                equiposList.add(equipo);
            }
        }
        return equiposList;
    }

    // Actualizar
    public void update(TeamChamps equipo) throws SQLException {
        String query = "UPDATE equipos_champions SET nombre = ?, pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getPais());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.setInt(5, equipo.getFundacion());
            stmt.setString(6, equipo.getEntrenador());
            stmt.setString(7, equipo.getWebOficial());
            stmt.setString(8, equipo.getFacebook());
            stmt.setString(9, equipo.getTwitter());
            stmt.setString(10, equipo.getInstagram());
            stmt.setString(11, equipo.getPatrocinadorPrincipal());
            stmt.setInt(12, equipo.getIdEquipo());
            stmt.executeUpdate();
        }
    }

    // Eliminar un registro
    public void delete(int idEquipo) throws SQLException {
        String query = "DELETE FROM equipos_champions WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idEquipo);
            stmt.executeUpdate();
        }
    }



}
