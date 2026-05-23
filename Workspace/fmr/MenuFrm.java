package Workspace.fmr;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuFrm extends JFrame {

    public MenuFrm() {
        // Configuración de la ventana principal de tu juego
        setTitle("Sistema Principal - King-CARDS!!");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en tu pantalla
        setLayout(null);

        // Letrero estético de bienvenida
        JLabel lblBienvenida = new JLabel("¡Bienvenido a King-CARDS!!", SwingConstants.CENTER);
        lblBienvenida.setBounds(50, 50, 400, 40);
        lblBienvenida.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        add(lblBienvenida);
        
        JLabel lblStatus = new JLabel("Sesión iniciada correctamente.", SwingConstants.CENTER);
        lblStatus.setBounds(50, 110, 400, 30);
        add(lblStatus);
    }
}