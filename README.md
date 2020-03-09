# Java_Compiler
A compiler I'm writing while reading Compiler Design by Alfred-something.

I'm making this compiler mainly to understand how executables are designed in the hopes of making me better at
picking up reverse engineering concepts. Although, having said that, I don't know how well it'll help.
Having said that, I find compilers really cool. 


## New Progress
My code is starting to expand and I've started with the nitty gritty of coding the lexical analyser and parser.
I've made a few pushes and finally started writing real code and it feels gosh darn exciting that everything I'm
writing makes a lot of sense. I actually know what I'm doing in Java!:D

## Current TODOs

-Extend the Lexer class to handle Comments (lines starting with //, /*...*/)

-Extend the Lexer class to handle Floating point numbers (2.31, 4.214,...)

-Extend the Lexer class to handle Relational Operator (< > == != >= ...)


## When I started
I've just started with working on the Front End (tokenizing, lexing etc).

It'll be written in Java as I'm following along with the book. I don't know hoow to code in Java so it'll be
a great learning experience too.

## 1. My first really clean piece of Java code.
I figured I'd post this. I'm really proud of it (leave me alone..).
```
package main;
import java.io.*;
import lexer.*;
import parser.*;

public class Main() {
	public static void main(String[] args) throws IOException {
		Lexer lexer = new Lexer();
		Parser parse = new Parser(lex);
		parse.program();
		System.out.write("\n")
	}
}
```

Okay that's all. Hoping to make good progress on this project.
