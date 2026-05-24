package Workspace.fmr;

import javax.swing.*;

public class MenuFrm extends JFrame {
    // Declaración de botones
    private JButton btnTarjetas, btnNotificaciones, btndetalle;

    public MenuFrm() {
        setTitle("King-CARDS!! - Menú Principal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Botón: GESTIÓN DE TARJETAS 
        btnTarjetas = new JButton("GESTIÓN DE TARJETAS");
        btnTarjetas.setBounds(80, 40, 240, 40);
        add(btnTarjetas);
        btnTarjetas.addActionListener(e -> {
            new TarjetasFrm().setVisible(true);
        });

        // Botón: VER DETALLE DE TARJETA 
        btndetalle = new JButton("VER DETALLE DE TARJETA");
        btndetalle.setBounds(80, 100, 240, 40);
        add(btndetalle);
        btndetalle.addActionListener(a -> {
            int idSeleccionado = 1; // ID de prueba
            DetallesFrm detalle = new DetallesFrm(idSeleccionado);
            detalle.setVisible(true);
        });

        //Botón: NOTIFICACIONES 
        btnNotificaciones = new JButton("NOTIFICACIONES");
        btnNotificaciones.setBounds(80, 160, 240, 40);
        add(btnNotificaciones);

        // Botón: CERRAR SESIÓN 
        JButton btnSalir = new JButton("Cerrar Sesión");
        btnSalir.setBounds(130, 240, 140, 30);
        add(btnSalir);
        btnSalir.addActionListener(o -> {
            new LoginFrm().setVisible(true);
            dispose();
        });
    }
}