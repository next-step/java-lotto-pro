package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

	private final List<LottoNumbers> lottoNumbersList;

	private LottoTicket(List<LottoNumbers> lottoNumbersList) {
		this.lottoNumbersList = lottoNumbersList;
	}

	public static LottoTicket of(List<LottoNumbers> lottoNumbers) {
		return new LottoTicket(lottoNumbers);
	}

	public static LottoTicket create() {
		return new LottoTicket(new ArrayList<>());
	}

	public void add(LottoNumbers lottoNumbers) {
		lottoNumbersList.add(lottoNumbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoTicket that = (LottoTicket)o;
		return lottoNumbersList.equals(that.lottoNumbersList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbersList);
	}
}
