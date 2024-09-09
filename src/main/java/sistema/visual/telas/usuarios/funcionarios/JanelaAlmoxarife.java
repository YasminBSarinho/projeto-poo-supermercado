package sistema.visual.telas.usuarios.funcionarios;
import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;

import javax.swing.*;
import java.awt.*;

public class JanelaAlmoxarife extends JanelaFuncionario{
    public JanelaAlmoxarife(SistemaMercado sistema, Usuario usuario){
        super(sistema, usuario);
        setSize(720, 400);
        setLocationRelativeTo(null);
        setCabecalho(adicionarCabecalho("Bem-vindo(a), " + usuario.getNome() + "."));
        add(getCabecalho());
        int larguraPainel = calcularLargura(200,20, 3);
        int alturaPainel = calcularAltura(150, 20, 1);
        int x = calcularX(larguraPainel);
        int y = calcularY(getCabecalho());
        getPainelBotoes().setLayout(new GridLayout(1,3, 20, 20));
        getPainelBotoes().setBounds(x, y, larguraPainel, alturaPainel);
    }
}
    
