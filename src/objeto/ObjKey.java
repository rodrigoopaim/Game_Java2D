package objeto;

import javax.imageio.ImageIO;

public class ObjKey extends SuperObjeto{

    public ObjKey() {
        nome = "Chave";
        try {
            imagem = ImageIO.read(getClass().getResourceAsStream("/assets/objetos/chave.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
