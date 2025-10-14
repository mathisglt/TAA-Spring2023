package sample.data.jpa.domain;

import jakarta.persistence.*;

@Entity
public class Reponse {

    private Long id;

    private String texte;
    private boolean correcte;


    private Question question;

    public Reponse() {}

    public Reponse(String texte, boolean correcte, Question question) {
        this.texte = texte;
        this.correcte = correcte;
        this.question = question;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean isCorrecte() {
        return correcte;
    }

    public void setCorrecte(boolean correcte) {
        this.correcte = correcte;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
