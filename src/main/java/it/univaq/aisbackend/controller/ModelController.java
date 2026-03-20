package it.univaq.aisbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.univaq.aisbackend.model.Model;
import it.univaq.aisbackend.service.ModelService;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping({"/api/models"})
@Tag(
        name = "Model",
        description = "API for getting 3D model data. Currently supported models: house; mammoth; marikaStatue; painting; rock; sword; vase; xrglasses"
)
public class ModelController {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ModelController.class);
    private final ModelService modelService;

    @Operation(
            summary = "Get a model metadata",
            description = "Return a json object containing the information related to the request model."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Model found",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = Model.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "500",
            description = "Model not found",
            content = {@Content(
                    mediaType = "application/json",
                    examples = {@ExampleObject("{\n  \"code\": 500,\n  \"message\": \"File not Found\",\n  \"timestamp\": unix timestamp\n}")}
            )}
    )})
    @GetMapping({"/{id}/metadata"})
    public ResponseEntity<Model> getModelMetadata(@PathVariable("id") final String id) throws Exception {
        log.debug("REST request to get Model metadata {}", id);
        Model model = this.modelService.getModelMetadata(id);
        return Objects.isNull(model) ? ResponseEntity.notFound().build() : ResponseEntity.ok(model);
    }

    @Operation(
            summary = "Get a complete model",
            description = "Return a json object containing the information related to the request model and the data stream of the 3D render."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Model found",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = Model.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "500",
            description = "Model not found",
            content = {@Content(
                    mediaType = "application/json",
                    examples = {@ExampleObject("{\n  \"code\": 500,\n  \"message\": \"File not Found\",\n  \"timestamp\": unix timestamp\n}")}
            )}
    )})
    @GetMapping({"/{id}"})
    public ResponseEntity<Model> getModelBatch(@PathVariable("id") final String id) throws Exception {
        log.debug("REST request to get Model batch {}", id);
        Model model = this.modelService.getModelBatch(id);
        return Objects.isNull(model) ? ResponseEntity.notFound().build() : ResponseEntity.ok(model);
    }

    @Generated
    public ModelController(final ModelService modelService) {
        this.modelService = modelService;
    }
}
