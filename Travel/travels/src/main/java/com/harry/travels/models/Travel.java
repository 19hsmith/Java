package com.harry.travels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="travel")
public class Travel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=1, message="must include expense")
    private String expense;

    @NotBlank
    @Size(min=1, message="must include a vendor")
    private String vendor;

    
    private Double amount;

    @NotBlank
    @Size(min=1, message="must include a description")
    private String description;

    public Travel() {

    }

    public Travel(String expense, String vendor, Double amount, String description){
        this.expense = expense;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    //==============SETS AND GETS==========================//

    public String getExpense(){
        return this.expense;
    }
    public void setExpense(String expense){
        this.expense = expense;
    }
    public String getVendor(){
        return this.vendor;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public Double getAmount(){
        return this.amount;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }


}
