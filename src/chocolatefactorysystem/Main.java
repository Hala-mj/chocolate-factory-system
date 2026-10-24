package chocolatefactorysystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //to store all products in the factory
        BST AllProducts = new BST();
        //We can store 10 orders only
        int ordernum = 0;
        Orders[] allOrders = new Orders[10];

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1- Insert new product");
            System.out.println("2- View all products sorted by price");
            System.out.println("3- Search for products based on price");
            System.out.println("4- Ask for order");
            System.out.println("5- Add quantity to a product");
            System.out.println("6- View all orders");
            System.out.println("7- Exit");
            String ch = input.nextLine();

            //--------------------------------------------
            if (ch.equals("1")) {
                //get details of the product
                System.out.println("Enter product details: ");
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Price: ");
                double price = input.nextDouble();
                input.nextLine();
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
                input.nextLine();
                //create new product
                Product p = new Product(name, price, quantity);
                //insert it in the bst
                AllProducts.insert(p);
                System.out.println("New Product inserted to system");
            }
            //-------------------------------------------- 
            else if (ch.equals("2")) {
                //view all products
                AllProducts.PrintAllProducts();
            }
            //-------------------------------------------- 
            else if (ch.equals("3")) {
                //get the price
                System.out.print("Enter price: ");
                double price = input.nextDouble();
                input.nextLine();
                //search for products with this price
                BSTNode node = AllProducts.Search(price);
                if (node == null) {
                    System.out.println("Sorry, we don't have products with this price.");
                } else {
                    System.out.println(node);
                }

            }
            //-------------------------------------------- 
            else if (ch.equals("4")) {
                //check if we can take more than 10 orders
                if (ordernum >= 10) {
                    System.out.println("Sorry, we can't take more orders now!");
                } else {
                    //get all products from the system
                    ArrayList<Product> products = AllProducts.getAllProducts();
                    //check if system empty or not 
                    if (products.isEmpty()) {
                        System.out.println("No current product!");
                    } else {
                        //init. the order
                        allOrders[ordernum]=new Orders();
                        //ask for the products to add it to order
                        while (true) {
                            System.out.println("please enter number of product to add it or (-1) to exit:");
                            //print the product
                            for (int i = 0; i < products.size(); i++) {
                                System.out.println("\t"+(i + 1) + ". " + products.get(i));
                            }
                            System.out.print("-> ");
                            //get number of it
                            int number = input.nextInt();
                            input.nextLine();
                            //check if done
                            if (number == -1) {
                                ordernum++;
                                break;
                            } 
                            //check if not valid number
                            else if (number < 1 || number >products.size())
                            {
                                System.out.println("Enter valid number please.");
                            }
                            else {
                                //get details of product
                                String name = products.get(number-1).name;
                                double price = products.get(number-1).price;
                                //get quantity
                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();
                                input.nextLine();
                                //decrease it
                                products.get(number - 1).quantity -= quantity;
                                //insert in the order
                                allOrders[ordernum].insert(new BillNode(name, price, quantity));
                            }
                        }
                        System.out.println("The order is done.");
                        System.out.println("Total cost is : " + allOrders[ordernum - 1].CalculateTotal());
                    }
                }
            }
            //-------------------------------------------- 
            else if (ch.equals("5")) {
                //get all products from the system
                ArrayList<Product> products = AllProducts.getAllProducts();
                //check if system empty or not 
                if (products.isEmpty()) {
                    System.out.println("No current products!");
                } else {
                    //print the product
                    System.out.println("please enter number of product :");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println("\t"+(i + 1) + ". " + products.get(i));
                    }
                    //get number of product
                    System.out.print("-> ");
                    int number = input.nextInt();
                    input.nextLine();
                     //check if not valid number
                    if (number < 1 || number > products.size()) {
                        System.out.println("Enter valid number please.");
                        continue;
                    }
                    //get quantity to add it
                    System.out.print("Enter quantity to add: ");
                    int quantity = input.nextInt();
                    input.nextLine();
                    //update it
                    products.get(number - 1).quantity += quantity;
                    System.out.println("Added done!");
                }
            }
            //-------------------------------------------- 
            else if (ch.equals("6")) {
                //check if we have orders
                if (ordernum == 0) {
                    System.out.println("No orders yet!");
                } else {
                    //print each one
                    for (int i = 0; i < ordernum; i++) {
                        System.out.println("Order_" + (i + 1) + " :");
                        System.out.println(allOrders[i]);
                        System.out.println("______________________________________");
                    }
                }
            }
            //-------------------------------------------- 
            else if (ch.equals("7")) {
                System.out.println("--------------- BYE BYE ---------------");
                System.exit(0);
            } 
            //--------------------------------------------
            else {
                System.out.println("Enter valid number between 1 -> 7 please!");
            }
        }

    }

}
