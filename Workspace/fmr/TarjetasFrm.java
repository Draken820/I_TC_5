package Workspace.fmr;

import Workspace.Datas.Conexion;
import java.sql.*;
import javax.swing.*;

public class TarjetasFrm extends JFrame {
    private JTextField txtNum, txtBanco, txtSaldo, txtLimite, txtCorte;
    private JRadioButton rbCredito, rbDebito;

    public TarjetasFrm() {
        setTitle("Registro de Tarjeta - King-CARDS!!");
        setSize(400, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        // Selección de Tipo
        rbCredito = new JRadioButton("Crédito");
        rbCredito.setBounds(80, 20, 100, 30);
        rbDebito = new JRadioButton("Débito");
        rbDebito.setBounds(220, 20, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbCredito); bg.add(rbDebito);
        add(rbCredito); add(rbDebito);

        // Campos
        txtBanco = agregarCampo("Banco:", 70);
        txtNum = agregarCampo("Número:", 120);
        txtSaldo = agregarCampo("Saldo:", 170);
        txtLimite = agregarCampo("Límite:", 220);
        txtCorte = agregarCampo("Día Corte:", 270);

        JButton btnGuardar = new JButton("REGISTRAR");
        btnGuardar.setBounds(100, 340, 200, 40);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardarEnBD());
    }

    private JTextField agregarCampo(String label, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(30, y, 100, 30);
        add(lbl);
        JTextField field = new JTextField();
        field.setBounds(150, y, 180, 30);
        add(field);
        return field;
    }

    private void guardarEnBD() {
        // Lógica de inserción según la tabla de tu BD
        String tabla = rbCredito.isSelected() ? "cardsCredito" : "cardsDebito";
        // Aquí ejecutas el INSERT en la tabla correspondiente...
        JOptionPane.showMessageDialog(null, "Tarjeta registrada en: " + tabla);
    }
}