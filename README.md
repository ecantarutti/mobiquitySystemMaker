# computerDataBase Project

# Test Suite

This tests are written in Java using two libraries, 'Selenium' for the UI, and 'RestAssured' for the Tear Down process.
The selected framework was Jbehave, due to is an easy way for the tester to administrate the Test Cases, and it gives a quick feedback through the reports of the causes of the failures.
Also, The 'BDD' ('Behave Driven Development') approach, gives a cleaner and faster look to all of the stakeholders who want to understand quickly how the developed feature works.

Please notice that the file 'test_cases.xlsx' is located in the main folder.

### Manual Test Cases

Within the root you will find the file 'test_cases.xlsx' that holds all of the test cases for this application.
Please also notice that the first tab, has a summary of the test cases, with the pass/fail ratio.
On the second that, the Test Cases are properly described with its respective execution status.

### Jbehave Suite

The Jbehave Test Suite executes 10 (ten) tests to verify the behaviour of the Computer DataBase website (http://computer-database.herokuapp.com/).

## Test Suite

The suite has ten different test cases:

- CreateAndDeleteComputer_ComputerDB: This test creates a new entry with all the parameters, saves it, re opens it and then deletes it;
- CreateAndUpdateComputer_ComputerDB: This test creates a new entry with all the parameters, saves it, re opens it and then updates it;
- CreateNewComputer_ComputerDB: This test creates a new entry with all the parameters, saves it, re opens it and then verifies that it was properly saved;
- CreateNewComputerWithCyrillicChars_ComputerDB: This test creates a new entry with all the parameters but using cyrillic characters on the name, saves it and verifies that it was properly saved;
- VerifyCancelFeatureWithinCreation_ComputerDB: This test creates a new entry with all the parameters, and then presses cancel and verifies that it wasn't created;
- VerifyCorrectDateFormat_ComputerDB: This test verifies that the date field only accepts the format 'yyyy-MM-dd';
- VerifyErrorOnEmptyCompName: This test verifies that no computer can be saved with an empty name;
- VerifyPagination_ComputerDB: This test verifies that the application allows browsing between different pages;
- CreateNewComputerWithoutDates_ComputerDB: The purpose of this test case is to verify that the date fields aren't mandatory;
- CreateAPreviouslyDeletedComputer_ComputerDB: This test creates a new entry with all the parameters, saves it, re opens it and then deletes it and then creates the same entry once again.


Each of this tests, except the one named 'CreateAndDeleteComputer_ComputerDB' and the ones that don't save a new entry, have their own personal Tear Down process. The Tear Down is executed by sending a 'POST' request the URL of the created entry adding '/delete' at the end of it.

### Maven Project

This is a maven project, so the test suite can be executed through command line. All you need to execute is:
```
    $mvn integration-test
```
and this will run the tests.

### Jbehave Tests

If you prefer to execute one test at a time, the command that you should execute is 
```
    $mvn test -Dtest='name of the test.
```
You can execute more than one, separated by comma ','.

If you decide to import the whole maven project to an IDE (Eclipse, for instance), all you have to do, is to run the classes that are in the package 'mapper' as jUnit, and the test will start automatically.

### Structure
#### Story Files
All the story files are placed under 'src\main\resources\stories'.
Each story file, holds a particular test case, following the structure 'Given', 'When', 'Then'.
The story files, are simply plain text files that describe the actual test.
#### Steps classes
The Steps are written in Java, and this classes are located in: 'src\main\java\steps'.
Each and every method, matches with the action phrases (sentences) described in the different story files.
#### Mapper files
The java classes that map the story files with the steps, are placed in: 'src\main\java\mapper'.
These classes, call the '.story' file, reads it, and look for the steps in the defined steps classes.

## Preconditions

The only requirements that you need to run this tests are:
- Maven;
- Java;
- Google Chrome.

