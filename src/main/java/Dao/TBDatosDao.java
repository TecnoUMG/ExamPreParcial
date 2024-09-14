package Dao;

import Model.DatosTb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TBDatosDao {
    private Connection connection;

    public TBDatosDao(Connection connection) {
        this.connection = connection;
    }

    // Para crear nuevo registro
    public void add(DatosTb datos) throws SQLException {
        String query = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, datos.getNombre());
            stmt.setString(2, datos.getApellido());
            stmt.setString(3, datos.getDepartamento());
            stmt.setDate(4, new java.sql.Date(datos.getFechaNacimiento().getTime()));
            stmt.executeUpdate();
        }
    }


    public DatosTb get(int codigo) throws SQLException {
        String query = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                DatosTb datos = new DatosTb();
                datos.setCodigo(rs.getInt("codigo"));
                datos.setNombre(rs.getString("nombre"));
                datos.setApellido(rs.getString("apellido"));
                datos.setDepartamento(rs.getString("departamento"));
                datos.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                return datos;
            }
            return null;
        }
    }


    public List<DatosTb> getAll() throws SQLException {
        List<DatosTb> datosList = new ArrayList<>();
        String query = "SELECT * FROM tb_datos";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DatosTb datos = new DatosTb();
                datos.setCodigo(rs.getInt("codigo"));
                datos.setNombre(rs.getString("nombre"));
                datos.setApellido(rs.getString("apellido"));
                datos.setDepartamento(rs.getString("departamento"));
                datos.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                datosList.add(datos);
            }
        }
        return datosList;
    }

    // Para actualizar el resgistro
    public void update(DatosTb datos) throws SQLException {
        String query = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, datos.getNombre());
            stmt.setString(2, datos.getApellido());
            stmt.setString(3, datos.getDepartamento());
            stmt.setDate(4, new java.sql.Date(datos.getFechaNacimiento().getTime()));
            stmt.setInt(5, datos.getCodigo());
            stmt.executeUpdate();
        }
    }

    // Para eliminar registro
    public void delete(int codigo) throws SQLException {
        String query = "DELETE FROM tb_datos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }

    // Para verificar si el correo ya existe
    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM tb_datos WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
    }
}
