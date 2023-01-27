/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
   

    
    public void DepositInsert(String name,String deposit) throws ClassNotFoundException, SQLException {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql="select * from DEPOSITTABLE where name=?";
               PreparedStatement ps1 = con.prepareStatement(sql);
               ps1.setString(1, name);
                           ResultSet rs=ps1.executeQuery();
                           if(rs.next()){
                           int num=rs.getInt(3);
                           Integer value=Integer.parseInt(deposit);
                          value+=num;
                          amount=value.toString();
                        sql="update DEPOSITTABLE set NAME=?,CREDITACCOUNT=?,AMOUNT=? where name=?";  
                  PreparedStatement ps=con.prepareStatement(sql);
                        ps.setString(1,name );
            ps.setString(2, creditaccount);
             ps.setString(3, amount);
            ps.setString(4, name);
            ps.executeUpdate();
                           } else {
                               String sqr = "Insert into DEPOSITTABLE(NAME,CREDITACCOUNT,AMOUNT) values(?,?,?)";
     
            PreparedStatement ps2 = con.prepareStatement(sqr);
            ps2.setString(1,name );
            ps2.setString(2, creditaccount);
             ps2.setString(3, amount);
            
            ps2.executeUpdate();
                           }
                           

           
        
     }
}

