Deskripsi projek: tugas 20 module 22 (Github Actions for API and WEB UI Automation Testing)

Kerangka uji: UI WEB menggunakan Cucumber. Java, Gradle dan Selenium

Task:
-create API and WEB UI Automation project
-push to Github
-create new workflow file .github/workflows/main.yml
-create Github Action configurations
    1. Events: push and pull request
    2. Jobs:
        Step 1: download repo
        Step 2: setup java
        Step 3: install browser
        Step 4: setup gradle
        Step 5: execute gradle command for running API test and WEB UI test
        Step 6: archieve test result
        Step 7: deploy to Github Pages

Cara run project
running command at local terminal: 
for API test: ./gradlew apiAutoTest
for WEB UI test: ./gradlew webUIAutoTest