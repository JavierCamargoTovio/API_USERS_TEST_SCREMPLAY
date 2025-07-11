Feature:Actualizar un Usuario en la API users
  como tester,
  Quiero actualizar un usuario
  Para poder verificar el funcionamiento de la API

  @UpdateUser  @integrationTest
  Scenario Outline: Actualizar usuario exitosamente
    Given que el tester desea actualizar usuario en la API de users
    And carga la información al sistema
      | <name> | <job> |
    When el tester realiza la solicitud para la actualizacion del usuario con parametro "<idUser>"
    Then su solicitud se actualizará en el sistema con su información
    Examples:
      | idUser | name    | job                  |
      | 1      | Martha  | Ingeniera industrial |
      | 4      | Charlis | Contador publico     |

