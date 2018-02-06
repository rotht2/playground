package functional

class Shortcut {

    def keys = new ArrayList()
    private whatItDoes

    Shortcut(String whatItDoes, String... s){
        this.whatItDoes = whatItDoes
        s.each { key -> keys.add(key) }
    }

    @Override
    String toString() {
        return "${keys.join(' + ')} : ${whatItDoes}"
    }
}
