package com.WorldBeauty.repository;

import org.springframework.data.repository.CrudRepository;

import com.WorldBeauty.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
