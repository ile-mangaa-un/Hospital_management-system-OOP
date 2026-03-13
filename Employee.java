public abstract class Employee extends Person {
    private String employeeID;
    private boolean isAvailable;

    public Employee(String name, int age, String contactInfo, String employeeID) {
        super(name, age, contactInfo);
        this.employeeID = employeeID;
        this.isAvailable = true; // default
    }

    // Getters and Setters
    public String getEmployeeID() { return employeeID; } 
    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; } 
    public boolean isAvailable() { return isAvailable; } 
    public void setAvailable(boolean available) { isAvailable = available; }
}