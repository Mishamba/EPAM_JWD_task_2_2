package com.mishamba.day2.util.factory.impl;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.WordType;
import com.mishamba.day2.util.factory.PartsFactory;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartsFactoryImpl implements PartsFactory {
    private static final Logger logger = Logger.getRootLogger();
    private static final String WORD = "[\\w-']+";

    private PartsFactoryImpl() {
    }

    private static class PartsFactoryImplHandler {
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

        logger.info("partsFactory: created part");

        return new Part(part, wordType);
    }
}
