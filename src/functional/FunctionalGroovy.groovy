package functional

class FunctionalGroovy {

    // Filter = findAll
    // map = collect
    // fold = inject

    def square = { number -> number * number}

    def squareIt = {it * it}

    def add = {x, y -> x + y}

    def addWithTypes = {int x, int y -> x + y}

    def sortByNumberOfKeys(List<Shortcut> shortcutList){
        println(shortcutList.collect{ it.keys.size() }.sort())
    }

}
