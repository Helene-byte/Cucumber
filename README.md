# Cucumber

Let's verify that the word "рыба" correctly appears in the first paragraph ("Что такое Lorem Ipsum?"):

Go to https://lipsum.com/

Switch to Russian language using one of the links
Verify that the text of the first  element, which is the first paragraph, contains the word «рыба».


Let's verify that default setting result in text starting with Lorem ipsum:

Go to https://lipsum.com/

Press “Generate Lorem Ipsum”
Verify that the first paragraph starts with "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
Let's verify that Lorem Ipsum is generated with correct size:

Go to https://www.lipsum.com/

Click on "words"
Input 10 into the number field
Press “Generate Lorem Ipsum”
Verify the result has 10 words
Verify correct generation for -1, 0, 5, 20 words
Create the same test for characters (bytes). Verify 3-4 values.

Let's verify the checkbox:

Go to https://www.lipsum.com/

Uncheck "start with Lorem Ipsum" checkbox
Press “Generate Lorem Ipsum”
Verify that result no longer starts with Lorem ipsum

Let's also check that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%:

Go to https://www.lipsum.com/

Press “Generate Lorem Ipsum”
Get text from each paragraph and determine the number of paragraphs containing the word “lorem”.
Run the generation 10 times and get the average number of paragraphs containing the word “lorem”.
Fail the test if the value is less than 2 (the actual value seems to be between 2 and 3, so use 3 to check that your test can actually fail).
