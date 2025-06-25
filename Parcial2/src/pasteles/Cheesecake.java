package pasteles;

public class Cheesecake implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;
    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "centro":
                precio = 20000;
                tiempo = 70;
                break;
            case "sur":
                precio = 28000;
                tiempo = 85;
                break;
            default:
                throw new IllegalArgumentException("Cheesecake no disponible en la sede: " + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel: Cheesecake");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }

    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Cheesecake"; }
}