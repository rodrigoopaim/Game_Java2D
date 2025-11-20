
package entidades;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidade {
    public int mundoX, mundoY;
    public int speed;
    
    public BufferedImage cima, cima1, cima2, baixo, baixo1, baixo2, esquerda1, esquerda2, direita1, direita2;
    public  String direcao;
    
    public int contadorSprite = 0;
    public int spriteNum = 1;
    
    public Rectangle areaSolida;
    public boolean colisaoON = false;
}
