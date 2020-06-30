/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import salao.model.Pessoa;

/**
 *
 * @author lucas
 */
public class PessoaDAO {

    private Connection connection;

    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }

    private void recuperaId(Pessoa pessoa) throws Exception {

        StringBuffer sql = new StringBuffer();

        sql.append("SELECT MAX(idPessoa) AS ultimoCodigo FROM SALAO.PESSOA");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        System.out.println(ps.toString());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int ultimoCodigo = rs.getInt("ultimoCodigo") + 1;
            pessoa.setIdPessoa(ultimoCodigo);

        }
    }

    public void inserir(Pessoa pessoa) throws Exception {

        if (Objects.isNull(pessoa.getIdPessoa())) {
            recuperaId(pessoa);
        }

        StringBuffer sql = new StringBuffer();

        sql.append("INSERT INTO SALAO.PESSOA("
                + "idPessoa, CPFPessoa, nomePessoa, endPessoa, tipoPessoa) "
                + "VALUES (?,?,?,?,?)");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        ps.setInt(1, pessoa.getIdPessoa());
        ps.setString(2, pessoa.getCPFPessoa());
        ps.setString(3, pessoa.getNomePessoa());
        ps.setString(4, pessoa.getEndPessoa());
        ps.setInt(5, pessoa.getTipoPessoa());

        System.out.println(ps.toString());
        ps.execute();
    }

    public void alterar(Pessoa pessoa) throws Exception {

        StringBuffer sql = new StringBuffer();

        sql.append("UPDATE SALAO.PESSOA SET "
                + "CPFPessoa = ?, nomePessoa = ?, endPessoa = ?, tipoPessoa = ? "
                + "WHERE idPessoa = ?");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        ps.setString(1, pessoa.getCPFPessoa());
        ps.setString(2, pessoa.getNomePessoa());
        ps.setString(3, pessoa.getEndPessoa());
        ps.setInt(4, pessoa.getTipoPessoa());
        ps.setInt(5, pessoa.getIdPessoa());

        System.out.println(ps.toString());
        ps.execute();
    }

    public void excluir(Pessoa pessoa) throws Exception {

        StringBuffer sql = new StringBuffer();

        sql.append("DELETE FROM SALAO.CURSO WHERE idPessoa = ?");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        ps.setInt(1, pessoa.getIdPessoa());

        System.out.println(ps.toString());
        ps.execute();
    }

    public ArrayList<Pessoa> consultarPorId(Pessoa pessoa) throws Exception {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT * FROM SALAO.PESSOA WHERE CPFPessoa = ?");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        ps.setInt(1, pessoa.getIdPessoa());

        System.out.println(ps.toString());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            pessoa = new Pessoa(
                    rs.getInt("idPessoa"), rs.getString("CPFPessoa"),
                    rs.getString("nomePessoa"), rs.getString("endPessoa"),
                    rs.getInt("tipoPessoa"));

            pessoas.add(pessoa);
        }

        return pessoas;
    }

     public ArrayList<Pessoa> consultarPorCPF(Pessoa pessoa) throws Exception {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT * FROM SALAO.PESSOA WHERE CPFPessoa = ?");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        ps.setString(1, pessoa.getCPFPessoa());

        System.out.println(ps.toString());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            pessoa = new Pessoa(
                    rs.getInt("idPessoa"), rs.getString("CPFPessoa"), 
                    rs.getString("nomePessoa"), rs.getString("endPessoa"), 
                    rs.getInt("tipoPessoa"));
            
            pessoas.add(pessoa);
        }

        return pessoas;
    }
    
    public ArrayList<Pessoa> listar(Pessoa pessoa) throws Exception {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT * FROM SALAO.PESSOA");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        System.out.println(ps.toString());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            pessoa = new Pessoa(
                    rs.getInt("idPessoa"), rs.getString("CPFPessoa"),
                    rs.getString("nomePessoa"), rs.getString("endPessoa"),
                    rs.getInt("tipoPessoa"));

            pessoas.add(pessoa);
        }

        return pessoas;
    }
}
