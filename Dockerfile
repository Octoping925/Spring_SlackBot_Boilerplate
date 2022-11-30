FROM openjdk:17-alpine
WORKDIR /app

# Run gradle build


COPY ./build/libs/slack-app-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

# root 대신 nobody 권한으로 실행
USER nobody
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "slack-app-0.0.1-SNAPSHOT.jar"              \
]