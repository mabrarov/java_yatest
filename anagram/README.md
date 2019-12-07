# Anagram

Checks if 2 strings are [anagrams](https://en.wikipedia.org/wiki/Anagram). 

Conditions

1. First and second lines of input are considered strings to check, both should consist of a-z only
1. Input is taken from standard input stream
1. Output is 1 if input streams are anagrams and 0 otherwise
1. Output is sent to standard output stream
1. Memory consumption should not exceed 20 MB

## Usage

Assuming:

1. current directory is directory where this README is located
1. Bash is used

```bash
echo -e "abcdc\ncdcab" | java -jar target/anagram-0.0.1-SNAPSHOT.jar
```

Expected output:

```text
1
```
