package com.mishamba.day2.util.separator.impl;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.util.exception.UtilException;
import com.mishamba.day2.util.factory.impl.PartsFactoryImpl;
import com.mishamba.day2.util.separator.Separator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorImpl implements Separator {
    // TODO: 9/2/20 sentence regex
    private static final String SENTENCE_REGEX = "(?<=[\\W])[а-яА-Яё\\s-\\w\\,]+[\\.\\?\\!\\n]";
    // TODO: 9/2/20 part regex
    private static final String PART_REGEX = "";

    private SeparatorImpl() {
    }

    public static class SeparatorImplFactory {
        @Contract(value = " -> new", pure = true)
        public static @NotNull SeparatorImpl createSeparator() {
            return new SeparatorImpl();
        }
    }

    @Override
    public ArrayList<Sentence> separateSentences(String text) throws UtilException {
        if (text == null) {
            throw new UtilException("no text ");
        }

        ArrayList<Sentence> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        for (int i = 0; i < matcher.groupCount(); i++) {
            String sentence = matcher.group(i);
            ArrayList<Part> parts = separateParts(sentence);
            sentences.add(new Sentence(parts));
        }

        return sentences;
    }

    @Override
    public ArrayList<Part> separateParts(String sentence) throws UtilException {
        if (sentence == null) {
            throw new UtilException("no sentence given");
        }

        ArrayList<Part> parts = new ArrayList<>();
        Pattern pattern = Pattern.compile(PART_REGEX);
        Matcher matcher = pattern.matcher(sentence);
        for (int i = 0; i< matcher.groupCount(); i++) {
            String part = matcher.group(i);
            parts.add(PartsFactoryImpl.getInstance().createSentencePart(part));
        }

        return parts;
    }
}
