package functional

import org.junit.Test

class ShortcutTest {

    @Test
    void constructorWorks(){
        // If I were to make "keys" private in Shortcut i could still access it here because of groovy privates
        def shortcut = new Shortcut('copy','control', 'c')
        assert shortcut.keys.size() == 2
    }

    @Test
    void overrideOfToString(){
        def shortcut = new Shortcut( 'copy','control', 'c')
        assert shortcut.toString() == 'control + c : copy'
    }

}
