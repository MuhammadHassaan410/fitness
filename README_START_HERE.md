# Assignment 2 — Android Java + XML Starter

This starter contains the Java and XML source files for a Fitness & Gym Planner themed app demonstrating the required common screens.

## Create the Android Studio project
1. Open Android Studio → **New Project**.
2. Select **Empty Views Activity** (not the Compose template).
3. Name: `FitnessGymPlanner`
4. Package name: `com.example.fitnessgymplanner`
5. Language: **Java**
6. Minimum SDK: API 23 or above.
7. Finish and wait for Gradle sync.
8. Close the project before copying, or keep Android Studio open and copy the files into the matching locations.
9. Copy the `app/src/main/` folder from this starter into your project's `app/src/main/` folder, replacing matching files when asked.
10. In `app/build.gradle` (Module: app), add this dependency inside `dependencies`:
   `implementation 'androidx.constraintlayout:constraintlayout:2.2.1'`
11. Sync Gradle, then Run ▶.

If your project uses `build.gradle.kts`, add:
`implementation("androidx.constraintlayout:constraintlayout:2.2.1")`

## Demo login
- Email: `demo@example.com`
- Password: `123456`

You can also register a new account locally. Registration/password recovery are simulated using SharedPreferences; there is no backend or real email sending.

## Screens included
- Welcome / Main
- Login
- Register
- Forgot Password
- Reset Password
- Dashboard (modules grid)
- Profile / Logout

## Required technical points demonstrated
- Java + XML
- `LinearLayout`, `GridLayout`, and `ConstraintLayout`
- `strings.xml`, default colors, and night-mode colors
- Input types for email and passwords
- Button click handlers and validation
- Explicit Intents between Activities
- Local simulated authentication using SharedPreferences

## Before submission
- Run the app and test every screen.
- Take screenshots of the running app screens.
- Take screenshots of the Java/XML code in Android Studio.
- Push the full Android Studio project to GitHub.
- Put the screenshots and repository URL into your instructor's required-length submission document.
