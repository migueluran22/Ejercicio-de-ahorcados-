package Entities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Ahorcado {
    public static final int MAX_INTENTOS = 8;
    private static List<String> palabras = new ArrayList<>();
    public static String palabraSecreta;
    private static char[] progresoPalabra;
    public static int intentosRestantes;


    public static void cargarPalabras() {
        palabras.add("java");
        palabras.add("programacion");
        palabras.add("computadora");
        palabras.add("codigo");
        palabras.add("algoritmo");
        palabras.add("software");
        palabras.add("lenguaje");
        palabras.add("tecnologia");
        palabras.add("sena");
        palabras.add("concatenar");
        palabras.add("navegador");
        palabras.add("desarrollo");
    }

    public static void seleccionarPalabraSecreta() {
        Random random = new Random();
        int indice = random.nextInt(palabras.size());
        palabraSecreta = palabras.get(indice);
    }

    public static void inicializarProgresoPalabra() {
        progresoPalabra = new char[palabraSecreta.length()];
        for (int i = 0; i < progresoPalabra.length; i++) {
            progresoPalabra[i] = '_';
        }
    }

    public static void mostrarProgresoPalabra() {
        for (char c : progresoPalabra) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean intentarAdivinar(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progresoPalabra[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    public static boolean hasGanado() {
        for (char c : progresoPalabra) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
