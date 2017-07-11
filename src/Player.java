public class Player {

    private String name;

    /**
     * Class Constructor
     *
     * @param name as String
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Get Trainer Name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set Trainer name
     *
     * @param name as String
     */
    public void setName(String name) {
        this.name = name;
    }
}
