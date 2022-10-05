FROM openjdk:17-alpine
COPY build/libs/player-srv-*-all.jar player-srv-*.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "player-srv-0.1.jar"]
