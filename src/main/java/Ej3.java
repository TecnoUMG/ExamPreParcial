import Dao.TeamChampsDao;
import Dao.TeamDao;
import Model.Team;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ej3 {
    private JLabel lblTitulo;
    private JLabel lblNombreEquipo;
    private JLabel lblPais;
    private JLabel lblCiudad;
    private JLabel lblEstadio;
    private JLabel lblFundacion;
    private JLabel lblEntrenador;
    private JLabel lblWebOficial;
    private JLabel lblPatrocinador;
    private JLabel lblFacebook;
    private JLabel lblInstragram;
    private JLabel lblTwitter;
    private JTextField textNombre;
    private JTextField textFieldPais;
    private JTextField textFieldCiudad;
    private JTextField textFieldEstadio;
    private JTextField textFieldFundacion;
    private JTextField textFieldEntrenador;
    private JTextField textFieldWebOficial;
    private JTextField textFieldPatrocinador;
    private JTextField textFieldFacebook;
    private JTextField textFieldInstragram;
    private JTextField textFieldTwitter;
    private JButton ButtonGuardar;
    private JButton ButtonEliminar;
    private JButton ButtonActualizar;

    public Ej3() {
        // Acción del botón Guardar
        ButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear el objeto equipo
                    Team team = new Team(
                            textNombre.getText(),
                            textFieldPais.getText(),
                            textFieldCiudad.getText(),
                            textFieldEstadio.getText(),
                            Integer.parseInt(textFieldFundacion.getText()),
                            textFieldEntrenador.getText(),
                            textFieldWebOficial.getText(),
                            textFieldFacebook.getText(),
                            textFieldTwitter.getText(),
                            textFieldInstragram.getText(),
                            textFieldPatrocinador.getText()
                    );

                    // Para guardar el x equipo
                    TeamDao teamDAO = new TeamDao();
                    teamDAO.add(team);
                    JOptionPane.showMessageDialog(null, "Equipo guardado exitosamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el equipo: " + ex.getMessage());
                    // Puedes agregar aquí un registro de errores más detallado, como un archivo de log
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El año de fundación debe ser un número.");
                }
            }
        });


        // Para el botón Actualizar
        ButtonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear el objeto equipo con los datos ingresados
                    Team team = new Team(
                            textNombre.getText(),
                            textFieldPais.getText(),
                            textFieldCiudad.getText(),
                            textFieldEstadio.getText(),
                            Integer.parseInt(textFieldFundacion.getText()),
                            textFieldEntrenador.getText(),
                            textFieldWebOficial.getText(),
                            textFieldFacebook.getText(),
                            textFieldTwitter.getText(),
                            textFieldInstragram.getText(),
                            textFieldPatrocinador.getText()
                    );

                    //Para actualizar el x equipo en la base de datos
                    TeamDao teamDao = new TeamDao();
                    teamDao.update(team);
                    JOptionPane.showMessageDialog(null, "Equipo actualizado exitosamente.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar el equipo.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: el año de fundación debe ser numérico.");
                }
            }
        });

        // Para el botón Eliminar
        ButtonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el nombre del equipo a eliminar
                    String nombre = textNombre.getText();

                    // Para eliminar el x equipo de la base de datos
                    TeamDao equipoDAO = new TeamDao();
                    equipoDAO.deleteByNombre(nombre);
                    JOptionPane.showMessageDialog(null, "Equipo eliminado.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Errot.");
                }
            }
        });






