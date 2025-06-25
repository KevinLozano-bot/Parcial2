import java.util.List;

public class Pedido {
    private String sede;
    private List<String> tipos;

    public Pedido(String sede, List<String> tipos) {
        this.sede = sede;
        this.tipos = tipos;
    }

    public String getSede() {
        return sede;
    }

    public List<String> getTipos() {
        return tipos;
    }
}