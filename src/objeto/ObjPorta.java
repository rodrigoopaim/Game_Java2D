package objeto;

import javax.imageio.ImageIO;

public class ObjPorta extends SuperObjeto{
    public ObjPorta() {
        nome = "Porta";
        try {
            imagem = ImageIO.read(getClass().getResourceAsStream("/assets/objetos/porta_fechada.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
