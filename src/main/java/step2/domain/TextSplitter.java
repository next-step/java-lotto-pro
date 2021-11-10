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
		final int REGEX_DELIMITER_GROUP = 1;
		final int REGEX_SPLIT_TEXT_GROUP = 2;

		Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text.getText());
		if (m.find()) {
			this.text = new Text(m.group(REGEX_SPLIT_TEXT_GROUP));
			this.delimiter = new Delimiter(m.group(REGEX_DELIMITER_GROUP));
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
