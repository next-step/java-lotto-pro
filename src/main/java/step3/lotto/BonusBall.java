package step3.lotto;

import java.util.Objects;

public class BonusBall {

	private LottoNumber lottoNumber;

	public BonusBall(int no) {
		this.lottoNumber = new LottoNumber(no);
	}

	public LottoNumber asLottoNumber() {
		return lottoNumber;
	}

	@Deprecated
	public static BonusBall of(int no, LottoNumbers winningLottoNumbers) {
		BonusBall bonusBall = new BonusBall(no);
		if (winningLottoNumbers.matchBonusBall(bonusBall)) {
			throw new IllegalArgumentException("보너스 번호가 당첨 번호와 동일할 수 없습니다");
		}
		return new BonusBall(no);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BonusBall))
			return false;
		BonusBall bonusBall = (BonusBall)o;
		return Objects.equals(lottoNumber, bonusBall.lottoNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public String toString() {
		return lottoNumber.toString();
	}
}
