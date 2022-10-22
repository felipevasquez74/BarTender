# BARTENDER

Programa hecho en springboot que determina si el número de un arreglo es divisible uniformemente por un numero primo.
El usuario debera ingresar la cantidad de iteraciones que desea y un numero entre 1-5 para seleccionar un arreglo que se encuentra en base de datos.

### End points
La aplicacion esta configurada para desplegar en el puerto 8080.
**GET** http://localhost:8080/bartender/iterations=5/stackId=2
iterations = # de iteraciones que se quieren realizar
stackId = pila que se quiere seleccionar de BD

### Base de datos
La aplicacion consume de una base de datos mysql llamada **bartender**. En el esquema **arrays** estan los arreglos que seran seleccionados para validar segun el valor que se envie en **stackId**.

### Metodos
En la clase **BarServiceImpl** existen dos metodos.

**getPrimeNumbers** : Este metodo se encarga de generar los numeros primos contra los cuales se validara el array proveniente de la BD, generara los numeros a partir del numero de iteraciones solicitado, multiplicado por **6** ya que es la cantidad de numeros que existen en los arrays de BD.

**getDivisibleNumber**: Es un metodo que se encarga de validar y obtener una lista de numeros (**b**) uniformemente divisibles a partir del stack seleccionado de la BD y los numeros primos generados.

### Respuestas
En caso de ser un proceso exitoso, el programa devovlera una respuesta con un **status 200** y el arreglo de los numeros uniformemente divisibles obtenidos.
En caso de existir algun fallo, el programa devovlera una respuesta con **status 500** y la razon del fallo de la ejecucion.

ejemplo respuesta:

```
{
    "status": 200,
    "reason": "Ok",
    "arrayB": [
        4,
        2,
        3,
        9,
        5,
        7
    ]
}
```

