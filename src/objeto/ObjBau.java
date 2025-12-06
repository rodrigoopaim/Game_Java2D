package objeto;

import javax.imageio.ImageIO;

public class ObjBau extends SuperObjeto{
    public ObjBau() {
        nome = "Bau";
        try {
            imagem = ImageIO.read(getClass().getResourceAsStream("/assets/objetos/bau.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
