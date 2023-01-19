/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Dependent
@Named
public class customerlist {
public List<AccountManagedBean> getUserList() {
        List<AccountManagedBean> list = new ArrayList<>();
        try {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from  ACCOUNTTA");
            while (rs.next()) {
               AccountManagedBean acc = new AccountManagedBean();
                acc.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
               acc.setAccountPin(rs.getString("ACCOUNTPIN"));
                acc.setDate(rs.getString("DAY"));
                acc.setGender(rs.getString("GENDER"));
                acc.setAddress(rs.getString("ADDRESS"));
                acc.setFname(rs.getString("FNAME"));
                  acc.setMname(rs.getString("MNAME"));
                    acc.setLname(rs.getString("LNAME"));
                      acc.setNationality(rs.getString("NATIONALITY"));
                        acc.setMobile(rs.getString("MOBILE"));
     
               
               
                list.add(acc);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
    
}
