package pharmaaid;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logs {
    
    public Logs() {
    }
    
    public void insertLoginLogout(Connection con,int id,String login,String logout,String todaydate){
        try {
            Date today=Date.valueOf(todaydate);
            
            String sql="insert into Logs(UserID,LogDate,LogInTime,LogOutTime)VALUES("
                    + "'"+id+"',"
                    + "'"+todaydate+"',"
                    + "'"+login+"',"
                    + "'"+logout+"')";
            
            Statement stmt=con.createStatement();
            if(stmt.executeUpdate(sql)>0){
                System.out.println("Inserted");
            }
            else{
                System.out.println("Not Inserted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getLogs(Connection con){
        ResultSet rs=null;
        String sql="select e.Emp_Name,e.Emp_Type,s.LogDate,s.LogInTime,s.LogOutTime from Logs s JOIN Employee e ON s.UserID=e.UserID order by s.LogDate desc";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
