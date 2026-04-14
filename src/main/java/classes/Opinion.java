package classes;

public class Opinion {
    private int idUser;
    private int idArticle;
    private String content;
    private int likes;
    private int line;

    public Opinion(int idUser, int idArticle, String content, int likes, int line) {
        this.idUser = idUser;
        this.idArticle = idArticle;
        this.content = content;
        this.likes = likes;
        this.line = line;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getLine() {
        return line;
    }
}
