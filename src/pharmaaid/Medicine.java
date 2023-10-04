package pharmaaid;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Medicine {

    Connection medCon;
    ResultSet medRes=null;
    float price;
    Date ExpDate;
    Date MfgDate;
    
    public Medicine() {
        
    }
    
    public void medicineInsert(String name,String type,String comp,Date exp,Date mfg,int qty,float mg,float price,Connection con){
        try {
            String medInsertSQL="insert into Medicine(MedicineName,Med_type,Company,Exp_Date,Mfg_Date,Qty,Mg,Price)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement medInsert=con.prepareStatement(medInsertSQL);
            medInsert.setString(1, name);
            medInsert.setString(2, type);
            medInsert.setString(3, comp);
            medInsert.setDate(4, exp);
            medInsert.setDate(5, mfg);
            medInsert.setInt(6, qty);
            medInsert.setFloat(7, mg);
            medInsert.setFloat(8, price);
            medInsert.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int medicineExists(String medName,String company,float mg,Connection con){
        int id=0;
        try {
            String allMedSQL="select * from Medicine where MedicineName = ? AND Company = ? AND Mg = ?";
            PreparedStatement getMed=con.prepareStatement(allMedSQL);
            getMed.setString(1, medName);
            getMed.setString(2, company);
            getMed.setFloat(3, mg);
            medRes=getMed.executeQuery();
            if(medRes.next()){
               id=medRes.getInt("MedID");
               return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void medicineUpdate(int id,int qty,Connection con){
        
        try {
            String medUpdateSQL="update Medicine set Qty = ? where MedID = ?";
            PreparedStatement medInsert=con.prepareStatement(medUpdateSQL);
            medInsert.setInt(1, qty);
            medInsert.setInt(2, id);
            medInsert.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet searchMedicine(String name,String company,float mg,Connection con){
        ResultSet rs=null;
        try {
            String searchSQL="select * from Medicine where  (Mg="+mg+") AND ((MedicineName LIKE '"+name+"%') OR (Company LIKE '"+company+"%'))";
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(searchSQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet searchMedicine(Connection con){
        ResultSet rs=null;
        try {
            String searchSQL="select * from Medicine where Exp_Date > GETDATE() order by Exp_Date";
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(searchSQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void medicineUpdate(int id,String name,String type,String comp,Date exp,Date mfg,int qty,float mg,float price,Connection con){
    
    }
    
}
