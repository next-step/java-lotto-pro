package step3;

public class ResultView {

	public static void purchasedLottoPrint() {
		LottoPapers.PAPERS.forEach(System.out::println);
	}

	public static void purchasedCount(Money money) {
		System.out.println(String.format("{0}를 구매했습니다.", money.buyCount()));
	}

	public static void statisticsPrintAndYield(Winner winner) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(winner);
	}
}
