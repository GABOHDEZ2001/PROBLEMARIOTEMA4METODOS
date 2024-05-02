package MétodoDeLaCuadraturaGaussiana;

import java.util.function.Function;

public class MétodoDeLaCuadraturaGaussiana3 {

    // Método para calcular la integral usando la cuadratura gaussiana
    public static double cuadraturaGaussiana(Function<Double, Double> funcion, double limiteInferior, double limiteSuperior, int numeroPuntos) {
        double[] nodos = { -0.8611363116, -0.3399810436, 0.3399810436, 0.8611363116 }; // Nodos predefinidos para cuatro puntos
        double[] pesos = { 0.3478548451, 0.6521451549, 0.6521451549, 0.3478548451 }; // Pesos predefinidos para cuatro puntos

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
        // Ejemplo de uso: integral de cos(x) desde 0 a pi/2
        Function<Double, Double> funcion = Math::cos;
        double limiteInferior = 0;
        double limiteSuperior = Math.PI / 2;
        int numeroPuntos = 4; // Utilizando cuatro puntos para la cuadratura gaussiana

        double resultado = cuadraturaGaussiana(funcion, limiteInferior, limiteSuperior, numeroPuntos);
        System.out.println("Resultado de la integral: " + resultado);
    }
}


//ENTRADA
// Ejemplo: integral de cos(x) desde 0 a pi/2

//SALIDA (Resultado)
//0.9999999772013956
