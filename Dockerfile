FROM maven as demoBuild
COPY ./pom.xml ./pom.xml
RUN mvn clean compile
COPY ./ ./
CMD ["mvn","clean","test","-Dtestng.suite=testng.xml"]