package com.example.customer.resources;


import com.example.customer.commons.models.CustomerModel;
import com.example.customer.services.CustomerService;
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
@RequestMapping("v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customers  APIs")
public class CustomerResource {

    private final CustomerService customerService;


    @Operation(summary = "Retrieve Customer Info  by Id", description = "Retrieve Customer Info  by Id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<CustomerModel> getCustomer(@RequestParam Long id) {

         CustomerModel customerModel = customerService.findById(id);

        return new ResponseEntity<>(customerModel, HttpStatus.OK);

    }

}
