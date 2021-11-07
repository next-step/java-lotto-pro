package lotto.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(int lottoCount) {
		this(generateLottoList(lottoCount));
	}
	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static List<Lotto> generateLottoList(int lottoCount) {
		List<Lotto> result = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			result.add(new Lotto());
		}
		return result;
	}

	public int size() {
		return lottos.size();
	}

	@Override
	public String toString() {
		return lottos.stream().map(Object::toString).collect(Collectors.joining("\n"));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos1 = (Lottos)o;
		return Objects.equals(lottos, lottos1.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottos);
	}

	/**
	 * 가지고 있는 로또의 당첨결과 반환
	 * @param winningLottoNumbers 로또 당첨 번호
	 * @return 당첨 결과 객체
	 */
	public WinningLottoStatus getWinningStatus(WinningLottoNumbers winningLottoNumbers) {
		Map<LottoResult, Integer> winningLottoCount = new HashMap<>();
		EnumSet.allOf(LottoResult.class).forEach(result -> winningLottoCount.put(result, 0));
		lottos.forEach(lotto -> {
			LottoResult result = winningLottoNumbers.result(lotto);
			winningLottoCount.merge(result, 1, Integer::sum);
		});

		return new WinningLottoStatus(winningLottoCount);
	}
}
