Feature: Buscar usuario por ID
  yo como tester,
  Quiero obtener la informacion de un usuario por su id
  Para confirmar que le funcionamiento del servicio corresponde al esperado

  @getIdUser
  Scenario Outline: Busqueda de un usuario por id exitosamente
    Given desea consultar la API de user
    When intenta realizar la consulta utilizando el parametro <id>
    And define los datos para verificar la consulta del servicio
      | <id> | <email> | <first_name> | <last_name> | <avatar> |
    Then se debera obtener la repuesta exitosa
    And valido los campos del servicio
    Examples:
      | id | email                    | first_name | last_name | avatar                                  |
      | 2  | janet.weaver@reqres.in   | Janet      | Weaver    | https://reqres.in/img/faces/2-image.jpg |
      | 7  | michael.lawson@reqres.in | Michael    | Lawson    | https://reqres.in/img/faces/7-image.jpg |
