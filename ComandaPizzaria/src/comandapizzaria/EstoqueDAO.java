package comandapizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EstoqueDAO extends PrincipalDAO{
    public boolean inserirEstoque(Estoque novoEstoque){
        connectToDB();
        String sql = "insert into Estoque(Nome,Descricao,Qtd,Preco,Total) values(?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,novoEstoque.getNome());
            pst.setString(2,novoEstoque.getDescricao());
            pst.setInt(3,novoEstoque.getQtd());
            pst.setFloat(4,novoEstoque.getPrecoPeca());
            pst.setFloat(5,novoEstoque.getPrecoTotal());
            pst.execute();
            sucesso = true;
            
        }catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage()); 
            sucesso = false;
        }finally{
            try{
                con.close();
                pst.close();
            }catch(SQLException ex){
                System.out.println("Erro: "+ex.getMessage());
            }
        }
        return sucesso;
    }
}
