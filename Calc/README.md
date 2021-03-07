# Calc

* [`Calc.g4`](src/ast/Calc.g4) contains the grammar of Calc in ANTLR notation.
* [`ExecVisitor.java`](src/calc/ExecVisitor.java) defines a depth-first, left-to-right traversal of the syntax tree of a Calc program. Each method defines what will be done at one kind of node, and returns the value of the corresponding expression (or returns `0` if the node is a command).
* [`CalcRun.java`](src/calc/CalcRun.java) is the top-level driver program, defining a `main` method. It expects an argument that is a named Calc source file. `CalcRun` creates a lexer and uses it to translate the source code into a token stream. Then it creates a parser and calls the parser's `prog()` method, which in turn calls `com()`, `expr()`, etc. The result of `prog()` is the syntax tree of the input source code. Finally, a visitor is created and its `visit` method is called on the syntax tree in order to execute the Calc program.

To make ANTLR generate a lexer and parser for Calc, use
```sh
$ java -jar antlr.jar -no-listener -visitor -o src/ast src/ast/Calc.g4
$ javac -cp "antlr.jar" -d bin/ -sourcepath src/ src/calc/CalcRun.java
```

To run `CalcRun` with a selected Calc source file, use
```sh
$ java -cp "antlr.jar;bin" calc/CalcRun tests/test1.calc
```

## Familiarisation Exercises

1. **Add comments**: To do this add a line in `Calc.g4` after the line defining `SPACE`, which defines the syntax of comments and then specifies `-> skip` to say that they should be ignored.

2. **Add a "/" operator**: This will require modification in `ExecVisitor.java`.

3. **Allow variable identifiers to consist of _one or more_ letters**: Replace `int[] store = new int[26];` by a `HashMap` that will be indexed by full variable names in `ExecVisitor.java`.
