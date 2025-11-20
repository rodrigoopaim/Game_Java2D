
package tile;

import game2d.GamePainel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class GerenciadorTile {
    GamePainel gp;
    public Tile[] tile;
    public int numTileMapa[][];

    public GerenciadorTile(GamePainel gp) {
        this.gp = gp;
        tile = new Tile[10];
        numTileMapa = new int[gp.maxMundoCol][gp.maxMundoRow];
        getTileImage();
        carregarMapa("/assets/mapas/mapa01.txt");
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].imagem = ImageIO.read(getClass().getResourceAsStream("/assets/backgroud/grama.png"));
            
            tile[1] = new Tile();
            tile[1].imagem = ImageIO.read(getClass().getResourceAsStream("/assets/backgroud/agua.png"));
            tile[1].colisao = true;
            
            tile[2] = new Tile();
            tile[2].imagem = ImageIO.read(getClass().getResourceAsStream("/assets/backgroud/tijolo.png"));
            tile[2].colisao = true;
            
            tile[3] = new Tile();
            tile[3].imagem = ImageIO.read(getClass().getResourceAsStream("/assets/backgroud/arvore.png"));
            tile[3].colisao = true;
            
            tile[4] = new Tile();
            tile[4].imagem = ImageIO.read(getClass().getResourceAsStream("/assets/backgroud/road.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void carregarMapa(String caminhoDoMapa){
        try {
            InputStream is = getClass().getResourceAsStream(caminhoDoMapa);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int coluna=0, linha=0;
            
            while (coluna < gp.maxMundoCol && linha < gp.maxMundoRow) {
                String line = br.readLine();
                
                while (coluna < gp.maxMundoCol) {
                    String numeros[] = line.split(" ");
                    int num = Integer.parseInt(numeros[coluna]);
                    
                    numTileMapa[coluna][linha] = num;
                    coluna++;
                }
                if(coluna == gp.maxMundoCol){
                    coluna=0;
                    linha++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void desenhar(Graphics2D g2){
        int coluna=0, linha=0;
        
        while (coluna < gp.maxMundoCol && linha < gp.maxMundoRow) {
            int numTile = numTileMapa[coluna][linha];
            
            int mundoX = coluna*gp.tamanhoPadrao;
            int mundoY = linha*gp.tamanhoPadrao;
            int telaX = mundoX - gp.player.mundoX + gp.player.telaX;
            int telaY = mundoY - gp.player.mundoY + gp.player.telaY;
            
            if(mundoX + gp.tamanhoPadrao> gp.player.mundoX - gp.player.telaX &&
                mundoX - gp.tamanhoPadrao< gp.player.mundoX + gp.player.telaX &&
                mundoY + gp.tamanhoPadrao> gp.player.mundoY - gp.player.telaY &&
                mundoY - gp.tamanhoPadrao< gp.player.mundoY + gp.player.telaY){
                g2.drawImage(tile[numTile].imagem, telaX, telaY, gp.tamanhoPadrao, gp.tamanhoPadrao, null);
            }
            
            coluna++;
           
            if(coluna == gp.maxMundoCol){
                coluna=0;
                linha++;
            }
        }
    }
}
