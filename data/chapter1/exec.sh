#!/usr/bin/env bash
cd ../../
mvn clean package -Dmaven.test.skip=true
java -cp target/master-java-tutorial-1.0-SNAPSHOT.jar chapter1.OnceAnywhere