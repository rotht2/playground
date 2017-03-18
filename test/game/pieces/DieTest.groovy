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
        def d4 = new Die(4)
        def d6 = new Die(6)
        def d10 = new Die(10)
        def d12 = new Die(12)
        assert d8.faces == 8
        assert d4.faces == 4
        assert d6.faces == 6
        assert d10.faces == 10
        assert d12.faces == 12
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