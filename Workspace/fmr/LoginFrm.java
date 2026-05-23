package Workspace.fmr;

import Workspace.Datas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrm extends JFrame {
    // 1. Componentes de la pantalla (Cajas de texto y botón)
    private JTextField cajaEmail;
    private JPasswordField cajaPass;
    private JButton botonSubmit;

    public LoginFrm() {
        // 2. Configurar la ventana principal
        setTitle("Iniciar Sesión - Ring-CARDS");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(null); // Nos permite acomodar los objetos por coordenadas

        // 3. Crear y acomodar la sección de Email
        JLabel etiquetaEmail = new JLabel("Email:");
        etiquetaEmail.setBounds(40, 50, 100, 30);
        add(etiquetaEmail);

        cajaEmail = new JTextField();
        cajaEmail.setBounds(140, 50, 200, 30);
        add(cajaEmail);

        // 4. Crear y acomodar la sección de Contraseña
        JLabel etiquetaPass = new JLabel("Contraseña:");
        etiquetaPass.setBounds(40, 110, 100, 30);
        add(etiquetaPass);

        cajaPass = new JPasswordField();
        cajaPass.setBounds(140, 110, 200, 30);
        add(cajaPass);

        // 5. Crear y acomodar el Botón SUBMIT
        botonSubmit = new JButton("SUBMIT");
        botonSubmit.setBounds(140, 180, 120, 35);
        add(botonSubmit);

        // 6. Programar la acción: ¿Qué pasa al dar clic al botón?
        botonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarIngreso(); // Llama a la función de abajo
            }
        });
    }

    // 7. Función lógica para revisar los datos en la Base de Datos
    private void validarIngreso() {
        String email = cajaEmail.getText();
        String pass = new String(cajaPass.getPassword());

        // Si el usuario dejó algún campo vacío, frena el proceso de inmediato
        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.");
            return;
        }

        // Conectamos a PostgreSQL
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        // Consulta SQL para buscar al usuario
        String sql = "SELECT * FROM usuarios WHERE email = ? AND pass = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet resultado = pst.executeQuery();

            if (resultado.next()) {
                // SI COINCIDE: Da la bienvenida, cierra el login y abre el menú
                JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                this.dispose(); 
                new MenuFrm().setVisible(true); 
            } else {
                // SI NO COINCIDE: Avisa que falló
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en el sistema: " + error.getMessage());
        }
    }

    // 8. El arrancador principal del programa
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrm().setVisible(true);
        });
    }
}