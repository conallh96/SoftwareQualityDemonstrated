# Demonstrating Software Quality

## Sprint Backlog and Task Estimation
![alt text](https://i.ibb.co/4835g7Z/Screenshot-2021-05-20-at-16-48-06.png "Sprint Backlog")

The story point estimations for the tasks in the above sprint have been made by means of planning poker. Planning poker is an effective method of task estimation that allows all team members to voice their opinion on a task and how long it should take to complete. The SCRUM master hands all members cards with story point values and they are asked to reveal how many points the task in question requires. This will result in a range of values which will lead to a discussion that will allow members to see from the perspective of others and realise areas that may take more or less time than expected. The value that a team then agrees on as a whole is assigned to the task that has now been openly and thoroughly discussed. 

As it can be seen from the above backlog, the project initialisation and set up of the systems object hierarchy will consist of a lot of effort required in design and environment set up, resulting in a group consensus of 3 story points. This being compared to task number 5, which involves implementing the ability to view student grades, shows that due to task 5 relying on the project that is already in place, it can be completed in a much shorter time and thus planning poker has resulted in an agreed assignment of 1 story point. Retrieving the student grades that are already existent in the data collection will be a rather quick task to implement and test and this has been reflected in the sprint backlog accordingly.

The tasks have been prioritised using the MoSCoW rules which refer to must have, should have, could have and won’t have features. Must have features are part of the core functionality and are vital in the system. Should have features are not part of the core functionality but are important to the system and should still be completed. Could have features would not affect core functionality if they were not implemented and won’t have features will be developed in a later sprint.

In order to effectively estimate how much work the your team is capable of completing in a sprint, you can calculate the work completed in past sprints and use this knowledge to more accurately estimate the teams work capacity for future sprints. This measurement is known as sprint velocity and is calculated by calculating the average story points completed in past sprints. If your team has completed 12, 14 and 10 story points in the last three completed sprints, you would know your team has an average sprint velocity of 12. This number will allow SCRUM masters to plan sprints and their involved tasks more accurately without placing unrealistic work expectancies on team members.

## Code Reviews 

When a team member submits a pull request in the project repo, a code reviewer should always check the code in question in order to ensure it is up to company standard and fit for purpose. Effective code reviewing improves the quality of a team’s code substantially as well as improving the skills of developers through open dialogue and constant feedback from reviewers. The checks a reviewer should make during pull requests are the following. 

1.	Readability: Is the code easily read and understood?
2.	Testing: Has the code produced been affectively and appropriately tested?
3.	Test Coverage: Is a satisfactory amount of the merged code covered by these relevant tests?
4.	Duplication: Has any Code in the request been duplicated?
5.	Complexity: Is the code being submitted to verbose or too long is it using most efficient solutions?
6.	Reliability: Would the code being merged work just as efficiently with large loads? Is the code written with the possibility of it being reused for similar applications?