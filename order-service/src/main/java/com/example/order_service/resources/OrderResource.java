package com.example.order_service.resources;

import com.example.order_service.commons.models.OrderModelResponse;
import com.example.order_service.repo.entity.Order;
import com.example.order_service.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/orders")
@RequiredArgsConstructor
@Tag(name = "Order Management APIS")
public class OrderResource {

    private final OrderService orderService;


    @GetMapping("{customerId}")
    public ResponseEntity<List<OrderModelResponse>> listCustomerOrders(@PathVariable Long customerId){

        List<OrderModelResponse> orderModelResponses = orderService.listCustomerOrders(customerId);

        return  new ResponseEntity<>(orderModelResponses, HttpStatus.OK);
    }


}
