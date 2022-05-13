import lotto.Lotto;
import lotto.model.UserMoney;

public class ApplicationMain {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		String money = lotto.inputMessage("구입금액을 입력해 주세요.");
		UserMoney userMoney = new UserMoney(money);
		lotto.buyAutoLotto(userMoney);
		lotto.printWinningData();
		lotto.printProfitRate(userMoney);
	}
}
