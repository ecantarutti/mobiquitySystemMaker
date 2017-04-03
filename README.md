# SystemMaker Project

# Test Suite

This tests are written in Java using 'Selenium' to automate the UI.
The selected framework was Jbehave, due to is an easy way for the tester to administrate the Test Cases, and it gives a quick feedback through the reports of the causes of the failures.
Also, The 'BDD' ('Behave Driven Development') approach, gives a cleaner and faster look to all of the stakeholders who want to understand quickly how the developed feature works.

Please notice that the file 'test_cases.xlsx' is located in the main folder.

### Manual Test Cases

Within the root you will find the file 'test_cases.xlsx' that holds all of the test cases for this application.
Please also notice that the first tab, has a summary of the test cases, with the pass/fail ratio.
On the second that, the Test Cases are properly described with its respective execution status.

### Jbehave Suite

The Jbehave Test Suite executes 7 (seven) tests to verify the behaviour of the Mobiquity's System Maker website (http://systemaker.com/angulardemo).

## Test Suite

The suite has ten different test cases:

- LoginAndAddAnEntry: This test creates a new entry with all the parameters, saves it,and then searches for it;
- LoginAndEditAnEntry: This test creates a new entry with all the parameters, saves it, re opens it and then updates it;
- LoginAndDeleteAnEntry: This test creates a new entry with all the parameters, saves it, re opens it and then deletes it;
- LoginAndAddAnEntryWithCyrillicChar: This test creates a new entry with all the parameters but using cyrillic characters on the name, saves it and verifies that it was properly saved;
- LoginAndDenyTheDeletion: This test creates a new entry with all the parameters, presses 'delete' but cancels when the 'are you sure?' pop up appears.
- AddingNewEntryWithoutLogin: This test verifies that unauthorized user cannot create a new entry;
- ChangingMainLanguage: This test verifies that the user can change the language to French;

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
You can execute more than one test case separated by comma ','.

If you decide to import the whole maven project to an IDE (Eclipse, for instance), all you have to do, is to run the classes that are in the package 'mapper' as jUnit, and the test will start automatically.

### Structure
#### Story Files
All the story files are placed under 'src\main\resources\stories'.
Each story file holds a particular test case, following the structure 'Given', 'When', 'Then'.
The story files are simply plain text files that describe the actual test.
#### Steps classes
The Steps are written in Java, and this classes are located in: 'src\main\java\steps'.
Each and every method matches with the action phrases (sentences) described in the different story files.
#### Mapper files
The java classes that map the story files with the steps, are placed in: 'src\main\java\mapper'.
These classes call the '.story' file, reads it, and look for the steps in the defined steps classes.

## Preconditions

The only tools that you need to run these tests are:
- Maven;
- Java;
- Google Chrome.

