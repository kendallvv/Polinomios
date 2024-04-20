/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.polinomios;

import java.util.Scanner;

/**
 * Esta clase representa un término en un polinomio.
 */
class Term {
    double coefficient; // El coeficiente del término
    int exponent;       // El exponente del término
    Term next;          // El siguiente término en la lista enlazada

    /**
     * Constructor de la clase Term.
     * @param coefficient El coeficiente del término.
     * @param exponent El exponente del término.
     */
    public Term(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

/**
 * Esta clase representa un polinomio como una lista enlazada de términos.
 */
class Polynomial {
    Term head; // El primer término del polinomio

    /**
     * Constructor de la clase Polynomial.
     */
    public Polynomial() {
        this.head = null;
    }

    /**
     * Agrega un término al polinomio.
     * @param coefficient El coeficiente del término.
     * @param exponent El exponente del término.
     */
    public void addTerm(double coefficient, int exponent) {
        Term newTerm = new Term(coefficient, exponent);
        if (head == null) {
            head = newTerm;
        } else {
            Term current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTerm;
        }
    }

    /**
     * Evalúa el polinomio en un valor dado de x.
     * @param x El valor de x en el cual se evalúa el polinomio.
     * @return El resultado de evaluar el polinomio en x.
     */
    public double evaluate(double x) {
        double result = 0.0;
        Term current = head;
        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent);
            current = current.next;
        }
        return result;
    }
}

/**
 * Esta clase contiene el método main y se utiliza para interactuar con el usuario.
 */
public class Polinomios {
    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial();
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario que ingrese los términos del polinomio
        System.out.println("Ingrese los términos del polinomio (coeficiente y exponente) separados por espacio. Ingrese '0 0' para terminar.");

        // Lee los términos del polinomio ingresados por el usuario
        while (true) {
            System.out.print("Ingrese el coeficiente y el exponente (por ejemplo, '1.0 2'): ");
            double coefficient = scanner.nextDouble();
            int exponent = scanner.nextInt();

            if (coefficient == 0 && exponent == 0) {
                break; // Si el usuario ingresa 0 0, se termina el ingreso de términos
            }

            polynomial.addTerm(coefficient, exponent);
        }

        // Imprime la tabla de valores del polinomio
        System.out.println("Tabla de valores del polinomio:");
        System.out.println("x\tPolinomio(x)");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double result = polynomial.evaluate(x);
            System.out.println(x + "\t" + result);
        }
        
        scanner.close(); // Cierra el scanner para liberar recursos
    }
}

