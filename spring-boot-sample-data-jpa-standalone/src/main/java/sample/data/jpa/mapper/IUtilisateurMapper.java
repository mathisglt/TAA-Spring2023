package sample.data.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sample.data.jpa.domain.Utilisateur;
import sample.data.jpa.dto.UtilisateurDTO;

@Mapper(componentModel = "spring")
public interface IUtilisateurMapper {

    IUtilisateurMapper INSTANCE = Mappers.getMapper(IUtilisateurMapper.class);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "userTypeCompte", source = "typeCompte")
    @Mapping(target = "userQuiz", source = "quiz")
    UtilisateurDTO toDto(Utilisateur entity);

    @Mapping(target = "id", source = "userId")
    @Mapping(target = "name", source = "userName")
    @Mapping(target = "typeCompte", source = "userTypeCompte")
    @Mapping(target = "quiz", source = "userQuiz")
    Utilisateur toEntity(UtilisateurDTO dto);

}
