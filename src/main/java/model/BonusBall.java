package model;

public class BonusBall {
	private Integer number;

	public BonusBall(Integer number) {
		this.number = number;
	}

	public static BonusBall from(Integer number) {
		return new BonusBall(number);
	}

	public Integer getNumber() {
		return number;
	}
}
