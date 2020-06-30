/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salao;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import salao.dao.PessoaDAO;
import salao.model.Pessoa;
import salao.util.ConexaoMySQL;

/**
 *
 * @author lucas
 */
public class Salao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection connection = null;

        JOptionPane.showMessageDialog(null,
                "Bem Vindo ao Sistema de Cadastro de Pessoas");

        int contador = 0;

        while (contador == 0) {
            String login = JOptionPane.showInputDialog(
                    "Insira o seu CPF, seguindo o seguinte formato(###.###.###-##)");

            if (login.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
                try {
                    connection = ConexaoMySQL.getConnection();
                    PessoaDAO dao = new PessoaDAO(connection);

                    Pessoa usuario = new Pessoa(login);

                    ArrayList<Pessoa> usuarios = dao.consultarPorCPF(usuario);
                    if (usuarios.isEmpty()) {
                        String cadastrar = JOptionPane.showInputDialog("CPF não cadastrado, deseja se cadastrar? \n"
                                + "1 - Sim \n"
                                + "2 - Não");
                        int opcaoCadastro = Integer.parseInt(cadastrar);
                        int verificaOpcaoCadastro = 0;
                        while (verificaOpcaoCadastro == 0) {
                            if (opcaoCadastro < 1 || opcaoCadastro > 2) {
                                JOptionPane.showMessageDialog(null,
                                        "Selecione uma opção válida!");
                                cadastrar = JOptionPane.showInputDialog("CPF não cadastrado, deseja se cadastrar? \n"
                                                                            + "1 - Sim \n"
                                                                            + "2 - Não");
                                opcaoCadastro = Integer.parseInt(cadastrar);
                            } else {
                                if(opcaoCadastro == 1){
                                    try {
                                        connection = ConexaoMySQL.getConnection();
                                        PessoaDAO daoInserir = new PessoaDAO(connection);

                                        int verificaCPF = 0;
                                        String novoCPF = JOptionPane.showInputDialog("Insira o CPF, seguindo o seguinte formato(###.###.###-##)");
                                        while (verificaCPF == 0) {
                                            if (novoCPF.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
                                                verificaCPF = 1;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Insira um CPF válido!");
                                                novoCPF = JOptionPane.showInputDialog("Insira o CPF, seguindo o seguinte formato(###.###.###-##)");
                                            }
                                        }
                                        String novoNome = JOptionPane.showInputDialog("Insira o Nome");
                                        String novoEndereco = JOptionPane.showInputDialog("Insira o Endereço");

                                        int verificaTipo = 0;
                                        String novoTipo = JOptionPane.showInputDialog("Escolha o tipo de Pessoa: \n"
                                                + "1 - Cliente \n"
                                                + "2 - Profissional");
                                        int valorNovoTipo = Integer.parseInt(novoTipo);
                                        while (verificaTipo == 0) {
                                            if (valorNovoTipo < 1 || valorNovoTipo > 2) {
                                                JOptionPane.showMessageDialog(null, "Escolha um Tipo de Pessoa válido!");
                                                novoTipo = JOptionPane.showInputDialog("Escolha o tipo de Pessoa: \n"
                                                        + "1 - Cliente \n"
                                                        + "2 - Profissional");
                                                valorNovoTipo = Integer.parseInt(novoTipo);
                                            } else {
                                                verificaTipo = 1;
                                            }
                                        }

                                        Pessoa pessoa = new Pessoa(novoCPF, novoNome, novoEndereco, valorNovoTipo);

                                        dao.inserir(pessoa);

                                        ConexaoMySQL.commit(connection);
                                        System.out.println("Cadastrado com sucesso");

                                    } catch (Exception e) {
                                        try {
                                            ConexaoMySQL.rollback(connection);
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }

                                        e.printStackTrace();
                                    }
                                } else {
                                    contador = 1;
                                }
                            }

                        }
                        
                        contador = 0;
                        
                    } else {
                        int controle = 0;
                        while (controle == 0) {

                            String opcao = JOptionPane.showInputDialog(
                                    "Selecione uma opção abaixo: \n"
                                    + "1 - Cadastrar Nova Pessoa \n"
                                    + "2 - Consultar Pessoa \n"
                                    + "3 - Excluir Pessoa \n"
                                    + "4 - Sair ");
                            int valorOpcao = Integer.parseInt(opcao);

                            if (valorOpcao < 1 || valorOpcao > 4) {
                                JOptionPane.showMessageDialog(null,
                                        "Selecione uma opção válida!");
                            } else {
                                switch (valorOpcao) {
                                    case 1:
                                        try {
                                        connection = ConexaoMySQL.getConnection();
                                        PessoaDAO daoInserir = new PessoaDAO(connection);

                                        int verificaCPF = 0;
                                        String novoCPF = JOptionPane.showInputDialog("Insira o CPF, seguindo o seguinte formato(###.###.###-##)");
                                        while (verificaCPF == 0) {
                                            if (novoCPF.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
                                                verificaCPF = 1;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Insira um CPF válido!");
                                                novoCPF = JOptionPane.showInputDialog("Insira o CPF, seguindo o seguinte formato(###.###.###-##)");
                                            }
                                        }
                                        String novoNome = JOptionPane.showInputDialog("Insira o Nome");
                                        String novoEndereco = JOptionPane.showInputDialog("Insira o Endereço");

                                        int verificaTipo = 0;
                                        String novoTipo = JOptionPane.showInputDialog("Escolha o tipo de Pessoa: \n"
                                                + "1 - Cliente \n"
                                                + "2 - Profissional");
                                        int valorNovoTipo = Integer.parseInt(novoTipo);
                                        while (verificaTipo == 0) {
                                            if (valorNovoTipo < 1 || valorNovoTipo > 2) {
                                                JOptionPane.showMessageDialog(null, "Escolha um Tipo de Pessoa válido!");
                                                novoTipo = JOptionPane.showInputDialog("Escolha o tipo de Pessoa: \n"
                                                        + "1 - Cliente \n"
                                                        + "2 - Profissional");
                                                valorNovoTipo = Integer.parseInt(novoTipo);
                                            } else {
                                                verificaTipo = 1;
                                            }
                                        }

                                        Pessoa pessoa = new Pessoa(novoCPF, novoNome, novoEndereco, valorNovoTipo);

                                        dao.inserir(pessoa);

                                        ConexaoMySQL.commit(connection);
                                        System.out.println("Cadastrado com sucesso");

                                    } catch (Exception e) {
                                        try {
                                            ConexaoMySQL.rollback(connection);
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }

                                        e.printStackTrace();
                                    }
                                    break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        controle = 1;
                                        contador = 1;
                                        break;
                                    default:
                                        controle = 1;
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    try {
                        ConexaoMySQL.rollback(connection);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                    e.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "CPF Inválido, insira no formato correto!");
            }
        }
    }
}
