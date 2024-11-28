public class Main {
    public static void main(String[] args) {
        // 사용자 생성
        User user = new User(1, "John Doe", 100000);

        // 회사 생성 (예: 추상 클래스를 상속받은 CompanyA)
        CompanyA company = new CompanyA("C001", "CompanyA", 1000);

        // 사용자 조건 설정
        user.setHighCondition(1100); // 매도 상한
        user.setLowCondition(900);  // 매수 하한

        // 사용자 정보 출력
        System.out.println("User Info:");
        System.out.println("ID: " + user.getUserId());
        System.out.println("Name: " + user.getName());
        System.out.println("Money: " + user.getMoney());

        // 회사 정보 출력
        System.out.println("\nCompany Info:");
        System.out.println("Name: " + company.getName());
        System.out.println("Price: " + company.getPrice());

        // 테스트: 거래 실행
        AutoHandler autoHandler = new AutoHandler(user, company);
        for (int i = 0; i < 5; i++) { // 5초 동안 테스트
            company.updatePrice();  // 회사 주식 가격 변동
            autoHandler.AutoTrade(); // 자동 매매 실행

            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                System.out.println("Test interrupted.");
            }
        }

        // 결과 출력
        System.out.println("\nFinal Trade History:");
        user.showTradeHistory();
    }
}
