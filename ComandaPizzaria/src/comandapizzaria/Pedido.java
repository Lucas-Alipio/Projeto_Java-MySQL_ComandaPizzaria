package comandapizzaria;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private ArrayList<String> pedido = new ArrayList();
    private float valor;
    private String observacao;
    private Estoque estoque[] = new Estoque[1000]; 

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public ArrayList<String> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<String> pedido) {
        this.pedido = pedido;
    }
    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Estoque[] getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque[] estoque) {
        this.estoque = estoque;
    }
    
    
}
