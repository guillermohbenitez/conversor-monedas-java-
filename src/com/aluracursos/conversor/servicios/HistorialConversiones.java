package com.aluracursos.conversor.servicios;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HistorialConversiones {
    private static final String ARCHIVO = "historial.json";

    public static void guardarConversion(String origen, String destino, double cantidad, double resultado) throws IOException {
        JsonArray historial;

        try (FileReader reader = new FileReader(ARCHIVO)) {
            historial = JsonParser.parseReader(reader).getAsJsonArray();
        } catch (Exception e) {
            historial = new JsonArray();
        }

        JsonObject registro = new JsonObject();
        registro.addProperty("moneda_origen", origen);
        registro.addProperty("moneda_destino", destino);
        registro.addProperty("cantidad", cantidad);
        registro.addProperty("resultado", resultado);
        registro.addProperty("timestamp", System.currentTimeMillis());

        historial.add(registro);

        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            writer.write(historial.toString());
        } catch (IOException e) {
            System.out.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }

        System.out.println("📝 Conversión guardada en historial.json");

    }

    public static void mostrarHistorial() {
        try (FileReader reader = new FileReader(ARCHIVO)) {
            JsonArray historial = JsonParser.parseReader(reader).getAsJsonArray();

            if (historial.size() == 0) {
                System.out.println("📂 El historial está vacío.");
                return;
            }

            System.out.println("📜 Historial de conversiones:");
            for (int i = 0; i < historial.size(); i++) {
                JsonObject registro = historial.get(i).getAsJsonObject();
                System.out.printf("%d. %.2f %s → %.2f %s%n",
                        i + 1,
                        registro.get("cantidad").getAsDouble(),
                        registro.get("moneda_origen").getAsString(),
                        registro.get("resultado").getAsDouble(),
                        registro.get("moneda_destino").getAsString()
                );
            }

        } catch (IOException e) {
            System.out.println("❌ No se pudo leer el historial: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ Error inesperado al mostrar el historial: " + e.getMessage());
        }
    }
}