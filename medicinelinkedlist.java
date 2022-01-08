
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mahmoud habshi
 */
public class medicinelinkedlist {

    nodemedicine head = null;


    public void loadData() throws FileNotFoundException, IOException {
        File file;
        file = new File("file path");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;

        while ((st = reader.readLine()) != null) {
            String[] newstring = st.split(";");
            medicine temp = new medicine();

            temp.medicineId = Integer.valueOf(newstring[0]);
            temp.quantity = Integer.valueOf(newstring[1]);
            temp.medicineName = newstring[2];
            temp.place = newstring[3];
            temp.Price = Double.parseDouble(newstring[4]);
            temp.Type = newstring[5];
            temp.Manufacture = newstring[6];
            temp.expireDate.day = Integer.valueOf(newstring[7]);
            temp.expireDate.month = Integer.valueOf(newstring[8]);
            temp.expireDate.year = Integer.valueOf(newstring[9]);
            Addnode(temp);

        }
    }

    public boolean Addnode(medicine data) {
        boolean retval = false;
        nodemedicine node;
        //node=createnode(data);
        node = new nodemedicine(data);
        nodemedicine temp;
        if (node != null) {
            if (head == null) {
                head = node;
            } else {
                temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;

            }
            retval = true;
        }
        return retval;
    }

    public boolean isempty() {
        return (head == null);
    }

    public void printall() {
        if (isempty()) {
            System.out.println("its empty");
        } else {
            nodemedicine temp = head;
            while (temp != null) {
                System.out.println("id:" + temp.data.medicineId + "quantity:" + temp.data.quantity + "medicineName:" + temp.data.medicineName + "place :" + temp.data.place + " Price:" + temp.data.Price + "Type:" + temp.data.Type + "Manufacture:" + temp.data.Manufacture + "expireDtae:" + temp.data.expireDate.day + ":" + temp.data.expireDate.month + ":" + temp.data.expireDate.year);

                temp = temp.next;
            }
        }

    }

    public nodemedicine searchnode(String name) {
        nodemedicine temp = head;
        if (isempty()) {
            System.out.println("its empty");
        } else {

            while (temp != null && !temp.data.medicineName.equalsIgnoreCase(name)) {
                temp = temp.next;

            }
            if (temp == null) {
                System.out.println("the medicine not found");
            }

        }
        return temp;

    }

    public void printMedicineData(String name) {
        nodemedicine temp = searchnode(name);
        if (temp == null) {
            System.out.println("the medicine not exists");
        } else {

            System.out.println("id:" + temp.data.medicineId + "quantity:" + temp.data.quantity + "medicineName:" + temp.data.medicineName + "place :" + temp.data.place + " Price:" + temp.data.Price + "Type:" + temp.data.Type + "Manufacture:" + temp.data.Manufacture + "expireDtae:" + temp.data.expireDate.day + ":" + temp.data.expireDate.month + ":" + temp.data.expireDate.year);
        }

    }

