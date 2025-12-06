package game2d;

import objeto.ObjBau;
import objeto.ObjKey;
import objeto.ObjPorta;

public class AssetsSetter {
    GamePainel gp;

    public AssetsSetter(GamePainel gp) {
        this.gp = gp;
    }
    public void setObjeto(){
        gp.obj[0] = new ObjKey();
        gp.obj[0].mundoX = 11 * gp.tamanhoPadrao;
        gp.obj[0].mundoY= 6 * gp.tamanhoPadrao;
        
        gp.obj[1] = new ObjPorta();
        gp.obj[1].mundoX = 7 * gp.tamanhoPadrao;
        gp.obj[1].mundoY= 6 * gp.tamanhoPadrao;
        
        gp.obj[2] = new ObjPorta();
        gp.obj[2].mundoX = 15 * gp.tamanhoPadrao;
        gp.obj[2].mundoY= 6 * gp.tamanhoPadrao;
        
        gp.obj[3] = new ObjBau();
        gp.obj[3].mundoX = 1 * gp.tamanhoPadrao;
        gp.obj[3].mundoY= 1 * gp.tamanhoPadrao;
        
        gp.obj[4] = new ObjBau();
        gp.obj[4].mundoX = 18 * gp.tamanhoPadrao;
        gp.obj[4].mundoY= 1 * gp.tamanhoPadrao;
    }
}
