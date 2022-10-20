package com.kcs.todo;

import com.kcs.todo.entity.ToDo;
import com.kcs.todo.persistence.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class ToDoTest {
    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    public void testInsert(){
        ToDo todo = ToDo.builder()
                .userId("power933")
                .title("서점가기")
                .build();
        toDoRepository.save(todo);

        ToDo todo2 = ToDo.builder()
                .userId("power933")
                .title("여행가기")
                .build();
        toDoRepository.save(todo2);
    }

    @Test
    public void selectTest(){
        List<ToDo> list = toDoRepository.findByUserId("power933");
        list.stream().forEach(toDo -> {
            System.out.println(toDo );
        });
    }
    @Test
    public void selectTest2(){
        Optional<ToDo> todo = toDoRepository.findById("4028815183f3825d0183f38265fd0001");
        if(todo.isPresent())
            System.out.println(todo.get());
    }
    @Test
    public void updateTest(){
        ToDo toDo = ToDo.builder()
                .id("4028815183f3825d0183f38265fd0001")
                .userId("ooping")
                .title("낚시여행")
                .done(true)
                .build();
        toDoRepository.save(toDo);

        Optional<ToDo> optionalToDo = toDoRepository.findById("4028815183f3825d0183f38265fd0001");
        if(optionalToDo.isPresent()){
            System.out.println(optionalToDo.get());
        }
    }
    @Test
    public void deleteTest(){
        toDoRepository.deleteById("4028815183f3825d0183f38265fd0001");

        Optional<ToDo> optionalToDo = toDoRepository.findById("4028815183f3825d0183f38265fd0001");
        if(optionalToDo.isPresent()){
            System.out.println(optionalToDo.get());
        }else{
            System.out.println("존재하지 않음");
        }
    }

    @Test
    public void qwe(){
        Integer asd[] = {1,2,3,4,5};
        ArrayList al = new ArrayList(Arrays.asList(asd));
        ArrayList al1 = new ArrayList();
        ArrayList al2 = new ArrayList();
        al.stream().forEach(o -> {

        });

    }

}
