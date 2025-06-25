package pasteles;

public class Vainilla   implements PastelType {
    private int precio;
    private int tiempo;
    private String sede;
    @Override
    public void configurar(String sede) {
        this.sede = sede.toLowerCase();
        switch (this.sede) {
            case "centro":
                precio = 12000;
                tiempo = 30;
                break;
            case "norte":
                precio = 14000;
                tiempo = 35;
                break;
            default:
                throw new IllegalArgumentException("Vainilla no disponible en " + sede);
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Pastel de Vainilla");
        System.out.println("Precio: $" + precio);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Sede: " + sede);
    }

    @Override public int getPrecio() { return precio; }
    @Override public int getTiempo() { return tiempo; }
    @Override public String getNombre() { return "Vainilla"; }

}