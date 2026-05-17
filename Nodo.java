public class Nodo {
    Pizza pizza;
    Nodo siguiente; // Puntero al nodo de abajo

    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null;
    }
}