package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.data.jpa.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
