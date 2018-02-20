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
    // fold/reduce = inject

    def square = { number -> number * number}

    def squareIt = {it * it}

    def add = {x, y -> x + y}

    def addWithTypes = {int x, int y -> x + y}

    static List<Shortcut> sortByNumberOfKeys(List<Shortcut> shortcutList){
        shortcutList.sort({ it.keys.size() })
    }

    static List<Shortcut> findShortCutContainingKey(List<Shortcut> shortcutList, String key) {
        shortcutList.findAll({ it.keys.contains(key)})
    }

    // TODO pass closure to method
    static List methodWithClosureParam(Closure closure, List shortCuts){
        closure(shortCuts)
    }

    static def calculateAvgIterativelyish(List<Integer> listOfGrades) {
        def sum = 0
        listOfGrades.each { grade ->
            sum += grade
        }
        return sum/listOfGrades.size()
    }

    static def calculateAvgWithInject(List<Integer> listOfGrades) {
        listOfGrades.inject {acc, val -> acc + val } / listOfGrades.size()
    }

    static def calculateAvgIteratively(List<Integer> listOfGrades){
        def sum = 0
        for(Integer grade : listOfGrades){
            sum += grade
        }
        return sum/listOfGrades.size()
    }

    static List collectWhatItDos(List<Shortcut> list) {
        list.collect( { it.whatItDoes } )
    }

    def calculateAvgIterativelyishWithNewGrade(List<Integer> listOfGrades, int gradeToInject) {

    }

    def calculateAvgWithInjectWithNewGrade(List<Integer> listOfGrades, int gradeToInject) {

    }

    def calculateAvgIterativelyWithNewGrade(List<Integer> listOfGrades, int gradeToInject) {

    }
}
