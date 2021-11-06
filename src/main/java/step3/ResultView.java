package step3;

public class ResultView {

	public static void purchasedLottoPrint() {
		LottoPapers.PAPERS.forEach(System.out::println);
	}

	public static void purchasedCount(int size) {
		System.out.println(String.format("%s개를 구매했습니다.", size));
	}

	public static void statisticsPrintAndYield(Winner winner) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(winner);
	}
}
