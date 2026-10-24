package chocolatefactorysystem;


public class Orders {

    double total;
    BillNode head;
    
    public Orders()
    {
        total=0;
        head=null;
    }
    
    public void insert(BillNode node) {
        //first node add at the head
        if (head == null) {
            head = node;
        } 
        //insert at the front
        else {
            node.setNext(head);
            head = node;
        }
    }
    
    public double CalculateTotal()
    {
        //we calculate the total cost of all products in the order
        BillNode temp = head;
        total =0;
        while(temp != null)
        {
            total+=temp.getProduct().price*temp.getProduct().quantity;
            temp=temp.getNext();
        }
        return total;
    }
    
    @Override
    public String toString()
    {
        String str="";
        BillNode temp = head;
        while(temp != null)
        {
            str+=temp.getProduct()+"\n";
            temp=temp.getNext();
        }
        str+="\tTotal cost: "+total;
        return str;
    }
    
}
