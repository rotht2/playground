package functional

class FunctionalGroovy {

    // Filter = findAll
    // map = collect
    // fold/reduce = inject

    static def square = { number -> number * number}

    static def squareIt = {it * it}

    static def add = {x, y -> x + y}

    static def addWithTypes = {int x, int y -> x + y}

    static List<Shortcut> sortByNumberOfKeys(List<Shortcut> shortcutList){
        shortcutList.sort({ it.keys.size() })
    }

    static List<Shortcut> findShortCutContainingKey(List<Shortcut> shortcutList, String key) {
        shortcutList.findAll({ it.keys.contains(key)})
    }

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

    static def calculateAvgIterativelyishWithNewGrade(List<Integer> listOfGrades, int gradeToInject) {
        def sum = 0
        listOfGrades.add(gradeToInject)
        listOfGrades.each { grade ->
            sum += grade
        }
        return sum/listOfGrades.size()
    }

    static def calculateAvgWithInjectWithNewGrade(List<Integer> listOfGrades, int gradeToInject) {
        listOfGrades.inject(gradeToInject){acc, val -> acc + val } / (listOfGrades.size() + 1)
    }

    static def calculateAvgIterativelyWithNewGrade(List<Integer> listOfGrades, int gradeToInject) {
        def sum = 0
        listOfGrades.add(gradeToInject)
        for(Integer grade : listOfGrades){
            sum += grade
        }
        return sum/listOfGrades.size()
    }
}
