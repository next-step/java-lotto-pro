package lotto.model;

import java.util.EnumSet;
import java.util.Map;

public class WinningLottoStatus {
	private final Map<LottoResult, Integer> winningLottoCount;

	public WinningLottoStatus(Map<LottoResult, Integer> winningLottoCount) {
		this.winningLottoCount = winningLottoCount;
	}

	/**
	 * 당첨된 로또 개수 반환
	 * @param result 당첨종류(LottoResult enum값)
	 * @return 해당 당첨의 개수반환
	 */
	public int getMatchCount(LottoResult result) {
		return winningLottoCount.get(result);
	}
}
