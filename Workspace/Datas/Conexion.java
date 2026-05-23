package Workspace.Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conectar = null;

    public Connection conectar() {
        try {
            // Buscamos el conector de PostgreSQL instalado en tu sistema
            Class.forName("org.postgresql.Driver");
            
            // Conectamos a tu base de datos con tus datos exactos
            conectar = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/I_TC_5", 
                "postgres", 
                "pavon2007"
            );
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return conectar;
    }
}