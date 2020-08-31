package com.mishamba.day2.util.factory.impl;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.WordType;
import com.mishamba.day2.util.factory.PartsFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartsFactoryImpl implements PartsFactory {
    private static final String WORD = "[\\w-]+";

    public static class PartsFactoryImplHandler {
        private PartsFactoryImplHandler() {
        }
        private static final PartsFactoryImpl HOLDER_INSTANCE = new PartsFactoryImpl();
    }

    public static PartsFactoryImpl getInstance() {
        return PartsFactoryImplHandler.HOLDER_INSTANCE;
    }

    @Override
    public Part createSentencePart(String part) {
        Pattern pattern = Pattern.compile(WORD);
        Matcher matcher = pattern.matcher(part);

        WordType wordType = (matcher.find()) ? WordType.WORD : WordType.PUNCTUATION_MARK;

        return new Part(part, wordType);
    }
}
