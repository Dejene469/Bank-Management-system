/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author hp
 */
@ManagedBean
@Dependent
public class admin {
private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //validate login
    public String validateUsernamePassword() throws SQLException, ClassNotFoundException {
        boolean valid =  AdminValidate.validate(username, password);
        if (valid) {
              DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select USERNAME from ADMIN where USERNAME=? and PASSWORD=?");
            ps.setString(1, username);  
             ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            rs.next();
           
            //String username =rs.getString(1);
            //String password =rs.getString(1);
           
            if ("Dej".equals(username) && "1212".equals(password)){
                return "newAccount";
            } else {
                return "new";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "AdminPage";
        }
    
}
}