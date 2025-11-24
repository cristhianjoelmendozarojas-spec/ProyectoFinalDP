package model.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static ConexionBD instancia;

    private final String URL = "jdbc:mysql://localhost:3306/reserlab?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "123456";

    private ConexionBD() {}

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // ATENCIÓN: cada llamada devuelve una nueva conexión
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
