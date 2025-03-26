package com.ht7;

import java.util.Scanner;


/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Joel Nerio, Fabián Prado
 * Creación: 24/03/2025
 * última modificación: 25/03/2025
 * File Name: Main.java
 * Descripción: Clase Main del proyecto
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        ProductReader reader = new ProductReader();
        reader.loadCSV("HT7\\src\\main\\resources\\info.csv");


        while (!exit) {
            System.out.print("\n1. Buscar un Producto según su SKU\n2. Salir\nIngrese la opción: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Ingrese SKU a buscar: ");
                    String sku = scanner.nextLine();
                    Producto found = reader.searchProduct(sku);

                    if (found != null) {
                        System.out.println("\nProducto con el precio más bajo encontrado:");
                        System.out.println("SKU: " + found.getSku());
                        System.out.println("Price Retail: " + found.getPriceRetail());
                        System.out.println("Price Current (más bajo): " + found.getPriceCurrent());
                        System.out.println("Product Name: " + found.getProductName());
                        System.out.println("Category: " + found.getCategory());
                    } else {
                        System.out.println("Producto no encontrado.\n");
                    }
                    break;

                case "2":
                    exit = true;
                    scanner.close();
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
