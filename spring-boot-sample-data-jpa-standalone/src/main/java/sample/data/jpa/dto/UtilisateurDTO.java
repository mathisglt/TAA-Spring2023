package sample.data.jpa.dto;

import sample.data.jpa.domain.Quiz;
import sample.data.jpa.domain.TypeCompte;

public class UtilisateurDTO {
    private Long userId;
    private String userName;
    private TypeCompte userTypeCompte;
    private Quiz userQuiz;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TypeCompte getUserTypeCompte() {
        return userTypeCompte;
    }

    public void setUserTypeCompte(TypeCompte userTypeCompte) {
        this.userTypeCompte = userTypeCompte;
    }

    public Quiz getUserQuiz() {
        return userQuiz;
    }

    public void setUserQuiz(Quiz userQuiz) {
        this.userQuiz = userQuiz;
    }
}
