# Duplicate Remover

Removes duplicates in non-descending sequence of 32 bit integers.

Conditions

1. First line of input is considered number of items, should be in \[1, 1000000\]
1. Second and subsequent lines of input are considered items to process, each item should be 
   32 bit integer (negative value is allowed), items should follow in non-decreasing order
1. Input is taken from standard input stream
1. Output is all input items except duplicates
1. Output is sent to standard output stream
1. Memory consumption should not exceed 20 MB

## Usage

Assuming:

1. current directory is directory where this README is located
1. Bash is used

```bash
echo -e "5\n-45\n0\n1\n1\n5" \
| java -jar target/deduplicate-0.0.1-SNAPSHOT.jar
```

Expected output:

```text
-45
0
1
5
```
