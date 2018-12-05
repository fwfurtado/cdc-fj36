package br.com.caelum.book.controller.request;

import br.com.caelum.book.model.Book;

import java.math.BigDecimal;

public class BookRequest {
    private String title;
    private Long authorId;
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Book toDomain() {
        return new Book(title, authorId, price);
    }
}
