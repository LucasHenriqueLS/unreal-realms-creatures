package br.com.ur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ur.exceptions.NotFoundException;
import br.com.ur.json.dto.CharacterNameDto;
import br.com.ur.mongodb.entity.Character;
import br.com.ur.mongodb.repository.CharacterRepository;

@Service
public class CharacterService {

	@Autowired
	private CharacterRepository characterRepository;
	
	public List<Character> getAll() {
		return characterRepository.findAll();
	}
	
	public Character getById(String characterId) {
		return characterRepository.findById(characterId).orElseThrow(() -> new NotFoundException(characterId, "Personagem"));
	}
	
	public Character getByName(String characterName) {
		return characterRepository.findByName(characterName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Nenhum personagem com o nome %s foi encontrado", characterName)));
	}
	
	public List<CharacterNameDto> getAllCharacterNames() {
		return characterRepository.findAllNames(Sort.by("name").ascending());
	}

	public Character save(Character input) {
		return characterRepository.save(input);
	}
	
//	public Character update(String characterId, Character input) {
//		var character = getById(characterId);
//		return characterRepository.save(character);
//	}
	
	public void delete(String characterId) {
		characterRepository.deleteById(characterId);
	}
}
