package cafe;
import java.util.ArrayList;

public class CafeUtil {
    
    int getStreakGoal(){
        int sum = 0; 
        for (int i = 1; i < 11;i++){
            sum += 1; 
        }
        return sum;
        }
    double getOrderTotal(double[]prices){
        double sum = 0;
        for (int i = 0; i < prices.length; i++){
            sum += prices[i];
        }
        return sum;
    }
    void displayMenu(ArrayList<String>menuItems){
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println(menuItems.get(i));
        }
    }

    void addCustomer(ArrayList<String>customer){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello $s there are $d people ahead of you",userName,customer.size());
        customer.add(userName);
    }
    

    




}