package com.example.payment.resources;

import com.example.payment.services.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/payments")
@RequiredArgsConstructor
@Tag(name = "Payments  APIs")
public class PaymentResource {

    private final PaymentService discountService;


    @Operation(summary = "verify balance", description = "verify if customer have balance or not")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @GetMapping("verify")
    public ResponseEntity<Boolean> verifyPayment(@RequestParam Long customerId, @RequestParam double amount) {

        boolean isVerified = discountService.verifyBalance(customerId,amount);

        return new ResponseEntity<>(isVerified, HttpStatus.OK);

    }



}
