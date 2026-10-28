# Fitness & Gym Planner — MAD Assignment 2

## Overview
A Java + XML Android application demonstrating common application screens and local simulated authentication.

## Implemented screens
- Welcome screen: app name/logo and navigation to Login/Register.
- Login: email, password, input validation, demo credentials, Register and Forgot Password links.
- Register: name, email, password and confirm password validation.
- Forgot Password: validates an email and simulates local recovery.
- Reset Password: validates and saves a new password locally.
- Dashboard: displays feature modules in a GridLayout.
- Profile: displays the signed-in user's information and supports Logout.

## Navigation flow
Welcome → Login ↔ Register  
Login → Forgot Password → Reset Password → Login  
Login → Dashboard → Profile → Logout → Login

## Demo login
- Email: `demo@example.com`
- Password: `123456`

You can also register a new local account. No backend or real email is used. Data is stored locally with SharedPreferences for demonstration purposes.

## Technical requirements demonstrated
- Java and XML layouts.
- LinearLayout, GridLayout, and ConstraintLayout.
- Strings resource and day/night color resources.
- Email/password input types and field validation.
- Button click listeners and explicit Intents.
- SharedPreferences for simulated local authentication.

## Setup
Create an Android Studio **Empty Views Activity** project using Java and package `com.example.fitnessgymplanner`. Copy this starter's `app/src/main/` folder into the new project's `app/src/main/` folder. Add the following dependency to the app module Gradle file and sync:

Groovy:
`implementation 'androidx.constraintlayout:constraintlayout:2.2.1'`

Kotlin DSL:
`implementation("androidx.constraintlayout:constraintlayout:2.2.1")`

Run on an emulator or Android phone.

## Limitations
Authentication and password recovery are simulated locally and are not secure enough for a production app. Password recovery does not send an actual email. Dashboard modules currently show a demo message; this assignment focuses on the required common screens and navigation.
