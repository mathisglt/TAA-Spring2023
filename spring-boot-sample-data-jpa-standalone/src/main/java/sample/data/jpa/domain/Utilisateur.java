package sample.data.jpa.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {


    private Long id;

    private String name;

    private TypeCompte typeCompte;

    private Quiz quiz;

    public Utilisateur() {}
    public Utilisateur(String name) { this.name = name;this.typeCompte=TypeCompte.USER; }
    public Utilisateur(String name,TypeCompte typeCompte) { this.name = name; this.typeCompte= typeCompte; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
