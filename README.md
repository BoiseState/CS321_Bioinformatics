# CS 321 Bioinformatics Project

**Table of contents:**
- [Starter Code](#starter-code)
- [Scrum Process](#scrum-process)
- [Project Requirements](#project-requirements)

<hr/>

# Starter Code
This repository contains:
- the expected project package structure, in the [src/](src/) folder
- some partial implementation of classes, in the [src/main/java/cs321/](src/main/java/cs321/) folder
- sample [jUnit](https://junit.org/) tests, in the [src/test/java/cs321/](src/test/java/cs321/) folder
- sample input data and expected results, in the [data/](data/) folder
- a wrapper for the [gradle](https://gradle.org/) build tool, which simplifies installing and running gradle. In turn, gradle facilitates and handles:
    - Java library (e.g., jUnit) dependency management
    - Compiling the code
    - Generating self-containing jars
    - Running classes
    - Running unit tests

:heavy_exclamation_mark: **NOTE: Do NOT fork this repository**, because the forked repository
cannot have its own GitHub issues, which will be used as Scrum tasks.

:heavy_exclamation_mark: **NOTE: Do NOT modify the package structure in the [src/](src/) folder**,
otherwise the project may not be built correctly using gradle.

## One-Time Team Setup
One team member should:
- Create a new **private** GitHub repository and
    - Give repository write permissions to all the other team members
    - Give repository read permissions to the instructor and TA
- Clone (**not fork**) this repository and verify that gradle can be run.

```bash
$ git clone https://github.com/BoiseState/CS321_Bioinformatics.git
$ cd CS321_Bioinformatics
$ ./gradlew tasks
```

The last command should perform a one-time gradle setup, followed by
listing all the available gradle tasks and their descriptions.

**NOTE:** On Windows, the `./gradlew` command should be replaced with `gradlew`
(which will call the [`gradlew.bat`](/gradlew.bat) file)

The same team member should push the cloned repository to the new private repository.  This can
be done by changing the remote URL of the cloned repository to the new private repository's URL.

```bash
$ git remote set-url origin NEW_URL_OF_YOUR_NEW_PRIVATE_REPOSITORY
$ git remote -v
$ git push
```

The other team members should then clone the newly created student repository containing the
[starter code](#starter-code).

## Compile and Run the Project from the Command Line
Gradle allows running unit tests and code from IDEs, or the command line, as described below.

Run all the jUnit tests and print a summary of the results:
```bash
$ ./gradlew test
```

Run the `main` method from `GeneBankCreateBTree.java` and pass the [appropriate `<arguments>`](#51-program-arguments):
```bash
$ ./gradlew createJarGeneBankCreateBTree
$ java -jar build/libs/GeneBankCreateBTree.jar <arguments>
```

Run the `main` method from `GeneBankSearchBTree.java` and pass the [appropriate `<arguments>`](#51-program-arguments):
```bash
$ ./gradlew createJarGeneBankSearchBTree
$ java -jar build/libs/GeneBankSearchBTree.jar <arguments>
```


## Eclipse Project
This repository is an [Eclipse](https://www.eclipse.org/) project, and can be directly opened in
[Eclipse](https://www.eclipse.org/) (e.g., `File -> Open Projects from File System...`).

However, it can be imported into [IntelliJ IDEA](https://www.jetbrains.com/idea/) or other IDEs.

Note that you can add as many classes in the src/main/java as you want, and gradle should build
them automatically. In other words, the you should not have to make any changes to build.gradle.
Also, you can add new test files with new tests cases in src/test/java and those will be run
automatically by gradle or IntelliJ.

<hr/>

# Scrum Process
The focus of this project is to learn about data structures, while working effectively in a group.
In addition, given the small project scope, and the fixed set of requirements that are already
defined (and will not need to be elicited with the use of a Product Owner), the team can
customize the Scrum process learned in CS-HU 271 and focus exclusively on:
- creating tasks
- linking commits to task IDs (e.g., `Implements task #123`)
- Test-Driven Development and unit testing. The [starter code](#starter-code) already contains a few [sample unit tests](src/test/java/cs321) that can be [run from the command line](#compile-and-run-the-project-from-the-command-line).

## Scrum Board
Creating the tasks upfront will allow dividing and assigning the work in order to provide
transparency and accountability within the team.

Use the [Projects](https://github.com/BoiseState/CS321_Bioinformatics/projects) tab (i.e., a simplified version
of [ZenHub](https://www.zenhub.com)) to configure your own team Scrum board,
based on this [project example](https://github.com/BoiseState/CS321_Bioinformatics/projects/1)
(feel free to copy the contents of these tasks to your Scrum board).

Your Scrum board should contain the following columns (pipelines):

Column Name     | Description
--------------- | -----------
Product Backlog | All (unassigned) tasks that are going to be completed by the team throughout the duration of the project
Sprint Backlog  | Tasks proposed to be implemented in the current week (sprint), assigned to developers
In Progress     | Tasks currently being worked on
Review/QA       | Tasks ready to be reviewed by another team member
Closed          | Completed tasks, whose corresponding code is integrated in the `master` branch

Tasks should be assigned to the developer working on them. Each team
member should add to the project log file, Project-Log.md, the tasks (e.g., `https://github.com/StudentUserNameHostingRepo/CS321_Bioinformatics/issues/123`) completed that
week, as described in the [progress reports](#9-progress-reports).

Here is an example of a [valid task](https://github.com/BoiseState/CS321_Bioinformatics/issues/3) written in engineering language
that is assigned to a developer. This task should be referenced by a commit containing a message similar to `Implements task #3`.

As a warmup exercise, each team member should create a task similar to [`task #2`](https://github.com/BoiseState/CS321_Bioinformatics/issues/2) and then edit the [`README-submission.md`](/README-submission.md) file with their information.

<hr/>

# Project Requirements

## 1. Introduction
In this assignment, we will solve a problem from the field of Bioinformatics using BTrees.
The amount of data that we have to handle is large and any data structure is not likely to
fit in memory. Hence a BTree is a good choice for the data structure.

## 2. Background
_Bioinformatics_ is the field of science in which biology, computer science, and information
technology merge to form a single discipline. One of the primary aims of Bioinformatics is to
attempt to determine the structure and meaning of the human genome. The _human genome_
is a complete set of human DNA. The Human Genome project was started in 1990 by the
United States Department of Energy and the U.S. National Institutes of Health. By April
14, 2003 99% of the Human Genome had been sequenced with 99.9% accuracy.
The Human Genome is a big strand of 4 different organic chemicals, known as bases, which
are:
- _Adenine_
- _Cytosine_
- _Thiamine_
- _Guanine_

Biologists often call them `A`, `C`, `T`, `G` for short. The bases `A` and `T` are always paired
together. Similarly the bases `C` and `G` are always paired together. So when we look at
the DNA representation, only one side is listed. For example: the DNA sequence: `AATGC`
actually represents two sequences: `AATGC` and its complement `TTACG` (replace `A` by `T`, `T`
by `A`, `C` by `G` and `G` by `C`). Even with only half the bases represented in a DNA sequence,
the human genome is about **2.87 billion characters** long!

See below an image of the DNA as well as the chemical structure of the bases.

![DNA_physical_and_chemical_structure.png](docs/DNA_physical_and_chemical_structure.png "Physical (left) and Chemical (right) Structure of DNA")

The primary source for getting the human genome (as well as all other mapped organisms)
is in the National Center for Biotechnology Information (NCBI) website
(http://www.ncbi.nlm.nih.gov/). See this page for downloading [human genome
data](https://www.ncbi.nlm.nih.gov/genome/guide/human/)

We will be using the GeneBank files from NCBI. The format is described with a sample file
at http://www.ncbi.nlm.nih.gov/Sitemap/samplerecord.html

Most of the information in a GeneBank file is of interest to biologists. We will only be
interested in the actual DNA sequences that are embedded in these files rather than in the
intervening annotations.

## 3. Specifications

### 3.1. Input Files
The GeneBank files have a bunch of annotations followed by the keyword `ORIGIN`. The DNA
sequences start from the next line. Each line has 60 characters (one of `A`, `T`, `C`, `G`, could
be lower/upper case) until the end of sequence, which is denoted by `//` on a line by itself.
Sometimes you will see the character `N`, which denotes that the sequence is not known at
that character. You would skip these characters. One GeneBank file may have several DNA
sequences in it, each marked by `ORIGIN` and `//` tags.

When we reach a character `N`, we assume that the sequence has ended. Similarly, when
we reach `//`, we also assume that the sequence has ended. So at those points, we reset
the sequence that we were building and start over when we find the next `ORIGIN` or the
next valid character after seeing a `N`.

Some sample genome files (having the *.gbk extension) can be found in the [data/files_gbk/](data/files_gbk/) folder.

### 3.2. Problem
For a given GeneBank file, we want to convert it into a BTree with each object being a
DNA subsequence of specified length `k` (where `1` ≤ `k` ≤ `31`). We will take the DNA sequence
from the GeneBank file and break it into subsequences of length `k` each. We are interested in
all subsequences with length `k`. For example, in the sequence `AATTCG`, the subsequences
of length three are: `AAT`, `ATT`, `TTC` and `TCG`. Once we have a BTree for a length `k`, we
want to be able to search for query subsequences of length `k`. The search returns the frequency
of occurrence of the query string (which can be zero if it is not found).

The biological motivation behind is to study the frequency of different length subsequences
to see if they are random or that some subsequences are more likely to be found in the DNA.

## 4. Design Issues

### 4.1. Saving memory
Since we only have four possible bases (`A`, `C`, `G` and `T`), we can optimize
on space by converting our DNA strings to base 4 numbers. Then we can represent each
base by a 2-bit binary number, as shown below:

DNA Base | 2-bit binary number
-------- | -------------------
A        | 00
T        | 11
C        | 01
G        | 10

Note that we have made the binary representations for complementary bases be binary
complements as well. With this compact representation, we can store a 31 length subsequence
in a 64-bit `long` primitive type in Java.

### 4.2. Key Values
Note that the binary compact representation of the subsequences will result
in a unique 64-bit integer value. Hence we can directly use that as our key value.

### 4.3. Class Design
We will need a `BTree` class as well as a `BTreeNode` class. The objects that
we store in the BTree will be similar to the objects we stored in the previous Hashtable
assignment. You may call the relevant class `TreeObject` to represent the objects.

## 5. Implementation
You will have two programs:
- one that **creates a BTree** from a given GeneBank file and
- another for **searching in the specified BTree** for subsequences of given length. The search program
assumes that the user specified the proper BTree to use depending upon the query length.

The main Java classes should be named `GeneBankCreateBTree` and `GeneBankSearchBTree`.

### 5.1. Program Arguments
The required arguments for the two programs are shown below:

```bash
java -jar build/libs/GeneBankCreateBTree.jar <0/1(no/with Cache)> <degree> <gbk_file> 
                                   <subsequence_length> [<cache_size>] [<debug_level>]

java -jar build/libs/GeneBankSearchBTree.jar <0/1(no/with Cache)> <btree_file> <query_file> 
                                   [<cache_size>] [<debug_level>]
```

- `<0 (no cache) | 1 (cache)>` specifies whether the program should use cache (value `1`) or
no cache (value `0`); if the value is `1`, the `<cache_size>` has to be specified

- `<degree>` is the degree to be used for the B-Tree. If the user specifies `0`, then your program
should choose the optimum degree based on a disk block size of `4096` bytes and the size of your
B-Tree node on disk

- `<gbk_file>` is the input `*.gbk` file containing the input DNA sequences

- `<subsequence_length>` is an integer that must be between `1` and `31` (inclusive)

- `< b-tree_file>` is the B-Tree file generated by the `GeneBankCreateBTree` program

- `<query file>` contains all the DNA strings of a specific subsequence length that we want to search
for in the specified B-Tree file. The strings are one per line and they all must have the same length
as the DNA subsequences in the B-Tree file. The DNA strings use `A`, `C`, `T`, and `G` (either lower or upper case)

- `[<cache size>]` is an integer between `100` and `500` (inclusive) that represents the maximum
number of `BTreeNode` objects that can be stored in memory

- `[<debug level>]` is an optional argument with a default value of zero.

    - It must support at least the following values for `GeneBankSearchBTree`:

        - `0`: The output of the queries should be printed on the standard output stream. Any diagnostic messages, help and status messages must be be printed on standard error stream.

    - It must support at least the following values for `GeneBankCreateBTree`:

        - `0`: Any diagnostic messages, help and status messages must be be printed on standard error stream.

        - `1`: The program writes a text file named `dump`, containing the frequency and the DNA string (corresponding to the key stored) in an inorder traversal, and has the following line format:

```bash
<frequency> <DNA string>
```

### 5.2. Additional Implementation Remarks

#### 5.2.1. Your programs should always keep the root node in the memory
Write the root node to disk file only at the end of the program and read it in when the program
starts up. In addition, your program can only hold a few nodes in memory. In other words,
you can only use a few BTreeNode variables (including the root) in your program (e.g., root,
parent, current, child, temporary node for split). However, using the `<1 (cache)>` option,
you can store in a one-level cache `<cache_size>` `BTreeNode` objects.

#### 5.2.2. Metadata storage
We need to store some metadata about the B-Tree on disk. For example, we can store the degree
of the tree, the byte offset of the root node (so we can find it), the number of nodes, and
so on. This information could be stored in separate metadata file or it can be stored at the
beginning of the B-Tree file.

#### 5.2.3. The B-Tree should be stored as a binary data file on the disk (and not as a text file)
If the name of the GeneBank file is `xyz.gbk`, the subsequence length is `<k>` and the B-Tree
degree is `<t>`, then the name of the B-Tree file should be `xyz.gbk.btree.data`.`<k>.<t>`.

:book: Describe the layout of the B-Tree file on disk as well as any other relevant observations
in the [`README-submission.md`](/README-submission.md) file.

#### 5.2.4. Running Tests
The [data/queries/](data/queries/) folder contains:
- sample query files
- a sample program named [`QueryGenerator.java`](data/queries/QueryGenerator.java) that
generates random queries for testing

Please be sensitive to other students when you run large tests on your assignments.
Preferably, run all your tests at home. If you do need to run them in the lab, please do
not run them on `onyx`. Instead run them on one of the workstations. If you are log in to `onyx`
remotely via `ssh`, then `ssh` into a idle workstation to run your tests. You can check if anyone
is on a workstation with the command `who`. You can also check the load on the system with the
command `top`. The workstations are named `onyxnode01` through `onyxnode99`.

We will setup [Amazon AWS](https://aws.amazon.com/) accounts for each student so you can run
your larger tests in the cloud.

## 6. Using a Cache
You should incorporate the Cache object from `Project 1` to improve the performance of your B-Tree
implementation. The size of the Cache should be a command line argument. An entry in the Cache is a
`BTreeNode`. With the `<1 (cache)>` command line option, the `<cache_size>` needs to be specified
as well.

:book: Report the time improvement using a cache of size `100` and `500` in your [`README-submission.md`](/README-submission.md) file.

## 7. Using a Database to store and search the results

Design a simple database to store the results (sequences and frequencies) from the B-Tree.
We will perform an inorder tree traversal to get the information to store in the database. This
would be done at the end of creating the GeneBank BTree. Then we will create a separate search
program named `GeneBankSearchDatabase` that uses the database instead of the BTree.

```bash
$ ./gradlew createJarGeneBankSearchDatabase
$ java -jar build/libs/GeneBankSearchDatabase.jar <path_to_SQLite_database> <query_file> [<debug_level>]
```

We will use the embedded SQLite database for this project.  The SQLite database is fully
contained in a jar file that gradle will automatically pull down for you. See the database
example in the section below on how to use SQLite.

## 8. Useful Examples

The following examples from the class examples repository will be useful for this project.

- [disk IO
  example](https://github.com/BoiseState/CS321-resources/tree/master/examples/disk-IO-examples): In
  particular, look at DiskReadWriteExample.java.
- [external binary search](https://github.com/BoiseState/CS321-resources/tree/master/examples/external-binary-search)
- [SQLite example](https://github.com/BoiseState/CS321-resources/tree/master/examples/SQLite)
- [Bitwise operators example](https://github.com/BoiseState/CS321-resources/tree/master/examples/bitwise-operators-example): In particular, look at BitwiseShiftDemo.java for helpful sequence utility code.

## 9. Testers

You can run a large test on the data file `test5.gbk` as follows:

```bash
./gradlew createJarGeneBankCreateBTree
./gradlew createJarGeneBankSearchBTree

./create-btrees.sh data/test5.gbk
./check-dumpfiles.sh test5.gbk
./check-queries.sh test5.gbk
```


## 10. Progress Reports

Each team member will fill out a progress report (via a survey) each week. The link to the
survey will be posted on Piazza.

In addition, each team member should log their project-related
activities for the week, including the URL to the tasks (e.g.,
`https://github.com/StudentUserNameHostingRepo/CS321_Bioinformatics/issues/123`) completed that
week, in a separate file named `Project-Log.md`.

As a reminder, each commit should link (reference) in the commit message the completed task
(e.g., `Implements task #123`), in order to automatically link the task to the commit, and make
the code changes directly available from the task itself.

It is expected that each team should have at least one meeting every week.

Progress reports are confidential.

## 10. Submission
Before submission, make sure that you:
- can clone the team repository on `onyx`
- can [compile and run the program from the command line](#compile-and-run-the-project-from-the-command-line) and obtain the expected results

**One team member should email the URL of the team GitHub repository to the instructor and TA.**

Make sure the [instructor and TA have access to the repository](#one-time-team-setup).
