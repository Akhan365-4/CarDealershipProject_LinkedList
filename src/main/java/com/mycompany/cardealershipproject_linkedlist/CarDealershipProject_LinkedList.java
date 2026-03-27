package com.mycompany.cardealershipproject_linkedlist;
/**
 * Abdallah Khan
 * CS 3345 Project 1
 * @author ak336
 */
import java.util.*;

public class CarDealershipProject_LinkedList  
{
    public static void main(String[] args) 
    {
        //******************************************NOTES**************************************************
        //linked list creation: GenericClass<OtherClass> variableName = new GenericClass<>();
        //linked list (gnrclnkdlst<prdct>) is designed so that each node inside it can store a Product object.
        GenericLinkedList<Product> list = new GenericLinkedList<>(); //linked list ('list' is the whole list, 
                                                                     //not a singular node; those are in the 
                                                                     //private class Node) whose nodes store 
                                                                     //(references to/points to (=)) objects 
                                                                     //made from type/class Product********
        Scanner keyboard = new Scanner(System.in); //user input

        //while (true) loop: Infinite loop to repeatedly show menu until user chooses to exit (option 7(return).
        while (true) 
        {
            System.out.println("\nOperations on List");
            System.out.println("1. Make Empty");
            System.out.println("2. Find ID");
            System.out.println("3. Insert At Front");
            System.out.println("4. Delete From Front");
            System.out.println("5. Delete ID");
            System.out.println("6. Print All Records");
            System.out.println("7. Done");
            System.out.print("Your Choice: ");

            int choice = keyboard.nextInt(); //user enters choice
            keyboard.nextLine(); //NOTE: Consumes the leftover Enter key (\n) that is added when you type 
                                 //in number and press Enter, so the next nextLine() reads actual 
                                 //user input instead of the newline.

            switch (choice) //switch cases based on user input 
            {
                case 1: // Make empty
                    list.makeEmpty(); //list (an object) calls (uses "." to call) make empty method to empty itself
                    System.out.println("List emptied.");
                    break;

                case 2: // Find ID
                    System.out.print("Enter Product ID: ");
                    int enteredID = keyboard.nextInt();//user ID input
                    keyboard.nextLine(); //consume leftover newline
                    Product found = list.findID(enteredID); //searches the linked list 'list' using 
                                                            //findID() method with the entered ID, 
                                                            //if found, saves that Product object into 
                                                            //the variable 'found'. (Product is a class)
                    if (found != null) //If ID found and is not end of list
                    {
                        found.printID(); //print it using printID() method
                    }
                    else 
                    {
                        System.out.println("Product with ID " + enteredID + " not found.");
                    }
                    break;

                case 3: // Insert at front
                    System.out.print("Enter Product ID: ");
                    int insertID = keyboard.nextInt();
                    keyboard.nextLine();
                    
                    System.out.print("Enter Product Name: ");
                    String pName = keyboard.nextLine();//NOTE: .next() is for singular word, .nextLine() is for whole line & reads Enter (\n)
                    
                    System.out.print("Enter Supplier Name: ");
                    String supplier = keyboard.nextLine();

                    //object ("newProduct") made from class 'Product'
                    //Line makes new Product object with given ID, name, and supplier, & store it in the variable newProduct
                    //NOTE: newProduct is a pointer/label to box/object which holds toys/data 
                    Product newProduct = new Product(insertID, pName, supplier);
                    if (list.insertAtFront(newProduct))//linked list method of inserting at front using object parameters /Node newNode = new Node(x); (newProduct = x)
                    {
                        System.out.println("Product Added.");
                    }
                    else 
                    {
                        System.out.println("Product with this ID already exists.");
                    }
                    break;

                case 4: // Delete from front
                    Product deletedFront = list.deleteFromFront(); //reference
                    if (deletedFront != null) 
                    {
                        deletedFront.printID();
                        System.out.println("First item deleted.");
                    }
                    else 
                    {
                        System.out.println("List is empty.");
                    }
                    break;

                case 5: // Delete ID
                    System.out.print("Enter Product ID to delete: ");
                    int deleteID = keyboard.nextInt();
                    keyboard.nextLine();
                    Product deleted = list.delete(deleteID);
                    if (deleted != null) 
                    {
                        deleted.printID();
                        System.out.println("Product deleted.");
                    } 
                    else
                    {
                        System.out.println("Product not found.");
                    }
                    break;

                case 6: // Print all records
                    list.printAllRecords();
                    break;

                case 7: // Done — exit loop cleanly
                    System.out.println("Done.");
                    keyboard.close();
                    return; //NOTE: In Java, return immediately exits the current method (while true loop in this case)

                default:
                    System.out.println("Invalid choice. Try again.");
            } // end switch
        } // end while
    }
}
