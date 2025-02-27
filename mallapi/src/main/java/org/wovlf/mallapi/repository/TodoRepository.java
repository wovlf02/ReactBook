package org.wovlf.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wovlf.mallapi.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
