package Db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DatabaseConnection {

    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Classe importada para usar o banco
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda_dende"
            , "postgres", "1705");
            System.out.println("Conexao com o banco feita com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Banco fechado");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}