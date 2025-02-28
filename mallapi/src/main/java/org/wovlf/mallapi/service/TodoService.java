package org.wovlf.mallapi.service;

import org.wovlf.mallapi.dto.PageRequestDTO;
import org.wovlf.mallapi.dto.PageResponseDTO;
import org.wovlf.mallapi.dto.TodoDTO;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

}
