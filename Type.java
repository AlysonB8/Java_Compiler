package symbols;
import lexer.*;
public class Type extends Word {
	public int width = 0;
	public Type(String s, int tag, int w) {
		super(s, tag);
		width = w;
	}

	// Primitive datatypes and their sizes.
	public static final Type
		Int = new Type("int", Tag.BASIC, 4),
		Float = new Type("float", Tag.BASIC, 8),
		Char = new Type("char", Tag.BASIC, 1),
		Bool = new Type("bool", Tag.BASIC,1);


	// Determining that a datatype is numeric by origin
	// and not a struct for example.
	public static boolean numeric(Type p) {
		if (p == Type.Char || p == Type.Int || p == Type.Float) {
			return true;
		}
		return false;
	}

	// Converting the result from comparing 2 different numeric datatypes.
	// The largest size of the 2 datatypes is always assumed to be the
	// size of the answer.
	public static Type max(Type p1, Type p2) {
		if (!numeric(p1) || !numeric(p2))
			return null;
		else if (p1 == Type.Float || p2 == Type.Float)
			return Type.Float;
		else if (p1 == Type.Int || p2 == Type.Int)
			return Type.Int;
		else
			return Type.Char;
	}
}
