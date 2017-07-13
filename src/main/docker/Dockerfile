FROM centos:latest
MAINTAINER zlikun "zlikun-dev@hotmail.com"
ENV REFRESHED_AT 2017-7-13
ENV JAVA_HOME /usr/local/jdk1.8.0_112
ENV PATH $JAVA_HOME/bin:$PATH
ENV CLASSPATH .:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ADD /home/zlikun/studio/docker/simple/jdk-8u112-linux-x64.tar.gz /usr/local
ADD zlikun-docker-simple-1.0.0.jar /simple.jar
EXPOSE 80
ENTRYPOINT ["java" ,"-jar" ,"/simple.jar" ,"--spring.profiles.active=pro"]