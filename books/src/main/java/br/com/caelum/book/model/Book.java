package br.com.caelum.book.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long authorId;
    private BigDecimal price;

    /**
     * @deprecated frameworks eyes only
     */
    @Deprecated
    private Book() {
    }

    public Book(String title, Long authorId, BigDecimal price) {
        this.title = title;
        this.authorId = authorId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
