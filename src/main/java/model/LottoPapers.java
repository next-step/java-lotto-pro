package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class LottoPapers {

	private final Collection<LottoPaper> collection;

	private LottoPapers(Collection<LottoPaper> collection) {
		validate(collection);
		this.collection = collection;
	}

	static LottoPapers from(Collection<LottoPaper> collection) {
		return new LottoPapers(collection);
	}

	public Score score(WinnerLotto winnerLotto) {
		Collection<LottoRank> lottoRanks = new ArrayList<>();
		for (LottoPaper lotto : collection) {
			lottoRanks.add(lotto.rank(winnerLotto));
		}
		return Score.from(lottoRanks);
	}

	public int size() {
		return collection.size();
	}

	public Collection<LottoPaper> collection() {
		return Collections.unmodifiableCollection(collection);
	}

	@Override
	public String toString() {
		return "Lottos{" +
			"collection=" + collection +
			'}';
	}

	private void validate(Collection<LottoPaper> collection) {
		if (collection == null) {
			throw new IllegalArgumentException("lotto collection must not be null");
		}
	}
}
