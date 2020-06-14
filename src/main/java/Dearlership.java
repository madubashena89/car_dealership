import java.util.*;

public class Dearlership {

    public static void main(String[] args) {
        //customer details
        String name;
        String  tyepOfTransaction;
        String address;
        double cashInHand;
        boolean finance;
       //vehicle details
        int year;
        int price;
        String vehicleModel;

        System.out.println("Hi welcome to Ford car dealership!! what's your name?");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("May I know your address ?");
        address = sc.nextLine();
        System.out.println("What's the car model you like to buy??");
        vehicleModel = sc.nextLine();
        System.out.println("What's the car year ");
        year = sc.nextInt();
        System.out.println("What's the car price you saw online? ");
        price = sc.nextInt();
        System.out.println("Do you want to finance or cash?");
        tyepOfTransaction = sc.nextLine();
        if(tyepOfTransaction.equalsIgnoreCase("finance")){
            finance = true;
            System.out.println("What is your credit score?");
            int creditScore = sc.nextInt();
            createCustomerAndVehicle(name, address, 0.0, true, creditScore, year, vehicleModel, price);
            System.out.println("Your transaction is processing !!");
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle ");

        }
        else{
            System.out.println("How much money you have?");
            cashInHand = sc.nextDouble();
            createCustomerAndVehicle(name, address, cashInHand, true, 850, year, vehicleModel, price);
            System.out.println("Your transaction is processing !!");
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle ");

        }

    }

    public static void createCustomerAndVehicle(String name, String custAddress, double cashInHand, boolean finance,
                                                int creditScore , int year, String model, int price){
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setCustomerAddress(custAddress);
        newCustomer.setFinance(finance);
        newCustomer.setCreditScore(creditScore);
        newCustomer.setCashInHand(cashInHand);

        Vehicle newVehicle = new Vehicle();
        newVehicle.setYear(year);
        newVehicle.setModel(model);
        newVehicle.setPrice(price);
        handleCustomer(newCustomer,newCustomer.isFinance(), newVehicle);
    }

    public static void handleCustomer(Customer customer, boolean finance, Vehicle vehicle){
        if(customer.isFinance()) {
            assignFinanceToTheBank(customer,vehicle);
        }
        else if(vehicle.getPrice() <= customer.getCashInHand()){
            processCashTransaction(customer, vehicle);
        }
        else {
            System.out.println("Please bring this much money");
        }
    }

    private static double getCreditScore(Customer customer){
        double interestRate = 0.0;
        if(customer.getCreditScore() >= 720){
            interestRate = 0;
        }else if(customer.getCreditScore() >= 650 && customer.getCreditScore() <720){
            interestRate = 0.05;
        }else if(customer.getCreditScore() >= 550 && customer.getCreditScore() <650){
            interestRate = 0.15;
        }else {
            System.out.println(customer +" is not eligible to buy the car");
        }
        return interestRate;
    }
    
    public static void processFinanceTransaction(Customer customer, Vehicle vehicle){
        saveCustomerToList(customer,vehicle);
        calculateTotalcarValueIfFinancing(customer, vehicle);
    }

    public static void assignFinanceToTheBank(Customer customer, Vehicle vehicle){
        Double carValue =  calculateTotalcarValueIfFinancing(customer, vehicle);
        List<Double> carValueList = new ArrayList<>();
        carValueList.add(carValue);
    }
    
    private static double calculateTotalcarValueIfFinancing(Customer customer, Vehicle vehicle){
         double carValueWithoutInterestAndTax = vehicle.getPrice();
         double taxRate = 0.075;
         double totalInterest = getCreditScore(customer)*carValueWithoutInterestAndTax;
         double totalvalueBeforeTax = carValueWithoutInterestAndTax + totalInterest;
         double totalTax = totalvalueBeforeTax*taxRate;
         double totalCarValueWithInterestAndTax = totalvalueBeforeTax + totalTax;
         return  totalCarValueWithInterestAndTax;
    }
    
    private static void processCashTransaction(Customer customer, Vehicle vehicle){
            saveCustomerToList(customer,vehicle);
            addCashToDearlershipAccount(customer,vehicle);
    }
    
    private static String generateCustomerID(Customer customer, Vehicle vehicle){
        String customerID =customer.getName()+ vehicle.getModel() + vehicle.getYear()+ customer.isFinance();
        customer.setCustomerID(customerID);
        return customerID;
    }
    
    private static void saveCustomerToList(Customer customer, Vehicle vehicle){
        List<String> customerList = new ArrayList<>();
        customerList.add(generateCustomerID(customer, vehicle));
    }
    
    public static void makeTransaction(Customer customer, Vehicle vehicle){
        if(customer.isFinance()){
            saveCustomerToList(customer,vehicle);
            addCashToDearlershipAccount(customer,vehicle);
        }
    }
    
    public static void addCashToDearlershipAccount(Customer customer, Vehicle vehicle){
        double dealrshipCash = 0;
        while (dealrshipCash>0){
            dealrshipCash += calculateTotalcarValueIfFinancing(customer, vehicle);
        }
    }
}
