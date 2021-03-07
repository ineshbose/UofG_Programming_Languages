# Fun

* [`Fun.g4`](src/ast/Fun.g4) defines the grammar of Fun.
* [`FunCheckerVisitor.java`](src/fun/FunCheckerVisitor.java) implements a visitor that will traverse a parse tree and enforce Fun's scope rules and type rules.
* [`FunEncoderVisitor.java`](src/fun/FunEncoderVisitor.java) implements another visitor that will traverse a parse tree and generate SVM object code.
* [`SVM.java`](src/fun/SVM.java) defines the representation of SVM instructions. It also contains a group of methods for emitting SVM instructions, i.e. placing them one by one in the code store; these methods are called by the Fun code generator. This class also contains a method `interpret()` that interprets the program in the code store.
* [`FunRun.java`](src/fun/FunRun.java) is the driver program. It first compiles a named Fun source file to SVM object code, then the program interprets the object code. There are two other driver programs: `FunParse.java` just does syntactic analysis (parsing) and `FunCheck.java` does syntactic analysis and contextual analysis (typechecking).

To make ANTLR generate a lexer and parser for Fun, use
```sh
$ java -jar antlr.jar -no-listener -visitor -o src/ast src/ast/Fun.g4
$ javac -cp "antlr.jar" -d bin/ -sourcepath src/ src/fun/FunRun.java
```

To run `FunRun` with a selected Fun source file, use
```sh
$ java -cp "antlr.jar;bin" fun/FunRun tests/assign.fun
```

## Familiarisation Exercises

### Stage 1

Replace the contents of `Fun.g4` with another provided version of Fun grammar that includes a new non-terminal `formal_decl_seq`, which is defined to be a sequence of one or more `formal_decl`, separated by commas. The optional tag (`?`) has moved from the definition of `formal_decl` into the definitions of `proc_decl` and `func_decl`. This means that the case of no parameters will be handled as a special case, and the general case is a non-empty sequence of parameters. It would be nice for the general case to be a sequence, empty or non-empty, of parameters, but the problem is that the comma only appears when there are at least two parameters.

After building the compiler, parse [`tests/multiple.fun`](tests/multiple.fun) by running [`FunParse`](src/fun/FunParse.java) using
```sh
$ javac -cp "antlr.jar" -d bin/ -sourcepath src/ src/fun/FunParse.java
$ java -cp "antlr.jar;bin" fun/FunParse tests/multiple.fun
```

### Stage 2

The next step is to extend the contextual analysis phase, which is defined in [`FunCheckerVisitor.java`](src/fun/FunCheckerVisitor.java). The file [`Type.java`](src/fun/Type.java) already defines the class `Type.Sequence`, which represents a sequence of types; this class is not used yet, but the idea is to use it to represent the parameter types of a procedure or function. The same file also defines `Type.EMPTY`, representing an empty sequence of types.

Make the following changes to [`FunCheckerVisitor.java`](src/fun/FunCheckerVisitor.java):
* In the method `predefine`, which defines the types of Fun’s built-in procedures and functions, change the parameter type of read from `Type.VOID` to `Type.EMPTY`. Change the parameter type of write to be a `Type.Sequence` containing just `Type.INT`.
* Change the definition of `MAINTYPE` so that the parameter type is `Type.EMPTY`.
* In the methods `visitProc` and `visitFunc`, in the third lin, instead of calling `ctx.formal_decl()`, call `ctx.formal_decl_seq()`. This is necessary to match the new grammar. The result type of this call is `FunParser.formal_decl_seqContext`. If it is null, meaning that there are no parameters, then the variable `t` should be set to `Type.EMPTY` instead of `Type.VOID`.
* Because `formal_decl_seq` is added to the grammar, with the label `formalseq`, add a method `visitFormalseq`. The method header should be in [`FunBaseVisitor.java`](src/ast/FunBaseVisitor.java). The method needs to visit every item in `ctx.formal_decl()`, which has type `List<FunParser.Formal_declContext>`. Visiting an item returns a `Type`. These values need to be collected into an `ArrayList` and used to construct a `Type.Sequence`, which is returned.
* The method `visitFormal` can be simplified because the result of `ctx.type()` is never `null`. This is because the optional clause in the grammar is now `formal_decl_seq`, and if there is one, then it must be a non-empty sequence of declarations.
* `visitProccall` and `visitFunccall` need to be modified because `ctx.actual_seq()` might return `null`. In this case, construct an empty sequence of types; otherwise visit the result of `ctx.actual_seq()` to get the sequence of types.
* Replace `visitActual` by `visitActualseq`, which needs to visit every item in `ctx.expr)` and construct a `Type.Sequence` of their types.

After building the compiler, typecheck [`tests/multiple.fun`](tests/multiple.fun) by running [`FunCheck`](src/fun/FunCheck.java) using
```sh
$ javac -cp "antlr.jar" -d bin/ -sourcepath src/ src/fun/FunCheck.java
$ java -cp "antlr.jar;bin" fun/FunCheck tests/multiple.fun
```

### Stage 3

A few changes are necessary in [`FunEncoderVisitor.java`](src/fun/FunEncoderVisitor.java).
* In `visitProc` and `visitFunc`, replace `FunParser.formal_declContext` by `FunParser.formal_decl_seqContext` and replace `ctx.formal_decl()` by `ctx.formal_decl_seq()`.
* Define the method `visitFormalSeq`; it just has to visit everything in `ctx.formal_decl()`.
* `visitFormal` can be simplified in the same way as in `FunCheckerVisitor`.
* In `visitProccall` and `visitFunccall`, use `ctx.actual_seq()` instead of `ctx.actual()`, but it might return `null`, so test for this. If it is `null`, then there is no need to call `visit(ctx.actual_seq())`.
* Similarly to `FunCheckerVisitor`, replace `visitActual` by `visitActualseq`, which needs to visit every item in `ctx.expr()`.

Compile and run [`tests/multiple.fun`](tests/multiple.fun) by running [`FunRun`](src/fun/FunRun.java) using
```sh
$ javac -cp "antlr.jar" -d bin/ -sourcepath src/ src/fun/FunRun.java
$ java -cp "antlr.jar;bin" fun/FunRun tests/multiple.fun
```