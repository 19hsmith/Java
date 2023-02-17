public class Gorilla extends Mammal{
    public void Throw(){
        System.out.println("The gorilla threw a brick at you!");
        this.setUseEnergy(5);
    }
    public void eatBanana(){
        System.out.println("The gorilla is pleased");
        this.setRegainEnergy(10);
    }
    public void climb(){
        System.out.println("The gorilla is climbing!");
        this.setUseEnergy(10);
    }
}
