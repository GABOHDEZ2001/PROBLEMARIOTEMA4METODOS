package MétodoDeLaCuadraturaGaussiana;

import java.util.function.Function;

public class MétodoDeLaCuadraturaGaussiana5 {

    // Método para calcular la integral usando la cuadratura gaussiana
    public static double cuadraturaGaussiana(Function<Double, Double> funcion, double limiteInferior, double limiteSuperior, int numeroPuntos) {
        double[] nodos = { -0.9324695142, -0.6612093865, -0.2386191861, 0.2386191861, 0.6612093865, 0.9324695142 }; // Nodos predefinidos para seis puntos
        double[] pesos = { 0.1713244924, 0.3607615730, 0.4679139346, 0.4679139346, 0.3607615730, 0.1713244924 }; // Pesos predefinidos para seis puntos

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
        // Ejemplo de uso: integral de 1/(1 + x^2) desde 0 a 1
        Function<Double, Double> funcion = x -> 1 / (1 + x * x);
        double limiteInferior = 0;
        double limiteSuperior = 1;
        int numeroPuntos = 6; // Utilizando seis puntos para la cuadratura gaussiana

        double resultado = cuadraturaGaussiana(funcion, limiteInferior, limiteSuperior, numeroPuntos);
        System.out.println("Resultado de la integral: " + resultado);
    }
}

//ENTRADA
// Ejemplo:  integral de 1/(1 + x^2) desde 0 a 1

//SALIDA (Resultado)
//2.6668000000000003
