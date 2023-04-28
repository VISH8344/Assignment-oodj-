package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentWallet implements Serializable {
    private double amount;
    private ArrayList<Topup> transaction_history;

    public StudentWallet(double amount, ArrayList<Topup> transaction_history) {
        this.amount = amount;
        this.transaction_history = transaction_history;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<Topup> getTransaction_history() {
        return transaction_history;
    }

    public void setTransaction_history(ArrayList<Topup> transaction_history) {
        this.transaction_history = transaction_history;
    }
    
}
