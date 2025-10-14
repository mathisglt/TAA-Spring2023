package sample.data.jpa.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sample.data.jpa.domain.Utilisateur;

@Transactional
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    @Query
    Utilisateur findUtilisateurById(@Param("idUtilisateur") Long idUtilisateur);
}
