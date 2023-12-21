import java.util.Scanner;

public class Product {
    private String nameProduct;
    private double price;
    private double weight;
    private double cost;
    Scanner sc = new Scanner(System.in);


    public Product () {
        System.out.print("Введіть вагу:\n> ");
        this.weight = sc.nextDouble();
        System.out.print("Введіть ціну на товар:\n> ");
        this.price = sc.nextDouble();
        this.cost = weight * price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
