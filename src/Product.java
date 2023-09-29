import java.util.Scanner;

public class Product {
    String nameProduct;
    double price;
    double weight;
    double cost;
    Scanner sc = new Scanner(System.in);
    public Product () {
        System.out.print("Введіть товар який хочете купити:\n> ");
        this.nameProduct = sc.nextLine();
        System.out.print("Введіть вагу:\n> ");
        this.weight = sc.nextDouble();
        System.out.print("Введіть ціну на товар:\n> ");
        this.price = sc.nextDouble();
        this.cost = weight * price;
    }

}
