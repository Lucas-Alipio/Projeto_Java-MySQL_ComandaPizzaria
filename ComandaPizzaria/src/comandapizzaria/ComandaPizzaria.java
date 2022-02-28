package comandapizzaria;

import br.inatel.comandapizzaria.telas.CadastraNovoPedido;
import br.inatel.comandapizzaria.telas.TelaPrincipal;
import java.util.ArrayList;

public class ComandaPizzaria {
    public static void main(String[] args) {
        //registrando tabela caixa no banco de dados
        Caixa nova = new Caixa();
        nova.setCnpj("11-222-333/4444-55");
        nova.setDinheiroEmCaixa(1556);
        nova.setTotalDiario(0);
        nova.setTotalMensal(555);
        
        CaixaDAO daocai = new CaixaDAO();
        //função para conectar e inserir os dados no BD
        if (daocai.inserirCaixa(nova)) {
            System.out.println("sucesso");
        }
        
        //registrando a tabela mesa no banco de dados
        MesasDAO daomes = new MesasDAO();
        Mesas mesa = new Mesas(); 
        String cnpj = "11-222-333/4444-55";
        //for para preenchimentos dos dados fixos das mesas
        for (int i = 1; i < 6; i++) {
            mesa.setIdMesa(i);
            mesa.setNumPessoas(6);
            //função para conectar e inserir os dados no BD
            if (daomes.inserirMesas(mesa, cnpj)) {
                System.out.println("ok");
            }
        }
        //mesmo for anterior para as mesas 6 á 9
        for (int i = 6; i < 10; i++) {
            mesa.setIdMesa(i);
            mesa.setNumPessoas(10);
            if (daomes.inserirMesas(mesa, cnpj)) {
                System.out.println("ok");
            }
        }
        //chamando a tela principal
        TelaPrincipal tp = new TelaPrincipal();
        tp.setVisible(true);
    }
}
