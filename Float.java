
public class Float extends Token {
	public final float value;
	public Float(float v) {
		super(Tag.NUM);
		value = v;
	}
	public String toString() {
		return "" + value;
	}
}
