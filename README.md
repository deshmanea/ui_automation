# Automation Framework
    UI Automation using Spring boot, Selenium, testNg and Docker
  
## Framework Flowchart

![image](https://user-images.githubusercontent.com/71212078/200164024-025bc498-b72d-4d19-8b46-9bd9be8299b0.png)

## Steps to run framework
    Preriquisite : Docker deamon is running 

    1 - Local Selenium grid execution
        Open terminal/command prompt at project location and execute `docker-compose -f docker-compose_local_grid.yml up` command

    2 - Dockerized dynamic grid execution 
        a - Open terminal/ command prompt run 'docker build -t ui_auto_img .' {DockerFie must exist under directory}
        b - 