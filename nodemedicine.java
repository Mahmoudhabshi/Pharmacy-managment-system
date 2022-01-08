/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahmoud habshi
 */
public class nodemedicine {
    public medicine data;
    public nodemedicine next;
    public nodemedicine(medicine d){
        data = d;
        next = null;
    }
    public nodemedicine(){
        data.medicineId=0;
        data.quantity=0;
        data.expireDate.day=0;
        data.Price=0.0;
        data.expireDate.month=0;
        data.expireDate.year=0;
    

    }
}
