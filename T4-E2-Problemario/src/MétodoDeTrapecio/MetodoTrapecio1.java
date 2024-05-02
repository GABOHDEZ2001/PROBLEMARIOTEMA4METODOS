package MétodoDeTrapecio;

import java.util.function.Function;

public class MetodoTrapecio1 {

    // Método para calcular la integral usando el método del trapecio
    public static double metodoTrapecio(double a, double b, int n, Function<Double, Double> f) {
        double h = (b - a) / n;
        double sum = 0.5 * (f.apply(a) + f.apply(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += f.apply(x);
        }

        return h * sum;
    }

    // Función de ejemplo: f(x) = x^2
    public static double funcionEjemplo(double x) {
        return x * x;
    }

    public static void main(String[] args) {
        double a = 0; // Límite inferior de integración
        double b = 2; // Límite superior de integración
        int n = 100;  // Número de trapezoides

        double integral = metodoTrapecio(a, b, n, MetodoTrapecio1::funcionEjemplo);

        System.out.println("La aproximación de la integral es: " + integral);
    }
}

//ENTRADA
// Función de ejemplo: f(x) = x^2

//SALIDA (Resultado)
//2.6668000000000003
