
public class Comparison extends Token {
	public String value;

	public Comparison(int t, String comp_value) {
		super(t);
		value = comp_value;
	}
	public String toString() {
		return value;
	}
}
