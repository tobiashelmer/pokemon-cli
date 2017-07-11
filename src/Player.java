import java.util.ArrayList;

public class Player {

    private String name;
    ArrayList<Pokemon> team = new ArrayList<>();

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

    /**
     * Get Team
     *
     * @return team as ArrayList
     */
    public ArrayList getTeam() {
        return team;
    }

    /**
     * Set Team
     *
     * @param pokemon as Pokemon
     */

    public void setTeam(Pokemon pokemon) {
        this.team.add(pokemon);
    }


}
