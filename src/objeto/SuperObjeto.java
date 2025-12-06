package objeto;

import game2d.GamePainel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class SuperObjeto {
    public BufferedImage imagem;
    public String nome;
    public boolean colisao = false;
    public int mundoX, mundoY;
    
    public void desenhar(Graphics2D g2, GamePainel gp){
        int telaX = mundoX - gp.player.mundoX + gp.player.telaX;
            int telaY = mundoY - gp.player.mundoY + gp.player.telaY;
            
            if(mundoX + gp.tamanhoPadrao> gp.player.mundoX - gp.player.telaX &&
                mundoX - gp.tamanhoPadrao< gp.player.mundoX + gp.player.telaX &&
                mundoY + gp.tamanhoPadrao> gp.player.mundoY - gp.player.telaY &&
                mundoY - gp.tamanhoPadrao< gp.player.mundoY + gp.player.telaY){
                g2.drawImage(imagem, telaX, telaY, gp.tamanhoPadrao, gp.tamanhoPadrao, null);
            }
    }
}
