package MétodoDeLaCuadraturaGaussiana;

import java.util.function.Function;

public class MétodoDeLaCuadraturaGaussiana2 {

    // Método para calcular la integral usando la cuadratura gaussiana
    public static double cuadraturaGaussiana(Function<Double, Double> funcion, double limiteInferior, double limiteSuperior, int numeroPuntos) {
        double[] nodos = { -0.7745966692, 0, 0.7745966692 }; // Nodos predefinidos para tres puntos
        double[] pesos = { 0.5555555556, 0.8888888889, 0.5555555556 }; // Pesos predefinidos para tres puntos

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
        // Ejemplo de uso: integral de e^(-x^2) desde -2 a 2
        Function<Double, Double> funcion = x -> Math.exp(-x * x);
        double limiteInferior = -2;
        double limiteSuperior = 2;
        int numeroPuntos = 3; // Utilizando tres puntos para la cuadratura gaussiana

        double resultado = cuadraturaGaussiana(funcion, limiteInferior, limiteSuperior, numeroPuntos);
        System.out.println("Resultado de la integral: " + resultado);
    }
}

//ENTRADA
// Ejemplo: integral de e^(-x^2) desde -2 a 2

//SALIDA (Resultado)
//1.9793732296222002


