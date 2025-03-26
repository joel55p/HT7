package com.ht7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

class ProductReader {
    private BinarySearchTree<Producto> bst = new BinarySearchTree<>();

    public void loadCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(filename)))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                try {
                    String sku = (values[6]);
                    String priceRetail = (values[9]);
                    
                    // Checkeo si la linea esta formatteada de la manera correcta (especificamente el price)
                    Double priceCurrent = 0.0; 
                    if (values.length > 10 && values[10] != null && !values[10].trim().isEmpty()) {
                        priceCurrent = Double.parseDouble(values[10].trim());
                    }

                    String productName = (values[18]);
                    String category = (values[0]);

                    bst.insert(new Producto(sku, priceRetail, priceCurrent, productName, category));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Producto searchProduct(String sku) {
        return bst.search(new Producto(sku, "0", 0.0, "", ""));
    }
}