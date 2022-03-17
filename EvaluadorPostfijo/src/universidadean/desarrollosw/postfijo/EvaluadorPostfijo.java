/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        List<String> operadores = Arrays.asList("+", "-", "*", "/");
        int cantElementos = expresion.size();
        int largoPila = 0;
        for (int i = 0; i < cantElementos; i++) {
            if (operadores.contains(expresion.get(i))) {
                if (expresion.get(i).equals(operadores.get(0))) {
                    int ultimo = pila.pop();
                    int penultimo = pila.pop();
                    int resultado = penultimo + ultimo;
                    pila.push(resultado);
                } else if (expresion.get(i).equals(operadores.get(1))) {
                    int ultimo = pila.pop();
                    int penultimo = pila.pop();
                    int resultado = penultimo - ultimo;
                    pila.push(resultado);
                } else if (expresion.get(i).equals(operadores.get(2))) {
                    int ultimo = pila.pop();
                    int penultimo = pila.pop();
                    int resultado = penultimo * ultimo;
                    pila.push(resultado);
                } else if (expresion.get(i).equals(operadores.get(3))) {
                    int ultimo = pila.pop();
                    int penultimo = pila.pop();
                    int resultado = penultimo / ultimo;
                    pila.push(resultado);
                }
            }
            else {
                pila.push(Integer.valueOf(expresion.get(i)));
                largoPila++;
            }
        }
        // TODO: Realiza la evaluación de la expresión en formato postfijo
        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }
}
