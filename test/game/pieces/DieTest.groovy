package game.pieces
import org.junit.Test

class DieTest{

    @Test
    void should_create_die(){
        assert new Die()
    }

    @Test
    void should_return_faces(){
        def d8 = new Die(8)
        assert d8.faces == 8
    }

    @Test
    void should_default_to_d6(){
        def d6 = new Die()
        assert d6.faces == 6
    }

    @Test
    void should_roll_die(){
        def die = new Die(6)
        def possibleResults = [1,2,3,4,5,6]
        (1..100).each(){
            assert possibleResults.contains(die.roll())
        }
    }

}