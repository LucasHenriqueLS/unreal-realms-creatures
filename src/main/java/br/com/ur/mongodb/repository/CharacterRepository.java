package br.com.ur.mongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.ur.json.dto.CharacterNameDto;
import br.com.ur.mongodb.entity.Character;

public interface CharacterRepository extends MongoRepository<Character, String> {

	Optional<Character> findByName(String characterName);
	
	@Query(value = "{}", fields = "{ 'id' : 1, 'name' : 1}")
	List<CharacterNameDto> findAllNames(Sort sort);
}