/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: A beverage that is alcohol, with methods pertaining to the drink
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/

public class Alcohol extends Beverage{
    private boolean isWeekend; //private field
    private static final double WEEKEND_COST = .6; //private constant value for additional cost on the weekend
    public Alcohol(String bevName, Size size, boolean isWeekend){ //constructor
        super(bevName, Type.ALCOHOL, size); //call parent constructor
        this.isWeekend = isWeekend; //assign field to argument
    }

    @Override
    public double calcPrice() {
        if(isWeekend) { //if it is weekend include the extra cost
            return super.addSizePrice() + WEEKEND_COST;
        } //else its normal price
        return super.addSizePrice();

    }

   public boolean equals(Beverage anotherBev){ //check if its equal based off of properties
        return getBevName().equals(anotherBev.getBevName()) && Type.ALCOHOL == anotherBev.getType() && getSize() == anotherBev.getSize();
   }
    public String toString(){ //return string of fields and price
        return super.getBevName() + "," + super.getSize() + "," + isWeekend + "," + calcPrice();
    }
    public boolean isWeekend(){
        return isWeekend;
    }

}
