package Workspace.fmr;

import Workspace.Datas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrm extends JFrame {
    private JTextField txtEmail;
    private JPasswordField txtPass;
    private JButton btnSubmit;

    public LoginFrm() {
        // 1. Configuración de la Ventana Principal
        setTitle("Iniciar Sesión - Ring-CARDS");
        setSize(400, 320); // Un poco más alta para dar aire al botón
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(null); // Layout absoluto para controlar las posiciones exactas

        // 2. Componentes del Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40, 50, 100, 30); // Posición X, Y, Ancho, Alto
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(140, 50, 200, 30);
        add(txtEmail);

        // 3. Componentes de la Contraseña 
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(40, 110, 100, 30); // Bajamos un poco la altura para separar
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(140, 110, 200, 30);
        add(txtPass);

        // 4. Botón SUBMIT 
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(140, 180, 120, 35); // Más ancho y alto para que no se corte el texto
        add(btnSubmit);

        // Botón al hacer clic
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarUsuario();
            }
        });
    }

    private void validarUsuario() {
        String email = txtEmail.getText();
        String pass = new String(txtPass.getPassword());

        // Validación de campos vacíos antes de ir a la Base de Datos
        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.");
            return;
        }

        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        String sql = "SELECT * FROM usuarios WHERE email = ? AND pass = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                // Aabrir la siguiente ventana 
                this.dispose(); // Cierra y destruye la ventana de Login
                new MenuFrm().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al validar: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrm().setVisible(true);
        });
    }
}