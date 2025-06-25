package pasteles;
public interface PastelType {
    void configurar(String sede);
    void showInfo();
    int getPrecio();
    int getTiempo();
    String getNombre();
}