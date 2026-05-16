package org.example.english_word.repository;

import org.example.english_word.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word,Long> {
    List<Word> findByWordContaining(String keyword);
}
