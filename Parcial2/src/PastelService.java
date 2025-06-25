import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pasteles.PastelType;

public class PastelService {
    private PastelFactory factory;

    public PastelService(PastelFactory factory) {
        this.factory = factory;
    }

    public void procesarPedidosSimultaneos(List<Pedido> pedidos) {
    int totalGeneralPrecio = 0;
    int totalGeneralTiempo = 0;

        int numeroPedido = 1;
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido " + numeroPedido + " (" + pedido.getSede() + "):");

            List<PastelType> pastelesValidos = new ArrayList<>();
            int subtotalPrecio = 0;
            int subtotalTiempo = 0;

            for (String tipo : pedido.getTipos()) {
                PastelType pastel = factory.createPastel(tipo.trim(), pedido.getSede());
                if (pastel != null) {
                    pastelesValidos.add(pastel);
                    subtotalPrecio += pastel.getPrecio();
                    subtotalTiempo += pastel.getTiempo();
                } else {
                    System.out.printf("- %s: No disponible en Sede %s\n", tipo.trim(), pedido.getSede());
                }
            }

            for (PastelType p : pastelesValidos) {
                System.out.printf("- %s: $%d, %d min\n", p.getNombre(), p.getPrecio(), p.getTiempo());
            }

            System.out.printf("Subtotal: $%d, %d min\n\n", subtotalPrecio, subtotalTiempo);

            totalGeneralPrecio += subtotalPrecio;
            totalGeneralTiempo += subtotalTiempo;
            numeroPedido++;
        }

        System.out.printf("Total general: $%d, %d minutos\n", totalGeneralPrecio, totalGeneralTiempo);
    }
        public void mostrarPastelesOrdenadosPorSede(List<Pedido> pedidos) {
        Map<String, List<PastelConPedido>> pastelesPorSede = new HashMap<>();
        int numeroPedido = 1;

        for (Pedido pedido : pedidos) {
            String sede = pedido.getSede().toLowerCase();
            for (String tipo : pedido.getTipos()) {
                PastelType pastel = factory.createPastel(tipo.trim(), sede);
                if (pastel != null) {
                    pastelesPorSede
                        .computeIfAbsent(sede, k -> new ArrayList<>())
                        .add(new PastelConPedido(pastel, numeroPedido));
                }
            }
            numeroPedido++;
        }

        System.out.println("Pasteles por sede (ordenados por tiempo de preparación):");

        for (String sede : pastelesPorSede.keySet()) {
            List<PastelConPedido> pasteles = pastelesPorSede.get(sede);
            pasteles.sort(Comparator.comparingInt(p -> p.getPastel().getTiempo()));

            int subtotal = 0;
            int totalTiempo = 0;

            System.out.println("Sede " + capitalize(sede) + ":");
            for (PastelConPedido pcp : pasteles) {
                PastelType pastel = pcp.getPastel();
                System.out.printf("- %s (Pedido %d): $%d, %d min\n",
                        pastel.getNombre(), pcp.getNumeroPedido(), pastel.getPrecio(), pastel.getTiempo());
                subtotal += pastel.getPrecio();
                totalTiempo += pastel.getTiempo();
            }
            System.out.printf("Total: $%,d, %d min\n\n", subtotal, totalTiempo);
        }
    }

    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }


    }