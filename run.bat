@echo off

mkdir bin
javac -d bin src\*.java

if %errorlevel% equ 0 (
  java -cp bin Main
)
