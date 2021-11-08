package lotto;

import lotto.service.LottoStore;

public class LottoApplication {
	public static void main(String[] args) {
		new LottoStore().start();
	}
}
