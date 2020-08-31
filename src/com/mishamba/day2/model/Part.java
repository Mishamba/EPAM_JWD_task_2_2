package com.mishamba.day2.model;

public class Part {
    private String lexeme;
    private WordType wordType;

    public Part(String lexeme, WordType wordType) {
        this.lexeme = lexeme;
        this.wordType = wordType;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Part part = (Part) o;
        return getLexeme().equals(part.getLexeme()) &&
                getWordType() == part.getWordType();
    }

    @Override
    public int hashCode() {
        return lexeme.hashCode() * 36;
    }
}
