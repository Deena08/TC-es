import java.util.*;

class Main{

    public static int isVaildConsumerId(String consumerId){
        if(consumerId.length()==13){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int isExistingEmail(String email,ArrayList<customer > custList){
        if(!custList.isEmpty()) {
            int exist = 0;
            for(int i=0; i<custList.size(); i++) {
                if(custList.get(i).getEmail().equals(email)) {
                    exist = 1;
                }
            }
            if( exist == 1) {
                return 1;
            } else return 0;
        }
        return 0;
    }

    public static int isVaildMobileNUmber(String mobileNumber){
        if(mobileNumber.length()<11){
            return 1;
        }
        return 0;
    }

    public static int isVaildUserName(String customerName){
        if(customerName.length()<30){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int isVaildBillNumber(int billNumber){
        if(Integer.toString(billNumber).length()<6){
            return 1;
        }
        return 0;
    }

    public static int isPasswordValid(String password) {
        if(password.length() >= 6 && password.length() <= 12 ) {
            return 1;
        } else return 0;
    }

    public static int isMatch(String password,String confirmPassword){

        if(password.equals(confirmPassword))return 1;
        else return 0;
    }

    public static int deleteCustomer(String consumerId,ArrayList<customer>custList){
        int i=0;
        if(!custList.isEmpty()){
            while(i<custList.size()){
                if(custList.get(i).getConsumerId().equals(consumerId)){
                    custList.remove(custList.get(i));
                    return 0;
                }
                i++;
            }
            return 1;
        }
        return 1;

    }

    public static int checkForUpdate(String consumerId,String emailId,ArrayList <customer> custList){

        if(!custList.isEmpty()){
            int i=0;
            while(i<custList.size()){

                if(custList.get(i).getConsumerId().equals(consumerId) && custList.get(i).getEmail().equals(emailId)){
                    return 0;
                }

                i++;
            }
        }
        return 1;
    }

    public static void printALLConsumer(ArrayList<customer>custList){

        if(custList.isEmpty()){
            System.out.println();
            System.out.println("No data available");
            return;
        }
        for(int i=0;i<custList.size();i++){
            System.out.println("\n Customer "+i);

            custList.get(i).getCustomersDetails();
            System.out.println();
        }
    }
    public static customer getCustomerById(String consumerId, ArrayList<customer> custList) {
        for (customer cust : custList) {
            if (cust.getConsumerId().equals(consumerId)) {
                return cust; // Return the found customer object
            }
        }
        return null; // Return null if customer not found
    }
    public static Complaint getCustomerComplaint(String consumerId, ArrayList<Complaint> custList) {
        for (Complaint cust : custList) {
            if (cust.getConsumerId().equals(consumerId)) {
                return cust; // Return the found customer object
            }
        }
        return null; // Return null if customer not found
    }



    public static void main(String[] args) {
        Scanner b=new Scanner(System.in);

        int exit=0;
        ArrayList<customer> custList=new ArrayList<customer>();
        ArrayList<Complaint>complaintsList=new ArrayList<>();
        System.out.println();
        System.out.print(" \n**--**Eletricity Management System**--**\n");

        while(exit==0){
            int choice=0;
            System.out.print("\n [1]Add Customer\n [2]Update Customer\n [3]Delete Customer\n [4]All consumer Data \n [5]Add Bill \n [6]Delete Bill \n [7]Update Bill \n [8]Get Customer Details \n [9]Register Complaint \n [10]Delete Complaint\n [11]Search Complaint \n [0]Exit");
            System.out.println();

            System.out.print("\n Enter your choice:");
            choice =b.nextInt();

            if(choice==1){

                System.out.print("\n#####Customer Registration#####\n");

                b.nextLine();
                System.out.println();
                System.out.print("\nEnter your consumer Id: ");
                String consumerId=b.nextLine();
                while(isVaildConsumerId(consumerId)==0){
                    System.out.println("\nconsumer Id should be an 13 digit number");
                    System.out.println("\nEnter your consumer Id: ");
                    consumerId=b.nextLine();
                }

                System.out.print("\nEnter your Name: ");
                String customerName=b.nextLine();
                while(isVaildUserName(customerName)==0){
                    System.out.print("\nEnter Name between 30 Characters");
                    System.out.print("\nEnter your Name: ");
                    customerName=b.nextLine();
                }

                System.out.print("\nEnter Email: ");
                String email = b.nextLine();
                while (isExistingEmail(email, custList) == 1) {
                    System.out.println("Email Exist");
                    System.out.print("\nEnter Email: ");
                    email = b.nextLine();
                }

                System.out.print("\nEnter your Bill Number: ");

                int billNumber=b.nextInt();b.nextLine();
                while(isVaildBillNumber(billNumber)==0){
                    System.out.println("consumer Id should be an 5 digit number");
                    System.out.print("\nEnter your Bill Number: ");
                    billNumber=b.nextInt();
                }
                System.out.println("\nEnter the title: ");
                System.out.print("\nMr. / Mrs. ");
                String Title=b.next();

                System.out.print("\nEnter your Mobile Number: ");
                b.nextLine();
                String mobileNumber=b.nextLine();
                while(isVaildMobileNUmber(mobileNumber)==0){
                    System.out.print("\nmoblie Number should be an 10 digit number");
                    System.out.print("\nEnter your Mobile Number: ");
                    mobileNumber=b.nextLine();
                }

                System.out.print("\nEnter Password: ");
                String password = b.nextLine();
                while (isPasswordValid(password) == 0) {
                    System.out.println("Password does not meet the security policy");
                    System.out.print("\nEnter Password: ");
                    password = b.nextLine();
                }
                b.nextLine();
                System.out.print("\nconfirmPassword: ");
                String confirmPassword = b.nextLine();
                while (isMatch(password,confirmPassword) == 0) {
                    System.out.println("Password and confirmPassword doesn't matches");
                    System.out.print("\nEnter confirmPassword: ");
                    confirmPassword = b.nextLine();
                }
                System.out.println();

                customer obj =new customer(consumerId,billNumber,Title,customerName,email,mobileNumber,password);

                custList.add(obj);

            }
            else if(choice==3){

                b.nextLine();
                System.out.print("\n**customer Deletion**");
                System.out.println();
                System.out.print("\nEnter the consumer Id for the deletion: ");

                String consumerId=b.nextLine();

                if(deleteCustomer(consumerId,custList)==0){
                    System.out.print("\n Successfully Deleted customer Details");
                    System.out.println();
                }
                else{
                    System.out.print("\n consumer Id not found , please try again\n");
                    System.out.println();
                }


            }

            else if(choice==2){

                System.out.print("\n**Update customer Details**");

                System.out.print("\n Enter your consumer ID: ");
                b.nextLine();
                String consumerId=b.nextLine();

                System.out.print("\n Enter your email Id: ");
                String emailId=b.nextLine();

                if(checkForUpdate(consumerId,emailId,custList)==0){

                    System.out.print("\n Enter the new Email: ");

                    String newEmailId=b.nextLine();
                    customer obj1=new customer();
                    obj1.setEmail(newEmailId);


                    System.out.print("\n updated Customer email Id Successfully");
                    System.out.println();

                }
                else{
                    System.out.print("\n user Not found, try again");
                }

            }

            else if(choice==4){
                printALLConsumer(custList);
            }
            else if(choice == 5) {
                System.out.println();
                System.out.print("\n***Customer Bill***");
                b.nextLine(); // Clear input buffer
                System.out.print("\nEnter consumer Id: ");

                String consumerId = b.nextLine();
                customer existingCustomer = getCustomerById(consumerId, custList);

                if (existingCustomer != null) { // Customer exists
                    System.out.print("Enter Due Amount: ");
                    double dueAmount = b.nextDouble();
                    System.out.print("Enter Payable Amount: ");
                    double payableAmount = b.nextDouble();

                    // Set the bill for the existing customer
                    existingCustomer.setBill(dueAmount, payableAmount);
                    System.out.println("Bill updated successfully.");
                } else {
                    System.out.println("No customer exists with the given ID.");
                }
            }
            else if(choice==6){
                b.nextLine();
                System.out.println();
                System.out.print("\n***Delete Bill***");
                System.out.print("\nEnter consumer Id");
                String consumerId=b.nextLine();
                customer existingCustomer = getCustomerById(consumerId, custList);
                if(existingCustomer!=null){
                    existingCustomer.setBill(0.0,0.0);
                    System.out.print("successfully Deleted Bill");
                }else{
                    System.out.print("\nPlease enter valid Consumer Id");
                }
            }
            else if(choice==7){
                b.nextLine();
                System.out.println();
                System.out.print("\n***Update Bill for the Consumer***");
                String consumerId=b.nextLine();
                customer existingCustomer = getCustomerById(consumerId, custList);
                if(existingCustomer!=null){
                    System.out.print("\nEnter the Due amount");
                    double dueAmount=b.nextDouble();
                    double payableAmount=b.nextDouble();
                    existingCustomer.setBill(dueAmount,payableAmount);
                    System.out.print("successfully Updated Bill Amount");
                }else{
                    System.out.print("\nPlease enter valid Consumer Id");
                }
            }

            else if(choice==8){
                b.nextLine();
                System.out.println();
                System.out.print("\n***Customer Details***");
                String consumerId=b.nextLine();
                customer existingCustomer = getCustomerById(consumerId, custList);
                if(existingCustomer!=null){
                    System.out.print("\n***Customer Details****");
                    existingCustomer.getCustomersDetails();
                    existingCustomer.bill.printBillDetails();
                }else{
                    System.out.print("\nPlease enter valid Consumer Id");
                }
            }
            else if(choice==9){
                b.nextLine();
                System.out.println();
                System.out.print("\n***Register a Complaint");

                String complaintType = "";
                String category = "";
                String landmark;
                String customerName;
                String problem;
                String consumerId;
                String address;
                String mobileNumber;



                System.out.print("\nChoose complaint type");
                System.out.print("\n[1]Billing related\n[2]Voltage related\n[3]Frequent Disruption\n[4]Street light\n[5]Pole");
                int choice2=b.nextInt();

                if(choice2==1){
                    complaintType="Billing related";
                } else if (choice2==2) {
                    complaintType="Voltage related";
                }else if(choice2==3){
                    complaintType="Frequent Disruption";
                }else if(choice2==4){
                    complaintType="Street Light";
                }else if(choice2==5){
                    complaintType="Pole";
                }

              System.out.print("\n select category");
                switch (complaintType) {
                    case "Billing related" -> {
                        int choice3 = 0;
                        System.out.print("\n[1]Incorrect Bill Amount");
                        System.out.print("\n[2]Billed for Unused period");
                        System.out.print("\nEnter choice: ");
                        choice3 = b.nextInt();
                        if (choice3 == 1) {
                            category = "Incorrect Bill Amount";
                        } else {
                            category = "Billed for Unused period";
                        }
                    }
                    case "Voltage related" -> {
                        int choice3 = 0;
                        System.out.print("\n[1]Low Voltage");
                        System.out.print("\n[2]High Voltage");
                        System.out.print("\nEnter choice: ");
                        choice3 = b.nextInt();
                        if (choice3 == 1) {
                            category = "Low Voltage";
                        } else {
                            category = "High Voltage";
                        }
                    }
                    case "Frequent Disruption" -> {
                        int choice3 = 0;
                        System.out.print("\n[1]Frequent power cuts");
                        System.out.print("\n[2]Intermittent power cuts");
                        System.out.print("\nEnter choice: ");
                        choice3 = b.nextInt();
                        if (choice3 == 1) {
                            category = "Frequent power cuts";
                        } else {
                            category = "Intermittent power cuts";
                        }
                    }
                    case "Street light" -> {
                        int choice3 = 0;
                        System.out.print("\n[1]non-funtional light");
                        System.out.print("\n[2]Dim lighting");
                        System.out.print("\nEnter choice: ");
                        choice3 = b.nextInt();
                        if (choice3 == 1) {
                            category = "non-funtional light";
                        } else {
                            category = "Dim lighting";
                        }
                    }
                    case "Pole" -> {
                        int choice3 = 0;
                        System.out.print("\n[1]Damaged pole");
                        System.out.print("\n[2]Leaning pole");
                        System.out.println("\nEnter choice: ");
                        choice3 = b.nextInt();
                        if (choice3 == 1) {
                            category = "Damaged pole";
                        } else {
                            category = "Leaning pole";
                        }
                    }
                }
               System.out.print("Enter the Landmark");
                landmark=b.nextLine();
               System.out.print("Enter the Customer Name");
               customerName=b.nextLine();
                System.out.print("Write the problem");
                problem=b.nextLine();
                System.out.print("Enter the Consumer Id");
                consumerId=b.nextLine();
                System.out.print("Enter the Address");
                address=b.nextLine();
                System.out.print("Enter the Mobile Number");
                mobileNumber=b.nextLine();
                Complaint comp=new Complaint(complaintType,category,landmark,customerName,problem,consumerId,address,mobileNumber);
                complaintsList.add(comp);
                System.out.print("\n Successfully registered Complaint");
            }
            else if(choice==10){
                System.out.println();
                b.nextLine();
                System.out.print("\n***Delete Complaint***");
                System.out.print("\n Enter the consumer ID");
                String consumerId=b.nextLine();
                Complaint existingCustomer = getCustomerComplaint(consumerId, complaintsList);
                if(existingCustomer!=null){
                   complaintsList.remove(existingCustomer);
                   System.out.print("\n Delete Customer Complaint");
                }else{
                    System.out.print("\nPlease enter valid Consumer Id");
                }
            }

            else if(choice==11){
                b.nextLine();
                System.out.println();
                System.out.print("\n***Search Complaint***");
                System.out.print("\nEnter Consumer ID");
                String consumerId=b.nextLine();
                Complaint existingCustomer = getCustomerComplaint(consumerId, complaintsList);
                if(existingCustomer!=null){
                    existingCustomer.getCustomerComplaintDetails();
                }else{
                    System.out.print("\nPlease enter valid Consumer Id");
                }

            }


            else if(choice==0){
                exit=1;
            }

        }
    }
}

class customer {
    String consumerId;
    int billNumber;
    String title;
    String customerName;
    String email;
    String mobile;
    int userId;
    String password;
    Bill bill; // Reference to Bill class

    private void generateUserID() {
        int min = 10000;
        int max = 99999;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        this.userId = rand;
    }

    public customer() {
        this.bill = new Bill(); // Initialize Bill object
    }

    public customer(String consumerId, int billNumber, String title, String customerName, String email, String mobile, String password) {
        this.consumerId = consumerId;
        this.billNumber = billNumber;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
        this.generateUserID();
        this.password = password;
        this.bill = new Bill(); // Initialize Bill object

        System.out.println("\nRegistration is Successfully complete");
        System.out.println();
        this.getCustomersDetails();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getMobileNumber() {
        return this.mobile;
    }

    public String getConsumerId() {
        return this.consumerId;
    }

    public void setEmail(String newEmailId) {
        this.email = newEmailId;
    }

    public void setBill(double dueAmount, double payableAmount) {
        this.bill.setBill(dueAmount, payableAmount);
    }

    public void getCustomersDetails() {
        System.out.println("Consumer ID: " + this.consumerId);
        System.out.println("Bill Number: " + this.billNumber);
        System.out.println("Title: " + this.title);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Email: " + this.email);
        System.out.println("Mobile Number: " + this.mobile);
        System.out.println("User ID: " + this.userId);
        System.out.println("Password: " + this.password);
       // this.bill.printBillDetails(); // Print bill details
    }
}


class Bill {
    private double dueAmount;
    private double payableAmount;

    public Bill() {
        this.dueAmount = 0.0;
        this.payableAmount = 0.0;
    }

    public Bill(double dueAmount, double payableAmount) {
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    public void setBill(double dueAmount, double payableAmount) {
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void printBillDetails() {
        System.out.println("Due Amount: " + this.dueAmount);
        System.out.println("Payable Amount: " + this.payableAmount);
    }
}
class Complaint{

    String compliantType;
    String category;
    String landmark;
    String customerName;
    String problem;
    String consumerId;
    String address;
    String mobileNumber;

    Complaint(String compliantType,String category,String landmark,
              String customerName,String problem,String consumerId,String address,String mobileNumber){
        this.compliantType=compliantType;
        this.category=category;
        this.landmark=landmark;
        this.customerName=customerName;
        this.problem=problem;
        this.consumerId=consumerId;
        this.address=address;
        this.mobileNumber=mobileNumber;
    }

    public String getConsumerId() {
        return this.consumerId;
    }

    public void getCustomerComplaintDetails(){
        System.out.println("Consumer ID: " + this.consumerId);
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Compliant Type: " + this.compliantType);
        System.out.println("Category: " + this.category);
        System.out.println("Landmark: " + this.landmark);
        System.out.println("problem: " + this.problem);
        System.out.println("Address: " + this.address);
        System.out.println("Mobile Number: " + this.mobileNumber);
    }
}