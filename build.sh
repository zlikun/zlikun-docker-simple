#!/bin/bash

# running dependency container
docker run -d --net=app --name redis docker.io/redis

# running container
docker run -d -p 80:80 --net=app --name simple zlikun/simple