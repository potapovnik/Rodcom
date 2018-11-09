package ru.relex.itschool.boot.rest.restApi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.relex.itschool.services.service.IInsertToDbInit;

/**
 * @author : sasha
 *
 * Имитация пуска загрузки базы начальными значениями
 * Для выполнения отправить POST-запрос с адреса localhost:8080/api/insert
 * Порт указан в \rodcom\src\main\resources\application.yml
 * Но так работать не будет :)
 * Ибо надо каждую модель DTO сохранить через Jpa.save().
 * Мне это делать лень, поэтому каждый пусть сделает свой кусочек.
 */
@RestController
@RequestMapping("insert")
public class InsertController {

    private final IInsertToDbInit insertToDbInit;

    public InsertController(IInsertToDbInit insertToDbInit) {
        this.insertToDbInit = insertToDbInit;
    }

    @PostMapping
    void InsertToDbInit(){
        insertToDbInit.DbInit();
    }

}
