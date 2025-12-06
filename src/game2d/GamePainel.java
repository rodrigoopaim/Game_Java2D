
package game2d;

import entidades.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import objeto.SuperObjeto;
import tile.GerenciadorTile;

public class GamePainel extends JPanel implements Runnable{
    //CONFIGURAÇÕES DA TELA
    final int tamanhoPadraoOriginal = 16; //16x16 pixels
    final int escala = 3;
    
    public final int tamanhoPadrao = tamanhoPadraoOriginal * escala; //48x48 pixels
    public final int maxTelaCol = 16;
    public final int maxTelaRow = 12;
    
    public final int telaWidth = maxTelaCol * tamanhoPadrao; //768 pixels
    public final int telaHeight = maxTelaRow * tamanhoPadrao; //576 pixels
    
    //CONFIGURAÇÕES DO MUNDO
    public final int maxMundoCol = 50;
    public final int maxMundoRow = 50;
    public final int mundoWidth = maxMundoCol*tamanhoPadrao;
    public final int mundoHeight = maxMundoRow*tamanhoPadrao;
    
    final int FPS = 60;
    
    GerenciadorTile gTile = new GerenciadorTile(this);
    GerenciadorTeclado teclado = new GerenciadorTeclado();
    Thread gameThread;
    public ChecagemColisao checarC = new ChecagemColisao(this);
    public AssetsSetter aSetter = new AssetsSetter(this);
    public Player player = new Player(this, teclado);
    public SuperObjeto obj[] = new SuperObjeto[10];

    public GamePainel() {
        this.setPreferredSize(new Dimension(telaWidth, telaHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(teclado);
        this.setFocusable(true);
    }
    
    public void setupGame() {
        aSetter.setObjeto();
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run(){
        double intervaloDesenho = 1000000000/FPS; //0.0166 segundos
        double proximoIntervaloTempo = System.nanoTime() + intervaloDesenho;
        
        while (gameThread != null) {            
            //ATUALIZAR: atualizar informações sobre o posicionamento do caracter
            atualizar();
            //DESENHAR: desenhar a tela com a informação atualizada
            repaint();
            
            try {
                double tempoPermanecido = proximoIntervaloTempo - System.nanoTime();
                tempoPermanecido = tempoPermanecido/1000000;
                if(tempoPermanecido < 0)
                    tempoPermanecido = 0;
                
                Thread.sleep((long) tempoPermanecido);
                proximoIntervaloTempo += intervaloDesenho;
                
            } catch (InterruptedException ex) {
                System.getLogger(GamePainel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
    
    public void atualizar(){
        player.atualizar();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        gTile.desenhar(g2);
        
        for(int i=0; i<obj.length; i++){
            if(obj[i] != null){
                obj[i].desenhar(g2, this);
            }
        }
        
        player.desenhar(g2);
        g2.dispose();
    }
}
