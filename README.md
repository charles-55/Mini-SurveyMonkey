# Mini-Survey Monkey

<!-- TOC -->
* [Mini-Survey Monkey](#mini-survey-monkey)
  * [Overview](#overview)
  * [Authors](#authors)
  * [State of the Project](#state-of-the-project)
  * [Database Schema as of Milestone 1](#database-schema-as-of-milestone-1)
  * [Model UML Diagram as of Milestone 1](#model-uml-diagram-as-of-milestone-1)
<!-- TOC -->

## Overview
A mini-survey monkey web application that allows a surveyor to create a survey with a list of questions. Questions can be open-ended (text), asking for a number within a range, or asking to choose among many options. Users fill out a survey that is a form generated based on the type of questions in the survey. Surveyor can close the survey whenever they want (thus not letting in new users to fill out the survey), and at that point a survey result is generated, compiling the answers: for open-ended questions, the answers are just listed as-is, for number questions a histogram of the answers is generated, for choice questions a pie chart is generated.

## Authors
1. Osamudiamen Nwoko
2. Osas Iyamu
3. Ese Iyamu
4. Leslie Ejeh
5. Toyin Adams

## State of the Project
- Our Mini-Survey application includes 4 main features:
  - Login/registration feature
  - Create new survey feature
  - Searching for surveys feature
  - Taking surveys feature
  - Displaying survey results feature 
- Index page:
  - The initial landing page has 3 links to login, register, or find a survey while a user is not logged in.
- Login/registration feature:
  - Users can register on the registration page, are saved to the DB, and are automatically logged in
  - Already registered users can log in
  - The application implements user authentication by checking that users attempted to log in are registered with the correct username and password in the DB
- Create new survey feature:
  - Logged in users can create a survey giving a title, and adding questions based on selected question type and content
  - They can select from open-ended, range, and multi-choice questions to add
  - Survey form is dynamic, users can add and remove questions, at least one question stays on the page at all times
- Search survey / take survey
  - All surveys in the DB are retrieved and displayed for any users to search for
  - Surveys are listed and shown as either open or locked, locked survey can not be accessed by users
  - Answers to open survey questions are saved to DB upon submission
- Display results of survey
  - A summary of the results of a survey can be viewed and are displayed as a list of the questions for open-ended questions, a histogram for range questions, and a pie chart for option questions


## Database Schema as of Milestone 3
![image](https://github.com/charles-55/Mini-SurveyMonkey/assets/140278554/544e0e6a-e0c2-44b1-b6bd-8faecd5c5963)


## Model UML Diagram as of Milestone 3
![image](https://github.com/charles-55/Mini-SurveyMonkey/assets/140278554/6a530df0-c828-49b1-b330-61d816349fc1)


