package org.redcabbage.garden.model;

import javax.persistence.*;

@Entity
public class Bed {
    private int id;
    private String name;
    private GardenLocation frontOrBack;

    public Bed(int id, String name, GardenLocation frontOrBack) {
        this.id = id;
        this.name = name;
        this.frontOrBack = frontOrBack;
    }

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public GardenLocation getFrontOrBack() {
        return frontOrBack;
    }

    public void setFrontOrBack(GardenLocation frontOrBack) {
        this.frontOrBack = frontOrBack;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frontOrBack=" + frontOrBack +
                '}';
    }

    public enum GardenLocation {
        front,
        back
    }
}
