package com.aluracursos.conversor.servicios;

import com.aluracursos.conversor.interfaz.ListaMonedas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMonedas {
    public static void realizarConversion() {
        Scanner scanner = new Scanner(System.in);

        try {
            String monedaOrigen = ListaMonedas.seleccionarMoneda(scanner, "origen");
            String monedaDestino = ListaMonedas.seleccionarMoneda(scanner, "destino");

            if (monedaOrigen.equals(monedaDestino)) {
                System.out.println("⚠️ La moneda origen y destino no pueden ser iguales.");
                return;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = Double.parseDouble(scanner.nextLine());

            if (cantidad <= 0) {
                System.out.println("❌ La cantidad debe ser mayor a cero.");
                return;
            }

            double resultado = ServicioTasaCambio.obtenerConversion(monedaOrigen, monedaDestino, cantidad);

            if (resultado == -1) {
                System.out.println("⚠️ No se pudo realizar la conversión.");
                return;
            }

            System.out.printf("✅ %.2f %s equivalen a %.2f %s%n",
                    cantidad, monedaOrigen, resultado, monedaDestino);

            while (true) {
                System.out.print("¿Desea guardar esta conversión? (s/n): ");
                String guardar = scanner.nextLine().trim().toLowerCase();

                if (guardar.equals("s")) {
                    try {
                        HistorialConversiones.guardarConversion(monedaOrigen, monedaDestino, cantidad, resultado);
                        System.out.println("📝 Conversión guardada.");
                    } catch (IOException e) {
                        System.out.println("❌ Error al guardar la conversión: " + e.getMessage());
                    }
                    break;
                } else if (guardar.equals("n")) {
                    System.out.println("ℹ️ Conversión no guardada.");
                    break;
                } else {
                    System.out.println("❌ Entrada inválida. Por favor ingrese 's' o 'n'.");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada inválida. Por favor ingrese números válidos.");
        } catch (InputMismatchException e) {
            System.out.println("❌ Tipo de dato incorrecto. Intente nuevamente.");
        } catch (Exception e) {
            System.out.println("⚠️ Error inesperado: " + e.getMessage());
        }
    }
}