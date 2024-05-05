package com.company;
import java.io.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Final_Medical_Store_Management{
    // static variables and arrays
    static boolean change_login = false;   // to check whether password is changed or not
    //login file
    static File login_path=new File("login Path");
    static  File login=new File(login_path,"Login_&_info.txt");
    // static medicine entity files
    static File med_path=new File("MEDICINE MENU FILES");  // (Directory) path of all the files
    static File med_names_file = new File(med_path,"Medicine_Names.txt");
    static File med_formulas_file = new File(med_path,"Medicine_Formulas.txt");
    static File med_companies_file = new File(med_path,"Medicine_companies.txt");
    static File med_prices_file = new File(med_path,"Medicine_Prices.txt");
    static File med_quantities_file = new File(med_path,"Medicine_Quantities.txt");
    static File med_exp_dates_file = new File(med_path,"Expiry_dates.txt");
    static File med_locations_file = new File(med_path,"Med_Locations.txt");
    //  declaring  company static files
    static File com_path=new File("COMPANY MENU FILES");  // (Directory) path of all the files
    static File com_names_file = new File(com_path,"Company_Names.txt");
    static File com_address_file = new File(com_path,"Company_addresses.txt");
    static File com_contact_file = new File(com_path,"Company_contacts.txt");
    static File com_email_file = new File(com_path,"Company_emails.txt");
    //  declaring  Employee static files
    static File employee_path=new File("EMPLOYEE MENU FILES");  // (Directory) path of all the files
    static File emp_names_file = new File( employee_path,"Employee_Names.txt");
    static File emp_address_file = new File( employee_path,"Employees_Addresses.txt");
    static File emp_contact_file = new File( employee_path,"Employees_Contacts.txt");
    static File emp_email_file = new File( employee_path,"Employees_Emails.txt");
    static File emp_cnic_file = new File( employee_path,"Employees_CNIC.txt");
    static File emp_salary_file=new File(employee_path,"Employee_Salaries.txt");
    // main method
    public static void main(String args[]) throws IOException {
        System.out.println("\t\t\t\t\t\t\t==============================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t  M E D I C A L   S T O R E   M A N A N G E M E N T ");
        System.out.println("\t\t\t\t\t\t\t==============================================================================================");
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      W E L L C O M E ");
        System_Login(change_login);
        main_menu();    // Function call for main menu
    }
    // Main Menu
    public static void main_menu() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t -------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t -------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t M A I N   M E N U ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t -------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t -------------------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("|1. MEDICINE MENU.............PRESS 1|\n|2. COMPANY MENU..............PRESS 2|\n|3. SALES MENU ......." +
                "........PRESS 3|\n|4. EMPLOYEE MENU ............PRESS 4|\n" +
                "|5. CHANGE PASSWORD ..........PRESS 5|\n|6. LOG OUT ..................PRESS 6|\n" +
                "|7. EXIT .....................PRESS 7|");
        System.out.println("--------------------------------------");
        String choice;
        while (true) {
            System.out.println("Enter Your Choice to Continue:");
            choice = input.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5")
                    || choice.equals("6")  || choice.equals("7")))
                System.out.println("INVALID ENTRY !");
            else
                break;
        }
        if (choice.equals("1"))
            MEDICINE();
        else if (choice.equals("2"))
            MED_COMPANY();
        else if (choice.equals("3"))
            SALES();
        else if (choice.equals("6")) {
            change_login=false;
            System_Login(change_login);
            main_menu();
        } else if (choice.equals("4"))
            EMPLOYEES();
        else if (choice.equals("5")) {
            change_login = true; //    it means user wants to change password
            System_Login(change_login);
            main_menu();
        }
        else if (choice.equals("7")) {
            System.exit(0);
        }
    }
    //Medicine Entity
    public static void MEDICINE() throws IOException{                  //Function Header
        Scanner input = new Scanner(System.in);
        if(!med_path.exists())
            med_path.mkdir(); // to create directory to store all files in it
        try {
            if(!med_names_file.exists()){
                med_names_file.createNewFile();
                med_companies_file.createNewFile();
                med_formulas_file.createNewFile();
                med_exp_dates_file.createNewFile();
                med_prices_file.createNewFile();
                med_quantities_file.createNewFile();
                med_locations_file.createNewFile();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        ///////////////////////////////////
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   M E D I C I N E   M E N U ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("-------------------------------------");
        System.out.println("|1. Add Medicine .............Press 1|\n|2. Search Medicine ..........Press 2|\n" +
                "|3. Delete Medicine ..........Press 3|\n|4. Update Medicine ..........Press 4|\n" +
                "|5. View All Stock ...........Press 5|\n|6. Same Formula Medicines ...Press 6|\n" +
                "|7. Same Company Medicines ...Press 7|\n" +
                "|8. Expired Medicines ........Press 8|\n|9. Main Menu ................Press M|\n" +
                "|e. Exit .....................Press E|");
        System.out.println("-------------------------------------");
        String med_choice;
        while (true) {
            System.out.println("\nENTER YOUR CHOICE TO CONTINUE:");
            med_choice = input.nextLine();
            if (!(med_choice.equals("1") || med_choice.equals("2") || med_choice.equals("3") || med_choice.equals("4")
                    || med_choice.equals("5") || med_choice.equals("6") || med_choice.equals("7")
                    || med_choice.equals("8") || med_choice.equalsIgnoreCase("m") || med_choice.equalsIgnoreCase("e")))
                print_box("INVALID ENTRY! INPUT AGAIN");
            else
                break;
        }
// Adding medicines
        if (med_choice.equals("1")) {
            Add_Medicines();  // function call
            medicine_master_file();  // function call
        }
// searching  medicine
        if (med_choice.equals("2")) {
            Search_Medicines(); // function call
        }
// Deleting  medicine
        if (med_choice.equals("3")) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  DELETE MEDICINES ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            String medicine_name;
            do {
                System.out.println("\nENTER MEDICINE NAME TO DELETE FROM STOCK:");
                medicine_name = input.nextLine();
            } while (medicine_name.isEmpty());
            boolean result = Del_Medicine(medicine_name);   // function call
            if (result) {
                print_box(medicine_name + " Medicine has been Deleted from the Record!");
            }
            else
                print_box("------- "+medicine_name+ " Medicine NOT Found In Stock -------");
        }
// Update Medicines
        if (med_choice.equals("4")) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  UPDATE MEDICINE ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            String medName;
            do {
                System.out.println("ENTER MEDICINE NAME TO UPDATE :");
                medName = input.nextLine();
                if (medName.isEmpty())
                    print_box("EMPTY INPUT NOT ALLOWED");
            } while (medName.isEmpty());
            Update_Medicine(medName);
            medicine_master_file();  // function call
        }
// Viewing all Stock
        if (med_choice.equals("5"))
            Medicine_Stock();
// Medicines having Same Formulas
        if (med_choice.equals("6"))
            Same_Formula_Medicines();
        if (med_choice.equals("7"))
            Same_Company_Medicines();
// Expired Medicines
        if (med_choice.equals("8"))
            Expired_Medicines_Check();
// to go to main menu
        if (med_choice.equalsIgnoreCase("m"))
            main_menu();
// Exit
        if (med_choice.equalsIgnoreCase("e")){
            System.out.println("Exited!");
            System.exit(0);
        }
        System.out.println("\n===============================");
        System.out.println("| 1. GO BACK  ....... PRESS B |\n| 2. MAIN MENU....... PRESS M |\n| 3. EXIT     ....... PRESS E |");
        System.out.println("===============================");
        String back = "";
        while (true) {
            System.out.println("ENTER YOUR CHOICE TO CONTINUE:");
            back = input.nextLine();
            if (!(back.equals("b") || back.equals("B") || back.equals("m") || back.equals("M")
                    || back.equals("e") || back.equals("E")))
                print_box("INVALID ENTRY!");
            else
                break;
        }
        if (back.equalsIgnoreCase("b"))
            MEDICINE();
        else if (back.equalsIgnoreCase("m"))
            main_menu();
        else
            System.exit(0);
    }
    // COMPANY ENTITY
    public static void MED_COMPANY()throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    C O M P A N Y  M E N U ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("-------------------------------------");
        System.out.println("|1. Add Company .............Press 1|\n|2. Search Company ..........Press 2|\n" +
                "|3. Delete Company ..........Press 3|\n|4. Update Company ..........Press 4|" +
                "\n|5. View All Companies ......Press 5|"+
                "\n|6. Main Menu ...............Press M|\n|7. Exit ....................Press E|");
        System.out.println("-------------------------------------");
        ///////////////////////////////////////////
        if(!com_path.exists())
            com_path.mkdir();
        if(!com_names_file.exists()){
            com_names_file.createNewFile();
            com_contact_file.createNewFile();
            com_address_file.createNewFile();
            com_email_file.createNewFile();
        }
        /////////////////////////////////////////
        String choice;
        while (true) {
            System.out.println("ENTER YOUR CHOICE TO CONTINUE:");
            choice = input.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
                    || choice.equals("5") || choice.equalsIgnoreCase("m") || choice.equalsIgnoreCase("e")))
                print_box("INVALID ENTRY ! INPUT AGAIN");
            else
                break;
        }
        if (choice.equals("1")) {
            Add_Company();  // function call
        }
// searching  Company
        if (choice.equals("2"))
            Search_Company();
// Deleting  Company
        if (choice.equals("3"))
            Delete_Company();
// Update Company
        if (choice.equals("4"))
            Update_Company();
// Viewing all Companies
        if (choice.equals("5"))
            Company_List();
// to go to main menu
        if (choice.equalsIgnoreCase("m"))
            main_menu();
// Exit
        if (choice.equalsIgnoreCase("e")) {
            print_box("Exited! From the System");
            System.exit(0);
        }
        System.out.println("------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------");
        System.out.println("\n===============================");
        System.out.println("| 1. GO BACK  ....... PRESS B |\n| 2. MAIN MENU....... PRESS M |\n| 3. EXIT     ....... PRESS E |");
        System.out.println("===============================");
        String back = "";
        while (true) {
            System.out.println("ENTER YOUR CHOICE:");
            back = input.nextLine();
            if (!(back.equals("b") || back.equals("B") || back.equals("m") || back.equals("M")
                    || back.equals("e") || back.equals("E")))
                print_box("INVALID ENTRY!");
            else
                break;
        }
        if (back.equalsIgnoreCase("b"))
            MED_COMPANY();
        else if (back.equalsIgnoreCase("m"))
            main_menu();
        else
            System.exit(0);
    }
    // EMPLOYEE entity
    public static void EMPLOYEES() throws IOException{
        Scanner input = new Scanner(System.in);
        // creating Files and path
        if(!employee_path.exists())
            employee_path.mkdir();
        if(!emp_names_file.exists()){
            emp_names_file.createNewFile();
            emp_contact_file.createNewFile();
            emp_email_file.createNewFile();
            emp_address_file.createNewFile();
            emp_cnic_file.createNewFile();
            emp_salary_file.createNewFile();
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  E M P L O Y E E   M E N U ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("-------------------------------------");
        System.out.println("|1. CREATE EMPLOYEE .........Press 1|\n|2. REMOVE EMPLOYEE .........Press 2|" +
                "\n|3. EMPLOYEE LIST ...........Press 3|\n|4. SEARCH EMPLOYEE .........Press 4|" +
                "\n|5. Main Menu ...............Press M|\n|6. Exit ....................Press E|");
        System.out.println("-------------------------------------");
        String choice;
        while (true) {
            System.out.println("ENTER YOUR CHOICE TO CONTINUE:");
            choice = input.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
                    || choice.equalsIgnoreCase("m") || choice.equalsIgnoreCase("e")))
                print_box("INVALID ENTRY!");
            else
                break;
        }
        String employee_num; // to add number of employees
        if (choice.equals("1")) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ADD EMPLOYEES");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            //....................................................................................//
            BufferedWriter emp_names=new BufferedWriter(new FileWriter(emp_names_file,true));
            BufferedWriter emp_addresses=new BufferedWriter(new FileWriter(emp_address_file,true));
            BufferedWriter emp_contacts=new BufferedWriter(new FileWriter(emp_contact_file,true));
            BufferedWriter emp_emails=new BufferedWriter(new FileWriter(emp_email_file,true));
            BufferedWriter emp_cnics=new BufferedWriter(new FileWriter(emp_cnic_file,true));
            BufferedWriter emp_salaries=new BufferedWriter(new FileWriter(emp_salary_file,true));
            //....................................................................................//
            String Employee_num = "";
            boolean check = true;
            do {
                try {
                    System.out.println("HOW MANY EMPLOYEES YOU WANT TO ADD:");
                    Employee_num = input.nextLine();
                    Integer.parseInt(Employee_num);
                    check = false;
                } catch (NumberFormatException ex) {
                    print_box("ENTER AN INTEGER VALUE");
                }
            } while (check);
            for (int x = 0; x < Integer.parseInt(Employee_num); x++) {
                //.........................................................
                print_box("----- Enter Details of EMPLOYEE (" + (x + 1) + ") -----");
                boolean name_check = true;
                String emp_name="";
                do {
                    try {
                        System.out.println("EMPLOYEE NAME:");
                        emp_name = input.nextLine();
                        Integer.parseInt(emp_name);
                        print_box("INVALID ENTRY! INPUT AGAIN");
                    } catch (NumberFormatException ex) {
                        name_check = false;
                    }
                } while (name_check);
                emp_names.write(emp_name+",,");  // appending data
                //................................................................
                BufferedReader br=new BufferedReader(new FileReader(emp_cnic_file));
                String str;
                String[] all_cnic=new String[100];
                while ((str=br.readLine())!=null){
                    all_cnic=str.split(",,");
                }
                br.close();
                String emp_cnic="";
                boolean cnicIntCheck = true;
                do {
                    try {
                        while (true) {
                            System.out.println("EMPLOYEE CNIC (FORMAT: 00000-0000000-0):");
                            emp_cnic = input.nextLine();
                            boolean Check = isCnicValid( emp_cnic);
                            if(Check){
                                for(int i=0;i<all_cnic.length;i++){
                                    if(all_cnic[i]!=null)
                                        if(all_cnic[i].equals(emp_cnic)) {
                                            print_box("THIS CNIC ALREADY EXISTS IN OUR RECORD");
                                            Check = false;
                                        }
                                }
                            }
                            if (Check == true)
                                break;
                        }
                        String[] cnic_parts =  emp_cnic.split("-");
                        Integer.parseInt(cnic_parts[0]);
                        Integer.parseInt(cnic_parts[1]);
                        Integer.parseInt(cnic_parts[2]);
                        cnicIntCheck = false;
                    } catch (NumberFormatException ex) {
                        print_box("INVALID CNIC,ENTER ONLY NUMBERS");
                        cnicIntCheck = true;
                    }
                } while (cnicIntCheck);
                emp_cnics.write(emp_cnic+",,");  // appending data
                //...................................................................
                String emp_address="";
                do {
                    System.out.println("EMPLOYEE ADDRESS:");
                    emp_address = input.nextLine();
                    if(emp_address.isEmpty())
                        print_box("Empty Input is Not Allowed !");
                } while (emp_address.isEmpty());
                emp_addresses.write(emp_address+",,");  // appending data
                //..................................................................
                String emp_email="";
                while (true) {
                    System.out.println("EMPLOYEE EMAIL:");
                    emp_email = input.nextLine();
                    boolean Check = isValidEmail(emp_email);
                    if (Check == true)
                        break;
                }
                emp_emails.write(emp_email+",,");  // appending data to file
                //................................................................
                boolean phoneIntCheck = true;
                String emp_contact="";
                do {
                    try {
                        while (true) {
                            System.out.println("EMPLOYEE CONTACT NO (FORMAT: 0000-0000000):");
                            emp_contact = input.nextLine();
                            boolean Check = isPhoneValid(emp_contact);
                            if (Check == true)
                                break;
                        }
                        String[] phone_parts = emp_contact.split("-");
                        Integer.parseInt(phone_parts[0]);
                        Integer.parseInt(phone_parts[1]);
                        phoneIntCheck = false;
                    } catch (NumberFormatException ex) {
                        print_box("INVALID CONTACT NO,ENTER ONLY NUMBERS");
                        phoneIntCheck = true;
                    }
                } while (phoneIntCheck);
                emp_contacts.write(emp_contact+",,"); // appending data to file
                //...............................................................
                String emp_salary="";
                boolean Check=false;
                do{
                    try {
                        System.out.println("EMPLOYEE SALARY:");
                        emp_salary = input.nextLine();
                        Integer.parseInt(emp_salary);
                        Check=true;
                        if(Integer.parseInt(emp_salary)<=0){
                            print_box("NEGATIVE OR NULL VALUE IS NOT ALLOWED");
                            Check=false;}
                    }
                    catch (NumberFormatException ex){
                        print_box("INVALID INPUT, ENTER ONLY NUMBERS!");
                        Check=false;
                    }
                }while(!Check);
                emp_salaries.write(emp_salary+",,");
                //......................................................................
                print_box(emp_name + " SUCCESSFULLY ADDED IN EMPLOYEE RECORD");
            }
            // closing all Files
            emp_names.close();
            emp_addresses.close();
            emp_cnics.close();
            emp_contacts.close();
            emp_emails.close();
            emp_salaries.close();
        }
