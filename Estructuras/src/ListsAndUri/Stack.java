package ListsAndUri;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Stack {

    Node top;
    
    public boolean isEmpty() 
    {
        return top == null ? true : false;
    }
    
    public void pop() 
    {
        Node temp = top;
        top = top.next;
        temp = null;
        System.gc();
    }

    public void printStack() throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = top;

        try {
            while (!isEmpty()) 
            {
                bw.write(peek());
                temp = temp.next;

            }
            bw.flush();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
    
    
    
    public String peek() 
    {
        Node temp = top;
        top = top.next;
        String info = temp.ToString();
        return info;
    }

    
    public void push(Node newNode) {
        newNode.next = top;
        top = newNode;
    }

    
    
}

