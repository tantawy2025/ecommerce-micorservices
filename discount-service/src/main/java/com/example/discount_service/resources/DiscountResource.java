package com.example.discount_service.resources;


import com.example.discount_service.commons.models.DiscountModel;
import com.example.discount_service.repo.entity.Discount;
import com.example.discount_service.services.DiscountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("v1/discount")
@RequiredArgsConstructor
@Tag(name = "Discount  APIs")
public class DiscountResource {

    private final DiscountService discountService;


    @Operation(summary = "Retrieve Discount for a specific product by SKU", description = "Retrieve Discount for a specific product by SKU ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @GetMapping("sku/{sku}")
    public ResponseEntity<DiscountModel> getDiscount(@RequestParam String sku) {

         DiscountModel discountModel = discountService.findBySku(sku);

        return new ResponseEntity<>(discountModel, HttpStatus.OK);

    }


    @Operation(summary = "Get all Discounts", description = "Returns list of Discounts ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<DiscountModel>> retrieveAllDiscounts(Pageable pageable){

        Page<DiscountModel> discountModels = discountService.getAll(pageable);
        return new ResponseEntity<>(discountModels, HttpStatus.OK);
    }

    @Operation(summary = "add new Discount", description = "add new Discount and return the  status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addNewDiscount(@RequestBody DiscountModel discountModel) {

        discountService.create(discountModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
