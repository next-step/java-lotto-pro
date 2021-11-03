import java.util.List;

public class Lottos {
	private List<Lotto> values;

	public static int buyCountFor(int money) {
		return money / Lotto.COST;
	}
}
