package com.zrich.scribe.repositories;

import java.time.LocalDate;
import java.util.List;

import com.zrich.scribe.enums.Priority;
import com.zrich.scribe.models.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findAllByPriority(Priority priority);

    List<Todo> findAllByCreatedAt(LocalDate createdAt);

    List<Todo> findAllByUserId(Integer priority);

}
