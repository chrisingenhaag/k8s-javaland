FROM openjdk:11-jre-slim

RUN useradd -s /bin/false --no-log-init -u 1001 appuser
RUN mkdir -p /app && \
    chown -R appuser:appuser /app

COPY --chown=appuser:appuser build/dependency/BOOT-INF/lib /app/lib
COPY --chown=appuser:appuser build/dependency/META-INF /app/META-INF
COPY --chown=appuser:appuser build/dependency/BOOT-INF/classes /app

USER 1001

EXPOSE 8080
ENV JAVA_OPTS="-XX:MaxRAMPercentage=50 -XshowSettings:vm"

ENTRYPOINT ["/bin/bash", "-c","/usr/local/openjdk-11/bin/java $JAVA_OPTS -cp app:app/lib/* de.cronn.k8s.demoapp.DemoAppApplication --spring.config.location=classpath:/"]