package sample.data.jpa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {

    private Long id;

    private String name;

    private int codepin;

    private List<Utilisateur> listeUtilisateurs = new ArrayList<>();

    private List<Question> listeQuestions = new ArrayList<>();

    public Quiz() {}
    public Quiz(String name) { this.name = name; }
    public Quiz(String name, int codepin) { this.name = name; this.codepin = codepin; }

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

    public int getCodepin() {
        return codepin;
    }

    public void setCodepin(int codepin) {
        this.codepin = codepin;
    }

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Question> getListeQuestions() {
        return listeQuestions;
    }

    public void setListeQuestions(List<Question> listeQuestions) {
        this.listeQuestions = listeQuestions;
    }
}
