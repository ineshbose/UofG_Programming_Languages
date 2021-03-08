# FunExtended

The assignment is to design and implement two extensions to Fun.
1. The first extension is a _for-command_, which is a new form of loop. It is similar to the `for` loop in Pascal and Ada, but a little different from the `for` loop in Java.
2. The second extension is a _switch-command_, which is similar to the one in Java and C.

Each extension consists of three stages:
1.  _Syntactic analysis:_ definition of the grammar to specify the syntax of the new language feature.
2. _Contextual analysis:_ definition of scope and type checking rules for the new feature, and extension of the visitor to implement them.
3. _Code generation:_ definition of code templates for the new feature, and extension of the visitor to implement code generation.

Start from the version of Fun that has been extended with multiple parameters (familiarisation exercise) and set up a new project called **FunExtended** and start by importing or copying the files. **Maintain the same structure of directory.**

### Extension A: the _for-command_

The following Fun function contains a for-command:

```
func int fac (int n):   # returns n!
    int i = 0
    int f = 1
    for i = 2 to n:
        f = f*i .
    return f
.
```

This particular for-command makes the control variable `i` range from 2 up to the value of `n`. The for-command's body "`f = f*i`" is executed repeatedly, once for each value of the control variable. If the value of `n` is less than 2, the for-command's body is not executed at all.

A for-command of the form `for` *ident = expr1* `to` *expr2 : seg-com .* must respect the following scope/type rules:
* The control variable *ident* must already have been declared as a local variable of type `int`.
* Both *expr1* and *expr2* must be of type `int`.

The for-command has the following semantics:
1. Assign the value of *expr1* to the control variable *ident*
2. If the value of the control variable is greater than the value of *expr2*, terminate the for-command.
3. Execute the body *seq-com*.
4. Increment the control variable.
5. Continue the for-command at step 2.

### Extension B: the _switch-command_

The following Fun function contains a switch-command with an integer expression:

```
func int test (int n):
    int r = 0
    int s = 0
    switch n:
        case 1:
            r = 1
            s = 2
        case 2..4:
            s = 3
        default:
            r = 4
    .
    write(s)
    return r
.
```


The following Fun function contains a switch-command with a boolean expression:

```
func bool invert (bool b):
    bool x = false
    switch b:
        case true:
            x = false
        default:
            x = true
    .
    return x
.
```

Note the following points about the syntax, typing rules and semantics of the switch-command:
* The expression being tested (i.e. the expression that appears after the `switch` keyword) can be any integer or boolean expression.
* Each guard (i.e. the value of values that appear after a `case` keyword) has one of three possible forms. (1) An integer literal. (2) A boolean literal. (3) An integer range, such as `2..4` in the first example; this case is selected when the value of `n` is either 2, 3 or 4. Note that only literal values, not arbitrary expressions, are allowed in guards.
* All of the guards must have the same type as the expression being tested.
* All of the guards must be non-overlapping. This means that the guards of forms (1) and (2) must all have different values, and the ranges in guards of form (3) must not overlap with other ranges or with guards of form (1).
* There can be any number of cases.
* There must be exactly one `default` case.
* The code for each case can be any sequence of commands.
* There is no fall-through, therefore no need for a `break` keyword. At the end of the sequence of commands associated with a particular case, execution jumps to the end of the switch-command. This is true even if the sequence of commands is empty.

## Assignment Stage 1: Syntactic Analysis

### Extension A: the _for-command_

Add a suitable grammar definition for the for-command to `Fun.g4`. Remember to extend the lexicon as necessary. Make sure the grammar corresponds to the examples given above; the grammar needs to be general enough, but not so general that it allows incorrect syntax.

Write one or more test Fun programs containing for-commands. Test the extended syntactic analyser by running the simplified driver program `FunParse` with each of the test programs, and see whether it accepts them or produces appropriate syntax error messages.

### Extension B: the _switch-command_

Add the switch-command to `Fun.g4`. Remember to extend the lexicon as necessary. Make sure the grammar corresponds to the examples given above; the grammar needs to be general enough, but not so general that it allows incorrect syntax.

Write one or more test Fun programs containing switch-commands. Test the extended syntactic analyser by running the simplified driver program `FunParse` with each of the test programs, and see whether it accepts them or produces appropriate syntax error messages.

## Assignment Stage 2: Contextual Analysis

### Extension A: the _for-command_

Add implementations of the missing methods in the `FunCheckerVisitor` class so that all the necessary type checking for the extended Fun grammar is done.

Test the extended contextual analyser by running `FunCheck` with each of the test programs, and see whether it performs scope/type checks. The test programs should include one that violates all the for-command's scope/type rules.

### Extension B: the _switch-command_

Add implementations of the missing methods in the `FunCheckerVisitor` class so that all the necessary type checking for the extended Fun grammar is done. Also implement a check that there are no *repeated or overlapping guards*.

Test the extended contextual analyser by running `FunCheck` with each of the test programs, and see whether it performs type checks and other analysis (no repeated or overlapping guards). The test programs should include one that violates all the switch-command's rules.

## Assignment Stage 3: Code Generation

### Extension A: the _for-command_

Extend the Fun code generator as follows.

Start by designing a code template for a for-command. This should combine code to evaluate the for-command's two expressions, code to execute the for-command's body, conditional and/or unconditional jumps, and instructions to initialise, test, and increment the control variable.

When the code template is understood, define the missing methods in the `FunEncoderVisitor` class.

Test the extended contextual analyser and code generator by running `FunRun` with each of the test programs, and see whether it performs proper scope/type checks and generates correct object code.

There are two ways to verify whether the compiler generates correct object code.
1. Visually inspect the object code.
2. See what happens when the object code is interpreted. If the object code's behaviour is unexpected, the compiler must be generating incorrect object code.

### Extension B: the _switch-command_

Extend the Fun code generator as follows.

Start by designing a code template for a switch-command. This should combine code to evaluate the switch-command's expressions, code to compare the value of the epxression with each guard in turn, and the necessary conditional and unconditional jumps to ensure that only the appropriate case (i.e. sequence of commands) is executed.

When the code template is understood, define the missing methods in the `FunEncoderVisitor` class. A couple of instructions will need to be added to the SVM in order to be able to repeatedly compare the value of the expression with the guards. Therefore, modify `SVM.java`.

Test the extended contextual analyser and code generator by running `FunRun` with each of the test programs, and see whether it performs proper checks and generates correct object code.