package com.imt.event.Model.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "locationTable")
public class LocationEntity {

    @Id
    private int id;
    @Column
    private String address;
    @Column
    private int capacity;

    public LocationEntity() {
        super();
    }

    public LocationEntity(int id, String address, int capacity) {
        this.id = id;
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LocationEntity that = (LocationEntity) o;
        return id == that.id && capacity == that.capacity && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, capacity);
    }
}

