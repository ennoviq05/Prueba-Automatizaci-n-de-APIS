Feature: Crear y consultar orden PetStore

  @testPrueba
  Scenario Outline: Crear orden
    When creo la orden con id <id>, petId <petId>, quantity <quantity>, shipDate <shipDate>,status <status>
    Then el codigo de respuesta es <statusCode>

    Examples:
      | id | petId | quantity | shipDate                | status  | statusCode |
      | 51  | 0     | 0        | "2024-08-07T20:38:52.584Z" | "placed"  | 200        |
      | 80  | 0     | 0        | "2024-08-07T20:39:53.584Z" | "placed"  | 200        |
      | 13  | 0     | 0        | "2024-08-07T20:40:54.584Z" | "placed"  | 200        |

  @testPrueba
  Scenario Outline: Consultar orden
    When consulto la orden con id <orderId>
    Then el codigo de respuesta sera <statusCode>

    Examples:
      | orderId | statusCode |
      | 51       | 200        |
      | 80       | 200        |
      | 13       | 200        |