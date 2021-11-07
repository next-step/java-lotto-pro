package lotto.view;

public class LottoView {
	public void printlnInputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printlnError(IllegalArgumentException e) {
		System.out.println("[ERROR] "+e);
	}
}
