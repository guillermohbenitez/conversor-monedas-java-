package com.aluracursos.conversor.servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicioTasaCambio {
    private static final String API_KEY = "88cdac3370d35c56ebe028bd"; // Reemplaza con tu clave real
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double obtenerConversion(String monedaOrigen, String monedaDestino, double cantidad) {
        try {
            String endpoint = BASE_URL + API_KEY + "/latest/" + monedaOrigen;
            URL url = new URL(endpoint);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            JsonObject json = JsonParser.parseReader(new InputStreamReader(conexion.getInputStream())).getAsJsonObject();
            double tasa = json.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();

            return cantidad * tasa;

        } catch (Exception e) {
            System.out.println("❌ Error al consultar la API: " + e.getMessage());
            return -1;
        }
    }
}