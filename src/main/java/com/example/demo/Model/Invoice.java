package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {
    @Id
    private int invoice_id;
    private int order_id;

    public Invoice(){
    }

    public Invoice(int invoice_id, int order_id){
        this.invoice_id = invoice_id;
        this.order_id = order_id;
    }

    public int getInvoice_id() { return invoice_id; }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
