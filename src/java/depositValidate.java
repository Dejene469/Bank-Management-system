/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author hp
 */
@Named(value = "depositValidate")
@Dependent
public class depositValidate {
    private String name;
    private String creditaccount;
    private String availablebalance;
      private String amount;
        private String totalamount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditaccount() {
        return creditaccount;
    }

    public void setCreditaccount(String creditaccount) {
        this.creditaccount = creditaccount;
    }

    public String getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(String availablebalance) {
        this.availablebalance = availablebalance;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }
        
   class BankAccount{
    double balance;
    double availablebalance;
    String amount;
    


    void deposit(double amount){
        if(amount!=0){
            balance+=amount;
           availablebalance=amount;
            System.out.println("Balance ="+balance);
        }
    }
   }
}
