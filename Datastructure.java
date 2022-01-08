
import java.io.IOException;

import java.util.*;

public class Datastructure {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        medicinelinkedlist m = new medicinelinkedlist();
        
        Scanner sc = new Scanner(System.in);
        medicinelinkedlist Medicine = new medicinelinkedlist();
        Medicine.loadData();
        boolean MD = true;
        String x;
        String y;

        while (MD) {
            System.out.println(" Load Data:  1 \n Print All:  2 \n Print Medicine Data:  3 \n Update Medicine:  4 \n Update All:  5 "
                    + "\n New Medicine: 6 \n Delete Medicine: 7 \n Sort by Price: 8 \n Sort by Quantity: 9 \n Sort by Expire Date: 10 "
                    + "\n Sell Medicine: 11 \n Notify user with expire date: 12 "
                    + "\n Save Data: 13 \n If you want exit enter:  Exit  ");
            x = sc.nextLine();
            y = x.toUpperCase();
            if (y.equals("1")) {               
                String Name = sc.nextLine();
                Medicine.loadData();
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("2")) {
                Medicine.printall();
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("3")) {
                System.out.println("Enter Medicine's Name:");
                String Name = sc.next();                
                Medicine.printMedicineData(Name);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
                
            } else if (y.equals("4")) {
                System.out.println("Enter Medicine's Name:");
                String Name = sc.next();               
                Medicine.specificupdate(Name);
                Medicine.printMedicineData(Name);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
                               
            } else if (y.equals("5")) {
                System.out.println("Enter Medicine's Name:");
                String Name = sc.next();               
                Medicine.Update(Name);
                Medicine.printMedicineData(Name);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
                
            } else if (y.equals("6")) {
                System.out.println("Enter New Medicine name: ");
                String Name = sc.next();
                Medicine.addNewMedicine();
                System.out.println("New Medicine added.");
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("7")) {
                System.out.println("Enter the Medicine you want to delete");
                String name=sc.next();
                Medicine.deleteMedicine(name);
                System.out.println("\nSuccessfully deleted a Medicine.");
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
                
            } else if(y.equals("8")){
                System.out.println("Sort by price");
                
                Medicine.sortByPrice();
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
            else if(y.equals("9")){
                System.out.println("Sort by Quantity");
                
                Medicine.sortByQuanitiy();
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
            else if(y.equals("10")){
                System.out.println("Sort by expire date");
                
                Medicine.SortByEpireDate();
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
            else if(y.equals("11")){
                System.out.println("Sell medicine");
                String name=sc.next();
                int quantity=sc.nextInt();
                Medicine.sellMedicine(name, quantity);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
            else if(y.equals("12")){
                System.out.println("Notify user");
                int month=sc.nextInt();
                int year=sc.nextInt();
                Medicine.expireAtDate(month, year);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
            
                else if (y.equals("EXIT")) {
                System.out.println("\n \t THANK YOU !");
                sc.close();
                MD = false;
            } else {
                System.out.println("Please Enter a Valid Order");
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
        }
    }


    }

