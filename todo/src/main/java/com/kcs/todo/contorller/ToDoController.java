package com.kcs.todo.contorller;

import com.kcs.todo.domain.ResponseDTO;
import com.kcs.todo.domain.ToDoDTO;
import com.kcs.todo.entity.ToDo;
import com.kcs.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("todo")
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping//테스트시 localhost/todo 에 post 방식으로 json에 title만 설정
    public ResponseEntity<?> createToDo(@RequestBody ToDoDTO dto){
        try {
            String temporaryUserId = "power2650";
            System.out.println(dto.toString());
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);
            //데이터생성
            List<ToDo> entities = toDoService.create(toDo);
            //ToDo 를 ToDoDTO로 변환
            //ToDoDTo의 생성자를 이용해 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }


    }
    @GetMapping
    public ResponseEntity<?> retriveToDoList(){
        String tempId = "power2650";
        //임시 아이디로 데이터 찾아오기
        List<ToDo> entities = toDoService.retrieve(tempId);
        //찾아온 데이터를 이용해서 DTO의 리스트 만들기
        List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
        //응답객체생성
        ResponseDTO<ToDoDTO> resonse = ResponseDTO.<ToDoDTO>builder()
                .data(dtos)
                .build();
        //클라 전송
        return ResponseEntity.ok().body(resonse);
    }

    @PutMapping//테스트시 localhost/todo 에 put 방식으로 json에 title,id 설정
    public ResponseEntity<?> updateToDo(@RequestBody ToDoDTO dto){
        try {
            String temporaryUserId = "power2650";
            System.out.println(dto.toString());
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);
            //데이터생성
            List<ToDo> entities = toDoService.update(toDo);
            //ToDo 를 ToDoDTO로 변환
            //ToDoDTo의 생성자를 이용해 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }


    }
    @DeleteMapping//테스트시 localhost/todo delete방식으로 id만 설정
    public ResponseEntity<?> deleteToDo(@RequestBody ToDoDTO dto){
        try {
            String temporaryUserId = "power2650";
            System.out.println(dto.toString());
            ToDo toDo = ToDoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);
            //데이터생성
            List<ToDo> entities = toDoService.delete(toDo);
            //ToDo 를 ToDoDTO로 변환
            //ToDoDTo의 생성자를 이용해 변환한 후 List로 만들어주기
            List<ToDoDTO> dtos = entities.stream().map(ToDoDTO::new).collect(Collectors.toList());
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<ToDoDTO> response = ResponseDTO.<ToDoDTO>builder()
                    .error(error).build();
            return ResponseEntity.badRequest().body(response);
        }


    }
}
