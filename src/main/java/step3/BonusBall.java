package step3;

public class BonusBall extends LottoNumber {

	private BonusBall(int no) {
		super(no);
	}
	public static BonusBall of(int no, LottoNumbers userLottoNumbers) {
		BonusBall bonusBall = new BonusBall(no);
		if (userLottoNumbers.hasBonusBall(bonusBall)) {
			throw new IllegalArgumentException("보너스 볼 번호가 지난주 보너스 볼 번호와 동일 할 수 없습니다.");
		};
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
