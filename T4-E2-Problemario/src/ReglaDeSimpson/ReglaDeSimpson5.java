package ReglaDeSimpson;

public class ReglaDeSimpson5 {
    public static double funcion(double x) {
        // Función logarítmica: f(x) = ln(x)
        return Math.log(x);
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
        double a = 1; // Límite inferior (ln(1) no está definido)
        double b = 5; // Límite superior
        int n = 100; // Número de intervalos
        System.out.println("Resultado: " + reglaDeSimpson(a, b, n));
    }
}



//ENTRADA
// Función de ejemplo: Función logarítmica: f(x) = ln(x)

//SALIDA (Resultado)
//4.047189534018284
