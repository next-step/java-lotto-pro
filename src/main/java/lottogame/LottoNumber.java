package lottogame;

import lottogame.exception.InvalidLottoNumber;

class LottoNumber {
	private int number;

	public LottoNumber(int number) {
		validateNumberInLottoRule(number);
		this.number = number;
	}

	public void validateNumberInLottoRule(int number){
		if(number<LottoNumbersMaker.START_INCLUSIVE_NUMBER || number >LottoNumbersMaker.END_EXCLUSIVE_NUMBER){
			throw new InvalidLottoNumber("로또 번호는 "+LottoNumbersMaker.START_INCLUSIVE_NUMBER + "~" + LottoNumbersMaker.END_EXCLUSIVE_NUMBER +"사이 숫자만 가능합니다.");
		}
	}

	public int getNumber() {
		return number;
	}
}
