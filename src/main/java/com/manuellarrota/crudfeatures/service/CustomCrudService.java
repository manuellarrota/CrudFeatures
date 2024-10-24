package com.manuellarrota.crudfeatures.service;

import java.util.List;

/**
 *
 * @param <T>
 * @param <DTO>
 * @param <ID>
 */
public interface CustomCrudService<T, DTO> {
    T save(T entity);
    T getById(Long id);
    List<T> getAll();
    T update(Long id, T entity);
    void delete(Long id);
    DTO saveDto(DTO dto);
    DTO getByIdDto(Long id);
    List<DTO> getAllDto();
    DTO updateDto(DTO entityDto);

    DTO getDto(T instance);

    /**
     * transforma dto en una instancia.
     *
     * @param dto objeto representativo de la instancia.
     * @return Instancia.
     */
    T getInstance(DTO dto);
}
