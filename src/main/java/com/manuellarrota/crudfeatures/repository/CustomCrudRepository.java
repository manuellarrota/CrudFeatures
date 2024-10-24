package com.manuellarrota.crudfeatures.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @param <T>
 * @author Manuel Larrota
 */

@NoRepositoryBean
public interface CustomCrudRepository<T>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
