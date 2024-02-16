import java.util.Scanner; //import scanner to recieve inputs
public class PatientDriverApp   {
    public static void main(String[] args){
        String firstName, middleName, lastName, address, city, state, zipcode, ICEName, ICENumber;
        Procedure firstProcedure, secondProcedure, thirdProcedure; //declare variables
        firstProcedure = secondProcedure = thirdProcedure = null; //initialize to null just in case not assigned later
        Scanner sc = new Scanner(System.in); //create scanner object
        System.out.print("Enter patient's first name: "); firstName = sc.nextLine(); //Start of asking info for the patient construction
        System.out.print("Enter patient's middle name: "); middleName = sc.nextLine();
        System.out.print("Enter patient's last name: "); lastName = sc.nextLine();
        System.out.print("Enter patient's address: "); address = sc.nextLine();
        System.out.print("Enter patient's city: "); city = sc.nextLine();
        System.out.print("Enter patient's state: "); state = sc.nextLine();
        System.out.print("Enter patient's zipcode: "); zipcode = sc.nextLine();
        System.out.print("Enter emergency contact's name (first and last): "); ICEName = sc.nextLine();
        System.out.print("Enter your emergency contact's phone number: "); ICENumber = sc.nextLine(); //End of asking info for the patient construction
        System.out.println(); //New line for formatting
        Patient patient = new Patient(firstName, middleName,lastName,address,
                city, state, zipcode, ICEName, ICENumber); //Creates a new Patient object named patient
    for(int i = 1; i <= 3; i ++){ //A for loop from 1 to 3 because 3 procedures
        String procedure, date, practitioner;
        double price; //declare variables
        System.out.print("Enter procedure " + i + ": "); procedure = sc.nextLine(); //Start of asking information for procedure construction
        System.out.print("Enter date of procedure: "); date = sc.nextLine();
        System.out.print("Enter practitioner name: "); practitioner = sc.nextLine();
        System.out.print("Enter price: "); price = sc.nextDouble(); //End of asking information for procedure construction
        sc.nextLine(); //Nextline because nextDouble doesn't seem to go to the next line after finished
        switch(i){ //Switch statement to create Procedure object based on which procedure number it is
            case 1:
                firstProcedure = new Procedure(procedure, date,practitioner, price);
                break;
            case 2:
                secondProcedure = new Procedure(procedure, date,practitioner,price);
                break;
            default:
                thirdProcedure = new Procedure(procedure, date,practitioner, price); //Default is when i = 3 (equivalent to else)
                break;
        }
        System.out.println(); //formatting
        }
    displayPatient(patient); //display patient info
    displayProcedure(firstProcedure); //display procedure 1 info
    displayProcedure(secondProcedure); //display procedure 2 info
    displayProcedure(thirdProcedure); //display procedure 3 info
    float calculation = (float)calculateTotalCharges(firstProcedure,secondProcedure, thirdProcedure); //assign calculation to calculateTotalCharges
    System.out.printf("Total Charge: $%,.2f", calculation); //prints out the total charges with 2 decimal precision and a comma to separate by 3 digits
    }
    public static void displayPatient(Patient patient){//Parameter of patient
        patient.display();
    }
    public static void displayProcedure(Procedure procedure){//Parameter of procedure
        procedure.display();
    }
    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3){//Parameters are all the procedures
        return procedure1.getPrice() + procedure2.getPrice() + procedure3.getPrice(); //Returns the sum of all of them
    }
}
