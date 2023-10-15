# Computer Science II
## Lab 3.0 - Strings & File I/O
### Python Version
[School of Computing](https://computing.unl.edu)  
[College of Engineering](https://engineering.unl.edu/)  
[University of Nebraska-Lincoln](https://unl.edu)  
[University of Nebraska-Omaha](https://unomaha.edu)  

An introduction to using strings and file input/output in Python.

### Resources

Prior to lab you should read/review the following sections of
the Python tutorial:

https://docs.python.org/3/tutorial/introduction.html#strings

https://docs.python.org/3/tutorial/inputoutput.html#reading-and-writing-files

### Lab Objectives & Topics

Following the lab, you should be able to:
* Use Strings and do basic file I/O in Python


### Peer Programming Pair-Up

To encourage collaboration and a team environment, labs will be
structured in a *pair programming* setup.  At the start of
each lab, you may be randomly paired up with another student by
a lab instructor.  One of you will be designated the *driver*
and the other the *navigator*.  

The navigator will be responsible for reading the instructions
and telling the driver what is to be done.  The driver will be
in charge of the keyboard and workstation.  Both driver and
navigator are responsible for suggesting fixes and solutions
*together*.  Neither the navigator nor the driver is "in charge."  
Beyond your immediate pairing, you are encouraged to help and
interact and with other pairs in the lab.

Each week you should try to alternate: if you were a driver
last week, be a navigator next, etc.  Resolve any issues (you
were both drivers last week) within your pair.  Ask the lab
instructor to resolve issues only when you cannot come to a
consensus.  

Because of the peer programming setup of labs, it is absolutely
essential that you complete any pre-lab activities and familiarize
yourself with the handouts prior to coming to lab.  Failure to do
so will negatively impact your ability to collaborate and work with
others which may mean that you will not be able to complete the
lab.  

## 1. Getting Started

Clone this project code for this lab from GitHub using the
URL: https://github.com/cbourke/CSCE156-Lab03. Refer to Lab 1.0 for
instructions on how to clone a project from GitHub.

## 2. Strings & File I/O

You will familiarize yourself with strings and file input/output by
completing two Python programs.

The first program involves processing a DNA nucleotide sequence (a
string consisting of the characters A, G, C, and T standing for the
nucleobases adenine, guanine, cytosine, and thymine). A common operation
on DNA is searching for and counting the number of instances of a
particular subsequence. For example, in the following DNA sequence,
`TAGAAAAGGGAAAGATAGT` the subsequence `TAG` appears twice. Your
activity will involve processing a file containing a nucleotide sequence
of the H1N1 flu virus and counting the number of instances of various
subsequences.

The second program involves processing a file containing formatted data.
Specifically, you will process a file containing the win/loss records of
National League baseball Teams from the 2011 season. The file is
formatted as follows: each line contains the win/loss record of a single
team (16 teams total). Each line contains the team name, the number of
wins, and the number of losses. Your program will read in the file,
process the data and sort the teams in the order of their win percentage
(wins divided by total games) and output the sorted and reformatted team
list into a new file.

## 2.1 Formatted Output

Most programming languages support the ability to format output using
the standard `printf`-style formatting.  In Python, this is best achieved
using "formatted strings".

Formatted strings are strings that have an `f` in front of them.  Inside
the string, you can use curly brackets, `{}` to specify a variable to be
formatted.  For example:

```python
x = 42
name = "Grace Hopper"
str = f"Hello, {name}, the answer is {x}"
print(str)
```

You can use `printf`-style modifiers to format variables within this string.
Usually this is done to control how many digits get printed with numbers.
Some examples:

```python
pi = 3.14159
# default formatting:
print(f"pi is {pi}") #prints 3.14159
# 2 decimals of precision:
print(f"pi is {pi:.2f}") #prints 3.14
# 3 decimals of precision; observe the rounding:
print(f"pi is {pi:.3f}") #prints 3.142

# 2 decimals of precision with at least 8 "columns" printed
print(f"pi is {pi:8.2f}") #prints 3.14 with 4 leading spaces


x = 42
# d is the placeholder for integers:
print(f"{x:d}")
# prints 42 with 3 leading spaces
print(f"{x:5d}")
# prints 42 with 3 leading zeros:
print(f"{x:05d}")

name = "Grace"
# s can be used as a placeholder for stirngs, but
# it is not necessary
# print with at least 20 columns (15 spaces)...
# left-justified:
print(f"|{name:<20}|")
# right-justified:
print(f"|{name:>20}|")
```

This code snippet would result in the following output.

```text
pi is 3.14159
pi is 3.14
pi is 3.142
pi is     3.14
42
   42
00042
|Grace               |
|               Grace|
cbourke@cse-cbourke-07 python % python3 dev.py
pi is 3.14159
pi is 3.14
pi is 3.142
pi is     3.14
42
   42
00042
|Grace               |
|               Grace|
```

## 2.2 Processing CSV Data

Comma separate value (CSV) data is a common *flat file* data representation.
In it, records are represented one per line in a file with individual data
fields separated by commas.  It is easy enough to process such data if you
already have them stored in a string: you can use the `split()` function
to *tokenize* the data into a list of string *tokens*.  Example:

```python
data = "Hello,World,How,Are,You?"
tokens = data.split(",")
print(tokens)
```

which would result in the output:
```text
['Hello', 'World', 'How', 'Are', 'You?']
```

## 3. Activities

### 3.1 Substring Searching

1.  Open the `dna_analysis.py` and `data/H1N1nucleotide.txt` files

2.  Modify the script to read in a DNA subsequence from the command line (and
    to echo an error and exit if it is not provided).

3.  The code to read in and process the nucleotide sequence is already
    provided. Observe how it works: it opens the file, reads in all lines,
    strips out whitespace (using a regular expression) and then "joins" all
    lines into one large DNA string using string concatenation.  

4.  Implement the `count_subsequences()` function to count the number of
    occurrences of the provided `subSequence`.  Many different solutions
    are possible.  Test your solution using the provided unittest suite:
    `python test_dna_analysis.py`

### 3.2 File Processing

1.  Open the `baseball.py` and `team.py` files. The class has already been
    implemented and included in the script.  Recall from lab 2 you can create
    an instance of an object by invoking its initializer; for example:  
    ```python
    # Huskers had 8 wins, 4 losses:
    t = Team("Huskers", 8, 4);
    ```

2.  Much of the code has been provided for you, including code to sort
    the teams by win percentage and print them out (study this code as
    it may be useful in future assignments).

3.  Finish implementing the `load_teams()` function by adding code to open
    the `mlb_nl_2011.csv` data file (in the `data` directory), process
    it line-by-line and create individual `Team` instances, adding them
    to a list of teams and returning the list.

#### 3.2.1 File Output

To output to a file you can open it for writing (`w`) and use `write()`.
A full example:

```python
f = open("path/to/filename.txt", "w");
x = 42;
f.write("You can write a normal string\n")
f.write(f"You can write a formatted string, x = {x}\n")
f.write("endline characters are not automatically printed :(")
# make sure to close the file:
f.close()
```

1.  Modify your `baseball.py` program to output the sorted team list
    to a file rather than the standard output.  Output to a file named
    `teams.txt` in the current working directory.

### 4. Testing, Submitting & Grading

* Test your programs, fix any errors, and completely debug your programs.
* Submit the following files:
  * `baseball.py`
  * `dna_analysis.py`
* Run the grader and verify the output to complete your lab.

### Advanced Activity (Optional)

The code to sort the teams according to their win percentage was
provided for you. It worked by specifying a key using a *lambda*
expression to refer to the `getWinPercentage()` function.  Alternatively
you could refer instead to an attribute of the class.  Read the Python
documentation or this tutorial:

https://favtutor.com/blogs/sort-list-of-objects-python

and modify the code to output the teams in alphabetic order according
to the team name instead.