//''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
// client list
        if (choice.equals("3")) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =====================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  EMPLOYEE LIST ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =====================================");
            System.out.println("\n\n-------------------------------------------------------------------------" +
                    "------------------------------------------------------------------------------------");
            System.out.println("EMPLOYEE NAMES\t\t\tEMPLOYEE-ID\t\t\t\t\tEMPLOYEE ADDRESSES\t\t\t\t\t\tEMAILS\t\t\t\t\t\t\t\t   CONTACT NO\t\t SALARY");
            System.out.println("-------------------------------------------------------------------------" +
                    "------------------------------------------------------------------------------------");
            /////////////////////////////////////////////////////////////////////////////////////////
            BufferedReader emp_names=new BufferedReader(new FileReader(emp_names_file));
            BufferedReader emp_contacts=new BufferedReader(new FileReader(emp_contact_file));
            BufferedReader emp_addresses=new BufferedReader(new FileReader(emp_address_file));
            BufferedReader emp_emails=new BufferedReader(new FileReader(emp_email_file));
            BufferedReader emp_cnics=new BufferedReader(new FileReader(emp_cnic_file));
            BufferedReader emp_salaries=new BufferedReader(new FileReader(emp_salary_file));
            /////////////////////////////////////////////////////////////////////////////////////////
            boolean search = false; // to find that user exits or not
            // arrays to store data from files
            String[] name_array=null;
            String[] address_array=null;
            String[] contact_array=null;
            String[] email_array=null;
            String[] cnic_array=null;
            String[] salary_array=null;
            String names;
            while ((names=emp_names.readLine())!=null) {
                search=true;  // it means employee list is not empty
                name_array = names.split(",,");
                String contacts = emp_contacts.readLine();
                contact_array = contacts.split(",,");
                String addresses = emp_addresses.readLine();
                address_array = addresses.split(",,");
                String emails = emp_emails.readLine();
                email_array = emails.split(",,");
                String cnics = emp_cnics.readLine();
                cnic_array = cnics.split(",,");
                String salary = emp_salaries.readLine();
                salary_array = salary.split(",,");
                for (int i = 0; i < name_array.length; i++) {
                    System.out.format("%-11s%-11s%-11s%-14s%-24s%-15s%-25s%-15s%-15s%-5s%-5s%n"
                            , name_array[i],"", cnic_array[i]
                            ,"", address_array[i],"   ", email_array[i],"", contact_array[i],"",salary_array[i]);
                }
            }
            if (search == false)
                print_box("----- Currently, The Employee Record is Empty -----");
            // closing all files
            emp_addresses.close();
            emp_contacts.close();
            emp_emails.close();
            emp_names.close();
            emp_cnics.close();
            emp_salaries.close();
        }
        //....................................................................................................................
        // searching  employee
        if (choice.equals("4")) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  SEARCH EMPLOYEE ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
            /////////////////////////////////////////////////////////////////////////////////////////
            BufferedReader emp_names=new BufferedReader(new FileReader(emp_names_file));
            BufferedReader emp_contacts=new BufferedReader(new FileReader(emp_contact_file));
            BufferedReader emp_addresses=new BufferedReader(new FileReader(emp_address_file));
            BufferedReader emp_emails=new BufferedReader(new FileReader(emp_email_file));
            BufferedReader emp_cnics=new BufferedReader(new FileReader(emp_cnic_file));
            BufferedReader emp_salaries=new BufferedReader(new FileReader(emp_salary_file));
            /////////////////////////////////////////////////////////////////////////////////////////
            String search_employee;
            do {
                System.out.println("\nENTER NAME OF EMPLOYEE TO SEARCH:");
                search_employee = input.nextLine();
            } while (search_employee.isEmpty());

            boolean search = false; // to find that user exits or not
            // arrays to store data from files
            String[] name_array=null;
            String[] address_array=null;
            String[] contact_array=null;
            String[] email_array=null;
            String[] cnic_array=null;
            String[] salary_array=null;
            String names;
            while ((names=emp_names.readLine())!=null) {
                name_array = names.split(",,");
                String contacts = emp_contacts.readLine();
                contact_array = contacts.split(",,");
                String addresses = emp_addresses.readLine();
                address_array = addresses.split(",,");
                String emails = emp_emails.readLine();
                email_array = emails.split(",,");
                String cnics = emp_cnics.readLine();
                cnic_array = cnics.split(",,");
                String salaries = emp_salaries.readLine();
                salary_array = salaries.split(",,");
                for (int i = 0; i < name_array.length; i++) {
                    if (search_employee.equalsIgnoreCase(name_array[i])) {
                        search = true;  // it means employee found
                        print_box("------ " + search_employee + " Employee EXISTS in Record ------");
                        System.out.println("Employee Name:" + "\t\t\t" + name_array[i]);
                        System.out.println("Employee-CNIC:" + "\t\t\t" + cnic_array[i]);
                        System.out.println("Contact No:   " + "\t\t\t" + contact_array[i]);
                        System.out.println("Email:        " + "\t\t\t" + email_array[i]);
                        System.out.println("SALARY:       " + "\t\t\t" + salary_array[i]);
                    }}}
            if (search == false)
                print_box("----- " + search_employee+ " Employee not Found in Record -----");
            emp_cnics.close();
            emp_contacts.close();
            emp_addresses.close();
            emp_emails.close();
            emp_names.close();
            emp_salaries.close();
        }
