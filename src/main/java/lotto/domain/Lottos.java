package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
	private final List<Lotto> lottos;

	public Lottos(IssueQuantity issueQuantity, List<LottoNumbers> manualNumbers) {
		this.lottos = buyLotto(issueQuantity, manualNumbers);
	}

	public static List<Lotto> buyLotto(IssueQuantity issueQuantity, List<LottoNumbers> manualNumbers) {
		List<Lotto> lottos = new ArrayList<Lotto>();
		lottos.addAll(buyManual(issueQuantity.getManualQuantity(), manualNumbers));
		lottos.addAll(buyAuto(issueQuantity.getAutoQuantity()));
		return lottos;
	}

	private static List<Lotto> buyAuto(int autoQuantity) {
		List<Lotto> lottos = new ArrayList<Lotto>();
		for (int i = 0; i < autoQuantity; i++) {
			lottos.add(Lotto.buyAuto());
		}
		return lottos;
	}

	private static List<Lotto> buyManual(int manualQuantity, List<LottoNumbers> manualNumbers) {
		List<Lotto> lottos = new ArrayList<Lotto>();
		for (int i = 0; i < manualQuantity; i++) {
			lottos.add(Lotto.buyManual(manualNumbers.get(i)));
		}
		return lottos;
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}

	public void execute(WinningLotto winningLotto) {
		for (Lotto lotto : lottos) {
			lotto.judgeRank(winningLotto);
		}
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottos.iterator();
	}

}
