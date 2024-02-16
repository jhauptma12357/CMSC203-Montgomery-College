/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Calculate the bonus of shops when given a 2D ragged array of amounts sold
 * Due: 11/13/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jacob Hauptman
 */
public class HolidayBonus {
    //constants for the bonuses
    private static final double HIGHEST_SALES_BONUS = 5000, LOWEST_SALES_BONUS = 1000, OTHER_SALES_BONUS = 2000;

    public HolidayBonus() {
        //Empty because javadoc asked for it but didn't have description
    }

    public static double[] calculateHolidayBonus(double[][] data) { //accepted the data array
        double[] bonuses = new double[data.length]; //create a new array using the row length of data
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(data); //create a variable of lowest in the array
        double highest = TwoDimRaggedArrayUtility.getHighestInArray(data); //create a variable of highest in the array
        int highestRow = 0, lowestRow = 0; //these will be the index for the lowest and highest
        for (int i = 0; i < data.length; i++) { //loop through all the rows
            for (int u = 0; u < data[i].length; u++) { //loop though all the columns
                if (lowest == data[i][u]) { //if the value of lowest is equal
                    lowestRow = i; //set the index of lowestRow to the row index i
                }
                if (highest == data[i][u]) { //if the value of highest is equal
                    highestRow = i; //set the index of highestRow to the row index i
                }
            }
        }
        for (int i = 0; i < data.length; i++) { //loop through all the rows
            for (int u = 0; u < data[i].length; u++) { //loop through all the columns
                if (i == lowestRow) { //if the current row is the lowest row
                    bonuses[i] += LOWEST_SALES_BONUS ; //use the lowest bonus
                } else if (i == highestRow) { //if the current row is the highest row
                    bonuses[i] += HIGHEST_SALES_BONUS; //use the highest bonus
                } else {
                    bonuses[i] += OTHER_SALES_BONUS; //use the "other bonus"
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0; //initialize variables
        double[] bonus = HolidayBonus.calculateHolidayBonus(data); //a new array of all the bonuses

        for (double b : bonus) { //loop through all the bonuses
            total += b; //add to the total
        }
        return total;
    }
}
