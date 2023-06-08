package com.reactive.rest.api.service

import com.reactive.rest.api.model.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
     fun getCustomerById(id: Long): Mono<Customer>
     fun getAllCustomers(): Flux<Customer>
     fun createCustomer(customer: Customer): Mono<Customer>
     fun updateCustomer(customer: Customer): Mono<Customer>
}