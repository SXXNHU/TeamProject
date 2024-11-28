import java.util.List;

public class Manager extends Thread {
    private volatile boolean isRunning = true; // volatile로 선언해 스레드 안전성 보장
    private final List<AbstractUser> users;
    private final List<AbstractCompany> companies;

    public Manager(List<AbstractUser> users, List<AbstractCompany> companies) {
        this.users = users;
        this.companies = companies;
    }

    public void stopRunning() {
        isRunning = false;
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updatePricesAndShow() {
        System.out.println("\n--- Company Price Updates ---");
        for (AbstractCompany company : companies) {
            company.updatePrice();
            System.out.println(company.getName() + ": " + company.getPrice());
        }
    }

    private void processUserTrades() {
        for (AbstractUser user : users) {
            for (AbstractCompany company : companies) {
                AutoHandler autoHandler = new AutoHandler(user, company);
                autoHandler.AutoTrade();
            }
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            clearConsole();                // 콘솔 출력 초기화
            updatePricesAndShow();         // 회사 가격 업데이트 및 출력
            processUserTrades();           // 사용자 거래 처리

            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
                stopRunning();
            }
        }
        System.out.println("Manager stopped.");
    }
}
