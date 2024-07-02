Proyecto para de prueba, el mismo se comprende una api como endpoind para un CRUD. 

Esta configurada para funcionar a a nivel local, pero esta parametrizada para solo recibir peticiones desde un puerto en especifico como el puerto:

http://localhost:3000


Pasos para buildear la aplicacion. 


Descargar la aplicacion del repositorio y a su vez descargar la aplicacion del front-end alojada en el siguiente repositorio:

https://github.com/OrlanDelgado/react-app-spring.git

En ese repositorio se encuentra la aplicacion que gestiona las peticiones.

Con el siguiente script podemos crear nuestra base de datos en mongodb

Crear la base de datos en la MongoDb

use TareasDb

db.createCollection("tareas")

db.tareas.insertOne({
    _id: ObjectId("667cbadb066fdec9ff7638a2"),
    Titulo: "Tarea de ejemplo",
    Descripcion: "Descripción de ejemplo",
    FechaCreacion: ISODate("2024-06-27"),
    Estado: "completado"
})

Una vez se cree la base de datos, subimos los docker al docker-desktop y ejecutamos los dos ambientes juntos...

