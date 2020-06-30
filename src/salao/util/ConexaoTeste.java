/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salao.util;

import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class ConexaoTeste {

    public static void main(String[] args) {

        try {

            Connection conexao = ConexaoMySQL.getConnection();

            String status = "Não conectou";

            if (conexao != null) {
                status = "Conectado com sucesso";
            } else {
                status = "Erro de conexão";
            }

            System.out.println(status);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
