import java.util.Scanner;

public class Communication {

    static Scanner sc = new Scanner(System.in);
    public static void start() {
        boolean flag = true;
        label:
        System.out.print("""
                Доброго дня, виберіть що ви хочете:
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
            Product product = new Product();
            System.out.printf("Ви взяли %s(%.2fкг) на суму %.2f гривень\n", product.nameProduct, product.weight, product.cost);
            System.out.print("Бажаєте додати в корзину?(Так/Ні)\n> ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("Так")) {
                Cart.addedToGoods(product);
            }
            System.out.print("Продовжити покупки?\n> ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("Ні")) {
                start();
                flag = false;
            }
        }
    }

}
