package ReglaDeSimpson;

public class ReglaDeSimpson1 {
    public static double funcion(double x) {
        // Función lineal: f(x) = 2x + 3
        return 2 * x + 3;
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
        double b = 4; // Límite superior
        int n = 100; // Número de intervalos
        System.out.println("Resultado: " + reglaDeSimpson(a, b, n));
    }
}
//ENTRADA
// Función de ejemplo: Función lineal: f(x) = 2x + 3

//SALIDA (Resultado)
//28.000000000000004