Feature: listar los usuarios
  yo como tester,
  Quiero obtener la informacion de la lista de usuario
  Para confirmar que le funcionamiento del servicio corresponde al esperado

  @getListUsers
  Scenario Outline: listar usuarios exitosamente
    Given desea consultar la API de user
    When realizo la solicitud por el metodo GET para obtener la pagina "<numero>" de usuarios
    Then se debera obtener la repuesta exitosa de la lista de usuario
    Examples:
      | numero |
      | 1  |
      | 2  |

