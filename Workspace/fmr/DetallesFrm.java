package Workspace.fmr;

import Workspace.Datas.Conexion;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DetallesFrm extends JFrame {
    private int idTarjeta;
    private JLabel lblNombre, lblSaldo, lblLimite;
    private JTable tablaMovimientos;
    private DefaultTableModel modelo;

    public DetallesFrm(int idTarjeta) {
        this.idTarjeta = idTarjeta;
        
        setTitle("Detalles de Tarjeta - King-CARDS");
        setSize(450, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        // --- Panel de Info (Estilo Administrativo) ---
        lblNombre = new JLabel("Tarjeta: ...");
        lblNombre.setBounds(30, 20, 300, 30);
        add(lblNombre);

        lblSaldo = new JLabel("Saldo: $0.00");
        lblSaldo.setBounds(30, 50, 200, 30);
        add(lblSaldo);

        // --- Tabla de Movimientos ---
        modelo = new DefaultTableModel(new String[]{"Concepto", "Monto", "Tipo"}, 0);
        tablaMovimientos = new JTable(modelo);
        JScrollPane sp = new JScrollPane(tablaMovimientos);
        sp.setBounds(30, 120, 380, 200);
        add(sp);

        // --- Botón de Conexión a Movimientos ---
        JButton btnAgregar = new JButton("AGREGAR MOVIMIENTO");
        btnAgregar.setBounds(100, 350, 250, 40);
        add(btnAgregar);

        // Al hacer clic, abre el formulario de Movimientos
        btnAgregar.addActionListener(e -> {
            MovimientosFrm mov = new MovimientosFrm(this.idTarjeta, true);
            mov.setVisible(true);
        });

        cargarDatos();
    }

    private void cargarDatos() {
        // Aquí iría tu lógica SQL: SELECT * FROM tarjetas WHERE id = idTarjeta
        // Y luego un SELECT * FROM movimientos_Credito WHERE id_CardCredito = idTarjeta
        lblNombre.setText("Tarjeta ID: " + idTarjeta);
    }
}