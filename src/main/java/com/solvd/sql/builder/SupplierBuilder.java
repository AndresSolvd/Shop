package com.solvd.sql.builder;

import com.solvd.sql.model.Supplier;

public class SupplierBuilder {
    private int id;
    private String supplierName;
    private String taxNumber;
    private String phone;

    public static SupplierBuilder builder() {
        return new SupplierBuilder();
    }

    public SupplierBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SupplierBuilder withSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public SupplierBuilder withTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    public SupplierBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Supplier build() {
        Supplier supplier = new Supplier();
        supplier.setId(this.id);
        supplier.setSupplierName(this.supplierName);
        supplier.setTaxNumber(this.taxNumber);
        supplier.setPhone(this.phone);
        return supplier;
    }
}
