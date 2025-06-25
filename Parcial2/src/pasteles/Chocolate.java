package pasteles;

public class Chocolate implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;
    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "centro":
                precio = 15000;
                tiempo = 45;
                break;
            case "norte":
                precio = 18000;
                tiempo = 55;
                break;
            case "sur":
                precio = 22000;
                tiempo = 65;
                break;
            default:
                throw new IllegalArgumentException("Chocolate no disponible en la sede:" + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel: Chocolate");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }

    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Chocolate"; }
}