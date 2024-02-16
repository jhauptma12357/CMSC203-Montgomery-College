/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: An order class that contains many beverages
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface{
    private int orderTime, orderNo; //private class fields
    private Day orderDay;
    private Customer cust;
    private ArrayList<Beverage> beverages; //arraylist to keep track of all the beverages

    public Order(int orderTime, Day orderDay, Customer cust){ //constructor
        this.orderTime = orderTime; //assign private fields equal to parameters
        this.orderDay = orderDay;
        this.cust = cust;
        beverages = new ArrayList<Beverage>(); //initialize a new arraylist
    }

    public int generateOrder(){
        Random r = new Random();
        orderNo = r.nextInt(80000) + 10000; //generate random number with a minimum of 10k and make of 90k
        return orderNo;
    }
    public int getOrderNo(){
        return orderNo;
    }
    public int getOrderTime(){
        return orderTime;
    }
    public Day getOrderDay(){
        return orderDay;
    }

    public Customer getCustomer(){
        return cust;
    }
    public Day getDay(){
        return orderDay;
    }
    @Override
    public boolean isWeekend() {
        return getDay() == Day.SUNDAY || getDay() == Day.SATURDAY; //check if the day is sunday or saturday
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        return beverages.get(itemNo); //return the beverage at the inputted index
    }

    public int getTotalItems(){
        return beverages.size(); //total items is the size
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot,extraSyrup)); //add a new beverage of coffee
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        boolean isWeekend = false;
        if(orderDay == Day.SUNDAY || orderDay == Day.SATURDAY){
            isWeekend = true; //if its weekend set isWeekend to true else its false
        }
        beverages.add(new Alcohol(bevName, size, isWeekend)); //add a new beverage of alcohol

    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
       beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein)); //add a new beverage of a smoothie
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for(Beverage b : beverages){ //loop through and add the prices of each
            total += b.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int counter = 0;
        for(Beverage b : beverages){
            if(type == b.getType()){ //if it is of that type increment the counter by 1
                counter ++;
            }
        }
        return counter;
    }
    public String toString(){
        String basicInfo = orderNo + "," + orderTime + "," + orderDay + "," + cust.getName() + "," + cust.getAge(); //basic fields
        StringBuilder sb = new StringBuilder();
        for(Beverage b : beverages){
            sb.append(b.getBevName()).append(",").append(b.getType()); //add to the string for all beverages
        }
        return basicInfo + "\n" + sb.toString(); //add them up and return
    }

    public int compareTo(Order anotherOrder){
        if(orderNo == anotherOrder.getOrderNo()){ //return 0 if equal
            return 0;
        }else if(orderNo > anotherOrder.getOrderNo()){
            return 1; //return 1 is greater than
        }else{
            return -1; //else return -1
        }
    }

    public ArrayList<Beverage> getBeverages(){ //return the arraylist of beverages in the order
        return beverages;
    }

}
