# Source - https://stackoverflow.com/q/77144532
# Posted by Winter Wolf, modified by community. See post 'Timeline' for change history
# Retrieved 2026-02-20, License - CC BY-SA 4.0

FROM maven:latest

WORKDIR /planner

COPY ./src/main .
COPY pom.xml pom.xml

CMD mvn quarkus:dev