    public boolean specificupdate(String name) {
        Scanner sc = new Scanner(System.in);
        boolean retval = false;
        nodemedicine temp = searchnode(name);
        if (temp == null) {
            return retval;
        } else {
            System.out.println("update medicine:enter the number");
            System.out.println("1-medicineid 2-quantity 3-medicinename 4-place 5-price 6-type 7-manufacture 8-expire date enter 8 for day,9 for month,10 for year");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("enter medicine Id");
                    temp.data.medicineId = sc.nextInt();
                    break;
                case 2:
                    System.out.println("enter quantity");
                    temp.data.quantity = sc.nextInt();
                    break;
                case 3:
                    System.out.println("enter medicine name");
                    temp.data.medicineName = sc.next();
                    break;
                case 4:
                    System.out.println("enter place");
                    temp.data.place = sc.next();
                    break;
                case 5:
                    System.out.println("enter price");
                    temp.data.Price = sc.nextDouble();
                    break;
                case 6:
                    System.out.println("enter type ");
                    temp.data.Type = sc.next();
                    break;
                case 7:
                    System.out.println("enter manufacture");
                    temp.data.Manufacture = sc.next();
                    break;
                case 8:
                    System.out.println("enter expire date for day");
                    temp.data.expireDate.day = sc.nextInt();
                    break;
                case 9:
                    System.out.println("enter expire date for month");
                    temp.data.expireDate.month = sc.nextInt();
                    break;
                case 10:
                    System.out.println("enter expire data for year");
                    temp.data.expireDate.year = sc.nextInt();
                    break;
                default:
                    System.out.println("no process");
                    break;

            }
            retval = true;
        }
        System.out.println("id:\\" + temp.data.medicineId + "  " + "quantity:\\" + temp.data.quantity + "  " + "medicineName:\\" + temp.data.medicineName + "  " + "place :\\" + temp.data.place + "  " + " Price:\\" + temp.data.Price + "  " + "Type:\\" + temp.data.Type + "  " + "Manufacture:\\" + temp.data.Manufacture + "  " + "expireDtae:\\" + " " + temp.data.expireDate.day + " " + ":" + temp.data.expireDate.month + " " + ":" + " " + temp.data.expireDate.year);
        return retval;
    }

    public void Update(String name) {
        Scanner sc = new Scanner(System.in);
        nodemedicine temp = searchnode(name);
        if (temp == null) {
            System.out.println("no medicine");
        } else {
            System.out.println("UpdaTe info.");
            System.out.println("enter medicine Id");
            temp.data.medicineId = sc.nextInt();
            System.out.println("enter quantity");
            temp.data.quantity = sc.nextInt();
            System.out.println("enter medicine name");
            temp.data.medicineName = sc.next();
            System.out.println("enter place");
            temp.data.place = sc.next();
            System.out.println("enter price");
            temp.data.Price = sc.nextDouble();
            System.out.println("enter type ");
            temp.data.Type = sc.next();
            System.out.println("enter manufacture");
            temp.data.Manufacture = sc.next();
            System.out.println("enter expire date for day");
            temp.data.expireDate.day = sc.nextInt();
            System.out.println("enter expire date for month");
            temp.data.expireDate.month = sc.nextInt();
            System.out.println("enter expire data for year");
            temp.data.expireDate.year = sc.nextInt();
        }
        printall();

    }

    public boolean addNewMedicine() {
         boolean retval;
        Scanner sc = new Scanner(System.in);
        medicine temp = new medicine();

        System.out.println("enter medicine information: 1-medicineid 2-quantity 3-medicinename 4-place 5-price 6-type 7-manufacture 8-expiredate enter day,month,year");
        temp.medicineId = Integer.valueOf(sc.next());
        temp.quantity = Integer.valueOf(sc.next());
        temp.medicineName = sc.next();
        temp.place = sc.next();
        temp.Price = sc.nextDouble();
        temp.Type = sc.next();
        temp.Manufacture = sc.next();
        temp.expireDate.day = sc.nextInt();
        temp.expireDate.month = sc.nextInt();
        temp.expireDate.year = sc.nextInt();
        retval = Addnode(temp);
        printall();
        return retval;

    }

    public boolean deleteMedicine(String name) {
         boolean retval = false;
        if (isempty()) {
            System.out.println("there is empty");
        } else {
            if (head != null) {
                if (head.next == null && head.data.medicineName.equalsIgnoreCase(name)) {//only one node
                    head = null;

                } else if (head.data.medicineName.equalsIgnoreCase(name)) {//there is a list but its fistnode
                    head = head.next;
                } else {
                    
     
                    nodemedicine temp = head;
                    while (temp.next != null && !temp.next.data.medicineName.equalsIgnoreCase(name)) {
                        temp = temp.next;

                    }
                    if (temp.next != null) {
                        temp.next = temp.next.next;

                    }
                }
            }
            retval = true;
        }
        printall();
        return retval;
    }

    public void sortByPrice() {
        nodemedicine temp = head;
        nodemedicine index = null;
        medicine r = new medicine();
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            System.out.println("no lists");

        } else {
            System.out.println("1 for ascending,2 for descending");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    while (temp != null) {
                        index = temp.next;

                        while (index != null) {
                            if (temp.data.Price > index.data.Price) {
                                r = temp.data;
                                temp.data = index.data;
                                index.data= r;

                            }
                            index = index.next;
                        }
                        temp = temp.next;

                    }
                    break;
                case 2:
                    while (temp != null) {
                        index = temp.next;

                        while (index != null) {
                            if (temp.data.Price < index.data.Price) {
                                r = temp.data;
                                
                                
                                temp.data = index.data;
                                index.data= r;

                            }
                            index = index.next;
                        }
                        temp = temp.next;

                    }
                    break;
                default:
                    System.out.println("wrong choose");
                    break;
            }
            printall();
        }
    }

    public void sortByQuanitiy() {
        nodemedicine temp = head;
        nodemedicine index = null;
        medicine r;
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            System.out.println("no lists");

        } else {
            System.out.println("1 for ascending,2 for descending");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    while (temp != null) {
                        index = temp.next;

                        while (index != null) {
                            if (temp.data.quantity > index.data.quantity) {
                                r = temp.data;
                                temp.data = index.data;
                                index.data = r;

                            }
                            index = index.next;
                        }
                        temp = temp.next;

                    }
                    break;
                case 2:
                    while (temp != null) {
                        index = temp.next;

                    }
                    while (index != null) {
                        if (temp.data.quantity < index.data.quantity) {
                            r = temp.data;
                            temp.data = index.data;
                            index.data = r;

                        }
                        index = index.next;
                    }
                    temp = temp.next;
                    break;
                default:
                    System.out.println("wrong choose");
                    break;
            }
            printall();
        }

    }

    public void SortByEpireDate() {
        nodemedicine temp = head;
        nodemedicine index = null;
        medicine r;
        Scanner sc = new Scanner(System.in);
        if (head == null) {
            System.out.println("no lists");

        } else {
            System.out.println("1 for ascending,2 for descending");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    while (temp != null) {
                        index = temp.next;

                        while (index != null) {
                            if ( temp.data.expireDate.year > index.data.expireDate.year) {
                                r = temp.data;
                                temp.data = index.data;
                                index.data = r;

                            }
                            if(temp.data.expireDate.month>temp.data.expireDate.month &&temp.data.expireDate.year == index.data.expireDate.year){
                                r = temp.data;
                                temp.data = index.data;
                                index.data = r;
                            }
                            index = index.next;
                        }
                        temp = temp.next;

                    }
                    break;
                case 2:
                    while (temp != null) {
                         index = temp.next;

                        while (index != null) {
                            if ( temp.data.expireDate.year < index.data.expireDate.year) {
                                r = temp.data;
                                temp.data = index.data;
                                index.data = r;

                            }
                            if(temp.data.expireDate.month<temp.data.expireDate.month &&temp.data.expireDate.year == index.data.expireDate.year){
                                r = temp.data;
                                temp.data = index.data;
                                index.data = r;
                            }
                            index = index.next;
                        }
                        temp = temp.next;
                    }
                    break;
                default:
                    System.out.println("wrong choose");
                    break;
            }
            printall();
        
        }

    }

    public void sellMedicine(String name, int Quantity) {
         nodemedicine temp;
        temp = searchnode(name);
        System.out.println("the price of drugs:" + temp.data.Price);
        temp.data.quantity -= Quantity;
       if(temp.data.quantity==0){
          System.out.println("Sold out");
          deleteMedicine(name);
          printall();
       }else{
            System.out.println(" medicinePrice * quanitiy:" + (temp.data.Price) * Quantity);
             System.out.println("id:\\" + temp.data.medicineId + "  " + "quantity:\\" + temp.data.quantity + "  " + "medicineName:\\" + temp.data.medicineName + "  " + "place :\\" + temp.data.place + "  " + " Price:\\" + temp.data.Price + "  " + "Type:\\" + temp.data.Type + "  " + "Manufacture:\\" + temp.data.Manufacture + "  " + "expireDtae:\\" + " " + temp.data.expireDate.day + " " + ":" + temp.data.expireDate.month + " " + ":" + " " + temp.data.expireDate.year);
       }
        
       

    }

    public void expireAtDate(int month, int year) {
        nodemedicine temp = head;
        nodemedicine tmp = head;
        if (isempty()) {
            System.out.println("is empty");
        } else {
            while (temp != null && temp.data.expireDate.month != month) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("no medicine will expire in this month");
            } else {
                System.out.println("medicine name will expire in this month:" + temp.data.medicineName);
            }
            while (tmp != null && temp.data.expireDate.year != year) {
                tmp = tmp.next;

            }
            if (tmp == null) {
                System.out.println("no medicine will expire in this year");
            } else {
                System.out.println("medicine name will expire in this year:" + temp.data.medicineName);
            }
        }

    }
     public int size() {
        int size = 0;
        if (isempty()) {
            return 0;
        } else {
            nodemedicine temp = head;
            while (temp != null) {
                size++;
                temp = temp.next;
            }

        }
        return size;

    }
    
    

    public void SaveData() throws IOException {
        BufferedWriter f_writer;
        f_writer = new BufferedWriter(new FileWriter("file path"));

        nodemedicine temp = head;
        String s = null;
        int x = size();
        String[] f = new String[x];
        while (temp != null) {

            for (int j = 0; j < x; j++) {
                f[j] = "medicine id:" + Integer.toString(temp.data.medicineId) + " quantity" + Integer.toString(temp.data.quantity) + "medicine name:  " + temp.data.medicineName + "place:  " + temp.data.place + "price:" + Double.toString(temp.data.Price) + "price:  " + temp.data.Price + "Type:  " + temp.data.Type + "Manufacture:" + temp.data.Manufacture + "expire date:" + Integer.toString(temp.data.expireDate.day) + ":" + Integer.toString(temp.data.expireDate.month) + ":" + Integer.toString(temp.data.expireDate.year);
                System.out.println(f[j]);
                temp = temp.next;
            }

        }

        // Try block to check for exceptions
        try{           // s = "medicine id:" + Integer.toString(temp.data.medicineId) + " quantity" + Integer.toString(temp.data.quantity) + "medicine name:  " + temp.data.medicineName + "place:  " + temp.data.place + "price:" + Double.toString(temp.data.Price) + "price:  " + temp.data.Price + "Type:  " + temp.data.Type + "Manufacture:" + temp.data.Manufacture + "expire date:" + Integer.toString(temp.data.expireDate.day) + ":" + Integer.toString(temp.data.expireDate.month) + ":" + Integer.toString(temp.data.expireDate.year);
            for (int i = 0; i < x; i++) {
                f_writer.write(f[i]);
                f_writer.newLine();

               
            }
             f_writer.close();
        } // Catch block to handle if exceptions occurs
        catch (IOException e) {

            // Print the exception on console
            // using getMessage() method
            System.out.print(e.getMessage());
        }

    }

    public void exit() throws IOException{
        Scanner sc =new Scanner(System.in);
        System.out.println("if you want to exit enter 1 for yes or 2 for no  ");
        int x=sc.nextInt();
        if(x==1){
            SaveData();
        }else if(x==2){
            System.out.println("ex");
        }
        
    }
    

   
}   


    

        
    




