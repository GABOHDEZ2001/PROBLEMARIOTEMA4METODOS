package ReglaDeSimpson;

public class ReglaDeSimpson2 {
    public static double funcion(double x) {
        // Función cuadrática: f(x) = x^2 + 2x + 1
        return Math.pow(x, 2) + 2 * x + 1;
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
// Función de ejemplo: Función cuadrática: f(x) = x^2 + 2x + 1

//SALIDA (Resultado)
//41.33333333333336
