package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class Lottos {

	private final Collection<Lotto> collection;

	private Lottos(Collection<Lotto> collection) {
		validate(collection);
		this.collection = collection;
	}

	public static Lottos from(Collection<Lotto> collection) {
		return new Lottos(collection);
	}

	public Score score(LottoGenerator lottoGenerator) {
		Lotto target = lottoGenerator.lotto();
		Collection<LottoRank> lottoRanks = new ArrayList<>();
		for (Lotto lotto : collection) {
			lottoRanks.add(lotto.rank(target));
		}
		return Score.from(lottoRanks);
	}

	public int size() {
		return collection.size();
	}

	public Collection<Lotto> collection() {
		return Collections.unmodifiableCollection(collection);
	}

	private void validate(Collection<Lotto> collection) {
		if (collection == null) {
			throw new IllegalArgumentException("lotto collection must not be null");
		}
	}
}
