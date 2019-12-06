# Max Sequence Length

Counts length of the longest sequence consisting of 1.

Conditions

1. First line of input is considered number of items, should be in \[1, 10000\]
1. Second and subsequent lines of input are considered items to process, each item may be 0 or 1
1. Input is taken from standard input stream
1. Output is the length of the longest sequence consisting of 1
1. Output is sent to standard output stream

## Usage

Assuming:

1. current directory is directory where this README is located
1. Bash is used

```bash
echo -e "22\n1\n0\n0\n1\n1\n0\n1\n1\n1\n1\n0\n0\n1\n0\n1\n1\n1\n1\n0\n0\n1\n1" \
| java -jar target/max-sequence-len-0.0.1-SNAPSHOT.jar
```

Expected output:

```text
4
```
