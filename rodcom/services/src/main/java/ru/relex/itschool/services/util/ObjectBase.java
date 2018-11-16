package ru.relex.itschool.services.util;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author : sasha
 *
 * Получает объект любого типа Entity из соответствующего ему репозитория
 * и осуществляет над ним различные проверки
 */
public class ObjectBase<T, R extends JpaRepository<T, Integer>> {

    private R repository;

    public ObjectBase(R repository) {
        this.repository = repository;
    }

    public ObjectBase() {
    }

    public R getRepository(){
        return this.repository;
    }

    /**
     * Проверить существование объекта в базе и вернуть его, если он есть
     * @param id - идентификатор нужного объекта
     * @return - либо null, либо объект
     */
    public T getByIdFromBase(int id) {
        Optional<T> optional = repository.findById(id);
        return optional.orElse(null);
    }

    /**
     * Сохранить объект в репозитории
     */
    public T saveToRep(T object){
        object = repository.save(object);
        return object;
    }

    /**
     * Удалаяет объект из репозитория
     */
    public void deleteFromRep(T object) {
        repository.delete(object);
    }

    /**
     * Проверка объекта на Null-значение
     * @return если не null - true
     */
    public boolean isPresent(T object){
        return object != null;
    }

    /**
     * Инверсивная проверка объекта на Null-значение
     * @return если null - true
     */
    public boolean isEmpty(T object){
        return object == null;
    }

    public List<T> getListObject(){
        return repository.findAll();
    }

}
