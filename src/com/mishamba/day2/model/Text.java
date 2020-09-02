package com.mishamba.day2.model;

import java.util.ArrayList;

public class Text {
    private ArrayList<Sentence> sentences;

    public Text(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
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

        Text text = (Text) o;
        return getSentences().equals(text.getSentences());
    }

    @Override
    public int hashCode() {
        int prime = 26;
        int hash = 0;
        for (Sentence sentence : sentences) {
            hash += sentence.hashCode() * prime;
        }

        return hash;
    }
}
