# ParkingLot

  - Project Requirements
  - How to Run
  - Assumptions
  - Measures for a Project Setup Failure
  - Contact

### Project Requirements

  - Java Openjdk version 1.8 (tested with 1.8.0_222 may work with other version too).
  - Ant (1.10) (tested on 1.10.5 may work with other versions too).
  - The project unit testing is done using Junit 4.12 (No additional jar needed as it's already included in bin/parkingLot/lib).
  - Linux (tested with xubuntu 19.04)


### How To Run
- execute $bin/setup in the bin directory of project root inorder to install dependencies ,run unit test and create a executable jar file.
- execute $bin/run_functional_tests in the bin directory of project root to run the functional suite
- execute $bin/parking_lot in the bin directory of project root to run the code in interactive mode
- execute $bin/parking_lot file_input.txt in the bin directory of project root to take input from file.

### Assumptions
- There will only be one parking Lot further attempts to create parking lot is not allowed.
- All the Vehicle must have unique Registration Number.
- The input commands must follow the datatypes (e.g [create_parking_lot Q] not supported).
- The project currently assumes that all cars will be parked at same level.
- The input commands must not have any trailing blankspaces.

### Measures for Project Setup Failure
- May be the project is compiled with an higher version of java (e.g 1.9) please change it to 1.8 or compile it with lower verision of java
- May be the project is using diffrent Ant version other tham specified above
- if the linux enviroment is other tham ubuntu than ant build may fail due to Junit compatibility and you have to manually make it compatible. 

### Contact
- If the Setup still fails please contact me at aashirwad3may@gmail.com or skype:goldie3may@gmail.com
