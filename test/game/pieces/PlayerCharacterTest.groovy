package game.pieces

import org.junit.Test

/**
 * Created by Andy on 3/19/2017.
 */
class PlayerCharacterTest {

    @Test
    void should_create_player_character_with_assigned_armor_class(){
        def p = new PlayerCharacter()
        p.armorClass = 2
        assert p.armorClass == 2
    }

    @Test
    void should_create_player_character_with_paramaters(){
        def p = new PlayerCharacter("Henrick", "Andy", 10, 12)
        assert p.name == "Henrick"
        assert p.armorClass == 10
    }

    @Test
    void should_add_armor_class(){
        def p = new PlayerCharacter("Henrick", "Andy", 10, 12)
        p.addArmorClass(3)
        assert p.armorClass == 13

    }

}
