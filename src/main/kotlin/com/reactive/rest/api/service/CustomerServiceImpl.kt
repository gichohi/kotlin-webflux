package com.reactive.rest.api.service

import com.reactive.rest.api.model.Customer
import com.reactive.rest.api.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

@Service
class CustomerServiceImpl(@Autowired private val customerRepository: CustomerRepository) : CustomerService {

    override fun getCustomerById(id: Long): Mono<Customer> {
        return customerRepository.findById(id).orElseThrow().toMono()
    }

    override fun getAllCustomers(): Flux<Customer> {
        return customerRepository.findAll().toFlux()
    }

    override fun createCustomer(customer: Customer): Mono<Customer> {
       return customerRepository.save(customer).toMono()
    }

    override fun updateCustomer(customer: Customer): Mono<Customer> {
       return customerRepository.save(customer).toMono()
    }
}