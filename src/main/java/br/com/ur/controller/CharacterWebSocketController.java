package br.com.ur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import br.com.ur.mongodb.entity.Character;
import br.com.ur.service.CharacterService;

@Controller
public class CharacterWebSocketController {
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private CharacterService characterService;
	
	@MessageMapping("/changeCharacter/{characterId}")
    public void changeText(@Payload Character input, @DestinationVariable String characterId) {
    	characterService.save(input);
        messagingTemplate.convertAndSend("/character/updates/" + characterId, input);
    }
}