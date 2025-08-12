package com.aluracursos.conversor.app;

import com.aluracursos.conversor.interfaz.Menu;
import com.aluracursos.conversor.servicios.ConversorMonedas;
import com.aluracursos.conversor.servicios.HistorialConversiones;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        Menu.mostrarBienvenida();

        while (continuar) {
            System.out.println("\n🌐 Conversor de Monedas");
            System.out.println("1. Realizar una conversión");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    ConversorMonedas.realizarConversion();
                    break;
                case "2":
                    HistorialConversiones.mostrarHistorial();
                    break;
                case "3":
                    continuar = false;
                    System.out.println("👋 ¡Gracias por usar el conversor!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}