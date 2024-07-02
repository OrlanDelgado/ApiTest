# Usar una imagen base de OpenJDK 21
FROM openjdk:21

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el JAR construido en el contenedor
COPY target/tareas-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que tu aplicación correrá
EXPOSE 8081

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
