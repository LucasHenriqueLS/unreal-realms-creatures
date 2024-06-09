package br.com.ur.mongodb.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "characters")
public class Character {

	@Id
	private String id;
	private String name;
	private String alignment;
	private String race;
	private String sex;
	private String combatantClass;
	private String backgroud;
	private Integer experience;
	private String description;
	private Integer inspirations;
	private Integer maxLifePoints;
	private Integer currentLifePoints;
	private Integer temporaryLifePoints;
	private Map<String, HitDie> hitDice;
    private DeathSaves deathSaves;
    private Double speed;
    private ProficiencyBonus proficiencyBonus;
    private Map<String, Integer> abilities;
    private Map<String, Integer> savingThrows;
    private Map<String, Map<String, Integer>> skills;
    private Map<String, Map<String, Map<String, Integer>>> specializedSkills;
    private Map<String, Integer> senses;
    private List<WieldableItem> wieldedItems;
    private Armor armor;
    private List<Characteristic> characteristics;
    private Spellcasting spellcasting;
    
    public Character() {
    	this.hitDice = new HashMap<>();
    	this.abilities = new HashMap<>();
    	this.savingThrows = new HashMap<>();
    	this.skills = new HashMap<>();
    	this.specializedSkills = new HashMap<>();
    	this.senses = new HashMap<>();
    	this.wieldedItems = new ArrayList<>();
    	this.characteristics = new ArrayList<>();
    }
}

@Getter
@Setter
@ToString
class ProficiencyBonus {

	private Integer total;
	private Integer current;
}

@Getter
@Setter
@ToString
class HitDie {

	private Integer total;
	private Integer remaining;
}

@Getter
@Setter
@ToString
class DeathSaves {

	private Integer successes;
	private Integer failures;
}

@Getter
@Setter
@ToString
class Characteristic {

	private String name;
	private String source;
	private String sourceType;
	private String description;
}

@Getter
@Setter
@ToString
class Spellcasting {

    private String spellcastingAbility;
    private Integer spellSaveDC;
    private Integer spellAttackBonus;
    private Map<Integer, SpellByLevel> spellsByLevel;
    
    public Spellcasting() {
    	spellsByLevel = new HashMap<>();
    }
}

@Getter
@Setter
@ToString
class SpellByLevel {

    private Integer totalSlots;
    private Integer currentSlots;
    private List<Spell> spells;
    
    public SpellByLevel() {
    	spells = new ArrayList<>();
    }
}

@Getter
@Setter
@ToString
class Spell {

    private String name;
    private Integer level;
    private Boolean isPrepared;
}

@Getter
@Setter
@ToString
class Clothing {

    private String name;
    private Integer fit;
}

@Getter
@Setter
@ToString
class Armor extends Clothing {

    private Integer armorBonus;
    private Integer armorPenalty;
    private Integer limiteDexterityModifier;
}

@Getter
@Setter
@ToString
class WieldableItem {

    private Shield item;
    private String id;
    private Boolean isWieldedInTheRightHand;
    private Boolean isWieldedInTheLeftHand;
}

@Getter
@Setter
@ToString
class Item {

    private String classification;
    private String name;
    private String hands;
    private String description;
}

@Getter
@Setter
@ToString
class Weapon extends Item {

    private String type;
    private String range;
    private String targets;
    private String damageDie;
    private String damageType;
    private List<String> properties;

    public Weapon() {
        this.properties = new ArrayList<>();
    }
}

@Getter
@Setter
@ToString
class Shield extends Weapon {

	private Integer coverageBonus;
	private Integer armorPenalty;
}
