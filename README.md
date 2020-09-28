# automation-practice
End-to-end test automation project using `Java`, `Selenium` and `TestNG`.

Test case: Purchase a random product with random quantity, size and color successfully as a new user, creating a random new account.

# Additional libraries
Besides `Selenium` and `TestNG`, this project also uses additional libraries, such as:
* `JavaFaker`: to generate random data
* `WebDriverManager`: to access browser's driver
* `ExtentReports`: to generate the test evidence in an elegant and user friendly way as an HTML file

# Requirements
* Java 8 installed

# Running the tests
Tests can be run using the following commands:
```bash
set classpath=<path where you saved the project>\automation-practice\target\test-classes;<path where you saved the project>\automation-practice\target\dependency\*
```
```bash
java org.testng.TestNG <path where you saved the project>\automation-practice\testng.xml 
```
This command will run the tests and generate the HTML file with the test evidences using `ExtentReports`.

# Test results
After the execution, you will be able to find the HTML file of the generated report inside the `reports` folder.
