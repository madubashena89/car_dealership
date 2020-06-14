import java.util.*;

public class Dearlership {

    public static void main(String[] args) {
        //customer details
        String name;
        boolean  tyepOfTransaction;
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
        System.out.println("Do you want to finance or cash? (Just Type cash = true or false for finance) ");
        tyepOfTransaction = sc.nextBoolean();
        if(!tyepOfTransaction){
            System.out.println("What is your credit score?");
            int creditScore = sc.nextInt();
            callEmployeeForHelp(name, address, 0.0, true, creditScore, year, vehicleModel, price);

        }
        else{
            finance =false;
            System.out.println("How much money you have?");
            cashInHand = sc.nextDouble();
            callEmployeeForHelp(name, address, cashInHand, finance, 850, year, vehicleModel, price);
            System.out.println("Your transaction is processing !!");
            System.out.println("Hurray !!, thanks for the purchase. Here is your vehicle ");

        }

    }

    public static void callEmployeeForHelp(String name, String custAddress, double cashInHand, boolean finance,
                                    int creditScore , int year, String model, int price){
        Employee employeeName = new Employee();
        employeeName.createCustomerAndVehicle(name, custAddress, cashInHand, finance, creditScore, year, model, price);
    }

}
