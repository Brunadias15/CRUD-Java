
package conexao;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexao {
    Connection conexao = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/petshop";
    private final String usuario="root";
    private final String senha="";
    
    public Connection getConnection()
    {
        try{
        Class.forName(driver);
        conexao = DriverManager.getConnection(url,usuario,senha);
        JOptionPane.showMessageDialog(null, "Sucesso ao conectar!!!");
        }catch(ClassNotFoundException drive)
        {
            JOptionPane.showMessageDialog(null, "Driver não encontrado " +drive);
        }
        catch(SQLException fonte)
        {
            JOptionPane.showMessageDialog(null, "Banco de dados não encontrado " + fonte);
        }
        return conexao;
    }
}

