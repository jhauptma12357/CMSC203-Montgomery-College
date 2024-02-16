/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Display to the console for the user to interact with
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import java.util.Random;
import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //scanner to receive input
        Day randomDay = randomDay(); //assign local variables to the random functions
        int randomTime = randomTime();
        double total = 0; //total price
        System.out.println("Beverage shop on " + randomDay + " at " + randomTime);
        System.out.println("The minimum age to order alcohol is 21");
        System.out.println("Orders can have a maximum of 3 alcoholic beverages.");
        while(true) { //infinite while loop for orders
            int age = 0;
            String name = "";
            System.out.println("Starting a new order...");
            System.out.print("Please enter your name: ");
            name = sc.nextLine(); //gets name
            System.out.print("Please enter your age: ");
            age = sc.nextInt(); //gets age
            Customer customer = new Customer(name,age); //creates a new customer
            Order order = new Order(randomTime,randomDay,customer); //creates a new order with customer and the random variables
            if(age >= 21){ //print out a message depending on age for alcohol
                System.out.println("Because you are at least 21 years of age, you can purchase alcoholic beverages\n");
            }else{
                System.out.println("Because you are under 21 years of age, you cannot purchase alcoholic beverages\n");
            }
            while(true) { //nest infite while loop for asking the beverage
                String drink = "", bevName = "", sizeInput = "";
                Size size = Size.SMALL;
                while (true) { //nested while loop in case invalid choice
                    System.out.print("Please enter the drink you wish to purchase (smoothie/alcohol/coffee): ");
                    drink = sc.next();
                    if(drink.equalsIgnoreCase("alcohol") && order.findNumOfBeveType(Type.ALCOHOL) >= 3){
                        System.out.println("You already have the max amount of alcoholic beverages.");
                        continue;
                    }
                    break;
                }
                sc.nextLine();
                System.out.print("Please enter the beverage name: "); //fill in info all the beverages need
                bevName = sc.nextLine();
                System.out.print("Please enter the beverage size (small/medium/large): ");
                sizeInput = sc.nextLine();
                //by default size is small so no if statement for small
                if(sizeInput.equalsIgnoreCase("medium")){
                    size = Size.MEDIUM;
                }
                if(sizeInput.equalsIgnoreCase("large")){
                    size = Size.LARGE;
                }

                if(drink.equalsIgnoreCase("smoothie")){
                    int fruits = 1;
                    String protein = "n";
                    while(true) { //nested infinite while loop to check validity
                        System.out.print("Please enter the amount of fruits (MAX 5): ");
                        fruits = sc.nextInt();
                        if(fruits > 5){
                            System.out.println("The max number of fruits is 5. Try again");
                            continue;
                        }
                        break;
                    }
                    System.out.print("Would you like to add protein powder (Y/N)? ");
                    protein = sc.next();
                    if(protein.equalsIgnoreCase("n")){ //ask for protein
                        order.addNewBeverage(bevName, size, fruits, false);
                    }else{
                        order.addNewBeverage(bevName, size, fruits, true);
                    }

                }
                if(drink.equalsIgnoreCase("alcohol")){
                 order.addNewBeverage(bevName, size); //add alcohol drink
                }
                if(drink.equalsIgnoreCase("coffee")){
                    boolean extraShot = false, extraSyrup = false;
                    System.out.print("Would you like an extra shot (Y/N)? ");
                    if(sc.next().equalsIgnoreCase("y")){ //default is false
                        extraShot = true;
                    }
                    System.out.print("Would you like extra syrup (Y/N)? ");
                    if(sc.next().equalsIgnoreCase("y")){ //default is false
                        extraSyrup = true;
                    }
                    order.addNewBeverage(bevName, size,extraShot, extraSyrup); //add beverage
                }
                System.out.println("You currently have " + order.getTotalItems() + " beverages"); //total amount of beverages
                total += order.calcOrderTotal();
                System.out.println("The total price for this order is $" + order.calcOrderTotal()); //price of this order
                System.out.print("Would you like to end this order (Y/N)? ");
                if(sc.next().equalsIgnoreCase("y")){ //ask if want to add another beverage
                    break;
                }
            }
            System.out.print("Would you like to create a new order (Y/N)? ");
            if(sc.next().equalsIgnoreCase("n")){ //ask if there is another order
                break;
            }
            sc.nextLine();
        }
        System.out.println("Your total is $" + total); //this is the total price of all the orders combined
    }
    public static Day randomDay(){
        Random r = new Random();
        int day = r.nextInt(7) + 1; //get a random day
        switch(day){
            case 1:
                return Day.MONDAY;
            case 2:
                return Day.TUESDAY;
            case 3:
                return Day.WEDNESDAY;
            case 4:
                return Day.THURSDAY;
            case 5:
                return Day.FRIDAY;
            case 6:
                return Day.SATURDAY;
            default:
                return Day.SUNDAY;
        }
    }
    public static int randomTime(){
        Random r = new Random(); //get a random that is valid
        return r.nextInt(16) + 8;
        }
}
