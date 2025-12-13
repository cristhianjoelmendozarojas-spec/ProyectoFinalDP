package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static ConexionBD instancia;
    private Connection conexion;

    private static final String URL = "jdbc:mysql://localhost:3306/reserlab";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private ConexionBD() {
        conectar();
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    private void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            // Configurar para evitar que se cierre automáticamente
            conexion.setAutoCommit(true);
            System.out.println("Conexión a BD establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en conexión BD: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        try {
            // Verificar si la conexión sigue activa
            if (conexion == null || conexion.isClosed()) {
                System.out.println("Reconectando a BD...");
                conectar();
            }
        } catch (SQLException e) {
            System.err.println("Error verificando conexión: " + e.getMessage());
            conectar();
        }
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error cerrando conexión: " + e.getMessage());
            }
        }
    }
}
