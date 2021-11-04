package com.example.lotto;

public class LottoApplication {
	public static void main(String[] args) {
		LottoController controller = new LottoController(new RandomNumbersGenerator());

		controller.run();
	}
}
