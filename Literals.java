

public class Literal extends Token {
	public final String literal_string;
	public Literal(int t, String s) {
		super(t);
		literal_string = new String(s);
	}
}