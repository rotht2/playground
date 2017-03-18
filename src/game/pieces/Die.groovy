package game.pieces

class Die {

    def faces
    private static Random rand
    Die(faces){
        this.faces = faces
        rand = new Random(System.currentTimeMillis())
    }

    static roll(){
        def randomNumber = (rand.nextInt() % 6)
        def positiveNumber = randomNumber > 0 ? randomNumber : randomNumber * -1
        return positiveNumber + 1
    }
}