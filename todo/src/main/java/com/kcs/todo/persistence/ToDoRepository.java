package com.kcs.todo.persistence;

import com.kcs.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,String> {
    public List<ToDo> findByUserId(String userId);


}
