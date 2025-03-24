public class Producto implements Comparable<Producto> {  /*clase para establecer los datos necesarios segun la HT que son los siguientes  */
    String SKU;
    double Price_Retail;  /*Datos */
    double Price_Current;
    String Product_Name;
    String Category;

    public Producto(String SKU, double Price_Retail, double Price_Current, String Product_Name, String Category) { /*Constructor */
        this.SKU = SKU;
        this.Price_Retail = Price_Retail;
        this.Price_Current = Price_Current;
        this.Product_Name = Product_Name;
        this.Category = Category;
    }

    public String getSku() {
        return SKU;
    }

    public double getPriceRetail() {
        return Price_Retail;
    }

    public double getPriceCurrent() {
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
}
