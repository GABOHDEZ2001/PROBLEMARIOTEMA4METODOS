package MétodoDeTrapecio;

import java.util.function.Function;

public class MetodoTrapecio4 {

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

    // Función de ejemplo: f(x) = x^3 + 2x^2 + x + 1
    public static double funcionPersonalizada(double x) {
        return Math.pow(x, 3) + 2 * Math.pow(x, 2) + x + 1;
    }

    public static void main(String[] args) {
        double a = 1; // Límite inferior de integración
        double b = 3; // Límite superior de integración
        int n = 100;  // Número de trapezoides

        double integral = metodoTrapecio(a, b, n, MetodoTrapecio4::funcionPersonalizada);

        System.out.println("La aproximación de la integral es: " + integral);
    }
}

//ENTRADA
// Función de ejemplo: f(x) = x^3 + 2x^2 + x + 1

//SALIDA (Resultado)
//43.33439999999999