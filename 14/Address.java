public class Address {
    private String Name;
    private String Number;

    public Address(String Name, String Number) {
        this.Name = Name;
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String add_address(){
        return getName() + ":" + this.getNumber();
    }

    public String toString() {
        return getName() + ":" + this.getNumber();
    }
}
