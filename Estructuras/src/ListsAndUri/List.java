package ListsAndUri;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Estudiante
 */
public class List 
{

    Node head = null;

    public boolean isEmpty() 
    {
        return head == null ? true : false;
    }

    public void printList() throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;

        try {
            while (temp != null) 
            {
                bw.write(temp.ToString());
                temp = temp.next;

            }
            bw.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(Node newNode) {
        if (isEmpty()) 
        {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }
    }

    public void insertAtIndex(Node newNode, int index) 
    {
        Node prev;
        prev = this.get(index);
        newNode.next = prev.next;
        prev.next = newNode; 
        
    }

    public void deleteAtPosition(int index) 
    {
        Node prev = head;
        for (int i = 0; i < index  - 1; i++) 
        {
            prev = prev.next;
        }
        Node temp = prev.next;
        Node aft = temp.next;
        prev.next = aft;
        temp = null;
        System.gc();

    }

    public void deleteAtBegin() 
    {
        Node temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }

    public void deleteAtEnd() 
    {
        Node temp = head;

        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        System.gc();
    }
    
    public Node searchByPosition(int position)
    {
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        return temp.next;
    }
    
    public List quickSort(List unsorted, int left, int right)
	{
            int pivote=unsorted.get(left).value; 
            int izq_der=left; 
            int der_izq=right; 
            int aux;
 
            while(izq_der < der_izq)
            {            
                while(unsorted.get(izq_der).value <= pivote && izq_der < der_izq) 
                    izq_der++; 
                while(unsorted.get(der_izq).value > pivote) 
                    der_izq--;         
                if (izq_der < der_izq) 
                {                                            
                    aux = unsorted.get(izq_der).value;                  
                    unsorted.get(izq_der).value = unsorted.get(der_izq).value;
                    unsorted.get(der_izq).value = aux;
                }
            }
            unsorted.get(left).value = unsorted.get(der_izq).value; 
            unsorted.get(der_izq).value = pivote; 
            
            if(left<der_izq-1)
                quickSort(unsorted,left,der_izq-1); 
            if(der_izq+1 <right)
                quickSort(unsorted,der_izq+1,right); 
            
            return unsorted;
        }
    
    
    public int length() {
        if (isEmpty()) {
            return 0;
        } else {
            Node temp = this.head;
            int counter = 1;
            while (temp.next != null) {
                temp = temp.next;
                counter++;
            }
            return counter;
        }
    }
    
    public void reverse()
    {
        Stack tempStack = new Stack();
        Node temp = head;
        while(temp!= null)
        {
            tempStack.push(temp.clone());
            temp=temp.next;
        }
        head=tempStack.top;
    }
    
    
    public List sublist(int begin)
	{
		List subList = new List();
		
		if(begin < this.length())
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.getNext();
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.getNext();
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public List sublist(int begin, int end)
	{
            List subList = new List();
		
            if(begin < this.length())
            {
		Node temp = head;
			
		for(int i = 0; i < begin; i++)
			temp = temp.getNext();
			
		while(temp != this.get(end+1))
		{
                    subList.insertAtEnd(temp.clone());
                    temp = temp.getNext();
		}
            }
		
            return subList;
	}
        
        public List cloneList()
	{
            List cloneList = this;
            
                
            return cloneList;
	}
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public boolean isEqual(List list)
	{
		boolean isEqual = true;
		Node tempCurrent = head;
		Node tempList = list.head;
		
		while(tempCurrent != null && tempList != null)
			if(tempCurrent.isEqual(tempList))
			{
				tempCurrent = tempCurrent.getNext();
				tempList = tempList.getNext();
			}
			else
			{
				isEqual = false;
				break;
			}
			
		return isEqual;
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Node get(int index)
	{
		Node temp = this.head;
                for (int i = 1; i <= index; i++) 
                temp = temp.next;
                
                return temp;
	}
        
        /**
	 * 
	 * @param node
	 * @return
	 */
	public int indexOf(Node node)
	{
		int index = -1;
		Node temp = head;
		
		while(temp != null)
		{
			index += 1;
			if(temp.isEqual(node))
				return index;
			
			temp = temp.getNext();
		}
		 
		return index;
	}
    
    public static void main(String[] args) throws IOException 
    {

        List grades = new List();

        grades.insertAtEnd(new Node(1));
        grades.insertAtEnd(new Node(2));
        grades.insertAtEnd(new Node(6));
        grades.insertAtEnd(new Node(5));
        
        grades.printList();
        //grades.deleteAtPosition(1);
        //grades.deleteAtEnd();


    }

}
