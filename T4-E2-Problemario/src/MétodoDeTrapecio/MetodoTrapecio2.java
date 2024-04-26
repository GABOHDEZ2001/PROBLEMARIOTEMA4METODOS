package MétodoDeTrapecio;

import java.util.function.Function;

public class MetodoTrapecio2 {

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

    // Función de ejemplo: f(x) = seno(x)
    public static double funcionEjemplo(double x) {
        return Math.sin(x);
    }

    public static void main(String[] args) {
        double a = 0; // Límite inferior de integración
        double b = Math.PI; // Límite superior de integración
        int n = 100;  // Número de trapezoides

        double integral = metodoTrapecio(a, b, n, MetodoTrapecio2::funcionEjemplo);

        System.out.println("La aproximación de la integral es: " + integral);
    }
}

//ENTRADA
// Función de ejemplo: f(x) = seno(x)

//SALIDA (Resultado)
//1.9998355038874436
