import ConexSQL.ConexSQL;
import Dao.TBDatosDao;
import Model.DatosTb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Ej1 {
    private JLabel lblTitulo;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDepartamento;
    private JLabel lblFechaNacimiento;
    private JTextField textFieldCodigo;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldDepartamento;
    private JTextField textFieldFechaNacimiento;
    private JButton ButtonEliminar;
    private JButton ButtonGuarda;
    private JButton ButtonActualizar;


private TBDatosDao TBDatosDao;

public Ej1(){


    try {
        Connection connection = ConexSQL.getConnection(); // Aquí se obtiene la conexión
        TBDatosDao = new TBDatosDao(connection);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + ex.getMessage());
        return;
    }

    ButtonGuarda.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener datos del formulario
            String nombre = textFieldNombre.getText();
            String apellido = textFieldApellido.getText();
            String departamento = textFieldDepartamento.getText();
            String fechaNacimiento = textFieldFechaNacimiento.getText();

            // Validar que no haya campos vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || departamento.isEmpty() || fechaNacimiento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                return;
            }

            // Crear un objeto TbDatos con los datos del formulario
            DatosTb datos = new DatosTb();
            datos.setNombre(nombre);
            datos.setApellido(apellido);
            datos.setDepartamento(departamento);
            try {
                datos.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento)); // Convertir la fecha a SQL Date
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Use el formato yyyy-MM-dd.");
                return;
            }

            // Llamar al DAO para guardar el registro en la base de datos
            try {
                TBDatosDao.add(datos);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
                limpiarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
            }
        }
    });

    ButtonEliminar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el código a eliminar
            String codigo = textFieldCodigo.getText();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un código para eliminar.");
                return;
            }

            // Para convertir a enteros
            int cod;
            try {
                cod = Integer.parseInt(codigo);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código inválido.");
                return;
            }

            // Para llamar al  comando DAO para eliminar X registro
            try {
                TBDatosDao.delete(cod);
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
                limpiarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar los datos: " + ex.getMessage());
            }
        }
    });

    ButtonActualizar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Para obtener los datos
            String codigo = textFieldCodigo.getText();
            String nombre = textFieldNombre.getText();
            String apellido = textFieldApellido.getText();
            String departamento = textFieldDepartamento.getText();
            String fechaNacimiento = textFieldFechaNacimiento.getText();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un código para actualizar.");
                return;
            }

            // Para convertir a entero
            int cod;
            try {
                cod = Integer.parseInt(codigo);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código inválido.");
                return;
            }

            // Para crear un objeto con nuevos datos TB
            DatosTb datos = new DatosTb();
            datos.setCodigo(cod);
            datos.setNombre(nombre);
            datos.setApellido(apellido);
            datos.setDepartamento(departamento);
            try {
                datos.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento)); // Convertir la fecha a SQL Date
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Use el formato yyyy-MM-dd.");
                return;
            }

            // Llamar al comando DAO para la actualizacion
            try {
                TBDatosDao.update(datos);
                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
                limpiarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + ex.getMessage());
            }
        }
    });

}

    // para limpiar los campos después de X operación
    private void limpiarCampos() {
        textFieldCodigo.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldDepartamento.setText("");
        textFieldFechaNacimiento.setText("");
    }


    }


