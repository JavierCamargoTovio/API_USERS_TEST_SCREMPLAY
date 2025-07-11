Feature:Eliminar un Usuario en la API users
  como tester,
  Quiero eleminar un usuario
  Para poder verificar el funcionamiento de la API

  @DeleteUser  @integrationTest
  Scenario Outline: Eliminar usuario exitosamente
    Given que el tester desea eliminar usuario en la API de users
    When el tester realiza la solicitud para la eliminación del usuario con parametro "<idUser>"
    Then el tester verifica que se elimino el usuario en el sistema
    Examples:
      | idUser |
      | 1      |


