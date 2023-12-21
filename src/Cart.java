import java.util.ArrayList;

public class Cart {
    private static final ArrayList<Product> goods = new ArrayList<>();
    private static final ArrayList<DiscountedProduct> discGoods = new ArrayList<>();
    private static double sum = 0;

    public static void addedToGoods (Product product) {
        goods.add(product);
        sum += product.getCost();
        System.out.printf("%s(%.2fкг) додано в корзину\n", product.getNameProduct(), product.getWeight());
    }

    public static void addedToDiscountGoods (DiscountedProduct product) {
        discGoods.add(product);
        sum += product.getDiscountPrice();
    }

    public static void showGoods () {
        System.out.println("Вміст корзини: ");

        for (Product p : goods) {
            System.out.printf("1. %s (%.2fкг) - %.2f грн\n", p.getNameProduct(), p.getWeight(), p.getCost());
        }
        for (DiscountedProduct p : discGoods) {
            System.out.printf("1. %s (%.2fг) - %.2f грн. Знижка -%d%%, (-%.2fгрн.)\n", p.getNameProduct(), p.getWeight(),
            p.getDiscountPrice(), p.getDiscount(), p.savingMoney());
        }

        System.out.printf("Загальна сума чеку %.2f грн\n\n", sum);

    }
    public static double getSum () {
        return sum;
    }
}
