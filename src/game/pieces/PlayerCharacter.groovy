package game.pieces

/**
 * Created by Andy on 3/18/2017.
 */

class PlayerCharacter {
    def name; //the players name will be printed in initiative, you can also refer to them with their name when writing commands
    def nickName; //an alternate way to access player with commands
    def armorClass = 1;
    def difficultyClass;

    PlayerCharacter(name, nickName, armorClass, difficultyClass){
        this.name = name
        this.nickName = nickName
        this.armorClass = armorClass
        this.difficultyClass = difficultyClass
    }

    void addArmorClass(value){
        this.armorClass += value;
        return
    }

}
