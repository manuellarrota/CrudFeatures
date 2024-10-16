package com.manuellarrota.crudfeatures.service;

import java.util.List;

/**
 *
 * @param <T>
 * @param <DTO>
 * @param <ID>
 */
public interface CustomCrudService<T, DTO, ID> {
    T create(T entity);
    T getById(ID id);
    List<T> getAll();
    T update(ID id, T entity);
    void delete(ID id);
    DTO createDto(T entity);
    DTO getByIdDto(ID id);
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
