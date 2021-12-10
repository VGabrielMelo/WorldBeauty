package com.WorldBeauty.repository;

import org.springframework.data.repository.CrudRepository;

import com.WorldBeauty.models.Cliente;
import com.WorldBeauty.models.Serviço;

public interface ServiçoRepository extends CrudRepository<Serviço, String> {
	
	Iterable<Serviço> findByCliente(Cliente cliente);
	Serviço findByid(String id);

}
