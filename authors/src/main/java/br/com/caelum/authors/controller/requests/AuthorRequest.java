package br.com.caelum.authors.controller.requests;

import br.com.caelum.authors.model.Author;

public class AuthorRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author toDomain() {
        return new Author(name);
    }
}
