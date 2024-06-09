package br.com.ur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ur.json.dto.CharacterNameDto;
import br.com.ur.mongodb.entity.Character;
import br.com.ur.service.CharacterService;

@RestController
@RequestMapping(value = "character")
public class CharacterController {

	@Autowired
	private CharacterService characterService;
	
	@GetMapping
	public ResponseEntity<List<Character>> getAll() {
		return ResponseEntity.ok().body(characterService.getAll());
	}
	
	
	@GetMapping("get-by-id/{characterId}")
	public ResponseEntity<Character> getById(@PathVariable("characterId") String characterId) {
		return ResponseEntity.ok().body(characterService.getById(characterId));
	}

	@GetMapping("get-by-name/{characterName}")
	public ResponseEntity<Character> getByName(@PathVariable("characterName") String characterName) {
		return ResponseEntity.ok().body(characterService.getByName(characterName));
	}

	@GetMapping("get-all-character-names")
	public ResponseEntity<List<CharacterNameDto>> getAllCharacterNames() {
		return ResponseEntity.ok().body(characterService.getAllCharacterNames());
	}
	
	@PostMapping
	public Character save(@RequestBody Character input) {
		return characterService.save(input);
	}
	
	@DeleteMapping("{characterId}")
	public void delete(@PathVariable("characterId") String characterId) {
		characterService.delete(characterId);
	}
}
