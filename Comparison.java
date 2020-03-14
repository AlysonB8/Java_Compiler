//package lexer;
public class Comparison extends Token {
	public final String comp;
	public Comparison(int t, String s) {
		super(t);
		comp = new String(s);
	}
}
