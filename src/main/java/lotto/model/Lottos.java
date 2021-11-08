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

	/**
	 * 입력받은 개수만큼 로또 생성
	 * @param lottoCount 생성할 로또 수
	 * @return 로또 목록
	 */
	public static List<Lotto> generateLottoList(int lottoCount) {
		List<Lotto> result = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			result.add(new Lotto());
		}
		return result;
	}

	/**
	 * 로또 개수 반환
	 * @return 로또 개수
	 */
	public int size() {
		return lottos.size();
	}

	@Override
	public String toString() {
		return lottos.stream()
			.map(Object::toString)
			.collect(Collectors.joining("\n"));
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
		Map<Rank, Integer> winningLottoCount = new HashMap<>();
		EnumSet.allOf(Rank.class).forEach(result -> winningLottoCount.put(result, 0));
		lottos.forEach(lotto -> {
			Rank result = winningLottoNumbers.result(lotto);
			winningLottoCount.merge(result, 1, Integer::sum);
		});

		return new WinningLottoStatus(winningLottoCount);
	}
}
