package com.kcs.todo.domain;


import com.kcs.todo.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoDTO {
    private String id;
    private String title;
    private boolean done;

    //엔티티를 받아 DTO 인스턴스를 생성해주는 생성자
    public ToDoDTO(final ToDo toDo){
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();

    }
    //DTO 인스턴스를 엔티티 인스턴스로 변환해주는 메서드
    public static ToDo toEntity(final ToDoDTO dto){
        return ToDo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }

}
