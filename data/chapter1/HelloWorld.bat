@echo off
call kotlinc.bat HelloWorld.kt -include-runtime -d HelloWorld.jar
java -jar HelloWorld.jar
pause