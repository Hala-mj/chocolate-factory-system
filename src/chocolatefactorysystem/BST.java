package chocolatefactorysystem;

import java.util.ArrayList;


public class BST {
    BSTNode root;

    public BST() {
        root = null;
    }

    //methods to insert new product in the bst (based on its price)
    public void insert(Product P) {
        root = insert(root, P);
    }

    private BSTNode insert(BSTNode root, Product P) {
        //if we insert new node
        if (root == null) {
            return new BSTNode(P , P.price);
        } else {
            if (root.price == P.price)//if new node price equals with current node price then insert the product in this node
            {
                root.insertProduct(P);
            } else if (root.price > P.price)//if new node price smaller than the current node
            {
                root.left = (insert(root.left, P));
            } else//if new node price higher than the current node
            {
                root.right = (insert(root.right, P));
            }
            return root;
        }
    }


    public BSTNode Search(double price)
    {
        return Search(root, price);
    }
    
    private BSTNode Search(BSTNode root , double price)
    {
        if(root == null)//if not found return null
            return null;
        if(root.price == price)//if found return the node
            return root;
        if(root.price > price)//if price smaller than the current node search in left side
            return Search(root.left, price);
        return Search(root.right, price);//price bigger than the current node search in right side
    }
    
    public ArrayList<Product> getAllProducts()
    {
        ArrayList<Product> list = new ArrayList<>();//to store all products
        getAllProducts(root , list);//get them
        return list;//return  the list
    }
    
    private void getAllProducts(BSTNode root, ArrayList<Product> list) {
        if (root != null) {
            //left - root - right
            getAllProducts(root.left, list);
            list.addAll(root.products);//add all product of this node
            getAllProducts(root.right, list);
        }
    }
    
    // Methods to print the products 
    public void PrintAllProducts() {
        if (root != null) {
            System.out.println("Products is as follow:");
            //we used InOrder to print the products from less to high
            Print(root);
        } else {
            System.out.println("No products yet..!");
        }
    }

    private void Print(BSTNode root) {
        if (root != null) {
            //left - root - right
            Print(root.left);
            System.out.print(root.toString());
            Print(root.right);
        }
    }
}
