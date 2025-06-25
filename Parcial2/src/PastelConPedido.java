import pasteles.PastelType;

public class PastelConPedido {
    private PastelType pastel;
    private int numeroPedido;

    public PastelConPedido(PastelType pastel, int numeroPedido) {
        this.pastel = pastel;
        this.numeroPedido = numeroPedido;
    }

    public PastelType getPastel() {
        return pastel;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
}