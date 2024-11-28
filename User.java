import java.util.LinkedList;

public class User {
    private int userId;            // 사용자 ID
    private String name;           // 사용자 이름
    private int money;             // 사용자 보유 금액
    private int highCondition;     // 매도 상한 조건
    private int lowCondition;      // 매수 하한 조건
    private LinkedList<Company> companyList = new LinkedList<>(); // 보유 주식 리스트
    private LinkedList<String> tradeHistory = new LinkedList<>(); // 거래 내역

    // 생성자
    public User(int userId, String name, int initialMoney) {
        this.userId = userId;
        this.name = name;
        this.money = initialMoney;
    }

    // Getter 메서드
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getHighCondition() {
        return highCondition;
    }

    public int getLowCondition() {
        return lowCondition;
    }

    // Setter 메서드
    public void setHighCondition(int highCondition) {
        this.highCondition = highCondition;
    }

    public void setLowCondition(int lowCondition) {
        this.lowCondition = lowCondition;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 주식 관련 메서드
    public void addCompany(Company company) {
        companyList.add(company);
        System.out.println("Added company: " + company.getName());
    }

    public void deleteCompany(Company company) {
        if (companyList.contains(company)) {
            companyList.remove(company);
            System.out.println("Removed company: " + company.getName());
        } else {
            System.out.println("Company not found in the list.");
        }
    }

    public void showCompanyList() {
        System.out.println("Owned companies:");
        for (Company company : companyList) {
            System.out.println(" - " + company.getName());
        }
    }

    // 거래 내역 관련 메서드
    public void addTradeList(Company company, int price) {
        String record = "Company: " + company.getName() + ", Price: " + price;
        tradeHistory.add(record);
        System.out.println("Trade added: " + record);
    }

    public void showTradeHistory() {
        System.out.println("Trade History:");
        for (String record : tradeHistory) {
            System.out.println(record);
        }
    }
}
