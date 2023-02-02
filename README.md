# ConcurrentFileProcessing

This is a spring boot maven project. it processes multiple files in parallel using java concurrency threads. 

Assumptions:
- It is not validating the contents of the file as it was out of the scope of the task.
- Considering all the file are csv format
- The whole purpose of this project is to run the code to process multiple files using java concurrency. It can be improved using fork joins. 
- For sake of simplicity I have hard coded the file path and some values in the code it-self. I can improve it and use the application properties file to make it configurable. 
- Just write a few of the Unit test cases using spring boot, try to cover edge cases and handle exceptions.

Prerequisites:
- Correct the file paths before running and testing(maven test).  
