package com.mishamba.day2.util.parser.impl;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.util.exception.UtilException;
import com.mishamba.day2.util.factory.impl.PartsFactoryImpl;
import com.mishamba.day2.util.parser.SentencePartParser;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencePartParserImpl implements SentencePartParser {
    private static final Logger logger = Logger.getRootLogger();
    // TODO: 9/2/20 sentence regex
    private static final String SENTENCE_REGEX = "(?<=[\\W])[а-яА-Яё\\s-\\w,'\"]+[.?!\\n]";
    private static final String PART_REGEX = "[\\w+-]+|!|,|\\.";

    private SentencePartParserImpl() {
    }

    public static class SeparatorImplFactory {
        private SeparatorImplFactory() {
        }

        @Contract(value = " -> new", pure = true)
        public static @NotNull SentencePartParserImpl createSeparator() {
            return new SentencePartParserImpl();
        }
    }

    @Override
    public ArrayList<Sentence> separateSentences(String text) throws UtilException {
        if (text == null) {
            logger.error("util.separator.separateSentence: given text is null");
            throw new UtilException("no text given");
        }

        ArrayList<Sentence> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        for (int i = 0; i < matcher.groupCount(); i++) {
            logger.info("util.separator.separateSentence: getting the sentence");
            String sentence = matcher.group(i);
            logger.info("going to separate sentence on parts");
            ArrayList<Part> parts = separateParts(sentence);
            sentences.add(new Sentence(parts));
        }

        return sentences;
    }

    @Override
    public ArrayList<Part> separateParts(String sentence) throws UtilException {
        if (sentence == null) {
            logger.error("util.separator.separateParts: given sentence is null");
            throw new UtilException("no sentence given");
        }

        ArrayList<Part> parts = new ArrayList<>();
        Pattern pattern = Pattern.compile(PART_REGEX);
        Matcher matcher = pattern.matcher(sentence);
        for (int i = 0; i< matcher.groupCount(); i++) {
            String part = matcher.group(i);
            logger.info("util.separator.separateParts: got part");
            parts.add(PartsFactoryImpl.getInstance().createSentencePart(part));
        }

        return parts;
    }
}
