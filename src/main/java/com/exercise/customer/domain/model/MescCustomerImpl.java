package com.exercise.customer.domain.model;



import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity(name="mescCustomer")
@Table(name = "customer")
public class MescCustomerImpl implements MescCustomer {

    @Id
    @Column(name ="customer_id")
    @GeneratedValue
   private long customerId;

    @NotNull
    @Column(name = "customer_name")
   private String customerName;

    @NotNull
    @Column(name = "customer_contact")
     private String customerContact;


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


    @Override
    public String getName() {
        return this.customerName;
    }

    @Override
    public String getContact() {
        return this.customerContact;
    }


    @Override
    public void setName(String newName) {
        this.customerName = newName;
    }

    @Override
    public void setContact(String newContact) {
        this.customerContact = newContact;
    }
}
