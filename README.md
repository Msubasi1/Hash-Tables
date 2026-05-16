# Hash Tables

[![Java](https://img.shields.io/badge/Java-8+-007396.svg)](https://www.java.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Three hash-table collision-resolution strategies implemented from scratch in Java, with side-by-side comparison of comparison counts and CPU search time. Built as a Data Structures assignment at Hacettepe University.

## Strategies Implemented

| # | Strategy | Storage |
|---|----------|---------|
| 1 | **Separate Chaining** | `LinkedList[]` — collisions appended to a chain |
| 2 | **Linear Probing** | `Employee[]` — collisions placed at the next free slot |
| 3 | **Double Hashing** | `Employee[]` — collisions placed at `(h₁(k) + i·h₂(k)) mod TABLE_SIZE` |

### Hash Functions

```
h₁(key) = key mod TABLE_SIZE
h₂(key) = 1 + (key mod (TABLE_SIZE − 1))
```

The `key` is the employee's `phone` field, parsed as an integer.

### Table Sizing

`TABLE_SIZE = ceil(record_count / load_factor)`. Two load factors are supplied as arguments — one for separate chaining (`LF1`), and one shared by linear probing and double hashing (`LF2`).

## Tech Stack

- **Language**: Java 8+
- **Dependencies**: none (standard library only — `java.io`, `java.util`)

## Project Structure

```
.
├── src/
│   ├── Main.java          # Reads input, runs all 3 strategies, writes output.txt
│   ├── MyHashTable.java   # Core table — put/get for all 3 strategies
│   ├── LinkedList.java    # Chain implementation for separate chaining
│   ├── Employee.java      # Record entity (employeeCode, NRIC, phone)
│   ├── FileRead.java      # Counts records for table sizing
│   └── input.txt          # Sample dataset (header + 20 records)
├── HashTables.pdf         # Original assignment specification
├── LICENSE
└── README.md
```

## Input Format

Space-separated columns with a single-line header:

```
E_Code NRIC Phone
TFTBYS H22779228 85670570
XDVSTY W14372211 96841548
ZLOTNS L13126691 87129676
...
```

## Build

```bash
cd src
javac *.java
```

## Run

```bash
cd src
java Main <input.txt> <LF1> <LF2> <search_phone>
```

| Argument | Meaning |
|----------|---------|
| `input.txt` | Path to the records file |
| `LF1`       | Load factor for separate chaining |
| `LF2`       | Load factor for linear probing and double hashing |
| `search_phone` | Phone number to look up |

### Example

```bash
javac *.java
java Main input.txt 0.5 0.7 85670570
```

Output is written to `output.txt` in the current directory.

## Example Output

```
input.txt,LF1=0.5,LF2=0.7,85670570
PART1
[CHAIN 0]: Null
[CHAIN 1]: 85670570
[CHAIN 2]: 96841548
...
PART2
Hashtable for Linear Probing
[0]--->null
[1]--->85670570
...
Hashtable for Double Hashing
[0]--->null
[1]--->85670570
...
SEPERATE CHAINING:
Key found with 1 comparisons
CPU time take to search = 14723 ns
LINEAR PROBING:
Key found with 1 comparisons
CPU time take to search = 6312 ns
DOUBLE HASHING:
Key found with 1 comparisons
CPU time take to search = 4998 ns
```

## Clean

```bash
cd src
rm -f *.class output.txt
```

## Author

**Muhammet Subaşı** ([@Msubasi1](https://github.com/Msubasi1))

## License

Released under the [MIT License](LICENSE).
