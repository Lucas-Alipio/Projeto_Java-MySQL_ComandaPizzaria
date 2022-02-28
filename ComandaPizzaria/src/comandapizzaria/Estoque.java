package comandapizzaria;
public class Estoque {
    private String idProduto;
    private String nome;
    private String descricao;
    private int qtd;
    private float precoPeca;  //preço por peça do produto
    private float precoTotal; // preço total em estoque  

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(float precoPeca) {
        this.precoPeca = precoPeca;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    
}
