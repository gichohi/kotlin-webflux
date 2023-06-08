package com.reactive.rest.api.repository

import com.reactive.rest.api.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long>