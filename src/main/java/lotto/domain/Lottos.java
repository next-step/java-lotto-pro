package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(final List<Lotto> lottos) {
		this.lottos = new ArrayList<>(lottos);
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public int size() {
		return lottos.size();
	}

	public LottoResult createLottoResult(WinningLotto winningLotto) {
		Map<Rank, Integer> lottoResult = new EnumMap<Rank, Integer>(Rank.class);
		for (Lotto lotto : lottos) {
			Rank rank = winningLotto.getRank(lotto);
			lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
		}
		return new LottoResult(lottoResult);
	}

	public Lottos addAll(Lottos autoLottos) {
		List<Lotto> newLottos = new ArrayList<>();
		newLottos.addAll(lottos);
		newLottos.addAll(autoLottos.lottos);
		return new Lottos(newLottos);
	}
}
