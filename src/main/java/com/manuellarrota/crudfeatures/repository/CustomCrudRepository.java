package com.manuellarrota.crudfeatures.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 *
 * @param <T>
 * @param <ID>
 * @author Manuel Larrota
 */

@NoRepositoryBean
public interface CustomCrudRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
