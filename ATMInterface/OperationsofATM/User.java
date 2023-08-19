package OperationsofATM;

public class User {
    private String accholdername;
    private String acctype;
    private String accnum;
    private double accbal;
    
    public User(String name, String type, String number, double bal) {
        accholdername = name;
        acctype = type;
        accnum = number;
    }

    public void calc() {
        accbal = 0;
    }
    public double display() {
        return accbal;
    }
}
