# Setup1

1. Rename FX-Template folder
2. Change database Name, username and password in hibernate.cfg.xml

## What to do if Application crashes

### Unable to locate persister 
Solution: Add Model to hibernate.cfg.xml

### Module xxx not found
Solution: Add Module to module-info.java

### App does not open after running the EXE
Make sure that SQL server is running on port 3306

## Steps to run produced EXE

1. Install JDK 21 
2. Add the JDK folder to system PATH
3. Add the JDK folder as a system environment variable JAVA_HOME
4. Run the EXE