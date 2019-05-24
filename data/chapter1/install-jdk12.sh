#!/usr/bin/env bash
# Use `sudo chmod u+x install-jdk12.sh` to make it executable
sudo add-apt-repository ppa:linuxuprising/java -y
sudo echo oracle-java12-installer shared/accepted-oracle-license-v1-2 select true | sudo /usr/bin/debconf-set-selections
sudo apt-get update -y
sudo apt-get install oracle-java12-installer -y
sudo apt-get install oracle-java12-set-default git sqlite3 -y
echo "*********************************"
echo "*                               *"
java -version
echo "*                               *"
echo "*********************************"