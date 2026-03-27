package com.mycompany.cardealershipproject_linkedlist;

//NOTE: Class → cookie cutter (blueprint for object (the cookie))
public class Product implements IDedObject //NOTE: must use "implements interfaceName" to use @Override when overriding the interface
{
    int productID;
    String productName;
    String supplierName;
    
    //contructor
    //NOTE: constructors use the class to make a new "cookie", like the cookie tray (What you customize the object on)
    public Product(int ID, String pName, String sName)
    {
        productID = ID;
        productName = pName;
        supplierName = sName;
    }
    
    //NOTES: 
    //Override = replacing an existing method from a parent class/interface with new code in the method of the current class
    //so:
    //Product class implements the IDedObject interface:
    //Product must override functions in IDedObject interface SINCE 
    //INTERFACES ARE A contract that forces a class to implement certain methods.
    
    
    //printID is declared in interface, so to override to print all the variable values in separate lines: 
    @Override
    //NOTE: anytime there's a varName(); that is a method 
        //(can do wtv with cookie(the object) analogy); defines an action the object can perform
    public void printID() 
    {
        System.out.println(productID);
        System.out.println(productName);
        System.out.println(supplierName);
    }
    
    //getID() is declared in interface, so override to return productID
    @Override
    public int getID()
    {
        return productID;
    }
    
    //NOTE: 
    //To access productName or supplierName outside of Product class, 
    //they need public getter methods for them (since they're private)
    
    
    //to make productName (, a private variable,) accessible outside of Product class->
    public String getProductName() 
    {
        return productName;
    }
    
    //makes supplierName (a private variable) accessible outside of Product class
    public String getSupplierName() 
    {
        return supplierName;
    }

    //NOTES:
    //objects are creations of a class, and they can mainpulate data using the methods given in the class
    //
    //How object call methods:    objectName.methodName(arguments);    
}
