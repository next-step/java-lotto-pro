package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
	private List<Lotto> lottoList;

	public LottoList(Integer count) {
		this.lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			this.lottoList.add(new Lotto());
		}
	}

	public int size() {
		return lottoList.size();
	}

	@Override
	public String toString() {
		return lottoList.toString();
	}
}
