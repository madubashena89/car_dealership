public class Customer {
    private String name;
    private String customerID;
    private String customerAddress;
    private double cashInHand;
    private boolean finance;
    private int creditScore;

    public Customer(String name, String customerID, String customerAddress, double cashInHand, boolean finance, int creditScore) {
        this.name = name;
        this.customerID = customerID;
        this.customerAddress = customerAddress;
        this.cashInHand = cashInHand;
        this.finance = finance;
        this.creditScore = creditScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCashInHand() {
        return cashInHand;
    }

    public void setCashInHand(double cashInHand) {
        this.cashInHand = cashInHand;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
}
