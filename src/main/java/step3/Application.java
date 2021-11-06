package step3;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView(new LottoMachineFacade());
		inputView.insertMoney();
		inputView.insertLottoNumber();
	}
}
