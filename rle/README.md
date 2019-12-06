# RLE

Transforms text consisting of A-Z characters from text like:

```text
AABBBBCCAAARRRTMMMN
```

to text like:

```text
A2B4C2A3R3TM3N
```

## Usage

Assuming current directory is directory where this README is located.

```bash
java -jar target/rle-0.0.1-SNAPSHOT.jar AABBBBCCAAARRRTMMMN
```

Expected output:

```text
AABBBBCCAAARRRTMMMN
A2B4C2A3R3TM3N
```
