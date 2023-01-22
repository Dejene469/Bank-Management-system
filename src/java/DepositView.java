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
public class DepositView {
public List<DepositValidate> getdepositList() {
        List<DepositValidate> list = new ArrayList<>();
        try {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from  DEPOSITTABLE");
            while (rs.next()) {
              DepositValidate acc = new DepositValidate();
                acc.setName(rs.getString("NAME"));
               acc.setCreditaccount(rs.getString("CREDITACCOUNT"));
                acc.setAmount(rs.getString("AMOUNT"));
               
                list.add(acc);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
    
}
