package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.BiConsumer;

import model.common.Score;
import utility.Assert;

public final class LottoPapers {

	private final Collection<LottoPaper> collection;

	private LottoPapers(Collection<LottoPaper> collection) {
		Assert.notNull(collection, "lotto collection must not be null");
		this.collection = collection;
	}

	public static LottoPapers from(Collection<LottoPaper> collection) {
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

	public int autoSize() {
		return calculateSize(LottoPapers::addIfAutoType);
	}

	public int manualSize() {
		return calculateSize(LottoPapers::addIfManualType);
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

	public LottoPapers merge(LottoPapers papers) {
		Collection<LottoPaper> newCollection = new ArrayList<>(collection);
		newCollection.addAll(papers.collection);
		return from(newCollection);
	}

	private int calculateSize(BiConsumer<LottoPapers, LottoPaper> biConsumer) {
		LottoPapers newLottoPapers = from(new ArrayList<>());
		for (LottoPaper lotto : collection) {
			biConsumer.accept(newLottoPapers, lotto);
		}
		return newLottoPapers.size();
	}

	private void addIfAutoType(LottoPaper lottoPaper) {
		if (lottoPaper.isAuto()) {
			collection.add(lottoPaper);
		}
	}

	private void addIfManualType(LottoPaper lottoPaper) {
		if (lottoPaper.isManual()) {
			collection.add(lottoPaper);
		}
	}

}
