/**
 * Name: Christopher Kabucho
 * Student ID: 224138
 */

interface IManageable {
    void saveData();
    void deleteData();
}

interface IBillable {
    void generateInvoice();
}

abstract class Person {
    protected String name;
    protected int age;
    protected String contactInfo;
    public static int totalPeopleCount = 0;

    public Person(String name, int age, String contactInfo) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        totalPeopleCount++;
    }

    public abstract void performRole();
}

abstract class HospitalStaff extends Person {
    protected String employeeID;

    public HospitalStaff(String n, int a, String c, String id) {
        super(n, a, c);
        this.employeeID = id;
    }
}

class Patient extends Person implements IBillable {
    private String ailment;
    private double billAmount;

    public Patient(String n, int a, String c, String id, String ailment, double bill) {
        super(n, a, c);
        this.ailment = ailment;
        this.billAmount = bill;
    }

    @Override
    public void performRole() {
        System.out.println(name + " is recovering from " + ailment + ".");
    }

    @Override
    public void generateInvoice() {
        System.out.println("Bill for " + name + ": $" + billAmount);
    }
}

class Doctor extends HospitalStaff implements IManageable {
    private String specialization;

    public Doctor(String n, int a, String c, String id, String spec) {
        super(n, a, c, id);
        this.specialization = spec;
    }

    @Override
    public void performRole() {
        System.out.println("Dr. " + name + " is consulting in " + specialization + ".");
    }

    @Override
    public void saveData() {
        System.out.println("Doctor " + name + " saved to database.");
    }

    @Override
    public void deleteData() {
        System.out.println("Doctor " + employeeID + " deleted.");
    }
}

class Nurse extends HospitalStaff {
    public Nurse(String n, int a, String c, String id) {
        super(n, a, c, id);
    }

    @Override
    public void performRole() {
        System.out.println("Nurse " + name + " is assisting.");
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Doctor doc = new Doctor("Christopher", 45, "chris@hosp.com", "D101", "Cardiology");
        Patient pat = new Patient("John Doe", 28, "john@mail.com", "P99", "Flu", 250.0);
        Nurse nur = new Nurse("Staff Nurse", 32, "nurse@hosp.com", "N202");

        System.out.println("--- Hospital Roles ---");
        doc.performRole();
        pat.performRole();
        nur.performRole();
        
        System.out.println("\n--- Actions ---");
        doc.saveData();
        pat.generateInvoice();

        System.out.println("\nTotal Registered: " + Person.totalPeopleCount);
    }
}