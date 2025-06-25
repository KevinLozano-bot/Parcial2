package pasteles;

public class Tiramisu implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;

    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "sur":
                precio = 25000;
                tiempo = 90;
                break;
            default:
                throw new IllegalArgumentException("Tiramisu no disponible en " + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel de Tiramisu");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }

    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Tiramisu";

    }
}