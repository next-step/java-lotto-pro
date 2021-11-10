package step2.domain;

public class Text {

	private String text;

	public Text(String text) {
		if (text == null) {
			this.text = "";
		}
		this.text = text;
	}

	public String getText() {
		if (checkIfNullOrEmpty()) {
			return "";
		}
		return this.text;
	}

	public boolean checkIfNullOrEmpty() {
		return text == null || text.isEmpty();
	}
}
