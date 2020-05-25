# DateParserAutomation
Date field verification

This project is done using Java with selenium. In this project, page factory and page object model structure had used. 

For reporting, extent report has used and in case of test failure, screenshot is captured for that page. 

This project is based on hybrid framework from where keyword driven and TDD has used. Input test data is called from excel file.

How to run project:
1. Download project or Clone it from GitHub.
2. Open it in Eclipse by selecting existing maven project.
3. Do right click on project> Maven> Update Project.
4. Do right click on project> Show in> Terminal.
5. Enter "mvn compile" in that terminal to compile maven.
6. Enter "mvn test" command to run project or do right click on pom.xml file and click on Run as Maven test.

Open Test Execution Report:
1. Once project is executed successfully, "Reports" folder is generated with index.html file.
2. Do right click on that file and click on open with> web browser to see report within eclips.
3. Copy report path and open it in Chrome/FireFox to see that report in browser.

Add Test Data:
1. Open src\test\resources\excel\testdata.xlsx file.
2. Add date format and date inside that file.






