package com.aluracursos.conversor.interfaz;

import java.util.*;

public class ListaMonedas {
    private static final Map<String, String> monedas = new LinkedHashMap<>();

    static {
        monedas.put("USD", "Dólar estadounidense");
        monedas.put("EUR", "Euro");
        monedas.put("GBP", "Libra esterlina");
        monedas.put("JPY", "Yen japonés");
        monedas.put("KRW", "Won surcoreano");
        monedas.put("ARS", "Peso argentino");
        monedas.put("BRL", "Real brasileño");
        monedas.put("CLP", "Peso chileno");
        monedas.put("MXN", "Peso mexicano");
    }

    public static String seleccionarMoneda(Scanner scanner, String tipo) {
        System.out.println("\nSeleccione la moneda de " + tipo + ":");

        int index = 1;
        List<String> claves = new ArrayList<>(monedas.keySet());
        for (String clave : claves) {
            System.out.printf("%d. %s (%s)%n", index++, monedas.get(clave), clave);
        }

        while (true) {
            System.out.print("Ingrese el número correspondiente: ");
            String entrada = scanner.nextLine().trim();

            try {
                int seleccion = Integer.parseInt(entrada);
                if (seleccion >= 1 && seleccion <= claves.size()) {
                    return claves.get(seleccion - 1);
                } else {
                    System.out.println("❌ Número fuera de rango. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Ingrese un número.");
            }
        }
    }
}