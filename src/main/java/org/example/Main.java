package org.example;

import java.util.Scanner;

import static Entities.Ahorcado.*;

public class Main {
    public static void main(String[] args) {
        cargarPalabras();
        seleccionarPalabraSecreta();
        inicializarProgresoPalabra();
        intentosRestantes = MAX_INTENTOS;

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego del Ahorcado!");
        System.out.println("Adivina la palabra secreta:");
        mostrarProgresoPalabra();

        while (intentosRestantes > 0) {
            System.out.println("\nIntentos restantes: " + intentosRestantes);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().charAt(0);
            if (!intentarAdivinar(letra)) {
                intentosRestantes--;
                System.out.println("Incorrecto. Inténtalo de nuevo.");
            }
            mostrarProgresoPalabra();
            if (hasGanado()) {
                System.out.println("\n¡Felicidades! ¡Has adivinado la palabra!");
                return;
            }
        }

        System.out.println("\n¡Has perdido! La palabra secreta era: " + palabraSecreta);
    }
}