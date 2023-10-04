package pharmaaid;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Company {

    public Company() {
    }
    
    public int companyExists(String compName,Connection con){
        int id=0;
        ResultSet rs;
        try {    
            String compExistsSQL="select * from Company where Company_name = ?";
            PreparedStatement compExist=con.prepareStatement(compExistsSQL);
            compExist.setString(1, compName);
            rs=compExist.executeQuery();
            if(rs.next()){
                id=rs.getInt("CompanyID");
                return id;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void updateCompany(int id,String Name,String Salesman,String Email,String phnno,Connection con){
        try {
            String compUpdateSQL="UPDATE Company SET Company_Name = ?, Salesman = ?,Phone_no = ?,Email = ? WHERE CompanyID = ? ";
            PreparedStatement compIns=con.prepareStatement(compUpdateSQL);
            compIns.setString(1, Name);
            compIns.setString(2, Salesman);
            compIns.setString(3, phnno);
            compIns.setString(4, Email);
            compIns.setInt(5, id);
            
            compIns.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void addNewCompany(String Name,String Salesman,String Email,String phnno,Connection con){
        try {
            String compAddSQL="insert into Company(Company_name,Salesman,Phone_no,Email)VALUES(?,?,?,?)";
            PreparedStatement compIns=con.prepareStatement(compAddSQL);
            compIns.setString(1, Name);
            compIns.setString(2, Salesman);
            compIns.setString(3, phnno);
            compIns.setString(4, Email);
            
            compIns.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getAllCompany(Connection con){
        ResultSet rs=null;
        try {
            String allCompSQL="select * from Company";
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(allCompSQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
