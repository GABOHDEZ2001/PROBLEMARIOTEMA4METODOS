package MétodoDeLaCuadraturaGaussiana;

import java.util.function.Function;

public class MétodoDeLaCuadraturaGaussiana4 {

    // Método para calcular la integral usando la cuadratura gaussiana
    public static double cuadraturaGaussiana(Function<Double, Double> funcion, double limiteInferior, double limiteSuperior, int numeroPuntos) {
        double[] nodos = { -0.9061798459, -0.5384693101, 0, 0.5384693101, 0.9061798459 }; // Nodos predefinidos para cinco puntos
        double[] pesos = { 0.2369268851, 0.4786286705, 0.5688888889, 0.4786286705, 0.2369268851 }; // Pesos predefinidos para cinco puntos

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
        // Ejemplo de uso: integral de ln(x+1) desde 0 a 2
        Function<Double, Double> funcion = x -> Math.log(x + 1);
        double limiteInferior = 0;
        double limiteSuperior = 2;
        int numeroPuntos = 5; // Utilizando cinco puntos para la cuadratura gaussiana

        double resultado = cuadraturaGaussiana(funcion, limiteInferior, limiteSuperior, numeroPuntos);
        System.out.println("Resultado de la integral: " + resultado);
    }
}

//ENTRADA
// Ejemplo: integral de ln(x+1) desde 0 a 2

//SALIDA (Resultado)
//1.2958374013063405

