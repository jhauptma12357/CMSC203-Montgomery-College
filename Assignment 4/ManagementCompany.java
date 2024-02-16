/*
 * Class: CMSC203-21575
 * Instructor: Grigoriy Grinberg
 * Description: Constructors, getters, setters, and other method to add property/get information about property.
 * Due: 10/23/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class ManagementCompany {
    static final int MAX_PROPERTY = 5, MGMT_DEPTH = 10, MGMT_WIDTH = 10; //Declare and initialize constants
    private String name, taxID; //Declare strings
    private double mgmFeePer; //Declare mgmFeePer as a double, the docx says name it "mgmFee" but the pdf says to name it "mgmFeePer"
    private Plot plot; //Declare a plot variables
    private Property[] properties = new Property[MAX_PROPERTY]; //Declare and set size of an array of properties (Property)
    private int numberOfProperties = 0; //Declare and int used as a counter for properties. Initialize to 0 for index 0

    //constructor with no parameters
    public ManagementCompany() {
        name = taxID = ""; //Initialize to an empty string
        plot = new Plot(); //Create a new plot
        plot.setDepth(MGMT_DEPTH); //Set it to the max depth
        plot.setWidth(MGMT_WIDTH); //Set it to the max width
    }

    //constructor with parameters of name, taxID, and mgmFee
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name; //Assign class variables to the values of the parameters
        this.taxID = taxID;
        mgmFeePer = mgmFee;
        plot = new Plot(); //Create a new plot
        plot.setDepth(MGMT_DEPTH); //Set it to the max depth
        plot.setWidth(MGMT_WIDTH); //Set it to the max width
    }

    //constructor with parameters of name, taxID, mgmFee, x, y, width, depth
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name; //Assign class variables to the values of the parameters
        this.taxID = taxID;
        mgmFeePer = mgmFee;
        plot = new Plot(x, y, width, depth); //Create a new plot with the x, y, width, and depth values in the parameter
    }

    //constructor with a parameter of a ManagementCompany
    public ManagementCompany(ManagementCompany otherCompany) {
        name = otherCompany.getName(); //Assign class variables to the values of the parameters using the getters
        taxID = otherCompany.getTaxID();
        mgmFeePer = otherCompany.getMgmFeePer();
        plot = otherCompany.getPlot();
    }

    //Add a property to the properties array
    public int addProperty(Property property) {
        if (property == null) {
            return -2; //Return -2 if the parameter is null
        }
        if (numberOfProperties == MAX_PROPERTY) {
            return -1; //If the array is at the max, return -1
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; //If not encompassed, return -3
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; //If properties overlap any of each other, return -4
            }
        }
        properties[numberOfProperties] = property; //Add the property to the index
        return numberOfProperties++; //Return the index then increase by 1
    }


    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner)); //Calls addProperty(Property property) after creating a new Property
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth)); //Calls addProperty(Property property) after creating a new Property
    }

    public void removeLastProperty() {
        properties[--numberOfProperties] = null; //Decrease count then set that element to null
    }

    public boolean isPropertiesFull() {
        return properties[properties.length - 1] != null; //If the last element is not null it is full
    }

    public int getPropertiesCount() {
        return numberOfProperties; //Return the index, but not minus 1 because we are excluding 0. (ex. 1 property would be count of 0 if -1)
    }

    public double getTotalRent() {
        double total = 0; //Declare and initialize a variable to hold total
        for (int i = 0; i < numberOfProperties; i++) { //Loop through all filled elements
            total += properties[i].getRentAmount(); //Add to total
        }
        return total; //Return the total
    }

    public Property getHighestRentPropperty() { //Misspelled Property because misspelled in the other classes provided
        Property highest = null; //Declare a property and just initialize to null
        double temp = -1; //Declare and initialize temp to whatever number <= 0. I just did -1
        for (int i = 0; i < numberOfProperties; i++) { //Loop through all filled elements
            if (temp < properties[i].getRentAmount()) { //If temp is lower than the rent amount
                temp = properties[i].getRentAmount(); //Make temp that value
                highest = properties[i]; //Set out local property value to that property
            }
        }
        return highest; //Return the property
    }

    public boolean isManagementFeeValid() {
        return mgmFeePer > 0 && mgmFeePer < 100; //Check if it's within the range
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public Property[] getProperties() {
        return properties;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

    public String toString() {
        String str = "List of the properties for " + name + ", taxID: " + taxID;
        str += "\n______________________________________________________\n";

        for (int i = 0; i < numberOfProperties; i++) { //Loop through all filled elements
            str += properties[i].toString(); //add each property string to str
            str += "\n";
        }
        str += "______________________________________________________\n\n";
        double totalMNGMFee = (getTotalRent() * mgmFeePer) / 100;
        str += " total management Fee: " + totalMNGMFee;
        return str;
    }

}
