package projeto.sistema.visual.telas.usuarios.funcionarios;


import javax.swing.JButton;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;

public class JanelaGerente extends JanelaFuncionario {
    private JButton cadastrarUsuario;

    public JanelaGerente(SistemaMercado sistema, Usuario usuario){
        super(sistema, usuario);
        cadastrarUsuario = adicionarBotao("Cadastrar Usuário", getFonteDoBotao(), getPainelBotoes());
        getPainelBotoes().setBounds(calcularX(250), 120, 250, calcularAltura(90));
    }

    public JButton getCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(JButton cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }
    
}
