package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrden;
import com.nttdata.steps.CrearOrden;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultarOrdenStepDefs {
    ConsultarOrden orden1;
    // Constructor para inicializar orden
    public ConsultarOrdenStepDefs() {
        this.orden1 = new ConsultarOrden(); // Inicializa el objeto CrearOrden
    }

    @When("consulto la orden con id {int}")
    public void consultoLaOrdenConId(int id) {
        orden1.consultarOrden(id);
    }

    @Then("el codigo de respuesta sera {int}")
    public void elCodigoDeRespuestaSera(int statusCode) {
        orden1.validarCodigo(statusCode);

    }


}
