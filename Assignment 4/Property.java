/*
 * Class: CMSC203-21575
 * Instructor: Grigoriy Grinberg
 * Description: Constructors, getters, setters, and a toString method that returns a string of the information
 * Due: 10/23/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class Property {
    private String propertyName, city, owner; //Declare string variables
    private double rentAmount; //Declare rentAmount variable
    private Plot plot; //Declare a plot variable

    //constructor with no parameters
    public Property() {
        propertyName = city = owner = "";
        plot = new Plot();
    }

    //constructor with parameters of propertyName, city, rentAmount, owner
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot();
    }

    //constructor with parameters of propertyName, city, rentAmount, owner, x, y, width, depth
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot(x, y, width, depth);
    }

    //constructor with no parameters
    public Property(Property otherProperty) {
        propertyName = otherProperty.getPropertyName();
        city = otherProperty.getCity();
        owner = otherProperty.getOwner();
        rentAmount = otherProperty.getRentAmount();
        plot = otherProperty.getPlot();
    }

    public Plot getPlot() {
        return plot;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public String toString() {
        return (propertyName + "," + city + "," + owner + "," + rentAmount); //Print out variables to a string
    }
}
