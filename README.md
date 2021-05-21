# Demonstrating Software Quality

## Sprint Backlog and Task Estimation
![alt text](https://i.ibb.co/4835g7Z/Screenshot-2021-05-20-at-16-48-06.png "Sprint Backlog")

The story point estimations for the tasks in the above sprint have been made by means of planning poker. Planning poker is an effective method of task estimation that allows all team members to voice their opinion on a task and how long it should take to complete. The SCRUM master hands all members cards with story point values and they are asked to reveal how many points the task in question requires. This will result in a range of values which will lead to a discussion that will allow members to see from the perspective of others and realise areas that may take more or less time than expected. The value that a team then agrees on as a whole is assigned to the task that has now been openly and thoroughly discussed. 

As it can be seen from the above backlog, the project initialisation and set up of the systems object hierarchy will consist of a lot of effort required in design and environment set up, resulting in a group consensus of 3 story points. This being compared to task number 5, which involves implementing the ability to view student grades, shows that due to task 5 relying on the project that is already in place, it can be completed in a much shorter time and thus planning poker has resulted in an agreed assignment of 1 story point. Retrieving the student grades that are already existent in the data collection will be a rather quick task to implement and test and this has been reflected in the sprint backlog accordingly.

The tasks have been prioritised using the MoSCoW rules which refer to must have, should have, could have and won’t have features. Must have features are part of the core functionality and are vital in the system. Should have features are not part of the core functionality but are important to the system and should still be completed. Could have features would not affect core functionality if they were not implemented and won’t have features will be developed in a later sprint.

In order to effectively estimate how much work the your team is capable of completing in a sprint, you can calculate the work completed in past sprints and use this knowledge to more accurately estimate the teams work capacity for future sprints. This measurement is known as sprint velocity and is calculated by calculating the average story points completed in past sprints. If your team has completed 12, 14 and 10 story points in the last three completed sprints, you would know your team has an average sprint velocity of 12. This number will allow SCRUM masters to plan sprints and their involved tasks more accurately without placing unrealistic work expectancies on team members.

## Unit Testing and Test Driven Development

Test driven development inloves breaking software components up into test cases which must be satisfied in order to enable the code to work as intended and ideally help prevent defects.

When implementing our approach to test driven development, we adopt unit tests developed alongside each software component. Sofware components are small pieces of code produced to execute a single task and unit testing focuses on making sure these components operate as intended. It is implied that we should consider designing unit tests before the components themselves as it provides a guideline on exactly what the component is trying to achieve.

[In the linked commit](https://github.com/conallh96/SoftwareQualityDemonstrated/commit/ae674faf643509e4c192a44ad3bb12fb335ac4f5) we can see a clear adoption of our test driven approach with unit testing through JUnit testing. Grading rubrics in the sample project must be added to the system collection and may not have more than 10 criteria against which students can be marked. The tests designed ensure that Rubrics can be created with up to 10 criteria allowed per rubric. The code to support these tests is also provided and once all test cases have passed, developers can be satisfied with the functionality their component has achieved.

This approach to unit testing and test driven development greatly improves the quality of the code in our projects and significanly decreases project times and costs due to reduced error fixing and debugging.

## Test Coverage Metric 

In order to ensure unit testing has covered a satisfactory proportion of the code being written, a test coverage tool must be used. The test coverage metric allows developers to understand how much of the code has been included in unit tests and in turn, implemented to be confirmed fit for purpose.

For software project in our organisation, we implement the use of EclEmma, Eclipse's plug-in which is integrated to check the coverage of code in a project by JUnit tests. The tool will return a score out of 100 for coverage as well as highlighting areas in the project which are yet to be tested by JUnit. 


![alt text](https://i.ibb.co/fXt1XYP/Screenshot-2021-05-20-at-20-48-38.png "Coverage Before Code Tested")

As seen from above, EclEmma tells use we have a code coverage statistic of 88.6%, a level which can be increased through more thorough JUnit tests covering more paths within the project. 

![alt text](https://i.ibb.co/VvBTL0N/Screenshot-2021-05-20-at-20-48-55.png "Code Not Yet Covered")

The above screenshot shows us EclEmma highlighting that the method for retrieving the average score from a rubric has not yet been covered by unit tests.

![alt text](https://i.ibb.co/SJXJGrW/Screenshot-2021-05-20-at-20-49-18.png "New Test Added")

In the test class, a new test is produced to ensure that the expected number for rubric average is returned based off hardcoded parameters initialised in the test class.

![alt text](https://i.ibb.co/j8scRVp/Screenshot-2021-05-20-at-20-49-46.png "Coverage After Code Tested")

When requesting a new test coverage score, EclEmma now indicates that 98.4% of the ode in the active project has been covered. 

![alt text](https://i.ibb.co/NLcjWtH/Screenshot-2021-05-20-at-20-49-55.png "Code Covered")

EclEmma also recognises and indicates to the developer that the method for returning a rubric's average grade has been covered by JUnit tests successfully.

## Team Version Control

When working on team projects, developers will work mainly on feature branches which are based from the develop branch. The develop branch is based off the master branch which is the final point of a how a project stands in completion. 

While developing new functionality, a developer will create a feature branch from the develop branch and implement new code seperately without affecting that of the others. Once a component has been completed, the developer can submit a [pull request](https://github.com/conallh96/SoftwareQualityDemonstrated/pull/3) to merge their quality code with the working code of others on the develop branch. 

When substantial and satisfactory progress has been acheived on the develop branch, this can be merged with the master branch by means of pull request of a release branch. The master branch is deployable and should be a functioning piece of software.

![alt text](https://i.ibb.co/n600gtP/Screenshot-2021-05-21-at-11-45-04.png "Project Branches")

From the above breakdown of the project's branches, we can see the develop branch set as the default branch to base feature branches on. The develop branch is up to date and all feature branches have been merged into it successfully. The master branch here is yet to receive a pull request for the merging of a release branch and is not yet up to date with project progress.

## Code Reviews 

When a team member submits a pull request in the project repository, a code reviewer should always check the code in question in order to ensure it is up to company standard and fit for purpose. Effective code reviewing improves the quality of a team’s code substantially as well as improving the skills of developers through open dialogue and constant feedback from reviewers. The checks a reviewer should make during pull requests are the following. 

1.	Readability: Is the code easily read and understood?
2.	Testing: Has the code produced been affectively and appropriately tested?
3.	Test Coverage: Is a satisfactory amount of the merged code covered by these relevant tests?
4.	Duplication: Has any Code in the request been duplicated?
5.	Complexity: Is the code being submitted to verbose or too long is it using most efficient solutions?
6.	Reliability: Would the code being merged work just as efficiently with large loads? Is the code written with the possibility of it being reused for similar applications?


[In the linked pull request](https://github.com/conallh96/SoftwareQualityDemonstrated/pull/3), the code reviewer has given the developer valuable feedback on their submitted code through use of the checklist, and would have found any shortcomings present should there have been any. Relevant testing has been ackowledged as well as sufficient code coverage of efficiently written solutions.

Code Reviews allow for the monitoring and ensuring of consistent, quality code throughot the devlopment stage for teams in our organisation through constant and incremental review such as the example provided.