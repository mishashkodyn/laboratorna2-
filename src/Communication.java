import java.util.Scanner;

public class Communication {

    static Scanner sc = new Scanner(System.in);
    public static void start() {
        System.out.print("""
                 Виберіть що дію:
                - Покупки
                - Корзина (перевірити вміст корзини)
                - Кінець (закінчити покупки та отримати чек)
                Введіть ваш вибір:
                >\s""");
        label:
        while (true) {
            String choice = sc.next().toLowerCase();
            switch (choice) {
                case "покупки":
                    productSelection();
                    break label;
                case "корзина":
                    Cart.showGoods();
                    start();
                    break label;
                case "кінець":
                    System.out.printf("Ви зробили покупки на суму - %.2f гривень.\n" +
                            "Дякуємо за покупки!", Cart.getSum());
                    break label;
                default:
                    System.out.print("Некоректний ввід, спробуйте ще раз: > ");
            }
        }
    }

    public static void productSelection() {
        boolean flag = true;
        while (flag) {
            DiscountedProduct.showLetters();
            System.out.print("Введіть назву товару:\n> ");
            String name = sc.next();
            if(DiscountedProduct.checkingFirstLetter(name)){
                DiscountedProduct productDisc = new DiscountedProduct();
                productDisc.setNameProduct(name);
                System.out.printf("""
                                Ви взяли %s (%.2fкг) на суму %.2f гривень.
                                Знижка на цей товар %d%%
                                """, productDisc.getNameProduct(), productDisc.getWeight(),
                                    productDisc.getDiscountPrice(), productDisc.getDiscount());
                System.out.print("Бажаєте додати в корзину?(Так/Ні)\n> ");
                String ans = sc.next().toLowerCase();
                if (ans.equals("так")) {
                    Cart.addedToDiscountGoods(productDisc);
                    System.out.println("--- Товар додано до корзини ---");
                }
                System.out.print("Продовжити покупки?(Так/Ні)\n> ");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("Ні")) {
                    start();
                    flag = false;
                }
            }else {
                Product product = new Product();
                product.setNameProduct(name);
                System.out.printf("Ви взяли %s (%.2fкг) на суму %.2f гривень\n", product.getNameProduct(),
                        product.getWeight(),
                        product.getCost());
                System.out.print("Бажаєте додати в корзину?(Так/Ні)\n> ");
                String ans = sc.next();
                if (ans.equalsIgnoreCase("Так")) {
                    Cart.addedToGoods(product);
                    System.out.println("--- Товар додано до корзини ---");
                }
                System.out.print("Продовжити покупки?(Так/Ні)\n> ");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("Ні")) {
                    start();
                    flag = false;
                }

            }
        }
    }

}
