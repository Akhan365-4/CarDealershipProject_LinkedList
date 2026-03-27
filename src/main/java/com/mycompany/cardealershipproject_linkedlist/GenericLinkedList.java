package com.mycompany.cardealershipproject_linkedlist;

//NOTES:
//GenericLinkedList is the class

/*Anytype is a placeholder for any class of this program who's 
  objects will ONLY use the methods from IDedObject*/
//(i.e. product, or customer, order, etc using only getID() or printID())
//
//extends IdedObject is basically the constraint of what methods 
//an object of any class (hence, anytype) in this package can use
public class GenericLinkedList <AnyType extends IDedObject> // using <> allows us to define a class or method that works with different classes, without specifying the exact class upfront. 
{
    //inner class: blueprint of each node/element in GenericLinkedList, GenericLinkedList controls the nodes (data) and pointers with its methods 
    private class Node 
    {
        AnyType data; //node to store data
        Node next; //pointer storage
        //Node prev; //would make it a doubly linked list as it would let user access previous nodes

        Node(AnyType data)//using AnyType in this constructor ensures Node only stores("Stores” = it points to / represents / references) objects of the same class that the GenericLinkedList is using 
        {
            this.data = data;
            this.next = null;
        }        
    }
    
    
    // Head pointer (points to the first node in the list)
    //`head` is outside Node because the linked list (genericLinkedList) manages the list and needs a starting point to access all nodes.
    private Node head;
    
    
    //constructor that generates empty list 
    //NOTE: blueprint for initializing a linked list 'GenericLinkedList', only runs once, at creation of a list
    public GenericLinkedList() //no arguement in () since no data variables initialized above
    {
        head = null; //in constructor, this line means when linked list is created, starts out empty (head is null)
    }
    
    
    //void method which empties the linked list
    //NOTE: a method blueprint that resets/empties any already created linked list GenericLinkedList 
    public void makeEmpty()
    {
        head = null; //in method, this line clears any already created list without creating a new linked list object
    }
    
      
    //Find an object by ID using generic type (AnyType) (return the object, return null if not found)
    //***NOTE: in main, when this method is called, you manually give it/type the ID you want to search for
    public AnyType findID(int ID) //ID we're searching for
    {
        Node current = head; //NOTE: current is a placeholder/cursor to point to head so that head always stays pointing at first node
        
        //NOTE: loop while current points to a node, once current becomes null, reached end of the list
        while (current != null)
        {
            if (current.data.getID() == ID) //NOTES: current.data accesses the object stored in the current node
                                            //.getID() calls that object’s getID() method and returns its ID (an int)
            {
                return current.data; //If IDs match, returns the object stored in that node (w/ out removing it)                
            }
            current = current.next; //Moves the cursor to the next node in the list.
        }
        return null; //If loop finishes without a match, returns null to indicate “not found”***/
    }
    
    
    //insert at front of list or return false if that ID already exists 
    public boolean insertAtFront(AnyType x)
    {
        //If there is already an object in the list with the same ID as x
        if (findID(x.getID()) != null) //***NOTES: x is a placeholder of an object of a class who's placeholder 
                                       //is AnyTime, (remember, Anytime is the placeholder for a class type)
                                       //getID() gives its ID (an int).
                                       //uses findID method above: if found, return object, if not, return null
                                       //****//
        {
            return false; //ID exists
        }
        //***NOTES: inserting a new object at the front of a linked list:
        //IMPORTANT: head always points to the first node in the list even when inserting a new node 
        //at the front, other nodes just shift down***//
        //steps:
        //A) creates a new Node object, x is the object we want to store
        Node newNode = new Node(x); 
        //B) Links new node to the current head of the list, points the node to the old head
        newNode.next = head;
        //C) moves head to point to the new node: 
        head = newNode;
        //D) 'true' indicates that insertion was successful (no duplicate ID was found)
        return true;
    }    
    
    
    //delete and return the record at the front of the list or return null if the list is empty 
    public AnyType deleteFromFront()
    {
        if (head == null)
        {
            return null; //empty list, nothing to delete
        }
        
        AnyType removedHeadData = head.data; //sets itself (rmvfrnt) to object (data) in first/head node (hence head.data)
        head = head.next; //set head to next node, deletes old head
        return removedHeadData; //return itself (object in head node)-->removeFront is the object stored inside the node
    }
    
    
    //find and delete the record with the given ID or returns null if it isn’t found
    //NOTE: This method is like deleteFromFront(), but it can remove nodes anywhere in the list rather than just front 
    public AnyType delete(int ID)
    {
        //empty list
        if (head == null)
        {
            return null;            
        }
        
        //ID is in the first node (object, or in this case, data)/ deleting head
        if (head.data.getID() == ID)
        {
            AnyType removeFrontData = head.data; 
            head = head.next; 
            return removeFrontData;           
        }
        
        //Completing the delete(int ID) method for nodes after the head
        Node current = head; //start at head
        
        //traversing list
        while (current.next != null)
        {                                       //*******************NOTES:************************
            if (current.next.data.getID() == ID)//current.next is the next node(s) after head && 
                                                //if (any) object in node after head is ID
            {
                AnyType removeNodeData = current.next.data; //set removeNode to the current Node
                
                current.next = current.next.next;//set the current node (found after head) to the node
                                                 //after it (to delete the current node)
                                                 
                return removeNodeData; //return removedData returns the object, even after the node which
                                       //contains it is removed because the value in the node (the object) 
                                       //was already set to removeNodeData in the first statement
            }
            current = current.next; //if ID is not found in current node move to the next node 
                                    //(while loop skips if statement)
                                    //**************************************************************
        }
        return null;       
    }
    
    
    // print all elements in the order they appear in the linked list. 
    //if list is empty print appropriate message. 
    public void printAllRecords()
    {
        //if list is empty
        if(head == null)
        {
            System.out.println("The list is empty");
            return; //NOTE: only say 'return' since 'return;' ends the function in void
        }
        
        Node current = head; //first node of list
        while(current != null) //loop til end of list
        {
            //call (the object's) printID function
            current.data.printID(); //access the object inside the current node (data) + call its printID() method 
            current = current.next; //move to next node
        }        
    }    
}
