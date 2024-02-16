/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Many methods due with purchasing drinks
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import java.util.ArrayList;

public class BevShop implements BevShopInterface{
    public ArrayList<Order> orders; //arraylist to keep track of all orders
    private int numOfAlcohol; //private field

    public BevShop(){ //default constructor
        orders = new ArrayList<Order>(); //initialize the arraylist
    }

    @Override
    public boolean isValidTime(int time) {
        return time > 8 && time < 23; //check if the time is valid inbetween these times
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT; //check if its max
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return orders.isEmpty() || numOfAlcohol < MAX_ORDER_FOR_ALCOHOL;
    }


    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcohol;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL; //is valid age for alcohol
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer cust = new Customer(customerName, customerAge); //starting a new order creates new customer
        orders.add(new Order(time, day, cust)); //add a new order to the orders arraylist
        numOfAlcohol = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        orders.get(orders.size() - 1).addNewBeverage(bevName, size, extraShot, extraSyrup); //adds a beverage to the most recent order
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        orders.get(orders.size() - 1).addNewBeverage(bevName, size); //adds a beverage to the most recent order
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein); //adds a beverage to the most recent order
    }

    @Override
    public int findOrder(int orderNo) {
        for(int i = 0; i < orders.size(); i ++){
            if(orders.get(i).getOrderNo() == orderNo){ //return the index once found
                return i;
            }
        }
        return -1; //if not found return -1
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        double total = 0;
        for(Order o : orders){
            if(o.getOrderNo() == orderNo){
                for(Beverage b : o.getBeverages()){
                    total += b.calcPrice(); //add all the beverage prices in all the orders
                }
            }
        }
        return total;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for(Order o : orders){
            for(Beverage b : o.getBeverages()){
                total += b.calcPrice(); //total of all orders
            }
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return orders.get(orders.size() - 1); //current order is the last element
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size()-1; i++) {
            int minOrderNumIdx = i;
            for (int j = i+1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo()) { //checking if this is less than the minimum
                    minOrderNumIdx = j;
                }
            }
            Order temp = orders.get(minOrderNumIdx);
            orders.set(minOrderNumIdx, orders.get(i));
            orders.set(i, temp);
        }
    }
}
