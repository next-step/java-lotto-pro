package model;

public class Number {
	private static final int MIN_NUMBER = 0;
	private int number;
	
	public Number(String number) {
		validation(number);
	}
	
	public int getNumber() {
		return this.number;
	}
	
	private void validation(String number) {
		if(!isNumber(number)) {
			throw new RuntimeException("nubmer: " + number + " 숫자가 아닙니다.");
		}
		
		if(!isNatural(this.number)) {
			throw new RuntimeException("nubmer: " + number + " 0보다 작은 수가 입력되었습니다.");
		}
	}
	
	private boolean isNatural(int number){
		return number > MIN_NUMBER;
	}
	
	private boolean isNumber(String number) {
		try {
			this.number = Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
