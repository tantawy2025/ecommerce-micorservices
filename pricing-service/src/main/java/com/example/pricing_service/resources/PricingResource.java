package com.example.pricing_service.resources;


import com.example.pricing_service.commons.models.PricingModel;
import com.example.pricing_service.services.PricingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("v1/pricing")
@RequiredArgsConstructor
@Tag(name = "Pricing  APIs")
public class PricingResource {

    private final PricingService pricingService;

    @Operation(summary = "add/update Pricing", description = "add new Pricing or update pricing for existing sku ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addOrUpdatePricing(@RequestBody PricingModel pricingModel) {

        pricingService.addOrUpdatePricing(pricingModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve Pricing for a SKU based on Date", description = "Retrieve Pricing for a SKU based on Date ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @GetMapping
    public Optional<PricingModel> getPricing(@RequestParam String sku, @RequestParam String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date + "T00:00:00"); // Adjust as needed
        return pricingService.getPricingForSkuAndDate(sku, dateTime);

    }

}
