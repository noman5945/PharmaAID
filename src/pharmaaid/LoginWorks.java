package pharmaaid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginWorks {
    
    Connection logCon;
    PreparedStatement getUser,getStats;
    ResultSet result,statres;
    
    public LoginWorks() {
        JDBCConnection con=new JDBCConnection();
        logCon=con.getConnection();
    }
    
    public int log_into(String userName,String pass,String userType){
        
        int id=0;
        try {
            String logSQL="SELECT * FROM Users WHERE UserName = ? AND User_pass = ? AND User_Type = ?";
            getUser=logCon.prepareStatement(logSQL);
            getUser.setString(1, userName);
            getUser.setString(2, pass);
            getUser.setString(3, userType);
            result=getUser.executeQuery();
            if(result.next()){
                id=result.getInt("UserID");
                return id;
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(LoginWorks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String userStatusCheck(String userName,String pass,String userType){
        
        String stat="";
        try {    
            String statsSQL="SELECT Status FROM Users WHERE UserName = ? AND User_pass = ? AND User_Type = ?";
            getStats=logCon.prepareStatement(statsSQL);
            getStats.setString(1, userName);
            getStats.setString(2, pass);
            getStats.setString(3, userType);
            statres=getStats.executeQuery();
            if(statres.next()){
                stat=statres.getString("Status");
                return stat;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginWorks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }
    
    public void logConClose(){
        try {
            logCon.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(LoginWorks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
