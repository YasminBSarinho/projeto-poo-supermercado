package sistema.visual.ouvintes;

import java.awt.event.ActionEvent;

import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.visual.telas.JanelasDeCampos.JanelaCadastroProduto;
import sistema.visual.telas.JanelasDeCampos.JanelaListarProdutos;
import sistema.visual.telas.usuarios.funcionarios.JanelaFuncionario;

public class OuvinteFuncionario extends OuvinteUsuario {
    private JanelaFuncionario janela;
    private Usuario usuario;
    public OuvinteFuncionario(JanelaFuncionario janela, SistemaMercado sistema, Usuario usuario){
        super(janela, sistema);
        setJanela(janela);
        setUsuario(usuario);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        if(e.getSource().equals(janela.getListarProdutos())){
            JanelaListarProdutos janelaListarProduto = new JanelaListarProdutos(getSistema(),getUsuario());
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
