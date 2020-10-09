package com.naveen.spring.springboot.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @Column(name="CUSTOMER_NO")
        // @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerNo;

    @Column(name="NAME")
    private String name;

    @Column(name="ACCOUNT_NO")
    private long accountNo;

    public long getAccountNo() {
        return accountNo;
    }
    public long getCustomerNo() {
        return customerNo;
    }
    public String getName() {
        return name;
    }
    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }
    public void setCustomerNo(long customerNo) {
        this.customerNo = customerNo;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}
