# Automation Framework
    UI Automation using Spring boot, Selenium, testNg and Docker
  
## Framework Flowchart

![image](https://user-images.githubusercontent.com/71212078/200164024-025bc498-b72d-4d19-8b46-9bd9be8299b0.png)

## Steps to run framework
    
 **Local trigger**
Prerequisite : Browser application must be installed in machine
               Compactible version downloaded and pointed correctly
               Set local flag (*application.properties*) true
Open terminal/cmd and execute below command :
***clean test -Dtestng.suite=testng.xml***

###### Execution with Docker
Prerequisite : Docker deamon is running and local flag (*application.properties*) should be set false
**1 -** Local Selenium grid execution
    Open terminal/command prompt at project location and execute `docker-compose -f docker-compose_local_grid.yml up` command

**2 -** Dockerized dynamic grid execution 
    Open terminal/ command prompt run docker-compose -f docker-compose-dynamic-grid.yml up' {Fie must exist under directory}

 ## Behind the scene

    1 - Docker image "ui_auto_img" will get created/updated (as per cached rule)
   ![image](https://user-images.githubusercontent.com/71212078/200178341-566bb9c2-ff13-4a54-b8e5-da86bc1f0168.png)
   
    2 - Docker compose file will create "ui_test" network
   ![image](https://user-images.githubusercontent.com/71212078/200178518-65f65422-984c-44da-bbad-7c5c93a5674f.png)
   
    3 - As per demand test container will get created and as video recording is enabled it's separate one on one mapped container get up
   ![image](https://user-images.githubusercontent.com/71212078/200178621-d2f06fb1-6a7e-4f95-8fe2-95cc7d4c77cc.png)
   
    4 - Post execution test and video containers will get removed 
   ![image](https://user-images.githubusercontent.com/71212078/200178668-185c6211-fd42-41d2-b83f-3150b84b6376.png)
  

    5 - Video recording get transfered to configured local machine path
   ![image](https://user-images.githubusercontent.com/71212078/200178766-72b628a1-5efd-45f7-9196-57492b283441.png)
   
   https://user-images.githubusercontent.com/71212078/200190501-43768f4e-501b-4148-bf67-ee98b62d6ab6.mp4
   
   
    6 - Bring down network using Ctrl+C, and then `docker-compose -f docker-compose-dynamic-grid.yml down`
