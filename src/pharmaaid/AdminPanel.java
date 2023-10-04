package pharmaaid;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminPanel {

    Connection Admincon;
    ResultSet rs;
    
    public AdminPanel() {
        JDBCConnection con=new JDBCConnection();
        Admincon=con.getConnection();
    }
    
    public void UpdateUser(int id,String username, String pass, String userType,Connection admincon){
        
        if(!sameUserName(userType,admincon,username).equals(username)){
            try {
                String updateSQL="UPDATE Users SET UserName = ? , User_Pass = ? , User_Type = ? WHERE UserID = ?";
                PreparedStatement update=admincon.prepareStatement(updateSQL);
                update.setString(1, username);
                update.setString(2, pass);
                update.setString(3, userType);
                update.setInt(4, id);

                update.executeUpdate();
                System.out.println("User updated");
            } 
            catch (SQLException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("User name already exists.");
        }
    }
        
    public String sameUserName(String usertyp,Connection admincon,String username){
        
        String id="";
        
        try {
            String getunameSQL="select UserName from users where User_Type = ? AND UserName = ?";
            PreparedStatement getID=admincon.prepareStatement(getunameSQL);
            getID.setString(1, usertyp);
            getID.setString(2, username);
            rs=getID.executeQuery();
            
            if(rs.next()){
                id=rs.getString("UserName");
                //System.out.println("Customer user id is="+id);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void UserStatusChange(int uid,String status){
        try {
            String statchngSQL="Update Users SET Status = ? WHERE UserID = ?";
            PreparedStatement statusCh=Admincon.prepareStatement(statchngSQL);
            statusCh.setString(1, status);
            statusCh.setInt(2, uid);
            if(statusCh.executeUpdate()>0){
                System.out.println("User Status changed");
            }
            else{
                System.out.println("User Status Not changed");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int userIDGet(String userName,String usertyp,Connection admincon){
        
        int id=0;
        
        try {
            String getuidSQL="select UserID from users where UserName = ? AND User_Type = ?";
            PreparedStatement getID=admincon.prepareStatement(getuidSQL);
            getID.setString(1, userName);
            getID.setString(2, usertyp);
            rs=getID.executeQuery();
            
            if(rs.next()){
                id=rs.getInt("UserID");
                //System.out.println("Customer user id is="+id);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public ResultSet getAlluser(){
        rs=null;
        try {
            String sql="select * from Users";
            Statement stmt=Admincon.createStatement();
            rs=stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getuser(int uid){
        rs=null;
        try {
            String sql="select * from Users where UserID = "+uid;
            Statement stmt=Admincon.createStatement();
            rs=stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void closeDatabase(){
        try {
            Admincon.close();
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
