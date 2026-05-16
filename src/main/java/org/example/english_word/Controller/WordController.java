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

    @PutMapping("/{id}")
    public Word update(@PathVariable Long id, @RequestBody Word newWord) {
        /*你传了id就是要根据id进行一个判断，就是这个对象存不存在。
        * 除此之外，也是需要根据id得到指定对象，这个对象里有全面数据，这里参数newWord不一定
        * 所有的成员变量都有更改数据，到时候是以null被处理了。*/
        Word word = wordRepository.findById(id).orElse(null);

        if (word == null) {
            return null;
        }

        if(newWord.getWord()!=null){
            word.setWord(newWord.getWord());
        }

        if(newWord.getMeaning()!=null){
            word.setMeaning(newWord.getMeaning());
        }

        return wordRepository.save(word);
    }
}
