/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author hp
 */
@ManagedBean
@Dependent
public class withdrawManaged {

    private String name;
    private String creditAcc;
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditAcc() {
        return creditAcc;
    }

    public void setCreditAcc(String creditAcc) {
        this.creditAcc = creditAcc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    
     public void withdraw(String name,String withdraw) throws ClassNotFoundException, SQLException {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql="select * from DEPOSITTABLE where name=?";
               PreparedStatement ps1 = con.prepareStatement(sql);
               ps1.setString(1, name);
                           ResultSet rs=ps1.executeQuery();
                           if(rs.next()){
                           int num=rs.getInt(3);
                         
                           Integer value=Integer.parseInt(withdraw);
                           if(num<value){
                               System.out.println("you are no elligal to withdraw");
                           } else{
                         value-=num;
                      value=Math.abs(value);
                          amount=value.toString();
                        sql="update DEPOSITTABLE set NAME=?,CREDITACCOUNT=?,AMOUNT=? where name=?";  
                  PreparedStatement ps=con.prepareStatement(sql);
                        ps.setString(1,name );
            ps.setString(2, creditAcc);
             ps.setString(3, amount);
            ps.setString(4, name);
            ps.executeUpdate();}
}
     }}