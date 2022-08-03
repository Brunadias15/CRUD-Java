/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author ifms
 */
public class DaoFuncionario {

    Connection con = null;
    PreparedStatement pstm = null;
    
    public boolean validalogin(String nome_func, String cod_func){
        con = new conexao().getConnection();
        String sql = "select * from tb_func where nome_func=? and cod_func=?";
        try{
        pstm = con.prepareStatement(sql);
        pstm.setString(1, nome_func);
        pstm.setString(2, cod_func);
        ResultSet rs = pstm.executeQuery();
        
        if(rs.first()){
            return true;
        }
    }catch (Exception e){
    
    }
    return false;
    
}
    public void salvarFunc(Funcionario u) {
        con = new conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_func(nome_func, cod_func)values(?,?)";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, u.getNome_func());
            pstm.setString(2, u.getCod_func());
            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir funcionário no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir funcionário" + closerr);
            }

        }

    }

    public void alterarFunc(Funcionario u) {
        con = new conexao().getConnection();
        String sqlinsert = "update tb_func set nome_func=?, cod_func=? where id_func=?";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, u.getNome_func());
            pstm.setString(2, u.getCod_func());
            pstm.setInt(3, u.getId_func());

            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o funcionário no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir funcionário" + closerr);
            }

        }
    }

    public void excluirFunc(Funcionario u) {
        con = new conexao().getConnection();
        String sqlinsert = "delete from tb_func where id_func=?";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setInt(1, u.getId_func());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário no banco de dados " + e + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir funcionário" + closerr);
            }

        }
    }

    public List<Funcionario> getFuncionarios() {
        con = new conexao().getConnection();
        ResultSet rs = null;
        List<Funcionario> lista = new ArrayList<Funcionario>();
        String query = "SELECT * FROM tb_func";
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.first()) {
                do {
                    Funcionario func = new Funcionario();
                    func.setId_func(rs.getInt("id_func"));
                    func.setNome_func(rs.getString("nome_func"));
                    func.setCod_func(rs.getString("cod_func"));

                    lista.add(func);

                } while (rs.next());
            }
            pstm.close();
        } catch (SQLException buscarerr) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionários no banco " + buscarerr);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao buscar funcionários" + closerr);
            }

        }
        return lista;
    }

    public List<Funcionario> PesquisarPorNome(String nome) {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        con = new conexao().getConnection();
        ResultSet rs = null;
        String sql = "select * from tb_func where nome_func like ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Funcionario objfunc = new Funcionario();
                objfunc.setId_func(rs.getInt("id_func"));
                objfunc.setNome_func(rs.getString("nome_func"));
                objfunc.setCod_func(rs.getString("cod_func"));

                lista.add(objfunc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionário pesquisar: " + e);
        }

        return lista;

    }

}
