package functional

class FunctionalGroovy {

    // TODO Metaclass out findAll, collect, and inject to rename them to Fiter map fold
    /*
        filter :
        map :
        fold :
     */
    // Filter = findAll
    // map = collect
    // fold = inject

    def square = { number -> number * number}

    def squareIt = {it * it}

    def add = {x, y -> x + y}

    def addWithTypes = {int x, int y -> x + y}

    def sortByNumberOfKeys(List<Shortcut> shortcutList){
        // This sorts a collection of things returned by it.keys.size. In our example this is the number of keys in the shortcut
        println(shortcutList.collect{ it.keys.size() }.sort())

        // This sorts the actual shortcut objects by the number of keys in the short cut.
        println(shortcutList.sort({ it.keys.size() }))
    }

    List<Shortcut> findShortCutContainingKey(List<Shortcut> shortcutList, String key) {
        shortcutList.findAll({ it.keys.contains(key)})
    }

    //TODO inject
    void injectShortCut(Shortcut shortcut){

    }

    // TODO pass closure to method
    void methodWithClosureParam(Closure closure){
        closure()
    }

    // TODO call the meta classed methods ( with the common functional names )
    void sameExamplesAsAboveWithConventionalFuntionalNames(List<Shortcut> shortcuts){

    }
}
