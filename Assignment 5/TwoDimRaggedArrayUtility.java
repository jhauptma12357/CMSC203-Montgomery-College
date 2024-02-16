/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Basic methods for a ragged 2D array, mostly getters
 * Due: 11/13/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jacob Hauptman
 */
import java.io.File; //all imports are for the file methods
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    public TwoDimRaggedArrayUtility() {
    //Empty because javadoc asked for it but didn't have description
    }


    public static double getAverage(double[][] data) {
        double total = 0, elements = 0; //initialize variables
        for (double[] datum : data) { //loop through all rows
            for (double v : datum) { //loop through all columns
                elements++; //increment the number of elements
                total += v; //add to total
            }
        }
        return total / elements; //divide the total by number of elements and return
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0; //initialize variables
        for (double[] datum : data) { //loop through each row
            if (col < datum.length) { //check if column is a valid number, prevent IndexOutOfBounds
                total += datum[col]; //add to the total
            }
        }
        return total;
    }

    public static double getHighestInArray(double[][] data) {
        double temp = 0; //initialize variables
        for (double[] datum : data) { //loop through all rows
            for (double v : datum) { //loop through all columns
                if (temp < v) { //if temp is smaller than the current element
                    temp = v; //set equal
                }
            }
        }
        return temp;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double temp = Double.MIN_VALUE; // Initialize to the smallest possible value
        for (double[] datum : data) { //loop through all rows
            if (col >= 0 && col < datum.length) { //check if valid column index
                if (temp < datum[col]) { //if temp is less than
                    temp = datum[col]; //set equal to each other
                }
            }
        }
        return temp;
    }


    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1; //initialized to -1 in case index not found
        double max = Double.NEGATIVE_INFINITY; // Start with a very small value

        for (int i = 0; i < data.length; i++) { //loop through all rows
            if (col < data[i].length && data[i][col] > max) { //check if valid columns index
                max = data[i][col]; //set max equal to element
                index = i; //set index equal to index
            }
        }
        return index;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double temp = 0; //initialize variables
        for (int i = 0; i < data[row].length; i++) { //loop though all columns in that row
            if (temp < data[row][i]) { //check if less than
                temp = data[row][i]; //set equal
            }
        }
        return temp;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = -1; //initialized to -1 in case index not found
        double temp = 0;
        for (int i = 0; i < data[row].length; i++) { //loop though columns in that row
            if (temp < data[row][i]) { //if less than
                temp = data[row][i]; //set equal
                index = i; //set index equal
            }
        }
        return index;
    }

    public static double getLowestInArray(double[][] data) {
        double temp = Double.MAX_VALUE; //initialize to max value
        for (double[] datum : data) { //loop through rows
            for (double v : datum) { //loop through columns
                if (temp > v) { //if temp is greater than element
                    temp = v; //set equal
                }
            }
        }
        return temp;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double temp = Double.MAX_VALUE; //initialize to max value
        for (double[] datum : data) { //loop through rows
            if (col >= 0 && col < datum.length) { //check if valid column index
                if (temp > datum[col]) { //if temp is greater than element
                    temp = datum[col]; //set equal
                }
            }
        }
        return temp;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1; //initialized to -1 in case index not found
        double temp = Double.MAX_VALUE; //initialize to max value
        for (int i = 0; i < data.length; i++) { //loop through all rows
            if (col < data[i].length && data[i][col] < temp) { //check if column is a valid index and if temp is greater than the element
                temp = data[i][col]; //set equal
                index = i; //set index equal
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double temp = Double.MAX_VALUE; //initialize to max value
        for (int i = 0; i < data[row].length; i++) { //loop through each column in that row
            if (temp > data[row][i]) { //if temp is greater than the element
                temp = data[row][i]; //set equal
            }
        }
        return temp;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = -1; //initialized to -1 in case index not found
        double temp = Double.MAX_VALUE; //initialize to max value
        for (int i = 0; i < data[row].length; i++) { //loop through all columns in that row
            if (temp > data[row][i]) { //if temp is greater than that element
                temp = data[row][i]; //set equal
                index = i; //set index equal
            }
        }
        return index;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0; //initialize variables
        for (int i = 0; i < data[row].length; i++) { //loop through all columns in that row
            total += data[row][i]; //add to total count
        }
        return total;
    }

    public static double getTotal(double[][] data) {
        double total = 0; //initialize variables
        for (double[] datum : data) { //loop through all rows
            for (double v : datum) { //loop through all columns
                total += v; //add element to total
            }
        }
        return total;
    }

    public static double[][] readFile(File file) throws FileNotFoundException { //throw an error (IDE auto did it for me)
        Scanner sc = new Scanner(file); //create new scanner variable for the file
        int indexRow = 0; //initialize variables
        String[][] temp = new String[10][]; //initialize, said max rows of 10s

        while (sc.hasNextLine()) {      //read file and pass numbers to temp
            String[] row = sc.nextLine().split(" "); //split based on space
            temp[indexRow] = new String[row.length]; // add to element as a string
            System.arraycopy(row, 0, temp[indexRow], 0, row.length); //originally as something else but the IDE auto completed
            indexRow++; //increment index
        }
        double[][] data = new double[indexRow][]; //new doubles array with same size as read above
        for (int i = 0; i < indexRow; i++) { //loop through all rows, could have used data.length
            data[i] = new double[temp[i].length]; //make it a new double
            for (int j = 0; j < temp[i].length; j++) { //loop through the columns now
                System.out.print(temp[i][j] + " "); //print out the array
                data[i][j] = Double.parseDouble(temp[i][j]); //parse from a string to a double
            }
            System.out.println(); //create new line
        }

        sc.close(); //close scanner
        return data; //return the array
    }

    static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(outputFile); //new PrintWriter object for the outputFile
        StringBuilder sb = new StringBuilder(); //new string builder object to append rather than +=
        for (double[] datum : data) { //loop through all rows
            for (double v : datum) { //loop through all columns
                sb.append(v).append(" "); //originally sb.append(v + " "); but asked to append twice
            }
            sb.append("\n"); //create a new line
        }
        output.print(sb.toString()); //converts string builder to a string then prints it
        output.close(); //close the file writer
    }

}
