package com.ht7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.ht7.ProductReader;
import com.ht7.Producto;

public class HT7Test {
    private ProductReader productReader;

    @Before
    public void setUp() {
        productReader = new ProductReader();
        productReader.loadCSV("info.csv");
    }

    @Test
    public void testSearchSpecificSKU() {
        // Buscar un SKU especficio y encontrar el producto con su menor valor
        Producto foundProduct = productReader.searchProduct("5013299783");
        
        assertEquals("5013299783", foundProduct.getSku(), "5013299783");
        assertEquals("602.99", foundProduct.getPriceRetail(), "602.99");
        assertEquals("Air Conditioners & Fans", foundProduct.getCategory(), "Air Conditioners & Fans");
        assertEquals("8000-BTU DOE (12000-BTU ASHRAE) 115-Volt White Vented Portable Air Conditioner", foundProduct.getProductName(), "8000-BTU DOE (12000-BTU ASHRAE) 115-Volt White Vented Portable Air Conditioner");
    }

    @Test
    public void testInsertAndSearchNewProduct() {
        // Crear un producto para insertar en el BST
        Producto newProduct = new Producto(
            "123", 
            "999.00", 
            999.00, 
            "Test Refrigerator", 
            "Refrigerators"
        );
        
        BinarySearchTree<Producto> bst = new BinarySearchTree<>();
        bst.insert(newProduct);
        
        // Buscar el producto usando search
        Producto foundProduct = bst.search(newProduct);
        
        assertNotNull("Product should be found", foundProduct);
        assertEquals("123", foundProduct.getSku());
        assertEquals("999.00", foundProduct.getPriceRetail());
        assertEquals("Test Refrigerator", foundProduct.getProductName());
        assertEquals("Refrigerators", foundProduct.getCategory());
    }

}
