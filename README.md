Compiler for MicroJava with elements of both Java and Python.

Project support four phases: Lexer generation, Parser generation, Semantic pass, and Code generation.

Compiler suppoorts the following:

- Working with variables and consts (char, bool, int), including arrays
- Various expression with mathemtical and relational operators
- Function calls
  - Print (supports printing arrays)
  - Ord
  - Chr
  - Len
  - Range
  - User-defined functions
  - Read from std input (in all variables)
- Namespaces
- Recovery from parser failure
- Error reporting, with continuation after error detection, to report all existing errors.
