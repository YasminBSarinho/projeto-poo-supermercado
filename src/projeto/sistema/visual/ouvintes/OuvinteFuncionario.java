package projeto.sistema.visual.ouvintes;

import java.awt.event.ActionEvent;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.telas.JanelaCadastroCliente;
import projeto.sistema.visual.telas.JanelaCadastroProduto;
import projeto.sistema.visual.telas.usuarios.funcionarios.JanelaFuncionario;

public class OuvinteFuncionario extends OuvinteUsuario {
    private JanelaFuncionario janela;

    public OuvinteFuncionario(JanelaFuncionario janela, SistemaMercado sistema){
        super(janela, sistema);
        setJanela(janela);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        if(e.getSource().equals(janela.getListarProdutos())){
            //JanelaListarProdutos janelaListarProduto = new JanelaListarProdutos(getSistema());
        }
        else if(e.getSource().equals(janela.getCadastrarProduto())){
            JanelaCadastroProduto janelaCadastrarProduto = new JanelaCadastroProduto(getSistema());
        }
    }

    public JanelaFuncionario getJanela() {
        return janela;
    }

    public void setJanela(JanelaFuncionario janela) {
        this.janela = janela;
    }
    
}
