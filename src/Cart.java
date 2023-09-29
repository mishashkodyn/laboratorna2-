import java.util.ArrayList;

public class Cart {
    private static final ArrayList<Product> goods = new ArrayList<>();
    private static double sum = 0;

    public static void addedToGoods (Product product) {
        goods.add(product);
        sum += product.cost;
        System.out.printf("%s(%.2fкг) додано в корзину\n", product.nameProduct, product.weight);
    }

    public static void showGoods () {
        System.out.println("Вміст корзини: ");
        for (Product p : goods) {
            System.out.printf("1. %s(%.2fкг) - %.2f грн\n", p.nameProduct, p.weight, p.cost);
        }
        System.out.printf("Загальна сума чеку %.2f грн\n\n", sum);
    }
    public static double getSum () {
        return sum;
    }
}
