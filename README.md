# Mini-Survey Monkey

<!-- TOC -->
* [Mini-Survey Monkey](#mini-survey-monkey)
  * [Overview](#overview)
  * [Authors](#authors)
  * [State of the Project](#state-of-the-project)
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
  - Login view is not yet set up, (all users have the same view, currently)
  - Logout functionality is not yet set up
- Create new survey feature:
  - Users can create a survey giving a title, and adding questions based on selected question type and content
  - Users can select from open-ended, range, and multi-choice questions to add, but treats all question types as open-ended for now
  - Survey form is dynamic, users can add and remove questions, at least one question stays on the page at all times
- Select survey / take survey
  - All surveys in the DB are retrieved and can be displayed
  - Surveys can be taken, all questions provide text areas for now
  - Answers to survey question are saved to DB upon submission
- Display results of survey
  - Displays answers submitted to each survey question of a selected survey

## Plan for next Sprint
- Login/registration feature:
  - Implement separate logged-in view for logged in surveyors
  - Implement Logout functionality
- Create new survey feature:
  - Add fields for additional inputs associated with range and multi-choice questions
  - Values should be saved appropriately in DB
- Select survey / take survey:
  - Surveys should display different fields (not just text areas) based on the type of question and addtional info saved from the create survey form (range, options)
  - Values should be saved appropriately in DB
- Display results of survey:
  - Surveys should display summarization of answers based on question type
    - for range, so sort of histogram interpretation
    - for option question so sort of piechart (or percentage) interpretation


## Database Schema as of Milestone 1
![image](https://github.com/charles-55/Mini-SurveyMonkey/assets/77470047/8e5ff22f-e72b-4987-b40d-165c8b9a3057)