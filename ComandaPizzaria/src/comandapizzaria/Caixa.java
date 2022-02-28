package comandapizzaria;
public class Caixa {
    private String cnpj;
    private float totalDiario;
    private float totalMensal;
    private float dinheiroEmCaixa;
    private Mesas mesa[] = new Mesas[9];

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getTotalDiario() {
        return totalDiario;
    }

    public void setTotalDiario(float totalDiario) {
        this.totalDiario = totalDiario;
    }

    public float getTotalMensal() {
        return totalMensal;
    }

    public void setTotalMensal(float totalMensal) {
        this.totalMensal = totalMensal;
    }

    public float getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    public void setDinheiroEmCaixa(float dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public Mesas[] getMesa() {
        return mesa;
    }

    public void setMesa(Mesas mesa,int x) {
        this.mesa[x] = mesa;
    }

    
}
