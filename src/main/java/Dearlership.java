import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dearlership {

    public static void main(String[] args) {
        String name;
        String  tyepOfTransaction;
        String vehicleModel;
        double totalMoney;
        System.out.println("Hi welcome to Ford car dealership!! what's your name?");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("How can I help you? Do you want to finance or cash?");
        tyepOfTransaction = sc.nextLine();
        if(tyepOfTransaction.equals("finance")){
            System.out.println("What is your credit score?");
            int creditScore = sc.nextInt();

        }
        else{

        }
        System.out.println("What kind of vehicle you like to buy?");
        vehicleModel = sc.nextLine();
        System.out.println("How much money you have?");
        totalMoney = sc.nextDouble();
        System.out.println("Your transaction is processing !!");
        createCustomer();
        System.out.println("Hurray !!, thanks for the purchase. ");

        
    }

    public static void createCustomer(String name, String custAddress, double cashInHand, boolean finance, int creditScore){
        Customer newCustomer = new Customer();

    }



    public static void handleCustomer(Customer customer, boolean finance, Vehicle vehicle){
        if(customer.isFinance()) {
            calculateTotalcarValueIfFinancing(customer,vehicle);
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
