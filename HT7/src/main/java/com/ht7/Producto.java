package com.ht7;
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Joel Nerio, Fabián Prado
 * Creación: 24/03/2025
 * última modificación: 25/03/2025
 * File Name: Producto.java
 * Descripción: Clase base de cada Producto
 */

public class Producto implements Comparable<Producto> {  /*clase para establecer los datos necesarios segun la HT que son los siguientes  */
    String SKU;
    String Price_Retail;  /*Datos */
    Double Price_Current;
    String Product_Name;
    String Category;

    public Producto(String SKU, String Price_Retail, Double Price_Current, String Product_Name, String Category) { /*Constructor */
        this.SKU = SKU;
        this.Price_Retail = Price_Retail;
        this.Price_Current = Price_Current;
        this.Product_Name = Product_Name;
        this.Category = Category;
    }

    public String getSku() {
        return SKU;
    }

    public String getPriceRetail() {
        return Price_Retail;
    }

    public Double getPriceCurrent() {
        return Price_Current;
    }

    public String getProductName() {
        return Product_Name;
    }

    public String getCategory() {
        return Category;
    }

    @Override
    public int compareTo(Producto otro) { /*la importancia de este metodo es porque como tal permite comparar 2 productos por su SKU */
        return this.SKU.compareTo(otro.SKU);
    }

    @Override /*importante ya que asi se mostrara al user */
    public String toString() {
        return "SKU: " + SKU + ", Price Retail: " + Price_Retail + ", Price Current: " + Price_Current + ", Product Name: " + Product_Name + ", Category: " + Category;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto otro = (Producto) obj;
        return this.SKU.equals(otro.SKU);
    }

    @Override
    public int hashCode() {
        return SKU.hashCode();
    }
}
