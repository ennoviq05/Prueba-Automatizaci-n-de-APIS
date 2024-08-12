package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrden {
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    public void crearOrden(int id, int petId, int quantity, String shipDate, String status) {
        System.out.println(id+petId+quantity+shipDate+status);
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "    \"id\": \"" + id + "\",\n" +
                        "    \"petId\": \"" + petId + "\",\n" +
                        "    \"quantity\": \"" + quantity + "\",\n" +
                        "    \"shipDate\": \"" + shipDate + "\",\n" +
                        "    \"status\": \"" + status + "\",\n" +
                        "    \"complete\": \"" + true+ "\"\n" +
                        "}")

                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all();
    }

    public void validarCodigoRespuesta(int statusCode) {

        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validarCuerpoRespuesta(int id, int petId, int quantity, String shipDate, String status) {
        restAssuredThat(response -> response.body("id", equalTo(id))
                .body("petId", equalTo(petId))
                .body("quantity", equalTo(quantity))
                .body("shipDate", equalTo(shipDate))
                .body("status", equalTo(status))
                .body("complete", equalTo(true)));
    }




}
