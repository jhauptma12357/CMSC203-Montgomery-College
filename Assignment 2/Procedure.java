public class Procedure {
    private String procedure, date, practitioner;
    double price;//Declare variables
    public Procedure(String procedure, String date, String practitioner, double price){
        this.procedure = procedure; //Assigns all the variables to the parameters of the constructor
        this.date = date;
        this.practitioner = practitioner;
        this.price = price;
    }
    public void display(){ //display everything
        System.out.println("\t\tProcedure: " + procedure); //display procedure name
        System.out.println("\t\tDate=" + date); //display date
        System.out.println("\t\tPractitioner=" + practitioner); //display practitioner
        System.out.println("\t\tCharge=" + price); //display the price
        System.out.println(); //create a new line for formatting
    }
    public String getProcedure() {//Everything below this is mutators and accessors (getters/setters)
        return procedure;
    }
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPractitioner() {
        return practitioner;
    }
    public void setPractitioner(String practitioner) {
        this.practitioner = practitioner;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
