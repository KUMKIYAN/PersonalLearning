# PersonalLearning


SELENIUM - DOCKER INTEGRATION
______________________________________

docker pull selenium/hub
docker pull selenium/node-firefox
docker pull selenium/node-chrome
docker run -d -p 4444:4444 --name selenium-hub selenium/hub
http://localhost:4444/
docker run -d --link selenium-hub:hub selenium/node-chrome
docker run -d --link selenium-hub:hub selenium/node-firefox
http://localhost:4444/grid/console

alternatively we can use the step below is the docker-compose.yml file.
goto the file folder and run "docker-compose up -d"

version: "3.1"
services:
    selenium-hub:
    image: selenium/hub
    ports:
        - "4444:4444"
    environment:
        GRID_MAX_SESSION: 10
    #selenium-chrome
    selenium-chrome:
    image: selenium/node-chrome
    depends_on:
        - hub
     environment:
        HUB_HOST: hub
        NODE_MAX_INSTANCES: 3
        NODE_MAX_SESSION: 3
     #selenium-firefox
     selenium-firefox:
     image: selenium/node-firefox
     depends_on:
        - hub
     environment:
        HUB_HOST: hub
        NODE_MAX_INSTANCES: 3
        NODE_MAX_SESSION: 3
        
To down docker compose use below commands
docker-compose down
docker-compose stop

docker-compose scale selenium-chrome=3 selenium-firefox=3. (to create more nodes)
(to create more sessions in a node)
