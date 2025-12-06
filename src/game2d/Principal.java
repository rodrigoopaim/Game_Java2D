
package game2d;

import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setTitle("Em Busca da Casa Automatica");
     
        GamePainel painel = new GamePainel();
        janela.add(painel);
        
        janela.pack();
        
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    painel.setupGame();
        painel.startGameThread();
    }
    
}
