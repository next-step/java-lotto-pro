package model;

enum LottoType {

	MANUAL, AUTO;

	boolean isAuto() {
		return this == AUTO;
	}

	boolean isManual() {
		return this == MANUAL;
	}
}
