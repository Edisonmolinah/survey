utilizando el framework de spring boot (java) se debe realizar una API Rest que cumpla con los siguientes requerimientos.

Un restaurante requiere un sistema que permita listar una encuesta a sus clientes para recibir el feedback de sus servicios; la encuesta tiene debe de tener un listado de preguntas de tipo abiertas y selección múltiple con sus respectivas respuestas.

Criterios de aceptación
Se debe exponer un servicio que permita listar una encuesta con sus respectivas preguntas.
Se debe exponer un servicio que permita registrar la encuesta.
Implementar test unitarios.
Las encuesta puede tener una o varias preguntas de tipo abierta o selección múltiple.

Para cargar las preguntas se debe correr en el siguiente endpoint:

localhost:8080/survey     POST

y montar el siguiete Json:
````
[
{
"questionText": "Question one",
"typeQuestion": "SINGLE",
"listAnswer": []
},
{
"questionText": "Question two",
"typeQuestion": "SINGLE",
"listAnswer": []
},
{
"questionText": "Select the Restaurant",
"typeQuestion": "MULTI",
"listAnswer": [
{
"textAnswer": "Restaurant1"
},
{
"textAnswer": "Restaurant2"
},
{
"textAnswer": "Restaurant3"
}
]
}

````

para obtener una la encuesta creada en el paso anterior, correr el siguiente endpoint:

localhost:8080/survey/1     GET

para ingresar la respuesta de preguntas a una encuesta correr el siguiente endpoint:

localhost:8080/survey/save      POST

y como ejemplo ingresamos el siguiente Json:

````
[
    {
        "numberQuestion": "1",
        "answerQuestion": "la respuesta es Respuesta"
    },
    {
        "numberQuestion": "2",
        "answerQuestion": "la respuesta es Respuesta"
    },
     {
        "numberQuestion": "3",
        "answerQuestion": "la respuesta es Respuesta"
    }
]
````

como respuesta obtendremos el siguiente mensaje:
````
Successful process responses with id: (numero de id)
````
