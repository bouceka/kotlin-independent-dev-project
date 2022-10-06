FROM openjdk:17-alpine
COPY build/libs/registration-srv-0.1-all.jar registration-srv.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "registration-srv.jar"]
