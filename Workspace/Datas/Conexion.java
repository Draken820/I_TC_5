package Workspace.Datas;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    // Variable global que guardará el enlace con la base de datos
    private Connection enlace = null;

    public Connection conectar() {
        // 1. Datos de la base de datos en PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/I_TC_5";
        String usuario = "postgres";
        String contrasena = "pavon2007";

        try {
            // 2. Cargar el conector que descargamos (.jar)
            Class.forName("org.postgresql.Driver");

            // 3. Intentar conectar usando los datos de arriba
            enlace = DriverManager.getConnection(url, usuario, contrasena);
            
        } catch (Exception error) {
            // Si algo falla, avisa qué pasó en un recuadro flotante
            JOptionPane.showMessageDialog(null, "Error al conectar: " + error.getMessage());
        }

        // 4. Regresa la conexión (esté conectada o siga vacía)
        return enlace;
    }
}