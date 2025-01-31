#Es la imagen oficial de OpenJDK, que proporciona un entorno de ejecución para Java.
#11-slim: Es una variante "slim" (ligera) de OpenJDK 11, con menos paquetes y un tamaño más reducido,
#ideal para contenedores.
FROM openjdk:11-slim
LABEL maintainer="Orlando <ogaspar@mail.com>"
ARG JAR_FILE
RUN echo ${JAR_FILE}
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



