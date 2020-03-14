
all_java_files = Lexer.java  Main.java Num.java Tag.java Token.java  Word.java SyntaxError.java \
				 Punctuation.java

class_files = Lexer.class Main.class Num.class Tag.class Token.class Word.class SyntaxError.class \
			  Punctuation.class

all:
	javac $(all_java_files)

clean:
	rm -r $(class_files)

re: clean all
