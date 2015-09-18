# Lab 2: Chapter 9
**Due:** September 29th by 6:30 PM

## Question 1: Course Grades

In a course, a teacher can give any number of the following tests and assignments:

- A **lab activity** that is observed by the teacher and assigned points out of 50.
- A **quiz** that has 10 questions worth 1 point each.
- A **curved exam** that has 25 questions worth 2 points each. A percentage can be specified to curve the grade.
- An **essay** that is assigned points out of 100.
- A **final exam** that has 50 questions 4 points each.

Write a class named `CourseGrades`.  The class should have a `GradedActivity` ArrayList as a field named `grades`.  `CourseGrades` should have a method named `addGrade` that has one parameter of `GradedActivity`.  `CourseGrades` should override the toString method to show a list of activity names, grades, and points.

`CourseGrades` should also implement the `Analyzable` interface included in the lab code.  Read the documentation comments on each method in the interface to see what it should do.

`GradedActivity` should include at least the methods and fields in this UML:

	GradedActivity
	--------------
	-name: String
	-earnedPoints: double
	-maxPoints: double
	--------------
	+setName(String)
	+getName()
	+setEarnedPoints(double)
	+getEarnedPoints():double
	+setMaxPoints(double)
	+getMaxPoints():double
	+getPercentage():double //Calculates earned points/max points. Returns 1.0 for 100%.
	+getGrade():char //Returns A,B,C,D, or F

When the Question1 main class runs, ask the user for a csv file name.  That file will contain rows of the following format (you can assume the file is following a valid format, but validate that the file exists and exit if it does not)
	
	<Activity Type>,<Activity Name>,<Activity Values that depend on Activity Type>
	
A **lab activity** row has Activity Type of LAB and a value of a numeric score, ex.:
	
	LAB,Lab #1,45

	<Activity Type> = LAB, <Activity Name> = Lab #1, Earned Points = 45
	
A **quiz** row has Activity Type of QUIZ and a value of how many correct answers, ex.:

	QUIZ,Quiz #1,9

	<Activity Type> = QUIZ, <Activity Name> = Quiz #1, Questions correct = 9

A **curved midterm exam** row has Activity Type of CURVEDEXAM and values of how many questions correct and a curve multiplier percentage (1.0 = 100%)

	CURVEDEXAM,Midterm #1,23,1.2

	<Activity Type> = CURVEDEXAM, <Activity Name> = Midterm #1, Questions correct = 23, Curve multiplier percentage = 1.2 (120%)
	
An **essay** row has Activity Type of ESSAY and a value of a numeric score, ex.:

	ESSAY,Essay #1,95
	
	<Activity Type> = ESSAY, <Activity Name> = Essay #1, Earned Points = 95
	
A **final exam** row has Activity Type of FINAL and a value of how many correct answers, ex.:

	FINAL,Final Exam,49
	
	<Activity Type> = FINAL, <Activity Name> = Final Exam, Questions Correct = 49

Read the csv file then generate a report card: Show a list of each assignment with points earned and letter grade (`CourseGrades` toString method), the assignment with the highest grade percentage, the assignment with the lowest grade percentage, the percentage earned of total points in the course, and the letter grade earned for the course. For example:

	COURSE GRADE REPORT
	
	Lab #1              |       45 |         A
	Quiz #1             |        8 |         B
	Lab #2              |       50 |         A
	Quiz #2             |        6 |         D
	Midterm             |       55 |         A
	Quiz #3             |       10 |         A
	Lab #3              |       35 |         C
	Essay               |       99 |         A
	Final               |      190 |         A
	
	Lowest Grade: Quiz #2 (60%)
	Highest Grade: Midterm (110%)
	Course %: 94%
	Grade: A
	
**Points breakdown**

- Technical: 55 points
- Style: 15 points
- Total: 70 points

----
### How to submit the lab
This section outlines how to get the lab on to your computer and how to submit it.

1. Fork the Chapter 9 lab repository
2. Import the project into Eclipse
	1. Click File->Import...
	2. Choose Git->Projects from Git
	3. Choose "Clone URI", press Next
	4. Copy the clone URI on **your forked** github repository (bottom right)
	5. Paste the URI into the Eclipse window
	6. Set your GitHub user name and password, leave everything else as it is.
	7. Press Next
	8. Choose Master on the "Branch Selection" screen and press Next
	9. Choose a local destination directory and press Next
	10. Select "Import existing Eclipse project" (should be default choice), press Next.
	11. Press Finish and your project is imported!
	12. Right click the project in the package explorer, click Maven->Update Project... (Or press Alt+F5)
3. Do the actual lab work
	1. Read/implement the Question 1 section above
	2. Keep all existing and new classes in the edu.carroll.cis232 package.
	3. Do not rename any existing files.
4. Test your work.
	1. Run the application by pressing the Play button to test your program manually.
	2. To test your program with the built-in Unit tests: 
		1. Open the unit test class named Question1Test in the src/test/java folder.
		2. Press the Play button.
		3. The failed tests will show up as red on the left. Passed tests will show up as green.
		4. Repeat the process with Question2Test
5. Submit your work
	1. Right click the project
	2. Choose Team->Commit...
	3. Enter a comment such as "My solution for the chapter 8 lab"
	4. Enter your name/email for the author/committer fields if it is not set
	5. Press "Commit and Push". (Committing saves the changes locally, Pushing saves the changes on your GitHub fork)
	6. Your work is now on your GitHub fork.  Open up the browser to your GitHub fork of the example lab.
	7. Press the green pull request button at the top to the left of the "Branch: master" dropdown.
	8. To finally submit your lab, Click the green "Create new pull request" button, enter a title and message, and press "Create pull request".
	9. Your lab is now submitted!

**Special**: You can give "kudos" points to up to 2 people for helping you with the lab either through tutoring or by looking at their forks.  When you submit your lab, indicate up to 2 people that you would like to give points.
