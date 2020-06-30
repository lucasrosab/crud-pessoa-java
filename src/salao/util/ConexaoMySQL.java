/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class ConexaoMySQL {
    
    public static String status = "Não conectou...";

    public static Connection getConnection() throws Exception {
        
        Connection connection = null;
        
        try {

            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            String serverName = "127.0.0.1:3306";    
            String mydatabase = "salao";        
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";       
            String password = "13120022";

            connection = DriverManager.getConnection(url, username, password);
            
            connection.setAutoCommit(false);
            
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static void closeConnection(Connection conexao) throws Exception {
        conexao.close();
    }

    public static void commit(Connection conexao) throws Exception {
        conexao.commit();
    }

    public static void rollback(Connection conexao) throws Exception {
        conexao.rollback();
    }
}
