
//package lexer;
import java.io.*;
//import lexer.Token;
import java.util.*;

// > >= == <= < != && || 

public class Lexer {
	public int line = 1;
	private char peek = ' ';
	private final String operator_symbols = "&=>|<!";
	private final String punctuation_marks = "{}();,";
	private Hashtable words = new Hashtable();

	void reserve(Word t) {
		words.put(t.lexeme, t);
	}

	public Lexer() {
		reserve(new Word(Tag.TRUE, "true"));
		reserve(new Word(Tag.FALSE, "false"));
		reserve(new Word(Tag.IF, "if"));
		reserve(new Word(Tag.ELSE, "else"));
		reserve(new Word(Tag.DO, "do"));
		reserve(new Word(Tag.BREAK, "break"));
		reserve(Word.True);
		reserve(Word.False);
		reserve(Type.Int);
		reserve(Type.Char);
		reserve(Type.Bool);
		reserve(Type.Float);

	}
	private Comparison ComparisonOperands() throws SyntaxError, IOException {
		StringBuffer b = new StringBuffer();
		do {

			char before = peek;
			peek = (char)System.in.read();

			if (peek == '\n')
				break;
	
			else if ((before == '=' || before == '>' || before == '<' || before == '!') && peek != '=') {
				throw new SyntaxError("Syntax Error.");
			}
			else if (before == '&' && peek != '&') {
				throw new SyntaxError("Syntax Error.");
			}
			else if (before == '|' && peek != '|') {
				throw new SyntaxError("Syntax Error.");
			}
			else if (before == '!' && peek != '=') {
				throw new SyntaxError("Syntax Error.");
			}
			b.append(before);
			b.append(peek);
			System.out.println("SUCESS");
		} while (peek != '\n');
		//System.out.println("soighaosidhg");
		String s = b.toString();
		System.out.println("Returning");
		return new Comparison(Tag.COMP, s);
	}

	public Literal HandleLiteral() {
		StringBuffer b = new StringBuffer();
		b.append(peek);
		do {
			peek = (char)System.in.read();
			b.append(peek);
		} while (peek != '\"');
		String s = new String(b);
		return new Literal(b);
	}


	private Float toFloat(int v) {
		float x = (float)v;
		float by_ten = 10;
		do {
			try {
				peek = (char)System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			float temp = Character.digit(peek, 10) / by_ten;
			by_ten = by_ten * 10;
			x = x + temp;
		} while (Character.isDigit(peek));
		return new Float(x);
	}

	public Token scan() throws IOException {
		for ( ; ; peek = (char)System.in.read()) {
			if (peek == ' ' || peek == '\t') continue;
			else if (peek == '\n') line = line + 1;
			else break;
		}
		if (Character.isDigit(peek)) {
			int v = 0;
			do {
				v = 10 * v + Character.digit(peek, 10);
				peek = (char)System.in.read();
				if (peek == '.') {
					return this.toFloat(v);
				}
			} while(Character.isDigit(peek));
			return new Num(v);
		}

		if (Character.isLetter(peek)) {
			StringBuffer b = new StringBuffer();
			do {
				b.append(peek);
				peek = (char)System.in.read();
			} while(Character.isLetterOrDigit(peek));
		
			String s = b.toString();
			Word w = (Word)words.get(s);
			if (w != null)
				return w;

			w = new Word(Tag.ID, s);
			words.put(s, w);
			return w;
		}

		if (punctuation_marks.indexOf(peek) != -1) {
			return new Punctuation(Tag.PUNCT, peek);
		}

		if (operator_symbols.indexOf(peek) > 0) {
			try {
				return this.ComparisonOperands();
			} catch (Exception e) {
				System.exit(1);
			}	
		}

		if (peek == '/') {
			peek = (char)System.in.read();
			// This is handling line commments.
			if (peek == '/') {
				do {
					peek = (char)System.in.read();
					System.out.println(peek);
				} while (peek != '\n');
				line = line + 1;
			} 
			// This is reading block comments.
			else if (peek == '*') {
				do {
					peek = (char)System.in.read();
					if (peek == '*') {
						peek = (char)System.in.read();
						if (peek == '/'){
							break;
						}
					}
					else if (peek == '\n') {
						line = line + 1;
					}
 				} while (true);
			}
			
			if (peek == '\"') {
				return this.HandleLiteral();
			}		

		}
		Token t = new Token(peek);
		peek = ' ';
		return t;
	}
/*
	public static void main(String... args) {
		Lexer lexer = Lexer();
		Token t = lexer.scan();
		System.out.println(t);

	}*/

}
