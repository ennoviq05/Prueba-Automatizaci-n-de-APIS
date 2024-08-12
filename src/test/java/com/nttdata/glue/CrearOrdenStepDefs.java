package com.nttdata.glue;

import com.nttdata.steps.CrearOrden;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrearOrdenStepDefs {
    CrearOrden orden;
    // Constructor para inicializar orden
    public CrearOrdenStepDefs() {
        this.orden = new CrearOrden(); // Inicializa el objeto CrearOrden
    }
   @When("creo la orden con id {int}, petId {int}, quantity {int}, shipDate {string},status {string}")
    public void creoLaOrdenConIdPetIdQuantityShipDateStatus(int id, int petId, int quantity, String shipDate, String status) {
       orden.crearOrden(id,petId,quantity,shipDate,status);
  }
    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        orden.validarCodigoRespuesta(statusCode);
    }
    @And("el cuerpo de la respuesta contiene id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}")
    public void elCuerpoDeLaRespuestaContieneIdPetIdQuantityShipDateStatus(int id, int petId, int quantity, String shipDate, String status) {
        orden.validarCuerpoRespuesta(id, petId, quantity, shipDate, status);
    }
}
