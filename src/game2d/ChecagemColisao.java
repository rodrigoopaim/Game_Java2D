package game2d;

import entidades.Entidade;

public class ChecagemColisao {
    GamePainel gp;
    
    public ChecagemColisao(GamePainel gp) {
        this.gp = gp;
    }
    
    public void checarTile(Entidade entidade){
        int entidadeEsqMundoX = entidade.mundoX + entidade.areaSolida.x;
        int entidadeDirMundoX = entidade.mundoX + entidade.areaSolida.x + entidade.areaSolida.width;
        int entidadeTopMundoY = entidade.mundoY + entidade.areaSolida.y;
        int entidadeBaiMundoY = entidade.mundoY + entidade.areaSolida.y + entidade.areaSolida.height;
        
        int entidadeEsqCol = entidadeEsqMundoX/gp.tamanhoPadrao;
        int entidadeDirCol = entidadeDirMundoX/gp.tamanhoPadrao;
        int entidadeTopRow = entidadeTopMundoY/gp.tamanhoPadrao;
        int entidadeBaiRow = entidadeBaiMundoY/gp.tamanhoPadrao;
        
        int tileN1, tileN2;
        
        switch (entidade.direcao) {
            case "cima":
                entidadeTopRow = (entidadeTopMundoY - entidade.speed)/gp.tamanhoPadrao;
                tileN1 = gp.gTile.numTileMapa[entidadeEsqCol][entidadeTopRow];
                tileN2 = gp.gTile.numTileMapa[entidadeDirCol][entidadeTopRow];
                if(gp.gTile.tile[tileN1].colisao == true || gp.gTile.tile[tileN2].colisao == true){
                    entidade.colisaoON = true;
                }
                break;
            case "baixo":
                entidadeBaiRow = (entidadeBaiMundoY + entidade.speed)/gp.tamanhoPadrao;
                tileN1 = gp.gTile.numTileMapa[entidadeEsqCol][entidadeBaiRow];
                tileN2 = gp.gTile.numTileMapa[entidadeDirCol][entidadeBaiRow];
                if(gp.gTile.tile[tileN1].colisao == true || gp.gTile.tile[tileN2].colisao == true){
                    entidade.colisaoON = true;
                }
                break;
            case "esquerda":
                entidadeEsqCol = (entidadeEsqMundoX - entidade.speed)/gp.tamanhoPadrao;
                tileN1 = gp.gTile.numTileMapa[entidadeEsqCol][entidadeTopRow];
                tileN2 = gp.gTile.numTileMapa[entidadeEsqCol][entidadeBaiRow];
                if(gp.gTile.tile[tileN1].colisao == true || gp.gTile.tile[tileN2].colisao == true){
                    entidade.colisaoON = true;
                }
                break;
            case "direita":
                entidadeDirCol = (entidadeDirMundoX + entidade.speed)/gp.tamanhoPadrao;
                tileN1 = gp.gTile.numTileMapa[entidadeDirCol][entidadeTopRow];
                tileN2 = gp.gTile.numTileMapa[entidadeDirCol][entidadeBaiRow];
                if(gp.gTile.tile[tileN1].colisao == true || gp.gTile.tile[tileN2].colisao == true){
                    entidade.colisaoON = true;
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}
