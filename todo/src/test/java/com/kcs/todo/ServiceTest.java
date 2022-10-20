package com.kcs.todo;

import com.kcs.todo.entity.ToDo;
import com.kcs.todo.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private ToDoService toDoService;

    @Test
    public void testInsert(){
        ToDo toDo = ToDo.builder()
                .userId("power933")
                .title("서비스 테스트")
                .done(false)
                .build();
        List<ToDo> list = toDoService.create(toDo);
        System.out.println(list);
    }
    @Test
    public void retrieve(){
        List<ToDo> list = toDoService.retrieve("power933");
    }
    @Test
    public void update(){
        ToDo toDo = ToDo.builder()
                .id("4028815183f40a4e0183f40a585f0000")
                .userId("kklol")
                .title("서비스단 테스트")
                .build();
        List<ToDo> list = toDoService.update(toDo);
        List<ToDo> list2 = toDoService.retrieve("kklol");
        System.out.println(list2);
    }
    @Test
    public void deteleTest(){
        ToDo toDo = ToDo.builder()
                .id("4028815183f40a4e0183f40a585f0000")
                .userId("kklol")
                .build();
        List<ToDo> list = toDoService.delete(toDo);
        System.out.println(list);
    }
}
