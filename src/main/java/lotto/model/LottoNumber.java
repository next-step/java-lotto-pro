package lotto.model;

import lotto.LottoUtil;

public class LottoNumber implements Comparable<LottoNumber>{
	private int lottoNumber;

	public LottoNumber(String lottoNumber) {
		lottoNumber = lottoNumber.trim();
		validationNumber(lottoNumber);
		validationRange(getLottoNumber());
	}
	
	public LottoNumber(int lottoNumber) {
		validationRange(lottoNumber);
		this.lottoNumber = lottoNumber;
	}
	
	public int getLottoNumber() {
		return this.lottoNumber;
	}
	
	private void validationRange(int lottoNumber) {
		if (!isRange(lottoNumber)) {
			throw new IllegalArgumentException("nubmer: " + lottoNumber + " 1~45 범의의 숫자만 입력이 가능합니다.");
		}
	}
	
	private boolean isRange(int lottoNumber){
		return lottoNumber >= LottoUtil.MIN_LOTTO_NUMBER && lottoNumber <= LottoUtil.MAX_LOTTO_NUMBER;
	}
	
	private void validationNumber(String lottoNumber) {
		if (!isNumber(lottoNumber)) {
			throw new IllegalArgumentException("nubmer: " + lottoNumber + " 숫자가 아닙니다.");
		}
	}
	
	private boolean isNumber(String lottoNumber) {
		try {
			this.lottoNumber = Integer.parseInt(lottoNumber);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return  getLottoNumber() - lottoNumber.getLottoNumber();
	}
	
	@Override
	public int hashCode() {
		return lottoNumber;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;        	
        }
        if (o instanceof LottoNumber) {
        	LottoNumber lottoNumber = (LottoNumber)o;
            return getLottoNumber() == lottoNumber.getLottoNumber();      	
        }
        if(o instanceof Integer) {
            return o.equals(getLottoNumber());    
        }
        return false;
    }
}
