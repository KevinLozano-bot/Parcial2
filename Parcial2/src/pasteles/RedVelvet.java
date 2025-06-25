package pasteles;

public class RedVelvet implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;
    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "centro":
                precio = 18000;
                tiempo = 60;
                break;
            default:
                throw new IllegalArgumentException("Red Velvet no disponible en la sede:" + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel Red Velvet");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }
    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Red Velvet"; }

}