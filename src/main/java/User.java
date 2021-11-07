import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class User {
    BigInteger money;
    List<Lotto> lottoList;

    public User(BigInteger money) {
        this.money = money;
        this.lottoList = new ArrayList<Lotto>();
    }

    public BigInteger getMoney() {
        return money;
    }

    public void setMoney(BigInteger money) {
        this.money = money;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void buyLotto(){
        expendMoney();
        lottoList.add(new Lotto());
    }

    private void expendMoney(){
        this.money = this.money.subtract(LottoGame.lottoPrice);
    }

    public boolean hasMoney(){
        return this.money.compareTo(LottoGame.lottoPrice) >= 0 ;
    }

    public int howManyLotto(){
        return lottoList.size();
    }
}
