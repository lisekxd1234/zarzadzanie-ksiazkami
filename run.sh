#!/bin/bash

mkdir -p bin
javac -d bin src/*.java

if [ $? -eq 0 ]; then
  java -cp bin Main
fi