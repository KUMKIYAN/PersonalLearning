# PersonalLearning


SELENIUM - DOCKER INTEGRATION
______________________________________

docker pull selenium/hub <br>
docker pull selenium/node-firefox <br>
docker pull selenium/node-chrome <br>
docker run -d -p 4444:4444 --name selenium-hub selenium/hub <br>
http://localhost:4444/ <br>
docker run -d --link selenium-hub:hub selenium/node-chrome <br>
docker run -d --link selenium-hub:hub selenium/node-firefox <br>
http://localhost:4444/grid/console <br>

alternatively we can use the step below is the docker-compose.yml file. <br>
goto the file folder and run "docker-compose up -d" <br>

version: "3.1" <br>
services: <br>
    selenium-hub: <br>
    image: selenium/hub <br>
    ports: <br>
        - "4444:4444" <br>
    environment: <br>
        GRID_MAX_SESSION: 10 <br>
    #selenium-chrome <br>
    selenium-chrome: <br>
    image: selenium/node-chrome <br>
    depends_on: <br>
        - hub <br>
     environment: <br>
        HUB_HOST: hub <br>
        NODE_MAX_INSTANCES: 3 <br>
        NODE_MAX_SESSION: 3 <br>
     #selenium-firefox <br>
     selenium-firefox: <br>
     image: selenium/node-firefox <br>
     depends_on: <br>
        - hub <br>
     environment: <br>
        HUB_HOST: hub <br>
        NODE_MAX_INSTANCES: 3 <br>
        NODE_MAX_SESSION: 3 <br>
        
To down docker compose use below commands <br>
docker-compose down <br>
docker-compose stop <br>

docker-compose scale selenium-chrome=3 selenium-firefox=3. (to create more nodes) <br>
(to create more sessions in a node) <br>
