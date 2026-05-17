import java.util.Arrays;

public class Pizza {
    private String nombre;
    private String[] ingredientes; // Arreglo fijo de tamaño 3

    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = Arrays.copyOf(ingredientes, 3);
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: " + Arrays.toString(ingredientes);
    }
}