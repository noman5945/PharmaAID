package pharmaaid;
import java.util.Random;
public class idGenarate {

    public idGenarate() {
    }
    
    public int customerID(){
        Random rand=new Random();
        int custID=10000;
        int ran=rand.nextInt(1000);
        return custID+ran;
    }
    
    public int employeeID(){
        Random rand=new Random();
        int custID=30000;
        int ran=rand.nextInt(1000);
        return custID+ran;
    }
    
    public int OwnerID(){
        Random rand=new Random();
        int custID=20000;
        int ran=rand.nextInt(1000);
        return custID+ran;
    }
    
    public int SaleID(){
        Random rand=new Random();
        int saleID=300;
        int ran=rand.nextInt(99);
        return saleID+ran;
    }
    
    public int OfflineCustID(){
        Random rand=new Random();
        int saleID=400;
        int ran=rand.nextInt(99);
        return saleID+ran;
    }
    
    public String employeeDetect(int empID){
        String emp_type="Staff";
        int detector=empID/1000;
        
        if(detector==20){
            emp_type="Owner";
            return emp_type;
        }
        
        return emp_type;
    }
}
