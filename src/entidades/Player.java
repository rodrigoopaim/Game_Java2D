
package entidades;

import game2d.GamePainel;
import game2d.GerenciadorTeclado;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entidade{
    GamePainel gp;
    GerenciadorTeclado teclado;
    
    public final int telaX, telaY;

    public Player(GamePainel gp, GerenciadorTeclado teclado) {
        this.gp = gp;
        this.teclado = teclado;
        
        telaX = gp.telaWidth/2-(gp.tamanhoPadrao/2);
        telaY = gp.telaHeight/2-(gp.tamanhoPadrao/2);
        
        areaSolida = new Rectangle(9, 21, 30, 24);
        
        setValoresPadrao();
        getPlayerImage();
    }
    
    public void setValoresPadrao(){
        mundoX = gp.tamanhoPadrao * 11;
        mundoY = gp.tamanhoPadrao * 10;
        speed = 4;
        direcao = "baixo";
    }
    public void getPlayerImage(){
        try {
            cima = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_costa.png"));
            cima1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_andando_costa.png"));
            cima2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_andando_costa2.png"));
            baixo = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_frente.png"));
            baixo1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_andando_frente.png"));
            baixo2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_andando_frente2.png"));
            esquerda1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_esquerda.png"));
            esquerda2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_andando_esquerda.png"));
            direita1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_direita.png"));
            direita2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/Hero_andando_direita.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void atualizar(){
        if(teclado.baixoPressionado==true || teclado.cimaPressionado==true ||
                teclado.direitaPressionado==true || teclado.esquerdaPressionado==true){
            
            if(teclado.cimaPressionado == true){
                direcao = "cima";
            } else if(teclado.baixoPressionado == true){
                direcao = "baixo";
            }else if(teclado.esquerdaPressionado == true){
                direcao = "esquerda";
            }else if(teclado.direitaPressionado == true){
                direcao = "direita";
            }
            
            //CHECA COLISÃO
            colisaoON = false;
            gp.checarC.checarTile(this);
            
            //SE A COLISÃO FOR FALSA O PLAYER PODE SE MEXER
            if(colisaoON==false){
                switch (direcao) {
                    case "cima":
                        mundoY -= speed;
                        break;
                    case "baixo":
                        mundoY += speed;
                        break;
                    case "esquerda":
                        mundoX -= speed;
                        break;
                    case "direita":
                        mundoX += speed;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
            contadorSprite++;
            if(contadorSprite > 10){
                if(spriteNum==0)
                    spriteNum=1;
                else if(spriteNum==1)
                    spriteNum=2;
                else if(spriteNum==2)
                    spriteNum=1;
                contadorSprite=0;
            }
        } else if(direcao.equals("cima") || direcao.equals("baixo")){
            spriteNum=0;
            contadorSprite=10;
        } else if(direcao.equals("esquerda") || direcao.equals("direita")){
            spriteNum=1;
        }
    }
    public void desenhar(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tamanhoPadrao, gp.tamanhoPadrao);
        
        BufferedImage imagem = null;
        switch (direcao) {
            case "cima":
                if(spriteNum==0)
                    imagem = cima;
                else if(spriteNum==1)
                    imagem = cima1;
                else if(spriteNum==2)
                    imagem = cima2;
                break;
            case "baixo":
                if(spriteNum==0)
                    imagem = baixo;
                else if(spriteNum==1)
                    imagem = baixo1;
                else if(spriteNum==2)
                    imagem = baixo2;
                break;
            case "esquerda":
                if(spriteNum==1)
                    imagem = esquerda1;
                else if(spriteNum==2)
                    imagem = esquerda2;
                break;
            case "direita":
                if(spriteNum==1)
                    imagem = direita1;
                else if(spriteNum==2)
                    imagem = direita2;
                break;
            
            default:
                throw new AssertionError();
        }
        g2.drawImage(imagem, telaX, telaY, gp.tamanhoPadrao, gp.tamanhoPadrao, null);
    }
}
