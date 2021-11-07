package step2.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplitter {

	private Text text;
	private Delimiter delimiter;

	public TextSplitter(Text text) {
		this.text = text;
		this.delimiter = new Delimiter();

		setCustomSplitterIfExist(text);
	}

	private void setCustomSplitterIfExist(Text text) {
		final String CUSTOM_REGEX = "//(.)\n(.*)";
		Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text.getText());
		if (m.find()) {
			this.text = new Text(m.group(2));
			this.delimiter = new Delimiter(m.group(1));
		}
	}

	public Delimiter getDelimiter() {
		return this.delimiter;
	}

	public String[] getSplitResult() {
		if (this.text.checkIfNullOrEmpty()) {
			return new String[]{};
		}
		return this.text.getText().split(this.delimiter.getRegex());
	}
}
