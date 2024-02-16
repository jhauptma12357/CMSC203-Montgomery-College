/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Customer class where the order will be linked to, because uses age and is a parameter.
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class Customer {
    private String name; //private fields
    private int age;

    public Customer(String name, int age){ //constructor
        this.name = name; //assign local fields to arguments
        this.age = age;
    }
    public Customer(Customer c){
        new Customer(c.getName(),c.getAge()); //copy constructor
    }
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){ //print out the fields
        return name + " " + age;
    }
}
