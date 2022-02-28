package comandapizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO extends PrincipalDAO{
    public boolean inserirCliente(Cliente novoCliente,Pedido novoP,int mesa){
        //conexão com o BD e inserção
        connectToDB();
        String sql = "insert into Cliente(nome,telefone,promoção,pedido_idPedido,Mesa_idmesa) values(?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,novoCliente.getNome());
            pst.setString(2,novoCliente.getTelefone());
            pst.setBoolean(3,novoCliente.isPromoção());
            pst.setInt(4,novoP.getIdPedido());
            pst.setInt(5,mesa);
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

    /*public void buscaCliente(String nome){

        connectToDB();
        String sql = "SELECT * FROM Cliente WHERE nome = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente c1 = new Cliente();
                c1.setIdCliente(rs.getInt("idcliente"));
                c1.setNome(rs.getString("nome"));
                c1.setTelefone(rs.getString("telefone"));
                c1.setPromoção(rs.getBoolean("Promoção"));                   

                if(c1.getNome().equals(nome)){
                    System.out.println("idCliente: " + c1.getIdCliente());
                    System.out.println("nome: " + c1.getNome());
                    System.out.println("Telefone: " + c1.getTelefone());
                    System.out.println("Promoção: " + c1.isPromoção());
                }
            }
            
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }finally{
            try{
                con.close();
                pst.close();
            }catch(SQLException ex){
                System.out.println("Erro: "+ex.getMessage());
            }
        }

    }*/
}
