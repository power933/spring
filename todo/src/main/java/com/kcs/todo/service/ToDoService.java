package com.kcs.todo.service;

import com.kcs.todo.entity.ToDo;

import java.util.List;

public interface ToDoService {
    //todo대신 DTO로 설정해도 됨
    //주읮머은 todo받을거라면 수정할 수 없도록 final로 설정해야 함
    public List<ToDo> create(final ToDo entity);

    //userid를 이용한 죄회
    public List<ToDo> retrieve(final String userId);
    //데이터 수정
    public List<ToDo> update(final ToDo toDo);
    //데이터 삭제
    public List<ToDo> delete(final ToDo toDo);
}
