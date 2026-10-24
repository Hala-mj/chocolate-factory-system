package chocolatefactorysystem;


public class Product 
{
    
    String name; 
    double price;
    int quantity;

    //constructor with arguments name and price and quantity
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity=quantity;

    }

    public Product(Product p) {
        this.name = p.name;
        this.price = p.price;
        this.quantity = p.quantity;
    }
 
    
    //toString to print the information of this product
    @Override
    public String toString() {
        return "\tProduct: " + "name: " + name + ", price: " + price +", quantity: "+quantity;
    }
    
}
