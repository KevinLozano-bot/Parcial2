package pasteles;

public class Macarons implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;

    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "sur":
                precio = 20000;
                tiempo = 120;
                break;
            default:
                throw new IllegalArgumentException("Macarons no disponible en " + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel de Macarons");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }

    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Macarons";

    }
}