
Feature:Crear un Usuario en la API users
    como tester,
    Quiero crear un usuario
    Para poder verificar el funcionamiento de la API

    @createUser  @Integracion
    Scenario Outline: Crear usuario exitosamente
        Given que el tester desea crear usuario en la API de users
        When el tester realiza la solicitud para la creación del usuario con nombre "<name>" y trabajo "<job>"
        Then la respuesta del sistema es exitosa
        Then su solicitud se creará en el sistema con su información y un número de registro único
    Examples:
        | name   | job       |
        | Javier | Tester    |
        | Alice  | Developer |


