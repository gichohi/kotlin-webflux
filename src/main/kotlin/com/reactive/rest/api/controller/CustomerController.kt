package com.reactive.rest.api.controller

import com.reactive.rest.api.model.Customer
import com.reactive.rest.api.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/customers")
class CustomerController(@Autowired val customerService: CustomerService) {

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun getAllCustomers(): Flux<Customer> {
        return customerService.getAllCustomers()
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: Customer): Mono<Customer> {
        return customerService.createCustomer(customer)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomerById(@PathVariable("id") customerId: Long): Mono<Customer> {
        return customerService.getCustomerById(customerId)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCustomerById(@PathVariable("id") customerId: Long, @RequestBody customer: Customer): Mono<Customer>? {
       try {
           customerService.getCustomerById(customerId)
           val updatedCustomer = Customer(customerId, customer.firstname, customer.lastname, customer.email)
           return customerService.createCustomer(updatedCustomer)
       } catch (e: NoSuchElementException) {
           throw ResponseStatusException(
                   HttpStatus.NOT_FOUND
           )
       }
    }



}