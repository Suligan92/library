package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.exception.AuthorNotFoundException;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()) {
            throw new AuthorNotFoundException("Autorul cu id-ul " + id + " nu a fost găsit");
        }
        return author.get();
    }

    public void deleteById(Long id) {
        if(!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Autorul cu id-ul " + id + " nu a fost găsit");
        }
        authorRepository.deleteById(id);
    }

}
