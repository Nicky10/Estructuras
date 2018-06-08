package ListsAndUri;

/**
 * 
 * @author Estudiante
 */
public class Node
{
    
    int value;
    
    Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    
    
    public String ToString()
    {
        return " " + this.value ;
    }
    
    public Node clone()
    {
         return  new Node(this.value);
        
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public boolean isEqual(Node node) 
	{
		Node temp = node;
		return this.value == temp.value ? true : false;
	}

	
	public boolean isLessThan(Node node) 
	{
		Node temp = node;
		return this.value < temp.value ? true : false;
	}
    
}
