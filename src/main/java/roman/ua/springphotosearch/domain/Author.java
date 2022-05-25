package roman.ua.springphotosearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("AUTHORS")
public class Author {
    @Id
    private String author;
    private Photo photo;

    public Author(String author, Photo photo) {
        this.author = author;
        this.photo = photo;
    }

    public Author(String author) {
        this.author = author;
    }

    public Author() {
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @MappedCollection(keyColumn = "AUTHOR", idColumn = "AUTHOR")
    private Set<Photo> photoSet;

}
