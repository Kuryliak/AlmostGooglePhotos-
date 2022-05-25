package roman.ua.springphotosearch.infrastructure.dto;

public class PhotoAuthorDTO {
    private String author;
    private byte[] photo;

    public PhotoAuthorDTO() {
    }

    public PhotoAuthorDTO(String author, byte[] photo) {
        this.author = author;
        this.photo = photo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
