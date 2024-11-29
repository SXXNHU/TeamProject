public class User {
    private int User_id;
    public String name;
    public int seed = 0;//초기 자본
    public int money=0;//현재 잔고
    ;//총 합산 금액(주식 + 잔고)
    public int high_condition=0;
    public int low_condition=0;
    public int stocks=0;
    //LinkedList<Company> company_list = new LinkedList<>();
    //유저가 가지고 있는 주식 리스트

    User(int User_id, String name, int money, int stocks){
        this.User_id = User_id;
        this.name = name;
        this.seed = money;
        this.money = seed;
        this.stocks = stocks;
    }
    public int getSeed() {return seed;}
    public int getMoney() {return money;}
    public int getTotal(Company com){
        return getStocks() * com.getCurrentPrice() + getMoney();
    }
    public String getName(){
        return name;
    }
    public int getUser_id(){
        return User_id;
    }
    public int getStocks() {return stocks;}
    public void buyStock(Company com) {
        ++stocks;
        money -= com.getCurrentPrice();
    }
    public void sellStock(Company com) {
        --stocks;
        money += com.getCurrentPrice();
    }
    /*public void Show_Company_List(){
        for(int i=0; i<company_list.size(); i++){
            System.out.println(company_list.get(i).getUserCom());
        }
    }
    public void addCompany(Company com){
        company_list.add(Com);
    }
    public void deleteCompany(Company com){
        company_list.remove(com);
    }*/
    public void SetHighCondition(Company com,int high){
        high_condition = high;
    }
    public int GetHighCondition(Company com){
        return high_condition;
    }
    public void SetLowCondition(Company com, int low){
        low_condition = low;
    }
    public int GetLowCondition(Company com){
        return low_condition;
    }
    public int GetReturn(Company com){
        return getTotal(com)-getSeed();
    } //수익 표시
    public double GetReturnPercent(Company com){
        return (double)GetReturn(com)/100;
    }
}