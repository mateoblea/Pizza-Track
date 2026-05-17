public class PilaManual {
    private Nodo tope; // Puntero al elemento de arriba de la pila

    public PilaManual() {
        this.tope = null; // Al iniciar, la pila está vacía
    }

    // Validar si la pila está vacía
    public boolean isEmpty() {
        return tope == null;
    }

    // Insertar un objeto Pizza en el tope de la pila
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza);
        if (!isEmpty()) {
            nuevoNodo.siguiente = tope;
        }
        tope = nuevoNodo;
    }

    // Retirar el objeto del tope y devolver su contenido
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        Pizza pizzaRetornada = tope.pizza;
        tope = tope.siguiente; // El tope baja al siguiente nodo en la lista
        return pizzaRetornada;
    }

    // Visualizar la pizza en el tope sin retirarla
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.pizza;
    }
}