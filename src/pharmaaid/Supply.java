package pharmaaid;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Supply {
    
    int comp_id;
    int med_id;
    float medprice;
    Date medExpDate;
    Date medMfgDate;
    String type;
    
    public Supply() {
    }
    
    public void supplyAdd(String medName,String companyName,int qty,int batch_no,String salesMan,String supply_date,float mg,Connection con){
        Date supplyDate=Date.valueOf(supply_date);
        try {
            Company comp=new Company();
            Medicine med=new Medicine();
            
            String supplyInsSQL="insert into Supply(MedID,CompanyID,Batch_No,Qty,SalesMan,Supp_Date)VALUES(?,?,?,?,?,?)";
            PreparedStatement supplyAdd=con.prepareStatement(supplyInsSQL);
            
            comp_id=comp.companyExists(companyName, con);
            med_id=med.medicineExists(medName, companyName, mg, con);
            
            if(med_id>0){
                med.medicineUpdate(med_id, qty, con);
                supplyAdd.setInt(1, med_id);
                supplyAdd.setInt(2, comp_id);
                supplyAdd.setInt(3, batch_no);
                supplyAdd.setInt(4, qty);
                supplyAdd.setString(5, salesMan);
                supplyAdd.setDate(6, supplyDate);
                supplyAdd.executeUpdate();
            }else{
                med.medicineInsert(medName, type, companyName, medExpDate, medMfgDate, qty, mg, medprice, con);
                med_id=med.medicineExists(medName, companyName, mg, con);
                
                supplyAdd.setInt(1, med_id);
                supplyAdd.setInt(2, comp_id);
                supplyAdd.setInt(3, batch_no);
                supplyAdd.setInt(4, qty);
                supplyAdd.setString(5, salesMan);
                supplyAdd.setDate(6, supplyDate);
                supplyAdd.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteSupplyRecord(int id,Connection con){
        try {
            String suppDelSQL="delete from Supply where MedID = ?";
            PreparedStatement delsupp=con.prepareStatement(suppDelSQL);
            delsupp.setInt(1, id);
            delsupp.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public ResultSet supplyFullRecord(Connection con){
        ResultSet rs=null;
        Statement stmt;
        try {    
            String fullSQL="select d.SupplyID,f.MedicineName,c.Company_name,d.Batch_No,d.Qty,d.SalesMan,d.Supp_Date from Medicine f JOIN Supply d ON f.MedID=d.MedID JOIN Company c ON c.CompanyID=d.CompanyID";
            stmt=con.createStatement();
            rs=stmt.executeQuery(fullSQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet supplyFullRecord(Connection con,String name){
        ResultSet rs=null;
        Statement stmt;
        try {    
            String fullSQL="select d.SupplyID,f.MedicineName,c.Company_name,d.Batch_No,d.Qty,d.SalesMan,d.Supp_Date from Medicine f JOIN Supply d ON f.MedID=d.MedID JOIN Company c ON c.CompanyID=d.CompanyID where d.SalesMan LIKE '"+name+"%'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(fullSQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet supplyFullRecord(Connection con,String Year,String Month){
        ResultSet rs=null;
        try {
            java.util.Date date = new SimpleDateFormat("MMMM").parse(Month);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            
            String DAY;
            int day=cal.get(Calendar.MONTH)+1;
            if(day<10){
                DAY="0"+Integer.toString(day);
            }
            else{
                DAY=Integer.toString(day);
            }
            
            String cratedate=Year+"-"+DAY+"-";
            System.out.println(cratedate);
            
            Statement stmt;
            try {
                String fullSQL="select d.SupplyID,f.MedicineName,c.Company_name,d.Batch_No,d.Qty,d.SalesMan,d.Supp_Date from Medicine f JOIN Supply d ON f.MedID=d.MedID JOIN Company c ON c.CompanyID=d.CompanyID where d.Supp_Date LIKE '"+cratedate+"%'";
                stmt=con.createStatement();
                rs=stmt.executeQuery(fullSQL);
                return rs;
            } catch (SQLException ex) {
                Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(Supply.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void setMedValues(float mrp,String exp,String mfgDate,String type){ 
        this.medprice=mrp;
        this.medExpDate=Date.valueOf(exp);
        this.medMfgDate=Date.valueOf(mfgDate);
        this.type=type;
    }
}
