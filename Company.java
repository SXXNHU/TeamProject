import java.util.Random;

public class Company {
    private String company_id;
    private String name;
    private int price;

    public Company(String company_id, String name, int initialPrice) {
        this.company_id = company_id;
        this.name = name;
        this.price = initialPrice;
    }

    //getter
    public String getCompany_id() {
        return company_id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    public abstract void updatePrice();

    /*
    가격 변동 10%
    public void updatePrice() {
        Random random = new Random();
        // 10% 범위의 가격 변동
        double changeRate = 0.9 + (0.2 * random.nextDouble()); // 0.9 ~ 1.1
        price = (int) (price * changeRate);
        System.out.println("Updated price for " + name + ": " + price);
    }
    */
}
