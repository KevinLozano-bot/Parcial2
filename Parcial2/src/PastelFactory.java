import java.util.Arrays;
import java.util.List;
import pasteles.Cheesecake;
import pasteles.Chocolate;
import pasteles.Coco;
import pasteles.Macarons;
import pasteles.PastelType;
import pasteles.RedVelvet;
import pasteles.Tiramisu;
import pasteles.Vainilla;
import pasteles.Zanahoria;


public class PastelFactory {
    private static final List<String> SEDES_VALIDAS = Arrays.asList("centro", "norte", "sur");

    public PastelType createPastel(String tipo, String sede) {
        if (!SEDES_VALIDAS.contains(sede.toLowerCase())) {
            System.out.println("Error: La sede '" + sede + "' no existe.");
            return null;
        }

        PastelType pastel = null;

        if (tipo.equalsIgnoreCase("chocolate")) {
            pastel = new Chocolate();
        } else if (tipo.equalsIgnoreCase("vainilla")) {
            pastel = new Vainilla();
        } else if (tipo.equalsIgnoreCase("red velvet")) {
            pastel = new RedVelvet();
        } else if (tipo.equalsIgnoreCase("cheesecake")) {
            pastel = new Cheesecake();
        } else if (tipo.equalsIgnoreCase("coco")) {
            pastel = new Coco();
        } else if (tipo.equalsIgnoreCase("zanahoria")) {
            pastel = new Zanahoria();
        } else if (tipo.equalsIgnoreCase("tiramisu")) {
            pastel = new Tiramisu();
        } else if (tipo.equalsIgnoreCase("macarons")) {
            pastel = new Macarons();
        } else {
            System.out.println("Error: El tipo de pastel '" + tipo + "' no existe.");
            return null;
        }

        try {
            pastel.configurar(sede);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return pastel;
    }
}

