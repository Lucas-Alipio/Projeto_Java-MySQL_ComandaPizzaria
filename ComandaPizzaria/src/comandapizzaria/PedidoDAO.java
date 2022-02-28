package comandapizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class PedidoDAO extends PrincipalDAO{
    
    public boolean inserirPedido(Pedido novoPedido){
        //conexão com o BD e inserção da tabela Pedido
        connectToDB();
        String sql = "insert into Pedido(pedido,valorTotal,obervacao) values(?,?,?)";
        //passando o ARRAY para um String
        String[] aux = new String[novoPedido.getPedido().size()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = novoPedido.getPedido().get(i);
        }
        String aux2 = aux[0];
        for (int i = 1; i < aux.length; i++) {
            aux2 = aux2 + "/" + aux[i];
        }
        try{
            pst = con.prepareStatement(sql);
            pst.setObject(1,aux2);
            pst.setFloat(2,novoPedido.getValor());
            pst.setString(3,novoPedido.getObservacao());
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
    
    public boolean inserirMesaPedido(int p, int m){
        //conexão com o BD e inserção da tablea Mesa_has_Pedido
        connectToDB();
        String sql = "INSERT INTO Mesa_has_Pedido values(?,?,?)";
        Timestamp hr = new Timestamp(System.currentTimeMillis());
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,m);
            pst.setInt(2, p);
            pst.setTimestamp(3,hr);
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
    
    public int buscaIdPedido(){
        //conexão com o BD e busca do ID do pedido
        connectToDB();
        int id = 0;
        String sql = "SELECT idpedido from Pizzaria.Pedido";
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (id < rs.getInt("idpedido")) {
                    id = rs.getInt("idpedido");
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
        return id;
    }
    
    public Pedido BuscaParaListar(int id){
        //conexão com o BD e busca do Pedido para listar os produtos
        connectToDB();
        String sql = "SELECT * FROM Pizzaria.Pedido WHERE idPedido = ?";
        Pedido p = new Pedido();
        String aux = "";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery(); 
            while (rs.next()) {
                aux = rs.getString("pedido");
                p.setValor(rs.getInt("valorTotal"));
            }
            
            ArrayList<String> aux2 = new ArrayList();
            aux2.add(aux);
            p.setPedido(aux2);
            
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
        return p;
    }
    
        //*********Atualizar Dados************
    public boolean atualizarPedido(int id,String novoPedido,float valor){
        //conexão com o BD e atualização do Pedido
        connectToDB();
        String sql = "UPDATE Pizzaria.Pedido SET pedido=?,valorTotal=? WHERE idPedido=?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,novoPedido);
            pst.setFloat(2,valor);
            pst.setInt(3, id);
            pst.execute();
            sucesso = true;
        }catch(SQLException ex){
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        }finally{
            try{
                con.close();
                pst.close();
            }catch(SQLException ex){
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    //************ Deletar*************
    public boolean DeletarPedido(int id){
        //conexão com o BD e o DELETE do pedido com o ID passado
        connectToDB();
        String sql = "DELETE FROM Pizzaria.Pedido WHERE idPedido=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            sucesso = true;
        }catch(SQLException ex){
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        }finally{
            try{
                con.close();
                pst.close();
            }catch(SQLException ex){
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    
    public ArrayList<Pedido> buscaPedidoSemFiltro(){
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pedido";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("        LISTA DE PEDIDOS");
            System.out.println("******************************************");
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                String aux = rs.getString("pedido");
                ArrayList<String> aux2 = new ArrayList();
                aux2.add(aux);
                pedido.setPedido(aux2);
                pedido.setValor(rs.getFloat("valorTotal"));
                pedido.setObservacao(rs.getString("obervacao"));                           
                System.out.println("Id: " + pedido.getIdPedido());
                System.out.println("Pedido: " + pedido.getPedido());
                System.out.println("Valor Total: " + pedido.getValor());
                System.out.println("Observação: " + pedido.getObservacao());
                System.out.println("******************************************");
                listaPedidos.add(pedido);
            }
            sucesso = true;
        }catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        }finally{
            try{
                con.close();
                st.close();
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return listaPedidos;
    }  
}
