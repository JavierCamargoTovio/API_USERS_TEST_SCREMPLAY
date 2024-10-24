
Feature:Crear un Usuario en la API users
como tester,
Quiero crear un usuario
Para poder verificar el funcionamiento de la API

@createUser  @integrationTest
Scenario Outline: Crear usuario exitosamente
Given que el tester desea crear usuario en la API de users
And carga la información al sistema
  | <name>   | <job>   |
When el tester realiza la solicitud para la creación del usuario
Then su solicitud se creará en el sistema con su información y un número de registro único
Examples:
| name |job|
| Alice  |docente|
| Eva  |Estudiante|

