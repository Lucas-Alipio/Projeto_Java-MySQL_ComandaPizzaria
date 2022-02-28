package comandapizzaria;
public class Cliente {
    private int idCliente;
    private String nome;
    private String telefone;
    private boolean promoção;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isPromoção() {
        return promoção;
    }

    public void setPromoção(boolean promoção) {
        this.promoção = promoção;
    }
  
    
    
}
