public abstract class Person {
    private String name;
    private int age;
    private String contactInfo;
    private static int totalPeopleCount = 0;

    public Person(String name, int age, String contactInfo) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        totalPeopleCount++;
    }

    public abstract void performRole();

    public void updateContact(String newContact) {
        this.contactInfo = newContact;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public static int getTotalPeopleCount() { return totalPeopleCount; }
}