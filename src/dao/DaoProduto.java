package dao;

import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

public class DaoProduto {

    Connection con = null;
    PreparedStatement pstm = null;

    public void salvarProduto(Produto c) {
        con = new conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_produto(nome_produ, cate_produ, cod_produ, valor_produ)values(?,?,?,?)";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, c.getNome_produ());
            pstm.setString(2, c.getCategoria());
            pstm.setInt(3, c.getCod_produ());
            pstm.setFloat(4, c.getValor());

            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir produto" + closerr);
            }

        }

    }

    public void alterarProduto(Produto c) {
        con = new conexao().getConnection();
        String sqlinsert = "update tb_produto set nome_produ=?, cate_produ=?, cod_produ=?, valor_produ=? where id_produ=?";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, c.getNome_produ());
            pstm.setString(2, c.getCategoria());
            pstm.setInt(3, c.getCod_produ());
            pstm.setFloat(4, c.getValor());
            pstm.setInt(5, c.getId_produ());

            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o produto no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir produto" + closerr);
            }

        }
    }

    public void excluirProduto(Produto c) {
        con = new conexao().getConnection();
        String sqlinsert = "delete from tb_produto where id_produ=?";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setInt(1, c.getId_produ());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto no banco de dados " + e + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir produto" + closerr);
            }

        }
    }

    public List<Produto> getProdutos() {
        con = new conexao().getConnection();
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<Produto>();
        String query = "SELECT * FROM tb_produto";
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.first()) {
                do {
                    Produto produto = new Produto();
                    produto.setId_produ(rs.getInt("id_produ"));
                    produto.setNome_produ(rs.getString("nome_produ"));
                    produto.setCategoria(rs.getString("cate_produ"));
                    produto.setCod_produ(rs.getInt("cod_produ"));
                    produto.setValor(rs.getFloat("valor_produ"));

                    lista.add(produto);

                } while (rs.next());
            }
            pstm.close();
        } catch (SQLException buscarerr) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos no banco " + buscarerr);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao buscar produtos" + closerr);
            }

        }
        return lista;
    }

    public List<Produto> PesquisarPorCodProdu(int codigo) {
        List<Produto> lista = new ArrayList<Produto>();
        con = new conexao().getConnection();
        ResultSet rs = null;
        String sql = "select * from tb_produto where cod_produ like ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Produto objprodu = new Produto();
                    objprodu.setId_produ(rs.getInt("id_produ"));
                    objprodu.setNome_produ(rs.getString("nome_produ"));
                    objprodu.setCategoria(rs.getString("cate_produ"));
                    objprodu.setCod_produ(rs.getInt("cod_produ"));
                    objprodu.setValor(rs.getFloat("valor_produ"));

                lista.add(objprodu);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto pesquisar: " + e);
        }

        return lista;

    }
}
