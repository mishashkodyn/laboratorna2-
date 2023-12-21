import java.util.Random;

public class DiscountedProduct extends Product {
    private int discount;
    private static final char[] firstLetter = generationFirstLetter();
    private double discountPrice;
    static {
        generationFirstLetter();
    }
    {
        generateDiscount();
    }
    DiscountedProduct(){
        super();
    }
    public static char[] generationFirstLetter(){
        Random random = new Random();
        char[] letters = new char[5];

        for(int i = 0; i < letters.length; i++){
            char randomLetter = (char) (random.nextDouble(32)+1072);
            letters[i] = randomLetter;
        }
        return letters;
    }
    public static void showLetters(){
        System.out.println("Товари з випадковою знижкою(0-50%) на продукти перша буква яких: ");
        for (char s:firstLetter) {
            System.out.print(s+ " ");
        }
        System.out.println();
    }
    public static boolean checkingFirstLetter(String s){
        char letter = s.toLowerCase().charAt(0);
        for (char c:firstLetter) {
            if(c == letter){
                return true;
            }
        }
        return false;
    }
    private void generateDiscount() {
        Random random = new Random();
        this.discount = random.nextInt(50) + 1;
    }

    public int getDiscount() {
        return discount;
    }
    public double getDiscountPrice(){
        setDiscountPrice();
        return discountPrice;
    }
    public double savingMoney(){
        return getPrice()*getWeight() * (getDiscount() / 100.0);
    }
    public void setDiscountPrice(){
        this.discountPrice = getPrice()*getWeight() - savingMoney();
    }

}