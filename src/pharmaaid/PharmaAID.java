package pharmaaid;
import InterFaces.*;
import InterFaces.MedicineDashboard;
import java.sql.Connection;
import java.util.ArrayList;
public class PharmaAID {
    public static void main(String[] args) {
        Login login=new Login();   
        //New line for test
        
        login.setTitle("Pharma AID");
        login.setVisible(true);
        
//          JDBCConnection con=new JDBCConnection();
//          Connection supCon=con.getConnection();
//          Supply supply=new Supply();
//          supply.setMedValues(60.0f, "2023-05-01", "2021-06-01", "Cream");
//          supply.supplyAdd("Nyclobate NN", "Incepta", 100, 21003, "Rabbi", "2021-05-19", 10, supCon);
//          con.closeConnection();

//        Employee emp=new Employee();
//        
//        ArrayList<EmployeeInfos> al=new ArrayList<>();
//        al=emp.getEmployeeInfo("Staff", emp.EmpCon);
//        emp.setEmpContact(al, "asdsadasd", "Staff", "01552369408", emp.EmpCon);
//        for(int i=0;i<al.size();i++){
//            System.out.println(al.get(i).getID());
//            System.out.println(al.get(i).getName());
//            System.out.println(al.get(i).getSalary());
//            System.out.println(al.get(i).getDoj());
//            System.out.println(al.get(i).getType());
//            System.out.println("\n");
//        }
//        emp.closeDatabase();
        
//        MedicineDashboard mbdb = new MedicineDashboard();
//        mbdb.setVisible(true);
//          Employee emp=new Employee();
//          emp.UpdateUser(16, "Rafi96", "12395", "Employee", emp.EmpCon);
//          emp.closeDatabase();
//          AdminPanel api=new AdminPanel();
//          api.UserStatusChange(12, "Blocked");
//          api.closeDatabase();
//            LoginWorks log=new LoginWorks();
//            String stat=log.userStatusCheck("noms42", "12345", "Customer");
//            System.out.println(stat);
//            log.logConClose();

    }
    
}
