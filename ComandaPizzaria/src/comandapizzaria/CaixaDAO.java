package comandapizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CaixaDAO extends PrincipalDAO{ 
    public boolean inserirCaixa(Caixa novoCaixa){
        //toda parte de conexão com o BD para inserção da tabela CAIXA
        connectToDB();
        String sql = "insert into Caixa(cnpj,totalDiario,totalMensal,dinheiroEmCaixa) values(?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,novoCaixa.getCnpj());
            pst.setFloat(2,novoCaixa.getTotalDiario());
            pst.setFloat(3,novoCaixa.getTotalMensal());
            pst.setFloat(4,novoCaixa.getDinheiroEmCaixa());
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
