import java.util.Scanner;

public class GestionPedidos {
    public static void main(String[] args) {
        PilaManual pilaPrincipal = new PilaManual();   // Para el Undo
        PilaManual pilaSecundaria = new PilaManual();  // Para el Redo
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== PIZZA-TRACK SYSTEM ===");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la pizza: ");
                    String nombre = scanner.nextLine();
                    String[] ingredientes = new String[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Ingrese el ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = scanner.nextLine();
                    }
                    
                    Pizza nuevaPizza = new Pizza(nombre, ingredientes);
                    pilaPrincipal.push(nuevaPizza);
                    pilaSecundaria = new PilaManual(); // Limpia el Redo al escribir nuevo
                    System.out.println("¡Pedido registrado con éxito!");
                    break;

                case 2: // Undo
                    if (!pilaPrincipal.isEmpty()) {
                        Pizza deshecha = pilaPrincipal.pop();
                        pilaSecundaria.push(deshecha);
                        System.out.println("Se deshizo el pedido: " + deshecha.getNombre());
                    } else {
                        System.out.println("No hay pedidos para deshacer.");
                    }
                    break;

                case 3: // Redo
                    if (!pilaSecundaria.isEmpty()) {
                        Pizza recuperada = pilaSecundaria.pop();
                        pilaPrincipal.push(recuperada);
                        System.out.println("Se recuperó el pedido: " + recuperada.getNombre());
                    } else {
                        System.out.println("No hay acciones por rehacer.");
                    }
                    break;

                case 4: // Peek
                    if (!pilaPrincipal.isEmpty()) {
                        System.out.println("Pedido listo para producción: " + pilaPrincipal.peek());
                    } else {
                        System.out.println("No hay pedidos activos.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}