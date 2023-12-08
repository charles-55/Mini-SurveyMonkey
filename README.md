# Mini-Survey Monkey

<!-- TOC -->
* [Mini-Survey Monkey](#mini-survey-monkey)
  * [Overview](#overview)
  * [Authors](#authors)
  * [State of the Project](#state-of-the-project)
  * [Plan for next Sprint](#plan-for-next-sprint)
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
- Index page:
  - The landing page has links to the currently implemented features
  - 4 main features currently implemented are:
    - surveyor login/registration
    - create new survey
    - select survey / take survey
    - display results of survey (display the answers submitted to the survey)
- Login/registration feature:
  - Users can register on registration page and are saved to the Database
  - Only registered users can log in, if not registered, users trying to log in will be sent to error page
- Create new survey feature:
  - Users can create a survey giving a title, and adding questions based on selected question type and content
  - Users can select from open-ended, range, and multi-choice questions to add
  - Survey form is dynamic, users can add and remove questions, at least one question stays on the page at all times
- Search survey / take survey
  - All surveys in the DB are retrieved and can be displayed
  - Surveys can be taken, all questions provide text areas, number, and option question
  - Answers to survey question are saved to DB upon submission
- Display results of survey
  - Displays answers submitted to each survey question of a selected survey


## Database Schema as of Milestone 3
![image](https://github.com/charles-55/Mini-SurveyMonkey/assets/140278554/544e0e6a-e0c2-44b1-b6bd-8faecd5c5963)


## Model UML Diagram as of Milestone 3
![image](https://github.com/charles-55/Mini-SurveyMonkey/assets/140278554/6a530df0-c828-49b1-b330-61d816349fc1)


