FROM openjdk
#EXPOSE 8084
COPY ./ ./
ADD target/spring-boot-docker-ec2.jar spring-boot-docker-ec2.jar
CMD [ "java","-jar","/spring-boot-docker-ec2.jar"]
