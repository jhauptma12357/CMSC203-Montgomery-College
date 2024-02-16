/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: A beverage that is smoothie, with methods pertaining to the drink
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class Smoothie extends Beverage{
    private int numOfFruits; //private fields
    private boolean addProtein;
    private static final double PROTEIN_COST = 1.5, FRUIT_COST = .5; //private constants

    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){ //constructor
        super(bevName, Type.SMOOTHIE, size); //call parent constructor
        this.numOfFruits = numOfFruits; //assign private fields equal to constructors
        this.addProtein = addProtein;
    }
    public int getNumOfFruits(){ //getter for number of fruits
        return numOfFruits;
    }
    public boolean getAddProtein(){ //getter for add protein
        return addProtein;
    }

    public String toString(){ //string of fields
        return super.getBevName() + "," + super.getSize() + "," + addProtein + "," + numOfFruits + "," + calcPrice();
    }
    @Override
    public double calcPrice() {
        if(addProtein){ //if there is protein include the cost of protein
            return PROTEIN_COST + super.addSizePrice() + (numOfFruits * FRUIT_COST);
        }
        return super.addSizePrice() + (numOfFruits * FRUIT_COST); //if no protein don't include that cost
    }
    public boolean equals(Beverage anotherBev){ //check if fields are equal to each other
        return getBevName().equals(anotherBev.getBevName()) && getSize() == anotherBev.getSize() && Type.SMOOTHIE == anotherBev.getType();
    }
}
