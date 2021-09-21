package bank;

public class User {
    String name;
    String surname;
    double balance;
    static long _id = 0;

    public User(String name, String surname, double balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this._id = this._id++;
    }

    public long get_id() {
        return _id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
