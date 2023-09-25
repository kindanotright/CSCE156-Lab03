# Computer Science II
## Lab 3.0 - Strings & File I/O
[School of Computing](https://computing.unl.edu)  
[College of Engineering](https://engineering.unl.edu/)  
[University of Nebraska-Lincoln](https://unl.edu)  
[University of Nebraska-Omaha](https://unomaha.edu)  

An introduction to using conditionals and loops in the Java programming language.
A separate folder containing a Python version of this lab is 
included for the honors section.

## Overview

### Resources

Prior to lab you should read/review the following resources.
* Java String tutorial   
http://download.oracle.com/javase/tutorial/java/data/strings.html
* Java File I/O tutorial  
http://download.oracle.com/javase/tutorial/essential/io/file.html
* Java tutorial on the `System.out.format` method  
https://docs.oracle.com/javase/tutorial/java/data/numberformat.html

### Lab Objectives & Topics

Following the lab, you should be able to:
* Use Strings and do basic file I/O in Java

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

Clone this project code for this lab from GitHub in Eclipse using the
URL: https://github.com/cbourke/CSCE156-Lab03. Refer to Lab 1.0 for
instructions on how to clone a project from GitHub.

For those with prior Java experience, do the PHP version of this
lab. For those without prior Java experience, do the Java version.

## 2. Strings & File I/O

You will familiarize yourself with strings and file input/output by
completing two Java programs.

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

Most programming languages support or implement the standard
functionality of the `printf()` or "print formatted" output originally 
provided in the C programming language.

Functions like `printf()` are *variable argument function* which 
means that they can take a *variable* number of arguments.  The first
argument is a string that specifies a *format* in which to print the 
subsequent arguments.  Various flags can be used to print different types of 
variable values in a specific format. Some of the major flags
supported:

* `%Ns` - print the argument as a string, right-justified with at least `N`
    characters. If the string value is less than `N`, it will be padded
    out with spaces. Variations on this flag can be used to change the
    padding character and to left-justify (negative `N`) instead.

* `%Nd` - print the argument as an integer with at least `N` spaces.

* `N.Mf` - print the argument as a floating point number with at least `N`
    characters (including the decimal) and at most `M` decimals of
    precision.

In Java you can use `String.format()` to format a `String` and save it
to a variable or you can use `System.out.printf()` to output the result
directly to the standard output.  A full example of both:

```java
String a = "hello"; 
int b = 42;
double c = 3.1418;
String result = String.format("%10s, %5d\t%5.2f\n", a, b, c);
System.out.println(result);

//alternatively:
System.out.printf("%10s, %5d\t%5.2f\n", a, b, c);
```

This code snippet would result in the following output (dots
have been added to highlight *added* the spaces)

```text
.....hello, ...42     .3.14
```

## 2.2 Processing CSV Data

Comma separate value (CSV) data is a common *flat file* data representation.
In it, records are represented one per line in a file with individual data 
fields separated by commas.  It is easy enough to process such data if you 
already have them stored in a `String`: you can use Java's `split()` method
to *tokenize* the data into an array of string *tokens*.  Example:

```java
String data = "Hello,World,How,Are,You?";
String tokens[] = data.split(",");
for(int i=0; i<tokens.length; i++) {
  System.out.println(tokens[i]);
}
```

which would result in the output: 
```text
Hello
World
How
Are
You?
```

## 3. Activities 

### 3.1 Substring Searching

1.  Open the `DnaAnalysis.java` and `data/H1N1nucleotide.txt` files

2.  Modify the `main` method to read in a DNa subsequence from the command line (and
    to echo an error and exit if it is not provided).
    
3.  The code to read in and process the nucleotide sequence is already
    provided. Observe how it works: a `static` block is executed when the
    class is loaded up by the JVM (before any methods are ever called).
    This allows you to do any `static` initialization of variables.  The
    `loadDnaFromFile()` method has been written for you.  It reads in 
    the file line by line concatenating it into one large string.  It 
    then trims out all whitespace using a *regular expression*
    
4.  Implement the `countSubsequences()` method to count the number of
    occurrences of the provided `subSequence`.  You may want to keep
    the Java `String` documentation open to find any method(s) that will
    help you process the DNA string:      
    https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html

    
### 3.2 File Processing

1.  Open `Baseball.java` the `Team.java` source files. 
    The `Team` class has already been implemented for you.  Recall from lab
    2 you can create an instance of an object by using the `new` keyword to
    call the class's constructor.  For example:  
    ```java
    //Huskers had 8 wins, 4 losses:
    Team t = new Team("Huskers", 8, 4);
    ```

2.  Much of the code has been provided for you, including code to sort 
    the teams by win percentage and print them out (study this code as
    it may be useful in future assignments).

3.  Finish implementing the `loadData()` method by adding code to open
    the `mlb_nl_2011.csv` data file (in the `data` directory), process
    it line-by-lie and create individual `Team` instances.

#### 3.2.1 File Output

In this activity, you will write a method to output the sorted team list
to a *file* rather than the standard output.  To output to a file, use 
the class which supports easy output to files. A full example:

```java
try {
  PrintWriter pw = new PrintWriter("path/to/filename.txt");
  pw.write("you can output a string directly using this method!");
  pw.printf("Or you can use printf!\n");
  pw.close();
} catch (FileNotFoundException fnfe) {
  throw new RuntimeException(fnfe);
}
```
Add the following method to the `Baseball.java` source file that 
takes a list of teams and an output file name and outputs
the team data to that file.  

`public static void persistData(List<Team> teams, String outputFileName)`
- The format is up to you 
- Call your method from the `main` and test that it works
- Add javadoc-style documentation to your method.  Remember that
  **all** classes and non-trivial methods require documentation.

### 4. Testing, Submitting & Grading

* Test your programs using the provided JUnit test suite(s).  Fix any
errors and completely debug your programs.
* Submit the following files:
  * `DnaAnalysis.java`
  * `Baseball.java`
* Run the grader and verify the output to complete your lab.

### Advanced Activity (Optional) 

The code to sort the teams according to their win percentage was
provided for you. It involved defining a `Comparator` (as an anonymous class) that
was passed as an argument to a built-in sort method. Study this code and
read the documentation for the sorting method. Modify the to sort the
list of teams in alphabetic order according to the team name instead.
