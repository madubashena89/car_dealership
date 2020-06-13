public class Vehicle {
    private double engineCapacity;
    private int year;
    private String model;
    private int price;

    private int minimumDownPayment;

    public Vehicle(double engineCapacity, int year, String model, int price) {
        this.engineCapacity = engineCapacity;
        this.year = year;
        this.model = model;
        this.price = price;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinimumDownPayment() {
        return minimumDownPayment;
    }

    public void setMinimumDownPayment(int minimumDownPayment) {
        this.minimumDownPayment = minimumDownPayment;
    }
}
