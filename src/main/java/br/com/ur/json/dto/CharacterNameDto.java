package br.com.ur.json.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharacterNameDto {

	private String id;
	
    private String name;

    public CharacterNameDto(String name, String id) {
    	this.id = id;
    	this.name = name;
    }
}
