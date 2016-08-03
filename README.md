# ﻿Implicheck


ImpliCheck is a program dedicated to providing an answer as to whether two words are related to each other. The answer is calculated by assigning a two possible types of relations:
* Correct - There is a clear relation between the two words
* Not Found - There is no relation between the two words
For each relation type, we offer a level of certainty of the answer. The levels are:
* Sure - The relation type is found with high certainty
* Not Sure - The relation type was found with possibility of error


In addition, the program determines if a word morphologically subsumes the other and how morphologically relevant the two words are. Three numerical values are returned by this algorithm:
* A value depicting morphological relevance.
* A value depicting how much word 1 morphologically subsumes word 2
* A value depicting how much word 2 morphologically subsumes word 1


ImpliCheck makes it's decisions using the Implication Relation Algorithm developed by researchers at the Sina Institute alongside the Morphological Subsume Algorithm developed by Prof. Fadi Zaraket and researchers at the Sina Institute.

INPUT

There are two forms of input in this program: Manual input Here you can input two words manually from your keyboard, one of each into the text fields labelled "Word 1" and "Word 2", respectively. Pressing the "Check Implication" button on the lower-right of the window will generate the results of the two words' implication.

File input: If you tap on "File" on the top-left corner of the screen, and then select "Select Input and Output Files", you will be shown a window to select a file to read the words you wish to check the implication of. The input from each line from a file must be structured as follows:

[Word 1] [Word 2]

Where [Word 1] and [Word 2] are the two words you wish to check the implication of. NOTE: The words must be tab-separated.


Output

There are two different forms of output that are obtainable from the software: Output in response to manual input When using manual input to view the implication of the two words, in the "Results" portion of the application window you will find the results of the implication test. The format of the results can be seen in the "Results" section below. Output in response to an input file After selecting an input file from the "Select Input and Output Files" option from the "File" menu, a window is opened that allows you to select or create a file in which to store the results. The format of the results can be seen in the "Results" section below.


Results

The output format is as follows, with each value in a column:

[Word 1][Word 2][Implication Result][Result Certainty][Implication Score][Implication Distance][Count of Conflicts][Morphological Similarity][Word 1 Subsume Word 2 Score][Word 2 Subsume Word 1 Score]

The fields and their significance are as follows:

* [Word 1] and [Word 2] are the two words you wish to check the implication of
* [Implication Result] is the result of the implication test
* [Result Certainty] is how certain the software is of the results
* [Implication Score] is the numerical score of the two words' implication test.
* [Morphological Similarity] is a rating of how morphologically similar the two words are
* [Word 1 Subsume Word 2 Score] is a score between 0 and 1 of how much word 1 morphologically subsumes word 2
* [Word 2 Subsume Word 1 Score] is a score between 0 and 1 of how much word 2 subsumes word 1


The possible values are:
* 0: The words do not imply each other
* 1: Word 1 implies word 2
* 2: Word 2 implies word 1
* 3: The words are an exact match [Implication Distance] is the distance between the two words [Count of Conflicts] is the number of conflicting diacritics between the two words


NOTE: To calculate the morphological distance, you must have the ALMOR Arabic morphological analyzer along with the SAMA database
