package com.kcs.todo.service;

import com.kcs.todo.entity.ToDo;
import com.kcs.todo.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;
    //유효성 검사를 위한 메서드
    private void validate(final ToDo toDo){
        if(toDo == null){
            throw  new RuntimeException("Todo cannot be null");
        }
        if(toDo.getUserId() == null){
            throw new RuntimeException("userId cannot be null");
        }
    }

    @Override
    public List<ToDo> create(ToDo toDo) {
        validate(toDo);
        toDoRepository.save(toDo);

        return toDoRepository.findByUserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> retrieve(String userId) {

        return toDoRepository.findByUserId(userId);
    }

    @Override
    public List<ToDo> update(ToDo toDo) {
        validate(toDo);
        toDoRepository.save(toDo);
        return toDoRepository.findByUserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> delete(ToDo toDo) {
        validate(toDo);
        toDoRepository.delete(toDo);
        return toDoRepository.findByUserId(toDo.getUserId());
    }
}
