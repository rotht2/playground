package functional

import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class FunctionalGroovyTest {

    List shortCuts
    FunctionalGroovy functionalGroovy

    @Before
    void setup(){
        functionalGroovy = new FunctionalGroovy()
        shortCuts = new ArrayList()
        shortCuts.add(new Shortcut('convert Java file to Kotlin','control', 'shift', 'alt', 'k'))
        shortCuts.add(new Shortcut('copy','control', 'c'))
        shortCuts.add(new Shortcut('paste','control', 'v'))
        shortCuts.add(new Shortcut('cut','control', 'x'))
        shortCuts.add(new Shortcut('save','control', 's'))
        shortCuts.add(new Shortcut('duplicate line in intellij','control', 'd'))
    }

    @Test
    void squaresTwoNumbers(){
        assert functionalGroovy.square(4) == 16
        assert functionalGroovy.squareIt(4) == 16
    }

    @Ignore("Fails because there is no * operator for string")
    @Test
    void takesTheSquareRootOfTwoNonNumbers(){
        assert functionalGroovy.square("A") == 16
        assert functionalGroovy.squareIt("a") == 16
    }

    @Test
    void addsStuff(){
        assert functionalGroovy.add(1,2) == 3
        assert functionalGroovy.add("x", "y") == "xy"
    }

    @Test
    void addWithTypes(){
        assert functionalGroovy.addWithTypes(1,2) == 3
        // Uncomment to see the types not match up.. Because I provided types in the lambda declaration
//        assert functionalGroovy.addWithTypes("x", "y") == "xy"
    }

    @Test
    void sortStuff(){
        functionalGroovy.sortByNumberOfKeys(shortCuts)
    }

    @Test
    void findstuff(){
        println(functionalGroovy.findShortCutContainingKey(shortCuts, "c"))
    }

    @Test
    void injectStuff(){
//        shortCuts.inject()
        println(shortCuts)
    }



}
