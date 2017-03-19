package game.pieces

class Die {

    def faces
    private static Random rand

    /**
     * Die class makes a new playing die and allows you to roll and get a random
     * generated number between 1 and the faces of the die
     * @param faces is the number of faces on the die you wish to construct
     */
    Die(faces = 6){
        this.faces = faces
        rand = new Random(System.currentTimeMillis())
    }

    /**
     * Rolls your die and returns the result
     */
    static roll(){
        def randomNumber = (rand.nextInt() % 6)
        def positiveNumber = randomNumber > 0 ? randomNumber : randomNumber * -1
        return positiveNumber + 1
    }
}