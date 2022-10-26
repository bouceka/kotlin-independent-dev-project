FROM openjdk:17-alpine
COPY build/libs/team-srv-0.1-all.jar team-srv.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "team-srv.jar"]
