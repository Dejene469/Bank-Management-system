
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
@ManagedBean
@RequestScoped
public class AdminValidate {
    
    
     public static boolean validate(String username, String password) {
        boolean status = false;
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from ADMIN where USERNAME=? and PASSWORD=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
}
