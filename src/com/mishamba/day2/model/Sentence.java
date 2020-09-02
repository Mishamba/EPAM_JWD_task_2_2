package com.mishamba.day2.model;

import java.util.ArrayList;

public class Sentence {
    private ArrayList<Part> parts;

    public Sentence(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Sentence sentence = (Sentence) o;
        return getParts().equals(sentence.getParts());
    }

    @Override
    public int hashCode() {
        int prime = 30;
        int hash = 0;
        for (Part part : parts) {
            hash += part.hashCode() * prime;
        }

        return hash;
    }
}
