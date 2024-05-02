package ReglaDeSimpson;


public class ReglaDeSimpson3 {
    public static double funcion(double x) {
        // Función seno: f(x) = sin(x)
        return Math.sin(x);
    }

    public static double reglaDeSimpson(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = funcion(a) + funcion(b);
        for (int i = 1; i < n; i += 2) {
            sum += 4 * funcion(a + i * h);
        }
        for (int i = 2; i < n - 1; i += 2) {
            sum += 2 * funcion(a + i * h);
        }
        return (h / 3) * sum;
    }

    public static void main(String[] args) {
        double a = 0; // Límite inferior
        double b = Math.PI; // Límite superior (un período de la función seno)
        int n = 100; // Número de intervalos
        System.out.println("Resultado: " + reglaDeSimpson(a, b, n));
    }
}


//ENTRADA
// Función de ejemplo: Función seno: f(x) = sin(x)

//SALIDA (Resultado)
//2.0000000108245044