// Removing user
        if (choice.equals("2")) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  REMOVE EMPLOYEE ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
            String remove_employee;
            do {
                System.out.println("\nENTER EMPLOYEE NAME TO REMOVE FROM EMPLOYEES RECORD:");
                remove_employee = input.nextLine();
            } while (remove_employee.isEmpty());
            // creating temporary files to store data in it for deletion
            File temp_name_file=new File(employee_path,"Temp_name_file.txt");
            File temp_address_file=new File(employee_path,"Temp_address_file.txt");
            File temp_email_file=new File(employee_path,"Temp_email_file.txt");
            File temp_contact_file=new File(employee_path,"temp_contact_file.txt");
            File temp_salary_file=new File(employee_path,"temp_salary_file.txt");
            File temp_cnic_file=new File(employee_path,"temp_cnic_file.txt");
            //.........................................................................
            BufferedReader emp_names=new BufferedReader(new FileReader(emp_names_file));
            BufferedReader emp_addresses=new BufferedReader(new FileReader(emp_address_file));
            BufferedReader emp_emails=new BufferedReader(new FileReader(emp_email_file));
            BufferedReader emp_contacts=new BufferedReader(new FileReader(emp_contact_file));
            BufferedReader emp_cnics=new BufferedReader(new FileReader(emp_cnic_file));
            BufferedReader emp_salaries=new BufferedReader(new FileReader(emp_salary_file));
            //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
            if(!temp_name_file.exists()){
                temp_name_file.createNewFile();
                temp_address_file.createNewFile();
                temp_contact_file.createNewFile();
                temp_email_file.createNewFile();
                temp_cnic_file.createNewFile();
                temp_salary_file.createNewFile();
            }
            //........................................................................
            PrintWriter temp_names=new PrintWriter(temp_name_file);
            PrintWriter temp_addresses=new PrintWriter(temp_address_file);
            PrintWriter temp_emails=new PrintWriter(temp_email_file);
            PrintWriter temp_contacts=new PrintWriter(temp_contact_file);
            PrintWriter temp_salaries=new PrintWriter(temp_salary_file);
            PrintWriter temp_cnics=new PrintWriter(temp_cnic_file);
            //............................................................................
            String names;
            String[] name_array=null;
            String[] address_array=null;
            String[] email_array=null;
            String[] contact_array=null;
            String[] salary_array=null;
            String[] cnic_array=null;
            int index=0;
            int var=0;
            boolean found = false;
            int count=0;
            int counter=0;
            boolean loop=true;
            ///...........................
            while((names=emp_names.readLine())!=null) {
                name_array = names.split(",,");
                String addresses = emp_addresses.readLine();
                address_array = addresses.split(",,");
                String emails = emp_emails.readLine();
                email_array= emails.split(",,");
                String contacts = emp_contacts.readLine();
                contact_array = contacts.split(",,");
                String salaries = emp_salaries.readLine();
                salary_array = salaries.split(",,");
                String cnics = emp_cnics.readLine();
                cnic_array = cnics.split(",,");
                for(String a:name_array) {
                    if(var==0){
                        if(remove_employee.equalsIgnoreCase(a)) {
                            found=true;
                            index=count;
                            loop = false;
                            var++;}
                        else
                            temp_names.write(a+",,");
                    }
                    else if(!remove_employee.equalsIgnoreCase(a) || loop==false)
                        temp_names.write(a + ",,");
                    count++;
                }
                for(int i=0;i<name_array.length;i++){
                    if(index!=counter || found==false) { // found=false in case if medicine not found, to write other things
                        temp_addresses.write(address_array[i] + ",,");
                        temp_emails.write(email_array[i] + ",,");
                        temp_contacts.write(contact_array[i]+",,");
                        temp_salaries.write(salary_array[i]+",,");
                        temp_cnics.write(cnic_array[i]+",,");
                    }
                    counter++; // incrementing
                }
            }
            emp_names.close();
            emp_emails.close();
            emp_addresses.close();
            emp_contacts.close();
            emp_cnics.close();
            emp_salaries.close();
            //////////////////////
            temp_names.close();
            temp_contacts.close();
            temp_emails.close();
            temp_addresses.close();
            temp_cnics.close();
            temp_salaries.close();
            //'''''''''''''''''''''''
            emp_names_file.delete();
            emp_address_file.delete();
            emp_email_file.delete();
            emp_contact_file.delete();
            emp_salary_file.delete();
            emp_cnic_file.delete();
            //.......................
            // renaming all temporary files to original files
            temp_name_file.renameTo(emp_names_file);
            temp_address_file.renameTo(emp_address_file);
            temp_email_file.renameTo(emp_email_file);
            temp_contact_file.renameTo(emp_contact_file);
            temp_cnic_file.renameTo(emp_cnic_file);
            temp_salary_file.renameTo(emp_salary_file);
            if (found ==true)
                print_box(remove_employee + " Employee has been Deleted from Record!");
            else
                print_box(remove_employee+ " Employee Not found in Record!");
        }
        if (choice.equalsIgnoreCase("m"))
            main_menu();
        if (choice.equalsIgnoreCase("e")) {
            print_box("Exited!");
            System.exit(0);
        }
        System.out.println("------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------");
        System.out.println("\n===============================");
        System.out.println("| 1. GO BACK  ....... PRESS B |\n| 2. MAIN MENU....... PRESS M |\n| 3. EXIT     ....... PRESS E |");
        System.out.println("===============================");
        String back = "";
        while (true) {
            System.out.println("ENTER YOUR CHOICE:");
            back = input.nextLine();
            if (!(back.equals("b") || back.equals("B") || back.equals("m") || back.equals("M")
                    || back.equals("e") || back.equals("E")))
                print_box("INVALID ENTRY!");
            else
                break;
        }
        if (back.equalsIgnoreCase("b"))
            EMPLOYEES();
        else if (back.equalsIgnoreCase("m"))
            main_menu();
        else
            System.exit(0);
    }
    // SALES
    public static void SALES() throws IOException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     S A L E S   M E N U ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t      ==================================================");
        Scanner input = new Scanner(System.in);
        System.out.println("\n------------------------------------");
        System.out.println("| 1. NEW SALE .............Press 1 |\n| 2. SALES RECORD .........Press 2 |\n" +
                "| 3. MAIN MENU ............Press M |\n| 4. EXIT .................Press E |");
        System.out.println("------------------------------------");
        String choice;
        while (true) {
            System.out.println("Enter Your Choice to Continue:");
            choice = input.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equalsIgnoreCase("m") || choice.equalsIgnoreCase("e")))
                print_box("INVALID ENTRY !");
            else
                break;
        }
        // declaring arrays
        String[] sell_item_names = new String[10];
        int[] sell_item_prices = new int[10];
        String[] sell_item_quantity = new String[10];
        String[] sell_item_category = new String[10];
        int[] product_prices = new int[10]; // to store price of medicine to be sold
        String customer_name = "";
        //................................
        if (choice.equals("1")) {
            // checking the medicine stock is empty or not
            if(!med_names_file.exists()) {
                print_box("------------ Sorry, The Medicine Stock is Empty -------------");
                main_menu();
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =======================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  N E W  S A L E S ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =======================================");
            //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
            BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
            BufferedReader med_prices=new BufferedReader(new FileReader(med_prices_file));
            BufferedReader med_quantities=new BufferedReader(new FileReader(med_quantities_file));
            String names;
            String remaining_quantity="";  // remaing qauantity of soldmedicine
            String[] med_names_array=new String[100];
            String[] med_prices_array=new String[100];
            String[] med_quantity_array=new String[100];
            while ((names=med_names.readLine())!=null){
                med_names_array=names.split(",,");
                String prices=med_prices.readLine();
                med_prices_array=prices.split(",,");
                String quantity=med_quantities.readLine();
                med_quantity_array=quantity.split(",,");
            }
            //............................................................................
            // checking how many items are availbe for sale
            int item_count=0;
            for(int i=0;i<med_names_array.length;i++){
                if(med_names_array[i]!=null)
                    item_count+=1;
            }
            //............................................................................
            boolean int_check = true;
            int grand_total = 0;
            String items_num = ""; // to sell number of items
            do {
                try {
                    System.out.println("Enter Number of Items to sell:");
                    items_num = input.nextLine();
                    Integer.parseInt(items_num);
                    int_check = false;
                    if(Integer.parseInt(items_num)>item_count || Integer.parseInt(items_num)<=0) {
                        print_box("NOT ENOUGH ITEMS ARE AVAILABE FOR SALE");
                        System.out.println("----------------------------");
                        System.out.println("|1.SALES MENU ......PRESS 1|\n|2.CONTINUE  .......PRESS 2|");
                        System.out.println("----------------------------");
                        System.out.println("ENTER YOUR CHOICE:");
                        String Choice = input.nextLine();
                        if (!(Choice.equals("1") || Choice.equals("2")))
                            print_box("INVALID ENTRY! INPUT AGAIN");
                        if (Choice.equals("1"))
                            SALES();
                        int_check = true; // to continue loop
                    }
                } catch (NumberFormatException ex) {
                    print_box("INVALID INPUT, ENTER INTEGER VALUE");
                }
            } while (int_check);
            int count;  // for loop
            int index = 0;// stored medicine index
            print_box("Enter The Following Details to sell Medicine!");
            boolean name_check=true;
            do {
                try {
                    System.out.print("CUSTOMER NAME:");
                    customer_name = input.nextLine();
                    Integer.parseInt(customer_name);
                    print_box("INVALID INPUT");
                }
                catch (NumberFormatException ex){
                    name_check=false;
                }

            } while (name_check);
            for (count = 0; count < Integer.parseInt(items_num); count++) {
                print_box("------ Enter Details of Medicine (" + (count + 1) + ") ------");
                boolean med_found = false;
                do {
                    System.out.print("ENTER PRODUCT NAME : ");
                    sell_item_names[count] = input.nextLine();
                    // to check medicine exits in stock or not
                    for (int i = 0; i < med_names_array.length; i++) {
                        if (sell_item_names[count].equalsIgnoreCase(med_names_array[i])) {
                            med_found = true;
                            index = i;
                            break;
                        }
                    }
                    if (med_found == false) {
                        print_box("Medicine " + sell_item_names[count] + " Not Found in Our Stock!");
                        System.out.println("----------------------------");
                        System.out.println("|1.SALES MENU ......PRESS 1|\n|2.CONTINUE  .......PRESS 2|");
                        System.out.println("----------------------------");
                        String Choice;
                        while (true) {
                            System.out.println("ENTER YOUR CHOICE :");
                            Choice = input.nextLine();
                            if(!(Choice.equals("1") || Choice.equals("2")))
                                print_box("INVALID ENTRY! INPUT AGAIN");
                            else
                                break;
                        }
                        if(Choice.equals("1"))
                            SALES();
                    }
                } while (med_found == false);
                /////////////////////////////////////////////////////////////////////
                // checking whether enough quantity of medicine exists or not
                boolean checkIntQuantity = true;  // to check quanity is integer value
                boolean check_quantity = true;   // to check enough quantity found or not
                do {
                    do {
                        try {
                            System.out.print("ENTER MEDICINE QUANTITY : ");
                            sell_item_quantity[count] = input.nextLine();
                            Integer.parseInt(sell_item_quantity[count]);
                            checkIntQuantity = false;
                            if(Integer.parseInt(sell_item_quantity[count])<=0){
                                checkIntQuantity=true;
                                print_box("NEGATIVE OR NULL VALUE IS NOT ACCEPTED");
                            }
                        } catch (NumberFormatException ex) {
                            print_box("INVALID INPUT, ENTER INTEGER VALUE");
                            checkIntQuantity = true;
                        }
                    } while (checkIntQuantity);
                    if ((Integer.parseInt(sell_item_quantity[count]) > Integer.parseInt(med_quantity_array[index]))) {
                        print_box("Not Enough Quantity of Medicine " + sell_item_names[count] + " is AVAILABLE!");
                        System.out.println("Available Quantity is " + med_quantity_array[index]);
                        check_quantity = true;
                    } else
                        check_quantity = false;
                } while (check_quantity);
                //////////////////////////////////////////////////////////////////////
                do {
                    System.out.print("PRODUCT CATEGORY : ");
                    sell_item_category[count] = input.nextLine();
                } while ((sell_item_category[count]).isEmpty());
                // Finding price of product from medicine entity
                for (int x = 0; x < med_names_array.length; x++) {
                    if (sell_item_names[count].equalsIgnoreCase(med_names_array[x])) {
                        index = x;
                        sell_item_prices[count] = Integer.parseInt(med_prices_array[index]);
                        break;
                    }
                }
                //......................................
                int discount=0;
                boolean check=true;
                do {
                    try {
                        System.out.print("Enter Percentage Discount : ");
                        discount = input.nextInt();
                        check=false;
                        if(discount<0){print_box("INVALID ENTRY,INPUT AGAIN!");
                            check=true;}}
                    catch (InputMismatchException ex){
                        print_box("INVALID INPUT, ENTER INTEGER VALUE");
                        input.nextLine();}
                }while (check);
                //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
                // to subtract sold quantity from stock
                int sub_quantity = Integer.parseInt(med_quantity_array[index]) - Integer.parseInt(sell_item_quantity[count]);
                remaining_quantity= Integer.toString(sub_quantity);
                File temp_quantity_file=new File(med_path,"Temp_med_Quantity.txt");
                if(!temp_quantity_file.exists())
                    temp_quantity_file.createNewFile();
                BufferedWriter new_quantity=new BufferedWriter(new FileWriter(temp_quantity_file));
                for(int i=0;i<med_quantity_array.length;i++){
                    if(i==index)
                        new_quantity.write(remaining_quantity+",,");
                    else
                        new_quantity.write(med_quantity_array[i]+",,");
                }
                // closing all file
                new_quantity.close();
                med_quantities.close();
                med_prices.close();
                med_names.close();
                med_quantities_file.delete();
                temp_quantity_file.renameTo(med_quantities_file);
                // to delete medicine if its quantity is 0
                if(remaining_quantity.equals("0"))
                    Del_Medicine(med_names_array[index]);
                //............................................................................
                // calculating price
                int original_price = (Integer.parseInt(med_prices_array[index])) * (Integer.parseInt(sell_item_quantity[count]));
                int discount_price=(discount*original_price)/100;
                int final_price=original_price-discount_price;
                //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
                product_prices[count]=final_price;  // storing product price to array for record
            }
            // calculating grand total
            for (int i = 0; i < product_prices.length; i++) {
                grand_total += product_prices[i];
            }
            // for extarcting store name from files
            BufferedReader br=new BufferedReader(new FileReader(login));
            String[] info = null;
            String str;
            while ((str = br.readLine()) != null) {
                info= str.split(",,");
            }
            System.out.println("\n=======================================================================================");
            System.out.println("\t\t\t\t\t\t\t\t "+ info[2]);
            System.out.println("=======================================================================================");
            System.out.println("ADDRESS: "+ info[4]);
            System.out.println("CONTACT: "+info[3]);
            System.out.println("EMAIL  : "+info[5]);
            System.out.println("BILL TO: " + customer_name);
            System.out.println("***************************************************************************************");
            System.out.println("| ITEM NAME\t\t\t CATEGORY\t\t\tPRICE(UNIT)\t\t\tQUANTITY\t\t  TOTAL   |");
            System.out.println("***************************************************************************************");
            for (int i = 0; i < sell_item_names.length; i++) {
                if (sell_item_names[i] != null)
                    System.out.format("%-11s%-11s%-11s%-11s%-11s%-9s%-9s%-7s%-7s%n", sell_item_names[i], "", sell_item_category[i], "", sell_item_prices[i], "",
                            sell_item_quantity[i], "", product_prices[i]);
            }
            System.out.println("\n\n\n___________________");
            System.out.println("| GRAND TOTAL= " + grand_total + " |"); // to print newline
            System.out.println("***************************************************************************************");
            System.out.println("\t\t\t\t\t\t\t\t THANK YOU COME AGAIN");
            System.out.println("***************************************************************************************");
            // closing information login file
            br.close();
            //..............................................................
            // saving sales record
            Sales_Record(product_prices, sell_item_quantity, sell_item_names, sell_item_category, choice);
            // function call for master file
            medicine_master_file();
            //////////////////////////////////////
        } else if (choice.equals("2"))
            Sales_Record(product_prices, sell_item_quantity, sell_item_names, sell_item_category,choice);
        else if (choice.equalsIgnoreCase("m"))
            main_menu();
        else if (choice.equalsIgnoreCase("e"))
            System.exit(0);
        System.out.println("\n===============================");
        System.out.println("| 1. GO BACK  ....... PRESS B |\n| 2. MAIN MENU....... PRESS M |\n| 3. EXIT     ....... PRESS E |");
        System.out.println("===============================");
        String back = "";
        while (true) {
            back = input.nextLine();
            if (!(back.equals("b") || back.equals("B") || back.equals("m") || back.equals("M")
                    || back.equals("e") || back.equals("E")))
                continue;
            else
                break;
        }
        if (back.equalsIgnoreCase("b"))
            SALES();
        else if (back.equalsIgnoreCase("m"))
            main_menu();
        else
            System.exit(0);
    }
    // sales Record
    public static void Sales_Record(int[] sell_item_prices, String[] sell_item_quantity, String[] sell_item_names, String[] sell_item_category,
                                    String choice) throws IOException {
        File sales_path=new File("SALES_ENTITY_FILES");
        if(!sales_path.exists())
            sales_path.mkdir();
        // sales record files
        File product_names_file=new File(sales_path,"Product_Names.txt");
        File product_prices_file=new File(sales_path,"Product_Prices.txt");
        File product_quantity_file=new File(sales_path,"Product_quantities.txt");
        File product_category_file=new File(sales_path,"Product_Categories.txt");
        if(!product_names_file.exists()){
            product_prices_file.createNewFile();          product_names_file.createNewFile();
            product_category_file.createNewFile();        product_quantity_file.createNewFile();
        }
        BufferedWriter product_prices=new BufferedWriter(new FileWriter(product_prices_file,true));
        BufferedWriter product_quantities=new BufferedWriter(new FileWriter(product_quantity_file,true));
        BufferedWriter product_category=new BufferedWriter(new FileWriter(product_category_file,true));
        BufferedWriter product_names=new BufferedWriter(new FileWriter(product_names_file,true));
        //..............................................................................
// copying arrays to files
        if (choice.equals(("1"))) {
            for (int i = 0; i < sell_item_prices.length; i++) {
                if(sell_item_names[i]!=null){
                    product_names.write(sell_item_names[i] + ",,");
                    product_quantities.write(sell_item_quantity[i]+",,");
                    product_category.write(sell_item_category[i]+",,");
                    product_prices.write(sell_item_prices[i]+",,");}
            }
        }
        // closing all files
        product_names.close();
        product_category.close();
        product_prices.close();
        product_quantities.close();
//................................................................................
        // viewing sales record
        if (choice.equals(("2"))) {
            System.out.println("====================================================================================" +
                    "=======================================================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tS A L E S   R E C O R D ");
            System.out.println("====================================================================================" +
                    "=======================================================================");
            //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
            BufferedReader item_names = new BufferedReader(new FileReader(product_names_file));
            BufferedReader item_prices = new BufferedReader(new FileReader(product_prices_file));
            BufferedReader item_categories = new BufferedReader(new FileReader(product_category_file));
            BufferedReader item_quantities = new BufferedReader(new FileReader(product_quantity_file));
            boolean check = false;
            String names;
            String[] item_names_array = null;
            String[] item_prices_array = null;
            String[] item_quantity_array = null;
            String[] item_category_array = null;
            while ((names = item_names.readLine()) != null) {
                check=true;      // it means sales record is not empty
                item_names_array = names.split(",,");
                String prices = item_prices.readLine();
                item_prices_array = prices.split(",,");
                String quantities = item_quantities.readLine();
                item_quantity_array = quantities.split(",,");
                String categories = item_categories.readLine();
                item_category_array = categories.split(",,");
            }
            if (check){
                System.out.println("\n\n-----------------------------------------------------------------------------------");
                System.out.println("|ITEM NAMES\t\t\tITEM QUANTITY\t\t\tITEM CATEGORY\t\t\tTOTAL PRICE   |");
                System.out.println("-----------------------------------------------------------------------------------");
                for (int i = 0; i < item_names_array.length; i++) {
                    System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%n"
                            , item_names_array[i]
                            , "", item_quantity_array[i], "", item_category_array[i], "",
                            item_prices_array[i]);
                }
                System.out.println("-----------------------------------------------------------------------------------");
                int total_sales_amount = 0;
                // calculating total amount of sales this month
                for (int i = 0; i < item_prices_array.length; i++) {
                    total_sales_amount += Integer.parseInt(item_prices_array[i]);
                }
                print_box("TOTAL SALES AMOUNT :" + total_sales_amount);
            }
            else
                print_box("Currently, The SALES RECORD is Empty!");
            //closing all files
            item_names.close();;
            item_quantities.close();
            item_prices.close();
            item_categories.close();
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
    // Change password function
    public static boolean isValidPassword(String password)throws IOException {
//digit counter
        int digit_count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
                digit_count += 1;
        }
// letters and digit checker
        boolean letter_digit_check = true;
        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) >= '0' && password.charAt(i) <= '9') ||
                    (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') ||
                    (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'))
                letter_digit_check = true;
            else {
                letter_digit_check = false;
                break;
            }
        }
        if (password.length() >= 8 && digit_count >= 2 && letter_digit_check == true)
            return true;
        else {
            print_box("INVALID PASSWORD!");
            return false;
        }
    }
    // ADD - MEDICINE
    public static void Add_Medicines() throws IOException{
        Scanner input = new Scanner(System.in);
        //.................................................
        BufferedWriter med_names=new BufferedWriter(new FileWriter(med_names_file,true));
        BufferedWriter med_formulas=new BufferedWriter(new FileWriter(med_formulas_file,true));
        BufferedWriter med_companies=new BufferedWriter(new FileWriter(med_companies_file,true));
        BufferedWriter med_prices=new BufferedWriter(new FileWriter(med_prices_file,true));
        BufferedWriter med_quanities=new BufferedWriter(new FileWriter(med_quantities_file,true));
        BufferedWriter med_locations=new BufferedWriter(new FileWriter(med_locations_file,true));
        BufferedWriter med_exp_dates=new BufferedWriter(new FileWriter(med_exp_dates_file,true));
        /////////////////////////////////
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ADD MEDICINES ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =======================================");
        boolean check = true;
        String med_num = "";
        do {
            try {
                System.out.println("HOW MANY MEDICINES YOU WANT TO ADD:");
                med_num = input.nextLine();
                Integer.parseInt(med_num);
                check = false;
            } catch (NumberFormatException ex) {
                print_box("ENTER AN INTEGER VALUE");
            }
        } while (check);
        for (int x = 0; x < Integer.parseInt(med_num); x++) {
            print_box("----- Enter Details of Medicine (" + (x + 1) + ") -----");
            boolean name_check = true;
            String med_name="";
            do {
                try {
                    System.out.println("MEDICINE NAME:");
                    med_name= input.nextLine();
                    Integer.parseInt(med_name);
                    print_box("INVALID NAME! INPUT AGAIN");
                } catch (NumberFormatException ex) {
                    name_check = false;
                }
            } while (name_check);
            //................................................................
            // checking medicine already exists or not
            BufferedReader medicines=new BufferedReader(new FileReader(med_names_file));
            String names;
            String[] medicine_names=new String[100];
            while ((names=medicines.readLine())!=null){
                medicine_names=names.split(",,");
            }
            boolean exists;
            do{
                exists=false;
                for(String a:medicine_names) {
                    if(a!=null)
                        if (a.equalsIgnoreCase(med_name))
                            exists = true;
                }
                if(exists){
                    print_box("Medicine "+med_name+" Already exists in Stock!");
                    System.out.println("ENTER MEDICINE NAME:");
                    med_name= input.nextLine();
                }
            }while (exists);
            medicines.close();
            //.............................................................
            med_names.write(med_name+",,");
            ////////////////////
            String med_formula="";
            do {
                System.out.println("MEDICINE FORMULA:");
                med_formula = input.nextLine();
                if ( med_formula.isEmpty())
                    print_box("EMPTY INPUT NOT ALLOWED!");
            } while ( med_formula.isEmpty());
            med_formulas.write(med_formula+",,");
            /////////////////////////////////////////////////
            String med_cmp="";
            do {
                System.out.println("COMPANY NAME:");
                med_cmp = input.nextLine();
                if ( med_cmp.isEmpty())
                    print_box("EMPTY INPUT NOT ALLOWED!");
            } while ( med_cmp.isEmpty());
            med_companies.write(med_cmp+",,");
            ///////////////////////////////////////////////
            boolean checkPrice = true;
            String med_price="";
            do {
                try {
                    System.out.println("MEDICINE PRICE (Per Unit):");
                    med_price = input.nextLine();
                    Integer.parseInt(med_price);
                    checkPrice = false;
                    if(Integer.parseInt(med_price)<=0){
                        checkPrice=true;
                        print_box("NEGATIVE OR NULL VALUE IS NOT ACCEPTED");
                    }
                } catch (NumberFormatException ex) {
                    print_box("ENTER PRICE AS INTEGER VALUE");
                }
            } while (checkPrice);
            med_prices.write(med_price+",,");
            ///////////////////////////////
            boolean checkQuantity = true;
            String med_quantity="";
            do {
                try {
                    System.out.println("MEDICINE QUANTITY:");
                    med_quantity = input.nextLine();
                    Integer.parseInt(med_quantity);
                    checkQuantity = false;
                    if(Integer.parseInt(med_quantity)<=0){
                        checkQuantity=true;
                        print_box("NEGATIVE OR NULL VALUE IS NOT ACCEPTED");
                    }
                } catch (NumberFormatException ex) {
                    print_box("ENTER QUANTITY AS AN INTEGER VALUE");
                }
            } while (checkQuantity);
            med_quanities.write(med_quantity+",,");
            ////////////////////////////////////////
            boolean date_check = true;
            boolean int_date_check=true;
            String med_date="";
            String[] date_array=null;
            do{
                try{
                    while(true) {
                        System.out.println("MEDICINE EXPIRY-DATE (Format:(D_M_Y)(00-00-0000):");
                        med_date = input.nextLine();
                        date_check = isDateValid(med_date);
                        if(date_check==false)
                            break;
                    }
                    date_array=med_date.split("-");
                    Integer.parseInt(date_array[0]);
                    Integer.parseInt(date_array[1]);
                    Integer.parseInt(date_array[2]);
                    int_date_check=false;
                } catch (NumberFormatException ex) {
                    int_date_check=true;
                    print_box("WRONG DATE FORMAT! ENTER AGAIN");
                }
            } while (int_date_check);
            med_exp_dates.write(med_date+",,");
            /////////////////////////////////////////
            String med_location="";
            do {
                System.out.println("MEDICINE LOCATION IN STORE :");
                med_location = input.nextLine();
                if (med_location.isEmpty())
                    print_box("EMPTY INPUT NOT ALLOWED!");
            } while (med_location.isEmpty());
            med_locations.write(med_location+",,");

            ////////////////////////////////////////
            print_box(med_name + " Added Successfully in Stock");

        }
        // closing all Files
        med_names.close();
        med_prices.close();
        med_quanities.close();
        med_formulas.close();
        med_companies.close();
        med_exp_dates.close();
        med_locations.close();
        medicine_master_file();
    }
    // Delete Medicine
    public static boolean Del_Medicine(String medicine_name)throws IOException {
        Scanner input=new Scanner(System.in);
        boolean found = false;
        String delete_medicine=medicine_name;
        File temp_name_file=new File(med_path,"Temp_name_file.txt");
        File temp_formula_file=new File(med_path,"Temp_formula_file.txt");
        File temp_company_file=new File(med_path,"Temp_company_file.txt");
        File temp_prices_file=new File(med_path,"Temp_prices_file.txt");
        File temp_quantity_file=new File(med_path,"Temp_quantity_file.txt");
        File temp_location_file=new File(med_path,"Temp_location_file.txt");
        File temp_exp_file=new File(med_path,"Temp_exp_file.txt");
        //.........................................................................
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas=new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        BufferedReader med_prices=new BufferedReader(new FileReader(med_prices_file));
        BufferedReader med_quanities=new BufferedReader(new FileReader(med_quantities_file));
        BufferedReader med_locations=new BufferedReader(new FileReader(med_locations_file));
        BufferedReader med_exp_dates=new BufferedReader(new FileReader(med_exp_dates_file));
        //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

        if(!temp_name_file.exists()){
            temp_name_file.createNewFile();
            temp_formula_file.createNewFile();
            temp_prices_file.createNewFile();
            temp_company_file.createNewFile();
            temp_quantity_file.createNewFile();
            temp_location_file.createNewFile();
            temp_exp_file.createNewFile();
        }
        //........................................................................
        PrintWriter temp_names=new PrintWriter(temp_name_file);
        PrintWriter temp_formulas=new PrintWriter(temp_formula_file);
        PrintWriter temp_companies=new PrintWriter(temp_company_file);
        PrintWriter temp_prices=new PrintWriter(temp_prices_file);
        PrintWriter temp_quanities=new PrintWriter(temp_quantity_file);
        PrintWriter temp_locations=new PrintWriter(temp_location_file);
        PrintWriter temp_exp_dates=new PrintWriter(temp_exp_file);
        //............................................................................
        String names;
        String[] name_array=null;
        String[] price_array=null;
        String[] quantity_array=null;
        String[] company_array=null;
        String[] formula_array=null;
        String[] location_array=null;
        String[] exp_date_array=null;
        int index=0;
        int var=0;
        int count=0;
        int counter=0;
        boolean loop=true;
        ///...........................
        while((names=med_names.readLine())!=null) {
            name_array = names.split(",,");
            String prices = med_prices.readLine();
            price_array = prices.split(",,");
            String quantities = med_quanities.readLine();
            quantity_array = quantities.split(",,");
            String com_names = med_companies.readLine();
            company_array = com_names.split(",,");
            String formulas = med_formulas.readLine();
            formula_array = formulas.split(",,");
            String locations = med_locations.readLine();
            location_array = locations.split(",,");
            String exp_dates = med_exp_dates.readLine();
            exp_date_array = exp_dates.split(",,");
            for(String a:name_array) {
                if(var==0){
                    if(delete_medicine.equalsIgnoreCase(a)) {
                        found=true;
                        index=count;
                        loop = false;
                        var++;}
                    else
                        temp_names.write(a+",,");
                }
                else if(!delete_medicine.equalsIgnoreCase(a) || loop==false)
                    temp_names.write(a + ",,");
                count++;
            }
            for(int i=0;i<name_array.length;i++){
                if(name_array[i]!=null)
                    if(index!=counter || found==false) { // found=false in case if medicine not found, to write other things
                        temp_prices.write(price_array[i] + ",,");
                        temp_quanities.write(quantity_array[i] + ",,");
                        temp_companies.write(company_array[i]+",,");
                        temp_formulas.write(formula_array[i] + ",,");
                        temp_exp_dates.write(exp_date_array[i] + ",,");
                        temp_locations.write(location_array[i] + ",,");
                    }
                counter++; // incrementing
            }
        }
        med_names.close();
        med_quanities.close();
        med_formulas.close();
        med_locations.close();
        med_prices.close();
        med_exp_dates.close();
        med_companies.close();

        temp_names.close();
        temp_companies.close();
        temp_prices.close();
        temp_quanities.close();
        temp_locations.close();
        temp_exp_dates.close();
        temp_formulas.close();
        //'''''''''''''''''''''''
        med_names_file.delete();
        med_companies_file.delete();
        med_prices_file.delete();
        med_quantities_file.delete();
        med_locations_file.delete();
        med_exp_dates_file.delete();
        med_formulas_file.delete();
        //.......................
        // renaming all temporary files to original files
        temp_name_file.renameTo(med_names_file);
        temp_company_file.renameTo(med_companies_file);
        temp_prices_file.renameTo(med_prices_file);
        temp_quantity_file.renameTo(med_quantities_file);
        temp_location_file.renameTo(med_locations_file);
        temp_exp_file.renameTo(med_exp_dates_file);
        temp_formula_file.renameTo(med_formulas_file);
        temp_name_file.delete();

        medicine_master_file();    // function call
        return found;
    }
    // updating medicine
    public static void Update_Medicine(String medName)throws IOException {
        String update_medicine = medName;
        boolean found = false;
        Scanner input = new Scanner(System.in);
        File temp_name_file = new File(med_path, "Temp_name_file.txt");
        File temp_formula_file = new File(med_path, "Temp_formula_file.txt");
        File temp_company_file = new File(med_path, "Temp_company_file.txt");
        File temp_prices_file = new File(med_path, "Temp_prices_file.txt");
        File temp_quantity_file = new File(med_path, "Temp_quantity_file.txt");
        File temp_location_file = new File(med_path, "Temp_location_file.txt");
        File temp_exp_file = new File(med_path, "Temp_exp_file.txt");
        //.........................................................................
        BufferedReader med_names = new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas = new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies = new BufferedReader(new FileReader(med_companies_file));
        BufferedReader med_prices = new BufferedReader(new FileReader(med_prices_file));
        BufferedReader med_quanities = new BufferedReader(new FileReader(med_quantities_file));
        BufferedReader med_locations = new BufferedReader(new FileReader(med_locations_file));
        BufferedReader med_exp_dates = new BufferedReader(new FileReader(med_exp_dates_file));
        //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        if (!temp_name_file.exists()) {
            temp_name_file.createNewFile();         temp_formula_file.createNewFile();
            temp_prices_file.createNewFile();       temp_company_file.createNewFile();
            temp_quantity_file.createNewFile();     temp_location_file.createNewFile();
            temp_exp_file.createNewFile();
        }
        //........................................................................
        PrintWriter temp_names = new PrintWriter(temp_name_file);
        PrintWriter temp_formulas = new PrintWriter(temp_formula_file);
        PrintWriter temp_companies = new PrintWriter(temp_company_file);
        PrintWriter temp_prices = new PrintWriter(temp_prices_file);
        PrintWriter temp_quantities = new PrintWriter(temp_quantity_file);
        PrintWriter temp_locations = new PrintWriter(temp_location_file);
        PrintWriter temp_exp_dates = new PrintWriter(temp_exp_file);
        //............................................................................
        String names;
        String[] name_array = new String[100];          String[] price_array = new String[100];
        String[] quantity_array = new String[100];      String[] company_array =new String[100];
        String[] formula_array = new String[100];       String[] location_array = new String[100];
        String[] exp_date_array = new String[100];
        //.......................
        int index = 0;
        int var = 0;
        int count = 0;
        int counter = 0;
        boolean loop = true;
        ///...........................
        while ((names = med_names.readLine()) != null) {
            name_array = names.split(",,");
            String prices = med_prices.readLine();
            price_array = prices.split(",,");
            String quantities = med_quanities.readLine();
            quantity_array = quantities.split(",,");
            String com_names = med_companies.readLine();
            company_array = com_names.split(",,");
            String formulas = med_formulas.readLine();
            formula_array = formulas.split(",,");
            String locations = med_locations.readLine();
            location_array = locations.split(",,");
            String exp_dates = med_exp_dates.readLine();
            exp_date_array = exp_dates.split(",,");
        }
        String update_choice = "";
        for (String x : name_array) {
            if (update_medicine.equalsIgnoreCase(x)) {
                found = true;
                index=count;

                System.out.println("---------------------------------------");
                System.out.println("|1. Medicine Name .............Press 1|\n|2. Medicine Formula ..........Press 2|\n" +
                        "|3. Medicine Company ..........Press 3|\n|4. Medicine Price ............Press 4|\n" +
                        "|5. Medicine quantity .........Press 5|\n|6. Location ..................Press 6|\n|7. Expiry Date ...............Press 7|");
                System.out.println("---------------------------------------");
                while (true) {
                    System.out.println("WHAT DO YOU WANT TO UPDATE:");
                    update_choice = input.nextLine();
                    if (!(update_choice.equals("1") || update_choice.equals("2") || update_choice.equals("3") ||
                            update_choice.equals("4") || update_choice.equals("5") || update_choice.equals("6") ||
                            update_choice.equals("7")))
                        System.out.println("INVALID ENTRY! INPUT AGAIN");
                    else
                        break;
                }
            }
            count++; // incrementing it to find medicine index
        }
        if(found){ // if update medicine exists in stock
            if (update_choice.equals("1")) {
                String new_name="";
                do {
                    System.out.println("ENTER NEW NAME OF MEDICINE:");
                    new_name= input.nextLine();
                } while (new_name.isEmpty());
                for (int i=0;i<name_array.length;i++) {
                    if (index==counter) {
                        temp_names.write(new_name + ",,");
                    } else
                        temp_names.write(name_array[i] + ",,");
                    counter++;
                }
                for (int i=0;i<name_array.length;i++) {
                    temp_prices.write(price_array[i]+",,");   temp_quantities.write(quantity_array[i]+",,");
                    temp_companies.write(company_array[i]+",,");   temp_locations.write(location_array[i]+",,");
                    temp_formulas.write(formula_array[i]+",,");    temp_exp_dates.write(exp_date_array[i]+",,");}
            }
            //......................................................
            if(update_choice.equals("2")){
                String new_formula="";
                do {
                    System.out.println("Enter New Formula Name of Medicine:");
                    new_formula= input.nextLine();
                } while ( new_formula.isEmpty());
                for (int i = 0; i < formula_array.length; i++) {
                    if(index==counter)
                        temp_formulas.write(new_formula+ ",,");
                    else
                        temp_formulas.write(formula_array[i]+",,");
                    counter++;
                }
                for (int i=0;i<formula_array.length;i++) {
                    temp_prices.write(price_array[i]+",,");   temp_quantities.write(quantity_array[i]+",,");
                    temp_companies.write(company_array[i]+",,");   temp_locations.write(location_array[i]+",,");
                    temp_names.write(name_array[i]+",,");    temp_exp_dates.write(exp_date_array[i]+",,");}}
            //.......................................
            if(update_choice.equals("3")){
                counter=0;
                String company_name="";
                do {
                    System.out.println("Enter New Company Name");
                    company_name= input.nextLine();
                } while (company_name.isEmpty());
                for (int i = 0; i < company_array.length; i++) {
                    if(index==counter)
                        temp_companies.write(company_name + ",,");
                    else
                        temp_companies.write(company_array[i]+",,");
                    counter++;
                }
                for (int i=0;i<company_array.length;i++) {
                    temp_prices.write(price_array[i]+",,");   temp_quantities.write(quantity_array[i]+",,");
                    temp_names.write(name_array[i]+",,");   temp_locations.write(location_array[i]+",,");
                    temp_formulas.write(formula_array[i]+",,");    temp_exp_dates.write(exp_date_array[i]+",,");}}
            //'''''''''''''''''''''''''''''''''''''''''''''''''''''''
            if(update_choice.equals("4")){
                counter=0;
                String new_price="";
                boolean check = true;
                do {
                    try {
                        System.out.println("Enter New Price:");
                        new_price = input.nextLine();
                        check = false;
                    } catch (InputMismatchException ex) {
                        print_box("Enter PRICE AS AN INTEGER VALUE");
                    }
                } while (check);
                for (int i = 0; i < price_array.length; i++) {
                    if(index==counter)
                        temp_prices.write(new_price+ ",,");
                    else
                        temp_prices.write(price_array[i]+",,");
                    counter++;
                }
                for (int i=0;i<price_array.length;i++) {
                    temp_names.write(name_array[i]+",,");   temp_quantities.write(quantity_array[i]+",,");
                    temp_companies.write(company_array[i]+",,");   temp_locations.write(location_array[i]+",,");
                    temp_formulas.write(formula_array[i]+",,");    temp_exp_dates.write(exp_date_array[i]+",,");}
            }
            //..........................................................
            if(update_choice.equals("5")){
                // finding old quantity of medicine
                BufferedReader br=new BufferedReader(new FileReader(med_quantities_file));
                String[] old_quantity_array=new String[100];
                String s;
                while ((s=br.readLine())!=null){
                    old_quantity_array=s.split(",,");
                }
                br.close(); // closing above file
                counter=0;
                String new_quantity="";
                boolean check = true;
                do {
                    try {
                        System.out.println("Enter medicine Quantity :");
                        new_quantity= input.nextLine();
                        check = false;
                    } catch (InputMismatchException ex) {
                        print_box("Enter QUANTITY AS AN INTEGER VALUE");
                    }
                } while (check);
                int final_quantity=Integer.parseInt(old_quantity_array[index])+Integer.parseInt(new_quantity);
                for (int i = 0; i < quantity_array.length; i++) {
                    if(index==counter)
                        temp_quantities.write(final_quantity+ ",,");
                    else
                        temp_quantities.write(quantity_array[i]+",,");
                    counter++;
                }
                for (int i=0;i<quantity_array.length;i++) {
                    temp_prices.write(price_array[i]+",,");   temp_names.write(name_array[i]+",,");
                    temp_companies.write(company_array[i]+",,");   temp_locations.write(location_array[i]+",,");
                    temp_formulas.write(formula_array[i]+",,");    temp_exp_dates.write(exp_date_array[i]+",,");}
            }
            /////////////////////////////////////////////
            if(update_choice.equals("6")){
                counter=0;
                System.out.println("Enter New Location of Medicine in Store:");
                String new_location= input.nextLine();
                for (int i = 0; i < location_array.length; i++) {
                    if(index==counter)
                        temp_locations.write(new_location+ ",,");
                    else
                        temp_locations.write(location_array[i]+",,");
                    counter++;
                }
                for (int i=0;i<location_array.length;i++) {
                    temp_prices.write(price_array[i]+",,");   temp_quantities.write(quantity_array[i]+",,");
                    temp_companies.write(company_array[i]+",,");   temp_names.write(name_array[i]+",,");
                    temp_formulas.write(formula_array[i]+",,");    temp_exp_dates.write(exp_date_array[i]+",,");}}
            //.......................................
            if(update_choice.equals("7")){
                counter=0;
                String new_date="";
                boolean check = true;
                boolean date_check = true;
                boolean int_date_check=true;
                String[] date_array=null;
                do{
                    try{
                        while(true) {
                            System.out.println("MEDICINE EXPIRY DATE(Format:(D_M_Y)(00-00-0000):");
                            new_date= input.nextLine();
                            date_check = isDateValid(new_date);
                            if(date_check==false)
                                break;}
                        date_array=new_date.split("-");
                        Integer.parseInt(date_array[0]);  Integer.parseInt(date_array[1]);  Integer.parseInt(date_array[2]);
                        int_date_check=false;
                    } catch (NumberFormatException ex) {
                        int_date_check=true;
                        print_box("WRONG DATE FORMAT! ENTER AGAIN");
                    }
                } while (int_date_check);
                for (int i = 0; i < exp_date_array.length; i++) {
                    if(index==counter)
                        temp_exp_dates.write(new_date+ ",,");
                    else
                        temp_exp_dates.write(exp_date_array[i]+",,");
                    counter++;
                }
                for (int i=0;i<exp_date_array.length;i++) {
                    temp_prices.write(price_array[i]+",,");   temp_quantities.write(quantity_array[i]+",,");
                    temp_companies.write(company_array[i]+",,");   temp_locations.write(location_array[i]+",,");
                    temp_formulas.write(formula_array[i]+",,");    temp_names.write(name_array[i]+",,");}}
        }
        med_names.close();
        med_quanities.close();
        med_formulas.close();
        med_locations.close();
        med_prices.close();
        med_exp_dates.close();
        med_companies.close();
        //...................
        temp_names.close();
        temp_companies.close();
        temp_prices.close();
        temp_quantities.close();
        temp_locations.close();
        temp_exp_dates.close();
        temp_formulas.close();
        //'''''''''''''''''''''''
        if(!found) {
            print_box("------------- " + update_medicine + " Not Found in Record -----------");
            // deleting temporary files if medicinenot found
            temp_name_file.delete(); temp_company_file.delete(); temp_exp_file.delete(); temp_formula_file.delete();
            temp_location_file.delete(); temp_quantity_file.delete(); temp_prices_file.delete();
        }
        if(found){
            print_box("----------- "+update_medicine+ " Successfully Updated -----------");
            med_names_file.delete();
            med_companies_file.delete();
            med_prices_file.delete();
            med_quantities_file.delete();
            med_locations_file.delete();
            med_exp_dates_file.delete();
            med_formulas_file.delete();
            // renaming all temporary files to original files
            temp_name_file.renameTo(med_names_file);
            temp_company_file.renameTo(med_companies_file);
            temp_prices_file.renameTo(med_prices_file);
            temp_quantity_file.renameTo(med_quantities_file);
            temp_location_file.renameTo(med_locations_file);
            temp_exp_file.renameTo(med_exp_dates_file);
            temp_formula_file.renameTo(med_formulas_file);
        }
    }
    // Expired Medicines
    public static void Expired_Medicines_Check()throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t=====================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  EXPIRED MEDICINES ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t=====================================================");
        String current_date = "";
        boolean date_check = true;
        boolean int_date_check=true;
        String[] date_array=null;
        do{
            try{
                while(true) {
                    System.out.println("\nMEDICINE CURRENT DATE (Format:(D_M_Y)(00-00-0000):");
                    current_date = input.nextLine();
                    String s = current_date;
                    date_check = isDateValid(s);
                    if(date_check==false)
                        break;
                }
                date_array=current_date.split("-");
                Integer.parseInt(date_array[0]);
                Integer.parseInt(date_array[1]);
                Integer.parseInt(date_array[2]);
                int_date_check=false;
            } catch (NumberFormatException ex) {
                int_date_check=true;
                print_box("WRONG DATE FORMAT! ENTER AGAIN");
            }
        } while (int_date_check);
        //////////////////////////////
        System.out.println("\n\n------------------------------------------------------------------------------" +
                "--------------------------------------------------------");
        System.out.println("Medicine Names\t\tFormulas\t\t\tCompany Names\t\t Price\t\t\tQuantity\t\t\t  Expiry Date\t\t\tLocation");
        System.out.println("------------------------------------------------------------------------------------" +
                "--------------------------------------------------");
        BufferedReader med_exp_dates=new BufferedReader(new FileReader(med_exp_dates_file));
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas=new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        BufferedReader med_prices=new BufferedReader(new FileReader(med_prices_file));
        BufferedReader med_quanities=new BufferedReader(new FileReader(med_quantities_file));
        BufferedReader med_locations=new BufferedReader(new FileReader(med_locations_file));
        String names;
        boolean found=false;
        String[] exp_dates_array=new String[100];        String location_array[]=new String[100];
        String price_array[]=new String[100];            String name_array[]=new String[100];
        String quantity_array[]=new String[100];         String company_array[]=new String[100];
        String formula_array[]=new String[100];
        while((names=med_names.readLine())!=null){
            name_array = names.split(",,");
            String prices=med_prices.readLine();
            price_array=prices.split(",,");
            String quantities=med_quanities.readLine();
            quantity_array=quantities.split(",,");
            String com_names=med_companies.readLine();
            company_array=com_names.split(",,");
            String formulas=med_formulas.readLine();
            formula_array=formulas.split(",,");
            String locations=med_locations.readLine();
            location_array=locations.split(",,");
            String dates=med_exp_dates.readLine();
            exp_dates_array=dates.split(",,");
        }
        String current_dates[] = current_date.split("-"); // to separate date month and year
        int c_date = Integer.parseInt(current_dates[0]);
        int c_month = Integer.parseInt(current_dates[1]);
        int c_year = Integer.parseInt(current_dates[2]);
        boolean a = true; // for the purpose if medicines expired list is empty
        String expiray_date[]=new String[10];
        for (int i = 0; i < exp_dates_array.length; i++) {
            if(exp_dates_array[i]!=null) {
                expiray_date = exp_dates_array[i].split("-"); // to separate date month and year
                //  int count=0;
                int exp_date = Integer.parseInt(expiray_date[0]);
                int exp_month = Integer.parseInt(expiray_date[1]);
                int exp_year = Integer.parseInt(expiray_date[2]);
                if ((exp_date <= c_date && exp_month <= c_month && exp_year <= c_year) ||
                        (exp_month < c_month && exp_year <= c_year) || (exp_year < c_year)) {
                    found = true;
                    System.out.format("%-10s%-10s%-10s%-10s%-10s%-12s%-12s%-10s%-10s%-10s%-10s%-10s%-10s%n"
                            , name_array[i], "     | ", formula_array[i], "    |  ", company_array[i],
                            "     |   ", price_array[i], "|", quantity_array[i], "|", exp_dates_array[i], "  | ", location_array[i]);
                }
            }
        }
        if (found==false)
            print_box("-------------NO Medicine is EXPIRED YET---------------");
        System.out.println("------------------------------------------------------------------------------------" +
                "--------------------------------------------------");
    }
    // Medicine Stock
    public static void Medicine_Stock()throws IOException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tALL MEDICINE STOCK ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        //.........................................................
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas=new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        BufferedReader med_prices=new BufferedReader(new FileReader(med_prices_file));
        BufferedReader med_quanities=new BufferedReader(new FileReader(med_quantities_file));
        BufferedReader med_locations=new BufferedReader(new FileReader(med_locations_file));
        BufferedReader med_exp_dates=new BufferedReader(new FileReader(med_exp_dates_file));
        //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        boolean check = false; // to check med_stock is empty or not
        System.out.println("\n------------------------------------------------------------------------------" +
                "----------------------------------------------------------------");
        System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s%-9s%-8s%-9s%-8s%-8s%-8s%-8s%n"
                , "MEDICINE NAMES", "   |", "FORMULAS", "   |  ", "COMPANY NAMES",
                "   |", "PRICES", "|","QUANTITY", "   |", "EXPIRY DATES", "     | ", "LOCATIONS");
        System.out.println("------------------------------------------------------------------------------------" +
                "----------------------------------------------------------");
        String names;
        String name_array[]=null;
        String price_array[]=null;
        String quantity_array[]=null;
        String company_array[]=null;
        String formula_array[]=null;
        String location_array[]=null;
        String exp_date_array[]=null;
        int med_count=0;
        while((names=med_names.readLine())!=null) {
            check=true;  // it means the files are not empty
            name_array = names.split(",,");
            String prices=med_prices.readLine();
            price_array=prices.split(",,");
            String quantities=med_quanities.readLine();
            quantity_array=quantities.split(",,");
            String com_names=med_companies.readLine();
            company_array=com_names.split(",,");
            String formulas=med_formulas.readLine();
            formula_array=formulas.split(",,");
            String locations=med_locations.readLine();
            location_array=locations.split(",,");
            String exp_dates=med_exp_dates.readLine();
            exp_date_array=exp_dates.split(",,");
            for(int i=0;i<name_array.length;i++){
                med_count+=1;
                System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-10s%-10s%-10s%-10s%-10s%-10s%n"
                        , name_array[i], "     |", formula_array[i], "     |  ", company_array[i],
                        "      |   ", price_array[i], "|", quantity_array[i], "|", exp_date_array[i], "  | ", location_array[i]);
            }
        }
        System.out.println("------------------------------------------------------------------------------------" +
                "----------------------------------------------------------");
        print_box("TOTAL  NO  OF  MEDICINES  :  "+med_count);
        if(check==false)
            print_box("Currently, The Stock is Empty!");
        med_names.close();
        med_quanities.close();
        med_companies.close();
        med_prices.close();
        med_formulas.close();
        med_locations.close();
        med_exp_dates.close();
    }
    // Searching Medicines
    public static void Search_Medicines()throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  SEARCH MEDICINE ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        //................................................................................//
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas=new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        BufferedReader med_prices=new BufferedReader(new FileReader(med_prices_file));
        BufferedReader med_quanities=new BufferedReader(new FileReader(med_quantities_file));
        BufferedReader med_locations=new BufferedReader(new FileReader(med_locations_file));
        BufferedReader med_exp_dates=new BufferedReader(new FileReader(med_exp_dates_file));
        //................................................................................//
        String search_med;
        do {
            System.out.println("\nENTER MEDICINE NAME TO SEARCH IN STOCK :");
            search_med = input.nextLine();
            if (search_med.isEmpty())
                print_box("EMPTY INPUT IS NOT ALLOWED");
        } while (search_med.isEmpty());
        //....................................
        boolean search = false; // to find that medicine exits or not
        String names;
        String[] name_array=new String [100];
        String[] price_array=new String [100];
        String[] quantity_array=new String [100];
        String[] company_array=new String [100];
        String[] formula_array=new String [100];
        String[] location_array=new String [100];
        String[] exp_date_array=new String [100];
        while((names=med_names.readLine())!=null) {
            name_array = names.split(",,");
            String prices = med_prices.readLine();
            price_array = prices.split(",,");
            String quantities = med_quanities.readLine();
            quantity_array = quantities.split(",,");
            String com_names = med_companies.readLine();
            company_array = com_names.split(",,");
            String formulas = med_formulas.readLine();
            formula_array = formulas.split(",,");
            String locations = med_locations.readLine();
            location_array = locations.split(",,");
            String exp_dates = med_exp_dates.readLine();
            exp_date_array = exp_dates.split(",,");
            for (int i = 0; i < name_array.length; i++) {  // loop to search medicines
                if (search_med.equalsIgnoreCase(name_array[i])) {
                    search = true;  // it means medicine found
                    print_box("------" + search_med + " Medicine EXISTS in Stock-------");
                    System.out.println("Medicine Name" + "\t\t\t" + name_array[i]);
                    System.out.println("Company Name" + "\t\t\t" + formula_array[i]);
                    System.out.println("Company Name" + "\t\t\t" + company_array[i]);
                    System.out.println("Medicine Price" + "\t\t\t" + price_array[i]);
                    System.out.println("Medicine Quantity" + "\t\t" + quantity_array[i]);
                    System.out.println("Medicine Location" + "\t\t" + location_array[i]);
                }
            }
        }
        if (search == false)
            print_box(search_med+ " Medicine Does not Found in Stock ");
        med_companies.close();
        med_names.close();
        med_prices.close();
        med_formulas.close();
        med_locations.close();
        med_quanities.close();
        med_exp_dates.close();
    }
    // Medicines with Same formulas
    public static void Same_Formula_Medicines()throws IOException {
        Scanner input = new Scanner(System.in);
        boolean found=false;
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSAME FORMULA MEDICINES");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =======================================");
        String medFormula;
        do {
            System.out.print("\nENTER MEDICINE FORMULA TO SEARCH ITS ALL MEDICINES :");
            medFormula = input.nextLine();
            if (medFormula.isEmpty())
                print_box("EMPTY INPUT IS NOT ALLOWED");
        } while (medFormula.isEmpty());
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas=new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        boolean search = false; // to find that medicine exits or not
        String names;
        //arrays
        String[] name_array=new String[100];
        String[] company_array=new String[100];
        String[] formula_array=new String[100];
        while((names=med_names.readLine())!=null) {
            name_array = names.split(",,");
            String com_names = med_companies.readLine();
            company_array = com_names.split(",,");
            String formulas = med_formulas.readLine();
            formula_array = formulas.split(",,");
        }
        System.out.println(" Medicines Having " + medFormula + " Formula are!");
        System.out.println("\n---------------------------------------------");
        System.out.println("Medicine Names\t\t Company Names\n");
        for (int i = 0; i < formula_array.length; i++) {
            if(formula_array[i]!=null)
                if (formula_array[i].equalsIgnoreCase(medFormula)) {
                    found=true;
                    System.out.println(name_array[i] + "\t\t\t\t\t" + company_array[i]);
                }
        }
        System.out.println("---------------------------------------------");
        if(!found)
            print_box("No Any Medicine Found with Formula "+medFormula);
        // closing all files
        med_names.close();    med_formulas.close();     med_companies.close();
    }
    // Adding Company details
    public static void Add_Company() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ADD COMPANY ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        //''''''''''''''''''''''''''''''''''''''''''''''''''

        String com_num = ""; // to add number of medicines
        boolean check = true;
        do {
            try {
                System.out.print("How many Companies you want you Add In Record:");
                com_num = input.nextLine();
                Integer.parseInt(com_num);
                check = false;
            } catch (NumberFormatException ex) {
                print_box("INVALID INPUT, ENTER AN INTEGER VALUE");
            }
        } while (check);
        String com_name="";// to store name of company
        for (int x = 0; x < Integer.parseInt(com_num); x++) {
            BufferedWriter com_names=new BufferedWriter(new FileWriter(com_names_file,true));
            BufferedWriter com_addresses=new BufferedWriter(new FileWriter(com_address_file,true));
            BufferedWriter com_contacts=new BufferedWriter(new FileWriter(com_contact_file,true));
            BufferedWriter com_emails=new BufferedWriter(new FileWriter(com_email_file,true));
            //..................................................
            //Creating Files
            try{
                if(!com_names_file.exists()){
                    com_names_file.createNewFile();
                    com_address_file.createNewFile();
                    com_contact_file.createNewFile();
                    com_email_file.createNewFile();
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            print_box("ENTER DETAILS OF COMPANY (" + (x + 1) + ")");
            boolean name_check = true;
            BufferedReader Names=new BufferedReader(new FileReader(com_names_file));
            String str;
            String[] all_names=new String [100];
            while ((str=Names.readLine())!=null){
                all_names=str.split(",,");
            }
            Names.close();
            do {
                try {
                    System.out.println("COMPANY NAME:");
                    com_name = input.nextLine();
                    Integer.parseInt(com_name );
                    print_box("INVALID NAME ! ENTER AGAIN");
                } catch (NumberFormatException ex) {
                    name_check = false;
                    for(int i=0;i<all_names.length;i++){
                        if(all_names[i]!=null)
                            if(all_names[i].equalsIgnoreCase(com_name)) {
                                print_box("THIS NAME ALREADY EXISTS IN OUR RECORD!");
                                name_check = true;
                                break;
                            }
                    }
                }
            } while (name_check);
            com_names.write(com_name+",,");   // appending data
            //''''''''''''''''''''''''''''''''''''''''''
            BufferedReader br=new BufferedReader(new FileReader(com_contact_file));
            String s;
            String[] all_contacts=new String[100];
            while ((s= br.readLine())!=null){
                all_contacts=s.split(",,");
            }
            br.close();
            boolean phoneIntCheck = true;
            String com_contact="";
            do {
                try {
                    while (true) {
                        System.out.println("COMPANY CONTACT NO (FORMAT: 0000-0000000):");
                        com_contact = input.nextLine();
                        boolean Check = isPhoneValid(com_contact);
                        if(Check){
                        for(int i=0;i<all_contacts.length;i++) {
                            if(all_contacts[i]!=null)
                                if (all_contacts[i].equals(com_contact)) {
                                 Check = false;
                                 print_box("CONTACT ALREADY EXISTS");
                                break;
                            } else
                                Check = true;
                        }
                        if (Check == true)
                            break;
                    }}
                    String[] phone_parts = com_contact.split("-");
                    Integer.parseInt(phone_parts[0]);
                    Integer.parseInt(phone_parts[1]);
                    phoneIntCheck = false;
                } catch (NumberFormatException ex) {
                    print_box("INVALID CONTACT NO,ENTER ONLY NUMBERS");
                    phoneIntCheck = true;
                }
            } while (phoneIntCheck);
            com_contacts.write(com_contact+",,");  // appending data
            //.........................................
            BufferedReader BR=new BufferedReader(new FileReader(com_email_file));
            String Str;
            String[] all_gmails=new String[100];
            while ((Str= BR.readLine())!=null){
                all_gmails=Str.split(",,");
            }
            String com_email="";
            boolean g_Check=true;
            while (true) {
                System.out.println("COMPANY EMAIL:");
                com_email = input.nextLine();
                g_Check = isValidEmail(com_email);
                if(g_Check){
                    for(int i=0;i<all_gmails.length;i++) {
                        if (all_gmails[i] != null)
                            if (all_gmails[i].equals(com_email)) {
                                g_Check = false;
                                print_box("EMAIL ALREADY EXISTS");
                                break;}
                            else
                                g_Check = true;}
                }
                if (g_Check == true)
                    break;
            }
            com_emails.write(com_email+",,"); // appending data
            //'''''''''''''''''''''''''''''''''''''''
            br.close();
            BR.close();
            //....................................
            String com_address="";
            do {
                System.out.println("COMPANY ADDRESS:");
                com_address= input.nextLine();
                if (com_address.isEmpty())
                    print_box("EMPTY INPUT NOT ALLOWED");
            } while (com_address.isEmpty());
            com_addresses.write(com_address+",,"); // appending data

            print_box(com_name +" Company Successfully Added in Record!");
            // closing all files
            com_names.close();
            com_contacts.close();
            com_addresses.close();
            com_emails.close();
        }
    }
    // deleting a company record
    public static void Delete_Company() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  DELETE COMPANY ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        String delete_company;
        do {
            System.out.println("\nENTER COMPANY NAME TO DELETE FROM RECORD:");
            delete_company = input.nextLine();
            if (delete_company.isEmpty())
                print_box("EMPTY INPUT IS NOT ALLOWED");
        } while (delete_company.isEmpty());
        // creating temporary files to store data in it for deletion
        File temp_name_file=new File(com_path,"Temp_name_file.txt");
        File temp_address_file=new File(com_path,"Temp_address_file.txt");
        File temp_email_file=new File(com_path,"Temp_email_file.txt");
        File temp_contact_file=new File(com_path,"temp_contact_file.txt");
        //.........................................................................
        BufferedReader com_names=new BufferedReader(new FileReader(com_names_file));
        BufferedReader com_addresses=new BufferedReader(new FileReader(com_address_file));
        BufferedReader com_emails=new BufferedReader(new FileReader(com_email_file));
        BufferedReader com_contacts=new BufferedReader(new FileReader(com_contact_file));
        //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        if(!temp_name_file.exists()){
            temp_name_file.createNewFile();         temp_address_file.createNewFile();
            temp_contact_file.createNewFile();      temp_email_file.createNewFile();
        }
        //........................................................................
        PrintWriter temp_names=new PrintWriter(temp_name_file);
        PrintWriter temp_addresses=new PrintWriter(temp_address_file);
        PrintWriter temp_emails=new PrintWriter(temp_email_file);
        PrintWriter temp_contacts=new PrintWriter(temp_contact_file);
        //............................................................................
        String names;
        //declaring arrays
        String[] name_array=new String[100];  String[] contact_array=new String[100];
        String[] address_array=new String[100]; String[] email_array=new String[100];
        int index=0;
        int var=0;
        boolean found = false;
        int count=0;
        int counter=0;
        boolean loop=true;
        ///...........................
        while((names=com_names.readLine())!=null) {
            name_array = names.split(",,");
            String addresses = com_addresses.readLine();
            address_array = addresses.split(",,");
            String emails = com_emails.readLine();
            email_array= emails.split(",,");
            String contacts = com_contacts.readLine();
            contact_array = contacts.split(",,");
            for(String a:name_array) {
                if(var==0){
                    if(delete_company.equalsIgnoreCase(a)) {
                        found=true;
                        index=count;
                        loop = false;
                        var++;}
                    else
                        temp_names.write(a+",,");
                }
                else if(!delete_company.equalsIgnoreCase(a) || loop==false)
                    temp_names.write(a + ",,");
                count++;
            }
            for(int i=0;i<name_array.length;i++){
                if(index!=counter || found==false) { // found=false in case if medicine not found, to write other things
                    temp_addresses.write(address_array[i] + ",,");
                    temp_emails.write(email_array[i] + ",,");
                    temp_contacts.write(contact_array[i]+",,");
                }
                counter++; // incrementing
            }
        }
        com_names.close();
        com_emails.close();
        com_addresses.close();
        com_contacts.close();
        //////////////////////
        temp_names.close();
        temp_contacts.close();
        temp_emails.close();
        temp_addresses.close();
        //'''''''''''''''''''''''
        com_names_file.delete();
        com_address_file.delete();
        com_email_file.delete();
        com_contact_file.delete();
        //.......................
        // renaming all temporary files to original files
        temp_name_file.renameTo(com_names_file);
        temp_address_file.renameTo(com_address_file);
        temp_email_file.renameTo(com_email_file);
        temp_contact_file.renameTo(com_contact_file);
        if (found ==true)
            print_box(delete_company + " Company has been Deleted from Record!");
        else
            print_box(delete_company+ " Company Not found in Record!");

    }
    // searching a company
    public static void Search_Company()throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  SEARCH COMPANY ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        //...............................................................................//
        BufferedReader com_names=new BufferedReader(new FileReader(com_names_file));
        BufferedReader com_contacts=new BufferedReader(new FileReader(com_contact_file));
        BufferedReader com_addresses=new BufferedReader(new FileReader(com_address_file));
        BufferedReader com_emails=new BufferedReader(new FileReader(com_email_file));
        //...............................................................................//
        System.out.println("\nENTER COMPANY NAME TO SEARCH IN RECORD:");
        String com_search = input.nextLine();
        boolean search = false; // to find that company exits or not
        // arrays to store data from files
        String[] name_array=new String [100];
        String[] address_array=new String [100];
        String[] contact_array=new String [100];
        String[] email_array=new String [100];
        String names;
        while ((names=com_names.readLine())!=null) {
            name_array=names.split(",,");
            String contacts = com_contacts.readLine();
            contact_array = contacts.split(",,");
            String addresses = com_addresses.readLine();
            address_array = addresses.split(",,");
            String emails = com_emails.readLine();
            email_array = emails.split(",,");

            for (int i = 0; i < name_array.length; i++) {
                if (com_search.equalsIgnoreCase(name_array[i])) {
                    search = true;  // it means medicine found
                    print_box("------" + com_search + " Company EXISTS in Record ------");
                    System.out.println("Company Name   " + "\t\t\t" + name_array[i]);
                    System.out.println("Company Contact" + "\t\t\t" + contact_array[i]);
                    System.out.println("Company Email  " + "\t\t\t" + email_array[i]);
                    System.out.println("Company Address" + "\t\t\t" + address_array[i]);
                    break;
                }
            }
        }
        if (search == false)
            print_box(com_search + " Company not Found in Record");
        com_names.close();
        com_emails.close();
        com_contacts.close();
        com_addresses.close();
    }
    // updating a company record
    public static void Update_Company()throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  UPDATE COMPANY ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ======================================\n");
        boolean found = false;
        String update_companyName; // name to update company
        do {
            System.out.println("ENTER COMPANY NAME TO UPDATE:");
            update_companyName= input.nextLine();
        } while (update_companyName.isEmpty());
        File temp_name_file = new File(com_path, "Temp_names_file.txt");
        File temp_address_file = new File(com_path, "Temp_addresses_file.txt");
        File temp_contact_file = new File(com_path, "Temp_contacts_file.txt");
        File temp_email_file = new File(com_path, "Temp_emails_file.txt");
        //.........................................................................
        BufferedReader com_names = new BufferedReader(new FileReader(com_names_file));
        BufferedReader com_addresses = new BufferedReader(new FileReader(com_address_file));
        BufferedReader com_contacts = new BufferedReader(new FileReader(com_contact_file));
        BufferedReader com_emails = new BufferedReader(new FileReader(com_email_file));
        //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        if (!temp_name_file.exists()) {
            temp_name_file.createNewFile();
            temp_contact_file.createNewFile();
            temp_address_file.createNewFile();
            temp_email_file.createNewFile();
        }
        //........................................................................
        PrintWriter temp_names = new PrintWriter(temp_name_file);
        PrintWriter temp_addresses= new PrintWriter(temp_address_file);
        PrintWriter temp_contacts = new PrintWriter(temp_contact_file);
        PrintWriter temp_emails = new PrintWriter(temp_email_file);
        //............................................................................
        String names;
        String[] name_array = new String [100];          String[] address_array = new String [100];
        String[] contact_array = new String [100];      String[] email_array = new String [100];
        //.......................
        int index = 0;
        int var = 0;
        int count = 0;
        int counter = 0;
        boolean loop = true;
        ///...........................
        while ((names = com_names.readLine()) != null) {
            name_array = names.split(",,");
            String addresses = com_addresses.readLine();
            address_array = addresses.split(",,");
            String contacts = com_contacts.readLine();
            contact_array = contacts.split(",,");
            String emails = com_emails.readLine();
            email_array= emails.split(",,");
        }
        String update_choice = "";
        for (String x : name_array) {
            if (update_companyName.equalsIgnoreCase(x)) {
                found = true;
                index=count;
                System.out.println("------------------------------------");
                System.out.println("|1. COMPANY NAME ...........Press 1|\n|2. COMPANY ADDRESS ........Press 2|\n" +
                        "|3. COMPANY EMAIL ..........Press 3|\n|4. COMPANY CONTACT NO .....Press 4|");
                System.out.println("------------------------------------");
                while (true) {
                    System.out.println("WHAT DO YOU WANT TO UPDATE:");
                    update_choice = input.nextLine();
                    if (!(update_choice.equals("1") || update_choice.equals("2") || update_choice.equals("3") ||
                            update_choice.equals("4")))
                        print_box("INVALID ENTRY! INPUT AGAIN");
                    else
                        break;}
            }
            count++; // incrementing it to find medicine index
        }
        if(found) { // if update medicine exists in stock
            if (update_choice.equals("1")) {
                String new_name = "";
                do {
                    System.out.println("ENTER NEW NAME OF COMPANY:");
                    new_name = input.nextLine();
                } while (new_name.isEmpty());
                for (int i = 0; i < name_array.length; i++) {
                    if (index == counter) {
                        temp_names.write(new_name + ",,");
                    } else
                        temp_names.write(name_array[i] + ",,");
                    counter++;
                }
                for (int i = 0; i < name_array.length; i++) {
                    temp_addresses.write(address_array[i] + ",,");
                    temp_contacts.write(contact_array[i] + ",,");
                    temp_emails.write(email_array[i] + ",,");
                }
            }
            //......................................................
            if (update_choice.equals("2")) {
                counter = 0;
                String new_address = "";
                do {
                    System.out.println("Enter New Address of Company:");
                    new_address = input.nextLine();
                } while (new_address.isEmpty());
                for (int i = 0; i < address_array.length; i++) {
                    if (index == counter)
                        temp_addresses.write(new_address + ",,");
                    else
                        temp_addresses.write(address_array[i] + ",,");
                    counter++;
                }
                for (int i = 0; i < address_array.length; i++) {
                    temp_names.write(name_array[i] + ",,");
                    temp_contacts.write(contact_array[i] + ",,");
                    temp_emails.write(email_array[i] + ",,");
                }
            }
            //.......................................
            if (update_choice.equals("3")) {
                counter = 0;
                String new_email = "";
                while (true) {
                    System.out.println("ENTER NEW EMAIL OF COMPANY:");
                    new_email = input.nextLine();
                    boolean Check = isValidEmail(new_email);
                    if (Check == true)
                        break;
                }
                for (int i = 0; i < email_array.length; i++) {
                    if (index == counter)
                        temp_emails.write(new_email + ",,");
                    else
                        temp_emails.write(email_array[i] + ",,");
                    counter++;
                }
                for (int i = 0; i < email_array.length; i++) {
                    temp_names.write(name_array[i] + ",,");
                    temp_addresses.write(address_array[i] + ",,");
                    temp_contacts.write(contact_array[i] + ",,");
                }
            }
            //'''''''''''''''''''''''''''''''''''''''''''''''''''''''
            if (update_choice.equals("4")) {
                counter = 0;
                String new_contact = "";
                boolean check = true;
                boolean phoneIntCheck = true;
                do {
                    try {
                        while (true) {
                            System.out.println("NEW COMPANY CONTACT NO (FORMAT: 0000-0000000):");
                            new_contact = input.nextLine();
                            boolean Check = isPhoneValid(new_contact);
                            if (Check == true)
                                break;
                        }
                        String[] phone_parts = new_contact.split("-");
                        Integer.parseInt(phone_parts[0]);
                        Integer.parseInt(phone_parts[1]);
                        phoneIntCheck = false;
                    } catch (NumberFormatException ex) {
                        print_box("INVALID CONTACT NO,ENTER ONLY NUMBERS");
                        phoneIntCheck = true;
                    }
                } while (phoneIntCheck);
                for (int i = 0; i < contact_array.length; i++) {
                    if (index == counter)
                        temp_contacts.write(new_contact + ",,");
                    else
                        temp_contacts.write(contact_array[i] + ",,");
                    counter++;
                }
                for (int i = 0; i < contact_array.length; i++) {
                    temp_names.write(name_array[i] + ",,");
                    temp_addresses.write(address_array[i] + ",,");
                    temp_emails.write(email_array[i] + ",,");
                }
            }
        }
        //..........................................................
        if(found==false)
            print_box("------------- "+update_companyName+ " Not Found in Record -----------");
        else
            print_box("----------- "+update_companyName+ " Successfully Updated -----------");
        //closing all files
        com_names.close();
        com_contacts.close();
        com_addresses.close();
        com_emails.close();
        temp_names.close();
        temp_addresses.close();
        temp_contacts.close();
        temp_emails.close();
        //'''''''''''''''''''''''
        if(found){
            com_names_file.delete();
            com_contact_file.delete();
            com_address_file.delete();
            com_email_file.delete();
            // renaming all temporary files to original files
            temp_name_file.renameTo(com_names_file);
            temp_address_file.renameTo(com_address_file);
            temp_contact_file.renameTo(com_contact_file);
            temp_email_file.renameTo(com_email_file);
        }
    }
    // company List
    public static void Company_List()throws IOException {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =====================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  COMPANY LIST ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  =====================================");
        ///////////////////////////////////////////
        BufferedReader com_names = new BufferedReader(new FileReader(com_names_file));
        BufferedReader com_contacts = new BufferedReader(new FileReader(com_contact_file));
        BufferedReader com_addresses = new BufferedReader(new FileReader(com_address_file));
        BufferedReader com_emails = new BufferedReader(new FileReader(com_email_file));
        //////////////////////////////////////////
        System.out.println("\n-------------------------------------------------------------------------" +
                "---------------------------------------------------------------------------");
        System.out.println(String.format("%-25s %10s %-20s %18s %-15s %10s %-25s ", "COMPANY NAMES", "|", "E-MailS",
                "|", "CONTACT NO", "|", "COMPLETE ADDRESS"));
        System.out.println("------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------");

        boolean check = false;// to check company list is empty or not
        //arrays to store data from files
        String[] names_array = new String[100];
        String[] contacts_array = new String[100];
        String[] emails_array = new String[100];
        String[] address_array = new String[100];
        String names;
        while ((names = com_names.readLine()) != null) {
            check = true;  // it means the files are not empty
            names_array = names.split(",,");
            String contacts = com_contacts.readLine();
            contacts_array = contacts.split(",,");
            String addresses = com_addresses.readLine();
            address_array = addresses.split(",,");
            String emails = com_emails.readLine();
            emails_array = emails.split(",,");
            for (int i = 0; i < names_array.length; i++) {
                System.out.println(String.format("%-25s %10s %-20s %18s %-15s %10s %-25s ", names_array[i], "|",
                        emails_array[i], "|", contacts_array[i], "|", address_array[i]));
            }
        }
        if(check==false)
            print_box("Currently, The Company List is Empty");
        com_names.close();
        com_emails.close();
        com_addresses.close();
        com_contacts.close();
    }
    // Same Company Medicines
    public static void Same_Company_Medicines()throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSAME COMPANY MEDICINES");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
        String company_name;
        do {
            System.out.print("\nENTER COMPANY NAME TO SEARCH ALL MEDICINES OF IT :");
            company_name = input.nextLine();
            if (company_name.isEmpty())
                print_box("EMPTY INPUT IS NOT ALLOWED");
        } while (company_name.isEmpty());
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        boolean search = false; // to find that medicine exits or not
        String names;
        //arrays
        String[] name_array=new String[100];
        String[] company_array=new String[100];
        while((names=med_names.readLine())!=null) {
            name_array = names.split(",,");
            String companies=med_companies.readLine();
            company_array=companies.split(",,");
        }
        System.out.println("\n---------------------------------------------");
        System.out.println(" Medicines Having " + company_name + " company");
        System.out.println("---------------------------------------------");
        System.out.println("Medicine Names");
        int n=1;
        for (int i = 0; i < company_array.length; i++) {
            if(company_array[i]!=null)
                if (company_array[i].equalsIgnoreCase(company_name)) {
                    search=true;
                    System.out.println(n+"."+name_array[i]);
                }
        }
        System.out.println("---------------------------------------------");
        if(search==false)
            print_box("No Medicine Found Having Company "+company_name);
    }
    // Checking CNIC
    public static boolean isCnicValid(String cnic) {
        if (cnic.length() == 15 && cnic.charAt(5) == '-' && cnic.charAt(13) == '-')
            return true;
        else {
            print_box("INVALID CNIC FORMAT! INPUT AGAIN");
            return false;
        }
    }
    // Checking date Validity
    public static boolean isDateValid(String s) {
        boolean date_check=true;
        String[] date_array = s.split("-");
        int date = Integer.parseInt(date_array[0]);
        int month = Integer.parseInt(date_array[1]);
        if (s.length() == 10) {
            if (s.charAt(2) == '-' && s.charAt(5) == '-' && (date >= 1 && date <= 31) && (month >= 1 && month <= 12))
                date_check = false;
            else
                print_box("WRONG DATE FORMAT! INPUT AGAIN");
        }
        return date_check;
    }
    //printing Box
    public static void print_box(String string) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i <= string.length() + 1; i++)
            System.out.print("_");
        System.out.println();
        System.out.println("|" + string + "|");
        for (int i = 0; i <= string.length() + 1; i++)
            System.out.print("-");
        System.out.println();
    }
    // validity of phone checking
    public static boolean isPhoneValid(String phone){
        if ((phone.length() == 12) && (phone.charAt(0) == '0' && phone.charAt(1) == '3') && phone.charAt(4) == '-') {
            return true;
        } else {
            print_box("INVALID CONTACT FORMAT(FORMAT: 0000-0000000)");
            return false;
        }
    }
    // checking mail
    public static boolean isValidEmail(String email){
        if (email.contains("@gmail.com") && email.charAt(0)!='@' && (email.endsWith("@gmail.com"))) {
            return true;
        } else {
            print_box("INVALID EMAIL! INPUT AGAIN");
            return false;
        }
    }
    // login
    public static void System_Login(boolean change_login) throws IOException{
        Scanner input = new Scanner(System.in);
        if(!login_path.exists())
            login_path.mkdir();
        String my_username="";
        String my_password="";
        int attempts = 3;
        if (!login.exists() || change_login==true) {  // condition for sign up
            if(change_login==false){
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t       S I G N   U P ");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tC R E A T E   S Y S T E M   L O G I N");
            }
            else{
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t C H A N G E  P A S S W O R D ");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
            }
            do {
                System.out.print("\nENTER YOUR USERNAME:");
                my_username = input.nextLine();
            } while (my_username.isEmpty());
            System.out.println("\n--------------------------------------------------");
            System.out.println("|1.A password must have at least eight characters|\n" +
                    "|2.A password consists of only letters and digits|\n" +
                    "|3.A password must contain at least two digits   |");
            System.out.println("--------------------------------------------------");
            do{
                System.out.print("ENTER YOUR PASSWORD:");
                my_password = input.nextLine();
            } while (isValidPassword(my_password) == false);
            //..............................................
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\tPLEASE PROVIDE THE FOLLOWING INFORMATION");
            String store_name="";
            do {
                System.out.print("ENTER YOUR MEDICAL STORE'S NAME:");
                store_name= input.nextLine();
            }while (store_name.isEmpty());
            //......................................................
            boolean phoneIntCheck = true;
            String store_contact="";
            do {
                try {
                    while (true) {
                        System.out.print("ENTER SOCIAL CONTACT NO (FORMAT: 0000-0000000):");
                        store_contact= input.nextLine();
                        boolean Check = isPhoneValid(store_contact);
                        if (Check == true)
                            break;
                    }
                    String[] phone_parts = store_contact.split("-");
                    Integer.parseInt(phone_parts[0]);
                    Integer.parseInt(phone_parts[1]);
                    phoneIntCheck = false;
                } catch (NumberFormatException ex) {
                    print_box("INVALID CONTACT NO,ENTER ONLY NUMBERS");
                    phoneIntCheck = true;
                }
            } while (phoneIntCheck);
            //................................................................
            String store_address="";
            do {
                System.out.println("MEDICAL STORE'S ADDRESS:");
                store_address= input.nextLine();
            } while (store_address.isEmpty());
            //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
            String store_email="";
            while (true) {
                System.out.println("ENTER STORE'S EMAIL:");
                store_email = input.nextLine();
                boolean Check = isValidEmail(store_email);
                if (Check == true)
                    break;
            }
            //''''''''''''''''''''''''''''''''''''''''''''''''''''''''
            try {
                if (!login.exists())
                    login.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            FileWriter fw = new FileWriter(login);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(my_username + ",,");
            bw.write(my_password+",,");
            bw.write(store_name+",,");
            bw.write(store_contact+",,");
            bw.write(store_address+",,");
            bw.write(store_email+",,");
            bw.close();
            print_box("--------- LOGIN CREATED SUCCESSFULLY ---------");
            print_box("YOUR (USERNAME) :" + my_username+ " (PASSWORD) : " + my_password);
        }
        ///////////////////////////////////////////////
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tL O G I N ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t  ========================================");
        String password;
        String user_name;
        FileReader fr = new FileReader(login);
        BufferedReader br = new BufferedReader(fr);
        String[] logs = null;
        String s;
        while ((s = br.readLine()) != null) {
            logs = s.split(",,");
        }
        do {
            if (attempts <= 0) {
                print_box("System Locked! You have entered wrong login Three times");
                System.exit(0);
            }
            System.out.print("ENTER USERNAME:");
            user_name = input.nextLine();
            System.out.print("ENTER PASSWORD:");
            password = input.nextLine();
            if (user_name.equals(logs[0]) == false)
                print_box("INCORRECT USERNAME");
            if (password.equals(logs[1]) == false)
                print_box("INCORRECT PASSWORD");
            if (user_name.equals(logs[0]) == false || password != logs[1])
                attempts--;
        } while (password.equals(logs[1]) == false || user_name.equals(logs[0]) == false);
        br.close();
    }
    // Master medicine file
    public static void medicine_master_file()throws IOException{
        //................................................................................//
        BufferedReader med_names=new BufferedReader(new FileReader(med_names_file));
        BufferedReader med_formulas=new BufferedReader(new FileReader(med_formulas_file));
        BufferedReader med_companies=new BufferedReader(new FileReader(med_companies_file));
        BufferedReader med_prices=new BufferedReader(new FileReader(med_prices_file));
        BufferedReader med_quanities=new BufferedReader(new FileReader(med_quantities_file));
        BufferedReader med_locations=new BufferedReader(new FileReader(med_locations_file));
        BufferedReader med_exp_dates=new BufferedReader(new FileReader(med_exp_dates_file));
        //................................................................................//
        boolean search = false; // to find that medicine exits or not
        String names;
        String[] name_array=new String[100];
        String[] price_array=new String[100];
        String[] quantity_array=new String[100];
        String[] company_array=new String[100];
        String[] formula_array=new String[100];
        String[] location_array=new String[100];
        String[] exp_date_array=new String[100];
        while((names=med_names.readLine())!=null) {
            name_array = names.split(",,");
            String prices = med_prices.readLine();
            price_array = prices.split(",,");
            String quantities = med_quanities.readLine();
            quantity_array = quantities.split(",,");
            String com_names = med_companies.readLine();
            company_array = com_names.split(",,");
            String formulas = med_formulas.readLine();
            formula_array = formulas.split(",,");
            String locations = med_locations.readLine();
            location_array = locations.split(",,");
            String exp_dates = med_exp_dates.readLine();
            exp_date_array = exp_dates.split(",,");
        }
        File master_file=new File(med_path,"Medicine_Master_file.txt");
        master_file.createNewFile();  // creating master file
        BufferedWriter Master_file=new BufferedWriter(new FileWriter(master_file));
        Master_file.write("\t\t\t\t\tM E D I C I N E   E N T I T Y\n");
        Master_file.write("_________________________________________________________________________________________" +
                "________________________\n");
        Master_file.write("MEDICINE NAMES\tCOMPANY NAMES\tFORMULAS\tPRICES\t\tQUANTITIES\tLOCATIONS\tEXPIRY DATES\n");
        Master_file.write("_________________________________________________________________________________________" +
                "________________________\n");
        for (int i = 0; i < name_array.length; i++) {
            if(name_array[i]!=null && company_array[i]!=null && formula_array[i]!=null && price_array[i]!=null
                    && location_array[i]!=null && exp_date_array!=null && quantity_array[i]!=null) {
                Master_file.write(name_array[i] + "\t\t");
                Master_file.write(company_array[i] + "\t\t");
                Master_file.write(formula_array[i] + "\t\t");
                Master_file.write(price_array[i] + "\t\t");
                Master_file.write(quantity_array[i] + "\t\t");
                Master_file.write(location_array[i] + "\t\t");
                Master_file.write(exp_date_array[i] + "\t\t");
                Master_file.write("\n");
            }
        }
        Master_file.write("_________________________________________________________________________________________" +
                "________________________\n");
        // closing all files
        Master_file.close();       med_names.close();
        med_formulas.close();      med_quanities.close();
        med_locations.close();     med_exp_dates.close();
        med_companies.close();     med_prices.close();
    }
}

