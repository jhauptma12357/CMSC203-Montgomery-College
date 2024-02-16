public class Patient {
    private String firstName, middleName, lastName, address, city, state,
        zipcode, emergencyContact, emergencyContactPhoneNumber; //declare all variables
    public Patient(String firstName, String middleName, String lastName, String address, String city, String state, String zipcode, String emergencyContact, String emergencyContactPhoneNumber){
        this.firstName = firstName; //Assigns all the variables to the parameters of the constructor
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.emergencyContact = emergencyContact;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }
    public void display(){ //display everything
        System.out.println("Patient:");
        System.out.println("  " + buildFullName()); //display name
        System.out.println("  " + buildAddress()); //display address
        System.out.println("  " + buildEmergencyContact()); //display emergency contact info
        System.out.println();
    }
    public String buildFullName(){ //concatenates to build a full name
        return firstName + " " + middleName + " " + lastName;
    }
    public String buildAddress(){ //concatenates to build a full address
        return address + " " + city + " " + state + " " + zipcode;
    }
    public String buildEmergencyContact(){ //concatenates emergency contact and phone number
        return emergencyContact + " " + emergencyContactPhoneNumber;
    }
    public String getFirstName() {//Everything below this is mutators and accessors (getters/setters)
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }
    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }
}