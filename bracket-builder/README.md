# Bracket Sequence Builder

Generates valid sequences of round brackets, sequences are generated in lexicographic order.

Conditions

1. First line of input is considered number of bracket pairs to generate in a single sequence,
   should be in \[0, 11\]
1. Input is taken from standard input stream
1. Output is all valid bracket sequences, each following in a new line
1. Bracket sequences are printed in lexicographic order
1. Output is sent to standard output stream
1. Memory consumption should not exceed 20 MB

## Usage

Assuming:

1. current directory is directory where this README is located
1. Bash is used

```bash
echo "4" | java -jar target/bracket-builder-0.0.1-SNAPSHOT.jar
```

Expected output:

```text
(((())))
((()()))
((())())
((()))()
(()(()))
(()()())
(()())()
(())(())
(())()()
()((()))
()(()())
()(())()
()()(())
()()()()
```
