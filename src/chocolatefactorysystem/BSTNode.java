package chocolatefactorysystem;

import java.util.ArrayList;


public class BSTNode 
{
    
    ArrayList<Product> products;
    double price;
    BSTNode left, right;
    
    public BSTNode(Product data, double price) {
        this.products = new ArrayList<>();
        this.products.add(data);
        this.price = price;
        left = right = null;
    }
    
    //get products
    public ArrayList<Product> getData() {
        return this.products;
    }


    //insert new product
    public void insertProduct(Product data) {
        this.products.add(data);
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Product p : products) {
            str += p + "\n";
        }
        return str;
    }
    
}
