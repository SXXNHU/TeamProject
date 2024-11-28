import java.util.Random;

public class CompanyA extends Company {
    public CompanyA(String companyId, String name, int initialPrice) {
        super(companyId, name, initialPrice);
    }

    @Override
    public void updatePrice() {
        Random random = new Random();
        double changeRate = 0.9 + (0.2 * random.nextDouble()); // 0.9 ~ 1.1
        price = (int) (price * changeRate);
        System.out.println("Updated price for " + getName() + ": " + price);
    }
}
