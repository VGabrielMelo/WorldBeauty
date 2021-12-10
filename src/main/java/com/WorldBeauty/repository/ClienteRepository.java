package com.WorldBeauty.repository;

import org.springframework.data.repository.CrudRepository;

import com.WorldBeauty.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	
	Cliente findByid(long id);

}
