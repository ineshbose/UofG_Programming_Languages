# FunExtended

The assignment is to design and implement two extensions to Fun.
1. The first extension is a _for-command_, which is a new form of loop. It is similar to the `for` loop in Pascal and Ada, but a little different from the `for` loop in Java.
2. The second extension is a _switch-command_, which is similar to the one in Java and C.

Each extension consists of three stages:
1.  _Syntactic analysis:_ definition of the grammar to specify the syntax of the new language feature.
2. _Contextual analysis:_ definition of scope and type checking rules for the new feature, and extension of the visitor to implement them.
3. _Code generation:_ definition of code templates for the new feature, and extension of the visitor to implement code generation.

Start from the version of Fun that has been extended with multiple parameters (familiarisation exercise) and set up a new project called **FunExtended** and start by importing or copying the files. **Maintain the same structure of directory.**