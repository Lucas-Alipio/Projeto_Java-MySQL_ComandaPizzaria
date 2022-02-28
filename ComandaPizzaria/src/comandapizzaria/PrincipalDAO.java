package comandapizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
//classe mãe para conexão com o BD, para as filhas somente chamar a função connectToBD
public class PrincipalDAO {
    Connection con;
    
    PreparedStatement pst;
    
    Statement st;
    
    ResultSet rs;
    
    String database = "Pizzaria";
    
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    
    String user = "root";
    
    String password = "root";
    
    boolean sucesso = false;
    public void connectToDB(){
        try{
           con = DriverManager.getConnection(url,user,password);
           System.out.println("conexão feita com sucesso");
        }catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
}
