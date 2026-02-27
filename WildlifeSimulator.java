/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    private Species[] species;
    private int speciesCount;
    
    public WildlifeSimulator(int maxSpecies) {
        species = new Species[maxSpecies];
    }
    
    /**
     * Add a species to the simulator
     */
    public void addSpecies(Species s) {
        species[speciesCount++] = s;
    }
    
    /**
     * Simulate one year of population changes for all species
     */
    public void simulateYear() {
        for (int i = 0; i < speciesCount;i++)
            species[i].simulateYear();
    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        for (int i = 0; i < years; i++){
            simulateYear();
        }
    }
    
    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        return species[index];
    }
    
    /**
     * Get species info as formatted string
     */
    public String getSpeciesInfo(int index) {
        return species[index].toString();
    }

    public String toString(){
        String s = "";
        for (Species sp: species){
            if ( sp != null)
                s = sp.toString() + "/n";
        }
        return s;
    }
    
    /**
     * Get total wildlife count across all species
     */
    public double getTotalPopulation() {
        double p = 0;

        for (int i = 0; i < speciesCount; i++){
            p += species[i].getPopulation();
        }

        return p;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        int mp = 0;

        for (int i = 1; i < speciesCount;i++){
            if (species[mp].getPopulationDensity() < species[i].getPopulationDensity()){
                mp = i;
            }
        }
        return mp;
    }
    
    /**
     * Find the species with smallest population (most endangered)
     */
    public int getMostEndangeredIndex() {
        int lp = 0;

        for (int i = 1; i < speciesCount;i++){
            if (species[lp].getPopulationDensity() > species[i].getPopulationDensity()){
                lp = i;
            }
        }
        return lp;
    }
    
    public int getSpeciesCount() {
        return speciesCount;
    }
    
    /**
     * Get array of all species
     */
    public Species[] getSpeciesArray() {
        return species;
    }
}
