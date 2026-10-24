package chocolatefactorysystem;


public class BillNode {
    
    private Product p;
    private BillNode next;

    public BillNode(String name,double price, int quantity) {
        this.p=new Product(name, price, quantity);
        next = null;
    }
    
    public Product getProduct()
    {
        return p;
    }
    
    public BillNode getNext() {
        return next;
    }

    public void setNext(BillNode next) {
        this.next = next;
    }
      
    
}
