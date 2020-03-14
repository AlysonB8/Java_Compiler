

public class Punctuation extends Token {
	public final char punct_mark;
	public Punctuation(int t, char s) {
		super(t);
		punct_mark = s;
	}
}