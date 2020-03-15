@echo off
javadoc -encoding UTF-8 -d target\html -sourcepath src\main\java chapter1 chapter2 chapter3 chapter4 chapter5
start target\html\index.html
