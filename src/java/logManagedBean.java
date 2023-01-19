/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

@Dependent
@ManagedBean
public class logManagedBean {

        private String AccountNumber;
    private String AccountPin;
    
   
    
    public logManagedBean() {
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getAccountPin() {
        return AccountPin;
    }

    public void setAccountPin(String AccountPin) {
        this.AccountPin = AccountPin;
    }
    
     public void profilerInsert() throws ClassNotFoundException, SQLException {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into DADA(AccountNumber,AccountPin) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, AccountNumber);
            ps.setString(2, AccountPin);
            ps.executeUpdate();
        
     }
}
