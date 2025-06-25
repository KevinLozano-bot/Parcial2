import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PastelFactory factory = new PastelFactory();
        PastelService service = new PastelService(factory);
        Scanner sc = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();

        System.out.println("=== Bienvenido a Dulce Tradición ===");

        while (true) {
            System.out.print("\nIngrese la sede del pedido (centro, norte, sur): ");
            String sede = sc.nextLine().trim().toLowerCase();

            System.out.print("Ingrese los tipos de pastel separados por coma (ej: chocolate, cheesecake): ");
            String tiposInput = sc.nextLine();
            List<String> tipos = Arrays.asList(tiposInput.split(","));

            pedidos.add(new Pedido(sede, tipos));

            System.out.print("\n¿Desea ingresar otro pedido? (s/n): ");
            String continuar = sc.nextLine().trim().toLowerCase();
            if (!continuar.equals("s")) {
                break;
            }
        }

        System.out.println("\n--- Procesando pedidos ---\n");
        service.procesarPedidosSimultaneos(pedidos);
        
        System.out.println("\n¿Desea ver los pasteles ordenados por sede según el tiempo de preparación? (s/n): ");
        String ordenar = sc.nextLine().trim().toLowerCase();

        if (ordenar.equals("s")) {
            service.mostrarPastelesOrdenadosPorSede(pedidos);
        }
    }

}