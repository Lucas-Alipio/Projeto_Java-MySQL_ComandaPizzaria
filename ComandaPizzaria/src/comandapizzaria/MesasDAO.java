package comandapizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MesasDAO extends PrincipalDAO{
    public boolean inserirMesas(Mesas novaMesas,String aux){
        //conexão com o BD e inserção da tabela MESA
        connectToDB();
        String sql = "insert into Mesa(idMesa,nPessoas,caixa_cnpj) values(?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,novaMesas.getIdMesa());
            pst.setInt(2,novaMesas.getNumPessoas());
            pst.setString(3,aux);
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
