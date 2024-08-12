package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultarOrden {
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order/";
    public void consultarOrden(int id) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .log().all()
                .get(CREATE_ORDER+id)
                .then()
                .log().all();

    }

    public void validarCodigo(int statusCode) {

        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
