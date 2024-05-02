package MétodoDeLaCuadraturaGaussiana;

import java.util.function.Function;

public class MétodoDeLaCuadraturaGaussiana1 {

    // Método para calcular la integral usando la cuadratura gaussiana
    public static double cuadraturaGaussiana(Function<Double, Double> funcion, double limiteInferior, double limiteSuperior, int numeroPuntos) {
        double[] nodos = { -0.5773502692, 0.5773502692 }; // Nodos predefinidos para dos puntos
        double[] pesos = { 1, 1 }; // Pesos predefinidos para dos puntos

        double suma = 0;
        double transformacion;

        // Iterar sobre los puntos y calcular la suma ponderada de la función en esos puntos
        for (int i = 0; i < numeroPuntos; i++) {
            transformacion = (limiteSuperior - limiteInferior) / 2 * nodos[i] + (limiteSuperior + limiteInferior) / 2;
            suma += pesos[i] * funcion.apply(transformacion);
        }

        return (limiteSuperior - limiteInferior) / 2 * suma;
    }

    public static void main(String[] args) {
        // Ejemplo de uso: integral de x^2 desde 0 a 1
        Function<Double, Double> funcion = x -> x * x;
        double limiteInferior = 0;
        double limiteSuperior = 1;
        int numeroPuntos = 2; // Utilizando dos puntos para la cuadratura gaussiana

        double resultado = cuadraturaGaussiana(funcion, limiteInferior, limiteSuperior, numeroPuntos);
        System.out.println("Resultado de la integral: " + resultado);
    }
}


//ENTRADA
// // Ejemplo: integral de x^2 desde 0 a 1

//SALIDA (Resultado)
//0.3333333333363282
