package functional

import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class FunctionalGroovyTest {

    List shortCuts

    @Before
    void setup(){
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
        assert FunctionalGroovy.square(4) == 16
        assert FunctionalGroovy.squareIt(4) == 16
    }

    @Ignore("Fails because there is no * operator for string")
    @Test
    void takesTheSquareRootOfTwoNonNumbers(){
        assert FunctionalGroovy.square("A") == 16
        assert FunctionalGroovy.squareIt("a") == 16
    }

    @Test
    void addsStuff(){
        assert FunctionalGroovy.add(1,2) == 3
        assert FunctionalGroovy.add("x", "y") == "xy"
    }

    @Test
    void addWithTypes(){
        assert FunctionalGroovy.addWithTypes(1,2) == 3
        // Uncomment to see the types not match up.. Because I provided types in the lambda declaration
//        assert functionalGroovy.addWithTypes("x", "y") == "xy"
    }

    @Test
    void collectShortCutListWhatItDos(){
        List<String> whatItDos = new ArrayList()
        shortCuts.each { Shortcut shortcut ->
            whatItDos.add(shortcut.whatItDoes)
        }

        assert whatItDos == FunctionalGroovy.collectWhatItDos(shortCuts)
    }

    @Test
    void sort(){
        List<Shortcut> listToBeSorted = new ArrayList()
        def shortcutKotlin = new Shortcut('convert Java file to Kotlin', 'control', 'shift', 'alt', 'k')
        def shortcutCut = new Shortcut('cut', 'control', 'x')
        def shortcutRightClick = new Shortcut('simulates right click', 'right click key?')
        def shortcutSettings = new Shortcut('load intellij project settings', 'control', 'alt', 's')
        listToBeSorted.add(shortcutKotlin)
        listToBeSorted.add(shortcutCut)
        listToBeSorted.add(shortcutRightClick)
        listToBeSorted.add(shortcutSettings)

        FunctionalGroovy.sortByNumberOfKeys(listToBeSorted)
        assert listToBeSorted.size() == 4
        assert listToBeSorted.indexOf(shortcutRightClick) == 0
        assert listToBeSorted.indexOf(shortcutCut) == 1
        assert listToBeSorted.indexOf(shortcutSettings) == 2
        assert listToBeSorted.indexOf(shortcutKotlin) == 3

        // This sorts a collection of things returned by it.keys.size. In our example this is the number of keys in the shortcut
//        println(shortCuts.collect{ it.keys.size() }.sort())
    }

    @Test
    void find(){
        List<Shortcut> listToFindThings = new ArrayList()
        def shortcutKotlin = new Shortcut('convert Java file to Kotlin', 'control', 'shift', 'alt', 'k')
        def shortcutCut = new Shortcut('cut', 'control', 'x')
        def shortcutRightClick = new Shortcut('simulates right click', 'right click key?')
        def shortcutSettings = new Shortcut('load intellij project settings', 'control', 'alt', 's')
        listToFindThings.add(shortcutKotlin)
        listToFindThings.add(shortcutCut)
        listToFindThings.add(shortcutRightClick)
        listToFindThings.add(shortcutSettings)

        List<Shortcut> foundAllShortcuts = FunctionalGroovy.findShortCutContainingKey(shortCuts, "x")
        assert foundAllShortcuts.size() == 1
        assert foundAllShortcuts.get(0).properties == shortcutCut.properties
//        println(shortcutCut.properties)
    }

    @Test
    void inject(){
        def listOfGrades = [ 90, 80, 100, 75, 89, 95]
        def iterativelyish = FunctionalGroovy.calculateAvgIterativelyish(listOfGrades)
        def injectivly = FunctionalGroovy.calculateAvgWithInject(listOfGrades)
        def iteratively = FunctionalGroovy.calculateAvgIteratively(listOfGrades)
        assert iterativelyish == injectivly
        assert iterativelyish == iteratively
        assert injectivly == iteratively
    }

    @Test
    void injectSomething(){
        def listOfGradesIterativelyish = [ 90, 80, 100, 75, 89, 95]
        def listOfGradesInject = [ 90, 80, 100, 75, 89, 95]
        def listOfGradesIterative = [ 90, 80, 100, 75, 89, 95]
        def iterativelyish = FunctionalGroovy.calculateAvgIterativelyishWithNewGrade(listOfGradesIterativelyish, 85)
        def injectivly = FunctionalGroovy.calculateAvgWithInjectWithNewGrade(listOfGradesInject, 85)
        def iteratively = FunctionalGroovy.calculateAvgIterativelyWithNewGrade(listOfGradesIterative, 85)
        assert iterativelyish == injectivly
        assert iterativelyish == iteratively
        assert injectivly == iteratively
    }

    @Test
    void metaClass(){
        List.metaClass.map = { cls ->
            delegate.collect(cls)
        }
        List.metaClass.filter = { cls ->
            delegate.findAll(cls)
        }

        assert shortCuts.filter( {it.keys.contains('control')}).size() > 0
        assert shortCuts.filter({ it.keys.contains('control') }) == FunctionalGroovy.findShortCutContainingKey(shortCuts, 'control')
        assert shortCuts.map( { it.whatItDoes }) == FunctionalGroovy.collectWhatItDos(shortCuts)
    }

    @Test
    void passClosureToReturnListOfFirstKeys(){
        def closure = { List shortcuts ->
            List<String> firstKeys = new ArrayList()
            shortCuts.each { Shortcut shortcut ->
                firstKeys.add(shortcut.keys.get(0) as String)
            }
            firstKeys
        }
        assert closure(shortCuts) == FunctionalGroovy.methodWithClosureParam(closure, shortCuts)
    }
}
