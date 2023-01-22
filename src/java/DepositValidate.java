/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hp
 */
@ManagedBean
@Dependent
public class DepositValidate {
  private String name;  
private String creditaccount;
private String amount;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void DepositInsert() throws ClassNotFoundException, SQLException {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sqr = "Insert into DEPOSITTABLE(NAME,CREDITACCOUNT,AMOUNT) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sqr);
            ps.setString(1,name );
            ps.setString(2, creditaccount);
             ps.setString(3, amount);
            
            ps.executeUpdate();
        
     }
     
}
