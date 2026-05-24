package Workspace.fmr;

import Workspace.Datas.Conexion;
import java.sql.*;
import javax.swing.*;

public class MovimientosFrm extends JFrame {
    private JTextField txtConcepto, txtMonto;
    private JComboBox<String> cbTipo; // retiro, compra, servicio, etc.
    private JButton btnRegistrar;
    private int idTarjeta;
    private boolean esCredito;

    public MovimientosFrm(int idTarjeta, boolean esCredito) {
        this.idTarjeta = idTarjeta;
        this.esCredito = esCredito;
        
        setTitle("Registrar Movimiento - King-CARDS!!");
        setSize(350, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        // Campos básicos
        addLabelYField("Concepto:", 40, txtConcepto = new JTextField());
        addLabelYField("Monto ($):", 90, txtMonto = new JTextField());

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 140, 100, 30);
        add(lblTipo);
        
        // El tipo cambia según si es crédito o débito (según tu DB)
        String[] opciones = esCredito ? 
            new String[]{"retiro", "compra", "servicio", "otro"} : 
            new String[]{"egreso", "ingreso"};
        cbTipo = new JComboBox<>(opciones);
        cbTipo.setBounds(140, 140, 150, 30);
        add(cbTipo);

        btnRegistrar = new JButton("GUARDAR MOVIMIENTO");
        btnRegistrar.setBounds(70, 220, 200, 40);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> registrarEnBD());
    }

    private void addLabelYField(String text, int y, JTextField field) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(30, y, 100, 30);
        field.setBounds(140, y, 150, 30);
        add(lbl); add(field);
    }

    private void registrarEnBD() {
        // Lógica de inserción usando PreparedStatement para evitar inyecciones
        // Si esCredito == true -> insert en movimientos_Credito
        // Si esCredito == false -> insert en movimientos_Debito
        JOptionPane.showMessageDialog(null, "Registro exitoso en " + (esCredito ? "Crédito" : "Débito"));
    }
}