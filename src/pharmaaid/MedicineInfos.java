package pharmaaid;
public class MedicineInfos {
    
    int medID;
    String medName;
    String type;
    String company;
    String Exp_date;
    String Mfg_date;
    int qty;
    float mg;
    float price;

    public MedicineInfos() {
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setExp_date(String Exp_date) {
        this.Exp_date = Exp_date;
    }

    public void setMfg_date(String Mfg_date) {
        this.Mfg_date = Mfg_date;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setMg(float mg) {
        this.mg = mg;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMedID() {
        return medID;
    }

    public String getMedName() {
        return medName;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getExp_date() {
        return Exp_date;
    }

    public String getMfg_date() {
        return Mfg_date;
    }

    public int getQty() {
        return qty;
    }

    public float getMg() {
        return mg;
    }

    public float getPrice() {
        return price;
    }
    
    
}
