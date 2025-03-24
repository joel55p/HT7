public class Product {  /*clase para establecer los datos necesarios segun la HT que son los siguientes  */
    String SKU;
    double Price_Retail;  /*Datos */
    double Price_Current;
    String Product_Name;
    String Category;

    public Product(String SKU, double Price_Retail, double Price_Current, String Product_Name, String Category) { /*Constructor */
        this.SKU = SKU;
        this.Price_Retail = Price_Retail;
        this.Price_Current = Price_Current;
        this.Product_Name = Product_Name;
        this.Category = Category;
    }

    @Override /*importante ya que asi se mostrara al user */
    public String toString() {
        return "SKU: " + SKU + ", Price Retail: " + Price_Retail + ", Price Current: " + Price_Current + ", Product Name: " + Product_Name + ", Category: " + Category;
    }
}
