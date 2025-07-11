
Feature:Crear un Usuario en la API users
como tester,
Quiero crear un usuario
Para poder verificar el funcionamiento de la API

@createUser  @Integracion
Scenario: Crear usuario exitosamente
Given que el tester desea crear usuario en la API de users
#And carga la información al sistema
 # | <name>   | <job>   |
When el tester realiza la solicitud para la creación del usuario con nombre "Alice" y trabajo "Ingeniera"
Then su solicitud se creará en el sistema con su información y un número de registro único


