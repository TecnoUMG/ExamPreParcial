package Dao;

import Model.User;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/db_telebot";
        String user = "root";
        String password = "DeLeonSar36202122";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    //  Para verificar si el correo existe
    public boolean emailExists(String correo) throws SQLException {
        String query = "SELECT COUNT(*) FROM tb_usuarios WHERE correo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, correo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        }
        return false;
    }

    // Para agregar un usuario
    public void add(User usuario) throws SQLException {
        String query = "INSERT INTO tb_usuarios (carne, nombre, correo, seccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, usuario.getCarne());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getSeccion());
            statement.executeUpdate();

            // Para obtener el id
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                usuario.setIdUsuario(generatedKeys.getInt(1));
            }
        }
    }

    // Para actualizar algun usuario
    public void update(User usuario) throws SQLException {
        String query = "UPDATE tb_usuarios SET carne = ?, nombre = ?, seccion = ? WHERE correo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getCarne());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getSeccion());
            statement.setString(4, usuario.getCorreo());
            statement.executeUpdate();
        }
    }

    // Método para eliminar un usuario por correo
    public void deleteByEmail(String correo) throws SQLException {
        String query = "DELETE FROM tb_usuarios WHERE correo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, correo);
            statement.executeUpdate();
        }
    }

    // Método para obtener un usuario por correo
    public User getByEmail(String correo) throws SQLException {
        String query = "SELECT idUsuario, carne, nombre, correo, seccion FROM tb_usuarios WHERE correo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, correo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("carne"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("seccion")
                );
            }
        }
        return null;
    }
}
