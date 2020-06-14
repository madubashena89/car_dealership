import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String employeeId;
    private String position;
    private int slary;
    private String department;
    private String branchName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSlary() {
        return slary;
    }

    public void setSlary(int slary) {
        this.slary = slary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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
            System.out.println("Your transaction is processing !!");
            assignFinanceToTheBank(customer,vehicle);

        }
        else if(vehicle.getPrice() <= customer.getCashInHand()){
            processCashTransaction(customer, vehicle);
            System.out.println("Your transaction is processing !!");
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle ");
        }
        else {
            System.out.println("Please bring " + vehicle.getPrice() +  "money on next time");
        }
    }

    private static double getCreditScore(Customer customer){
        double interestRate = 0.0;
        if(customer.getCreditScore() >= 720){
            interestRate = 0;
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle and the interest rate is: " + interestRate*100 + "%");
        }else if(customer.getCreditScore() >= 650 && customer.getCreditScore() <720){
            interestRate = 0.05;
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle and the interest rate is: " + interestRate*100 + "%");
        }else if(customer.getCreditScore() >= 550 && customer.getCreditScore() <650){
            interestRate = 0.15;
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle and the interest rate is: " + interestRate*100 + "%");
        }else {
            System.out.println(customer.getName() +" is not eligible to buy the car at this time because of the credit score");
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
