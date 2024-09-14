import Dao.UserDao;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ej2 {
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblCorreo;
    private JLabel lblSeccion;
    private JLabel lblID;
    private JLabel lblCarnet;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JTextField textFieldSeccion;
    private JTextField textFieldID;
    private JTextField textFieldCarnet;
    private JButton ButtonEliminar;
    private JButton ButtonGuardar;
    private JButton ButtonActualizar;
    private JButton ButtonBorrar;

    public Ej2() {
        // Acción para el botón Guardar
        ButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String carnet = textFieldCarnet.getText();
                String correo = textFieldCorreo.getText();
                String seccion = textFieldSeccion.getText();

                if (nombre.isEmpty() || carnet.isEmpty() || correo.isEmpty() || seccion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                    return;
                }

                try {
                    UserDao userDao = new UserDao();
                    if (userDao.emailExists(correo)) {
                        JOptionPane.showMessageDialog(null, "El correo ya existe, por favor ingrese otro.");
                        return;
                    }

                    User user = new User(carnet, nombre, correo, seccion);
                    userDao.add(user);
                    JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
                   ;

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el usuario: " + ex.getMessage());
                }
            }
        });

        // Para el botón Actualizar
        ButtonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String carnet = textFieldCarnet.getText();
                String correo = textFieldCorreo.getText();
                String seccion = textFieldSeccion.getText();

                if (nombre.isEmpty() || carnet.isEmpty() || correo.isEmpty() || seccion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                    return;
                }

                try {
                    UserDao userDao = new UserDao();
                    User user = new User(carnet, nombre, correo, seccion);
                    UserDao.update(user);
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el usuario: " + ex.getMessage());
                }
            }
        });

        // Para el botón Eliminar
        ButtonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = textFieldCorreo.getText();

                if (correo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un correo para eliminar.");
                    return;
                }

                try {
                    UserDao userDao = new UserDao();
                    userDao.deleteByEmail(correo);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                  ;

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + ex.getMessage());
                }
            }
        });
    }













