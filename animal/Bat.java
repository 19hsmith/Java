public class Bat extends Mammal{
    public Bat(){
        this.setRegainEnergy(200);
    }
    public void fly(){
        System.out.println("The bat begins to fly!");
        this.setUseEnergy(50);
    }
    public void eatHumans(){
        System.out.println("The bat consumes human flesh");
        this.setRegainEnergy(25);
    }
    public void attackTown(){
        System.out.println("The bat is attacking the town!");
        this.setUseEnergy(100);
    }
}
