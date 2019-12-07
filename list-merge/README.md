# List Merge

Merges multiple lists sorted in non-decreasing order into a single list sorted in non-decreasing order.

Conditions

1. First line of input is number of lists to merge (number-of-lists), 
   should be an integer in \[0, 1024\]
1. Second and subsequent lines of input are considered lists to merge,
   each list starts from an integer in \[0, 10 * number-of-lists\] representing size of list,
   then items of list are following, items of list may be separated with whitespaces or new line
1. Items of each list should be given in non-descending order,
   each item should be an integer in \[0, 100\]
1. Input is taken from standard input stream
1. Output is the merged list consisting of items of all input lists in non-descending order, 
   items are separated with space
1. Output is sent to standard output stream

## Usage

Assuming:

1. current directory is directory where this README is located
1. Bash is used

```bash
echo -e "4\n6 2 26 64 88 96 96\n4 8 20 65 86\n7 1 4 16 42 58 61 69\n1 84" \
| java -jar target/list-merge-0.0.1-SNAPSHOT.jar
```

Expected output:

```text
1 2 4 8 16 20 26 42 58 61 64 65 69 84 86 88 96 96
```
