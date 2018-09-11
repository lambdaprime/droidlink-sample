package id.droidlink.sample.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Words")
@NamedQueries({ 
    @NamedQuery(name = Card.FIND_ALL, query = "SELECT c FROM Card c ORDER BY c.id")})
public class Card {

    public static final String FIND_ALL = "SELECT c FROM Card c";

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;
    private String question;
    private String answer;
    private boolean isLearned;
    private boolean isMarked;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    public Card() {
    }

    public Card(int id) {
        this.id = id;
    }
    
    public Card(int id, String question, String answer, boolean isLearned, boolean isMarked) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.isLearned = isLearned;
        this.isMarked = isMarked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned(boolean isLearned) {
        this.isLearned = isLearned;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

    @Override
    public String toString() {
        return "Card [id=" + id + ", question=" + question + ", answer="
            + answer + ", isLearned=" + isLearned + ", isMarked=" + isMarked
            + ", author=" + author + "]";
    }
    
}
