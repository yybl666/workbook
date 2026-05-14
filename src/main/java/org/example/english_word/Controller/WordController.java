package org.example.english_word.Controller;

import org.example.english_word.entity.Word;
import org.example.english_word.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordRepository wordRepository;

    @GetMapping
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    @PostMapping
    public Word save(@RequestBody Word word) {
        return wordRepository.save(word);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wordRepository.deleteById(id);
    }
}
