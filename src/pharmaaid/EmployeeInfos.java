package pharmaaid;

import java.sql.Date;

public class EmployeeInfos {
    
    int ID;
    String name;
    String type;
    String doj;
    String resDate;
    int salary;
    
    public EmployeeInfos() {
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDoj() {
        return doj;
    }

    public String getResDate() {
        return resDate;
    }

    public int getSalary() {
        return salary;
    }
    
    
    
}
