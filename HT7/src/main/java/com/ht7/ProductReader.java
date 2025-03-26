package com.ht7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Joel Nerio, Fabián Prado
 * Creación: 24/03/2025
 * última modificación: 25/03/2025
 * File Name: ProductReader.java
 * Descripción: Lee el archivo CSV 
 */

public class ProductReader {
    private Map<String, List<Producto>> productsMap = new HashMap<>();

    public void loadCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Saltar cabecera

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (values.length < 19) continue; /*para validacion  */

                try {
                    String sku = values[6].trim();
                    String priceRetail = values[9].trim();
                    Double priceCurrent = values[10].trim().isEmpty() ? Double.MAX_VALUE : Double.parseDouble(values[10].trim());
                    String productName = values[18].trim();
                    String category = values[0].trim();

                    Producto newProduct = new Producto(sku, priceRetail, priceCurrent, productName, category);

                    productsMap.putIfAbsent(sku, new ArrayList<>());
                    productsMap.get(sku).add(newProduct);

                } catch (NumberFormatException e) {
                    System.out.println("Error en formato de número en línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Producto searchProduct(String sku) {
        if (!productsMap.containsKey(sku)) {
            return null;
        }
        
        // Buscar el producto con el menor Price_Current
        return productsMap.get(sku).stream()
                .min(Comparator.comparingDouble(Producto::getPriceCurrent))
                .orElse(null);
    }
}
