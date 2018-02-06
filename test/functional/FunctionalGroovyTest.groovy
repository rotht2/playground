package functional

import org.junit.Before

class FunctionalGroovyTest extends GroovyTestCase {

    List shortCuts

    @Before
    void setup(){
        shortCuts = new ArrayList()
        shortCuts.add(new Shortcut('copy','control', 'c'))
        shortCuts.add(new Shortcut('paste','control', 'v'))
        shortCuts.add(new Shortcut('cut','control', 'x'))
        shortCuts.add(new Shortcut('save','control', 's'))
        shortCuts.add(new Shortcut('duplicate line in intellij','control', 'd'))
        shortCuts.add(new Shortcut('convert Java file to Kotlin','control', 'shift', 'alt', 'k'))
    }
}
