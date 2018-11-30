## Running the tests

1. To run the tests from the console on specific browser use:

mvn test -Dbrowser=*browserString*

Replace *browserString* with:

- firefox
- chrome
- safari
- IE

 If no browser has been specified, default Firefox will be used.

2. To set timeout for DriverWait other that default use:

mvn test -Dtimeout=*timeoutInSec*

 If no timeout has been specified, default 3 sec will be used.



