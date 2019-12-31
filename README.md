This project contains two folders `local-dashboard` contains a react front end and `local-dashboard-backend` contains a spring boot backend.

## General Function

The purpose of this project is to display docker application status (running/not running) and the individual containers status (running/not running).

To use start the backend and then the frontend in development mode (refer to their folder's documentation). 

You will see the status of your docker containers in a pane in the center of the application UI. This status is supplied by a backend call to the locally running java process. 

## Refresh Button

Example usage: If you have five containers and remove one using `docker rm <container_name>` clicking the refresh button would reduce the list of containers by one.