package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class IssueQuantity {
	private final Map<IssueType, Integer> issueQuantity;

	public IssueQuantity() {
		this.issueQuantity = new HashMap<IssueType, Integer>();
	}

	public IssueQuantity fromAuto(int autoQuantity) {
		this.issueQuantity.put(IssueType.AUTO, autoQuantity);
		return this;
	}

	public IssueQuantity fromManual(int manualQuantity) {
		this.issueQuantity.put(IssueType.MANUAL, manualQuantity);
		return this;
	}

	public int getAutoQuantity() {
		return issueQuantity.get(IssueType.AUTO) == null ? 0 : issueQuantity.get(IssueType.AUTO);
	}

	public int getManualQuantity() {
		return issueQuantity.get(IssueType.MANUAL) == null ? 0 : issueQuantity.get(IssueType.MANUAL);
	}

}
