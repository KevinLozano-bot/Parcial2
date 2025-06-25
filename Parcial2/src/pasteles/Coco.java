package pasteles;

public class Coco implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;

    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "norte":
                precio = 15000;
                tiempo = 40;
                break;
            default:
                throw new IllegalArgumentException("Coco no disponible en " + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel de Coco");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }

    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Coco";

    }
}