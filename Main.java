
//import lexer.*;
import java.io.*;

public class Main {
	public static void main(String... args) {
		Lexer lexer =  new Lexer();
		try {
			Token t = lexer.scan();
			System.out.println(t);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}


	}
}
