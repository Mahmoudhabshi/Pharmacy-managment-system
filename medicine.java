/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahmoud habshi
 */
public class medicine {

    public int medicineId;
    public int quantity;
    public String medicineName;
    public String place;
    public double Price;
    public String Type;
    public String Manufacture;
    public date expireDate;

    public medicine(int id, int q, String name, String p, double money, String t, String M, date ex) {
        this.medicineId = id;
        this.quantity = q;
        this.medicineName = name;
        this.place = p;
        this.Price = money;
        this.Type = t;
        this.Manufacture = M;
        this.expireDate = ex;

    }

    public medicine() {
        medicineId = 0;
        quantity = 0;
        medicineName = null;
        place = null;
        Price = 0.0;
        Type = null;
        Manufacture = null;
        expireDate = new date();
    }

    
}
