package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningRecords {
	private final List<WinningRecord> winningRecords;

	private WinningRecords() {
		this.winningRecords = new ArrayList<>();
	}

	public static WinningRecords createDefault() {
		return new WinningRecords();
	}

	public void add(WinningRecord winningRecord) {
		this.winningRecords.add(winningRecord);
	}

	public List<WinningRecord> getValues() {
		return this.winningRecords;
	}
}
