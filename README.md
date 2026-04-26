# Algorithms & Data Structures

A personal study repository for algorithms, data structures, and coding problem solutions, implemented in **Java** and **Kotlin**.

## Structure

```
src/
├── bigOStudy/        # Fundamental algorithms with Big O focus
├── implementation/   # Data structures built from scratch
│   ├── hashmap/
│   └── linkedlist/
├── interview/        # Coding interview challenges
├── leetcode/         # LeetCode problem solutions
│   └── kotlin/
├── systemDesign/     # System design references
└── utils/            # Shared classes (ListNode, TreeNode)
```

## Topics Covered

### Algorithms (`bigOStudy/`)
| Algorithm | File |
|---|---|
| Binary Search | `BinarySearch.java` |
| Bubble Sort | `BubbleSort.java` |
| Merge Sort | `MergeSort.java` |
| Quick Sort | `QuickSort.java` |
| Binary Tree traversals | `BinaryTree.java` |
| Two Pointer technique | `TwoPointer.java` |
| Bit Manipulation | `BitManipulation.java` |

### Data Structures (`implementation/`)
| Structure | Files |
|---|---|
| HashMap (with collision handling) | `hashmap/HashMapImpl.java` |
| Doubly Linked List | `linkedlist/DoublyLinkedListStudy.java` |

### LeetCode Problems (`leetcode/`)

**Arrays & Strings**
- Merge Sorted Array, Remove Duplicates, Remove Element, Rotate Array
- Reverse Words in a String, Length of Last Word, Longest Common Prefix
- Kids With the Greatest Number of Candies, Can Place Flowers

**Hashing**
- Two Sum, Group Anagrams, Valid Anagram, Contains Duplicate
- Valid Sudoku, Ransom Note, Word Pattern, Unique Number of Occurrences
- Longest Consecutive Sequence

**Linked Lists**
- Add Two Numbers, Merge Two Lists, Middle of Linked List, Linked List Cycle

**Trees**
- Invert Binary Tree

**Two Pointers / Sliding Window**
- Container With Most Water, Three Sum
- Maximum Average Subarray, Maximum Length Substring Without Repeating Characters

**Math & Others**
- Roman to Integer / Integer to Roman, Happy Number, Palindrome
- Number of Bits, Jump Game, Majority Element, Valid Parentheses
- Summary Ranges, Search Insertion Position, Insert Delete Get Random O(1)

> Several problems have parallel Kotlin solutions under `leetcode/kotlin/`.

### Interview Challenges (`interview/`)
- Bracket matching validation
- Linked list challenge
- Tic-Tac-Toe game implementation
- Transaction processing challenge (Kotlin)

## Setup

**Requirements:** JDK 21+, IntelliJ IDEA (recommended)

1. Clone the repository
2. Open the project root in IntelliJ IDEA
3. Run any `main` method directly from the IDE

## Languages

- **Java** — primary implementation language (58 files)
- **Kotlin** — secondary, used for select LeetCode problems and interview challenges (9 files)