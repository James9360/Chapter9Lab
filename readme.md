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
	


