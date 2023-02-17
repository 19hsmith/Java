public class Mammal {
    private int energy = 100;

    public int displayEnergy(){
        System.out.println(this.energy);
        return this.energy;
    }
    
    public int totalEnergy(){
        return this.energy;
    }
    
    public void setUseEnergy(int use){
        this.energy -= use;
    }

    public void setRegainEnergy(int regain){
        this.energy += regain;
    }
}
