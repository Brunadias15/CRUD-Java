package dao;

import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class DaoCliente {

    Connection con = null;
    PreparedStatement pstm = null;

    public void salvarCliente(Cliente c) {
        con = new conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_cliente(nome_cliente,cpf_cliente,fone_cliente, nome_pet, tipo_pet, idade_pet)values(?,?,?,?,?,?)";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, c.getNome_cli());
            pstm.setString(2, c.getCpf());
            pstm.setString(3, c.getFone());
            pstm.setString(4, c.getNome_pet());
            pstm.setString(5, c.getTipo_pet());
            pstm.setInt(6, c.getIdade_pet());

            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir cliente" + closerr);
            }

        }

    }

    public void alterarCliente(Cliente c) {
        con = new conexao().getConnection();
        String sqlinsert = "update tb_cliente set nome_cliente=?, cpf_cliente=?, fone_cliente=?, nome_pet=?, tipo_pet=?, idade_pet=? where id_cliente=?";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setString(1, c.getNome_cli());
            pstm.setString(2, c.getCpf());
            pstm.setString(3, c.getFone());
            pstm.setString(4, c.getNome_pet());
            pstm.setString(5, c.getTipo_pet());
            pstm.setInt(6, c.getIdade_pet());
            pstm.setInt(7, c.getId_cli());

            pstm.execute();
            pstm.close();
        } catch (SQLException inserterr) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o cliente no banco de dados " + inserterr + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir cliente" + closerr);
            }

        }
    }

    public void excluirCliente(Cliente c) {
        con = new conexao().getConnection();
        String sqlinsert = "delete from tb_cliente where id_cliente=?";
        try {
            pstm = con.prepareStatement(sqlinsert);
            pstm.setInt(1, c.getId_cli());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente no banco de dados " + e + " SQL: " + sqlinsert);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao inserir cliente" + closerr);
            }

        }
    }

    public List<Cliente> getClientes() {
        con = new conexao().getConnection();
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<Cliente>();
        String query = "SELECT * FROM tb_cliente";
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.first()) {
                do {
                    Cliente cliente = new Cliente();
                    cliente.setId_cli(rs.getInt("id_cliente"));
                    cliente.setNome_cli(rs.getString("nome_cliente"));
                    cliente.setCpf(rs.getString("cpf_cliente"));
                    cliente.setFone(rs.getString("fone_cliente"));
                    cliente.setNome_pet(rs.getString("nome_pet"));
                    cliente.setTipo_pet(rs.getString("tipo_pet"));
                    cliente.setIdade_pet(rs.getInt("idade_pet"));
                    

                    lista.add(cliente);

                } while (rs.next());
            }
            pstm.close();
        } catch (SQLException buscarerr) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes no banco " + buscarerr);
        } finally {
            try {
                con.close();
            } catch (SQLException closerr) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o banco ao buscar clientes" + closerr);
            }

        }
        return lista;
    }

    public List<Cliente> PesquisarPorNomeCli(String nome_cli) {
        List<Cliente> lista = new ArrayList<Cliente>();
        con = new conexao().getConnection();
        ResultSet rs = null;
        String sql = "select * from tb_cliente where nome_cliente like ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nome_cli);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cliente objcli = new Cliente();
                objcli.setId_cli(rs.getInt("id_cliente"));
                objcli.setNome_cli(rs.getString("nome_cliente"));
                objcli.setCpf(rs.getString("cpf_cliente"));
                    objcli.setFone(rs.getString("fone_cliente"));
                    objcli.setNome_pet(rs.getString("nome_pet"));
                    objcli.setTipo_pet(rs.getString("tipo_pet"));
                    objcli.setIdade_pet(rs.getInt("idade_pet"));

                lista.add(objcli);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente pesquisar: " + e);
        }

        return lista;

    }
}
