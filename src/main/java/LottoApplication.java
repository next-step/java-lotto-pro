import java.util.Scanner;

import lotto.AutoLottoNumberGenerator;
import lotto.LottoVendor;
import money.Money;
import view.InputView;

public class LottoApplication {

	public static void main(String[] args) {
		InputView inputView = new InputView(
			new Scanner(System.in),
			new LottoVendor(Money.wons(1000), new AutoLottoNumberGenerator()));

		inputView.runLottoVendor();
	}
}
