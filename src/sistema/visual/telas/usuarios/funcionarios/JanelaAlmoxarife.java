package sistema.visual.telas.usuarios.funcionarios;
import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;

public class JanelaAlmoxarife extends JanelaFuncionario{

    public JanelaAlmoxarife(SistemaMercado sistema, Usuario usuario){
        super(sistema, usuario);
        setSize(800, 800);

        add(adicionarCabecalho("Bem-vindo(a), " + usuario.getNome()));

        int larguraPainel = calcularLargura(200,20, 2);
        int alturaPainel = calcularAltura(150, 20, 2);
        int x = calcularX(larguraPainel);
        getPainelBotoes().setBounds(x, 80, larguraPainel, alturaPainel);
    }
}
    
