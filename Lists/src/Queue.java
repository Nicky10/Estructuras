

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Queue {
 
    public boolean isEmpty() 
    {
        return head == null ? true : false;
    }
    
        Node head = null;

    
    public void enqueue(Node newNode) {
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
    
    public Node dequeue() 
    {
        Node temp = head;
        Node temp1 = head;
        head = head.next;
        temp = null;
        System.gc();
        return temp1;
    }
    
}
