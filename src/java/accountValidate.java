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
public class AccountValidate {

  public static boolean validat(String accountNumber, String accountPassword) {
        boolean status = false;
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from ACCOUNTTA where ACCOUNTNUMBER=? and ACCOUNTPIN=?");
            ps.setString(1, accountNumber);
            ps.setString(2, accountPassword);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return status;
    } 
}
