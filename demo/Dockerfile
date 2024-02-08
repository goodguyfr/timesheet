FROM ibm-semeru-runtimes:open-21-jre-focal
MAINTAINER https://renanfranca.github.io/about.html
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENV _JAVA_OPTIONS="-XX:MaxRAM=70m"
CMD java $_JAVA_OPTIONS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar demo-0.0.1-SNAPSHOT.jar