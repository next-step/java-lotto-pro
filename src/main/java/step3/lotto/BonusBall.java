package step3.lotto;

public class BonusBall extends LottoNumber {

	public BonusBall(int no) {
		super(no);
	}

	@Deprecated
	public static BonusBall of(int no, LottoNumbers winningLottoNumbers) {
		BonusBall bonusBall = new BonusBall(no);
		if (winningLottoNumbers.hasBonusBall(bonusBall)) {
			throw new IllegalArgumentException("보너스 번호가 당첨 번호와 동일할 수 없습니다");
		}
		return new BonusBall(no);
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
