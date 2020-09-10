package com.mishamba.day2.service.impl;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.service.SentenceService;
import com.mishamba.day2.service.exception.ServiceException;
import com.mishamba.day2.util.exception.UtilException;
import com.mishamba.day2.util.parser.impl.SentencePartParserImpl;
import com.mishamba.day2.util.restorer.impl.RestorerImpl;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class SentenceServiceImpl implements SentenceService {
    private static final Logger logger = Logger.getRootLogger();

    public static class SentenceServiceImplHolder {
        private SentenceServiceImplHolder() {
        }

        private static final SentenceServiceImpl HOLDER_INSTANCE = new SentenceServiceImpl();
    }

    public static SentenceServiceImpl getInstance() {
        return SentenceServiceImplHolder.HOLDER_INSTANCE;
    }

    @Override
    public CustomText splitText(String text) throws ServiceException {
        logger.info("service.splitText: got text to split");
        SentencePartParserImpl separator = SentencePartParserImpl.SeparatorImplFactory.createSeparator();
        try {
            ArrayList<Sentence> sentences = separator.separateSentences(text);
            logger.info("service: separated text");
            return new CustomText(sentences);
        } catch (UtilException exception) {
            logger.error("service: got exception. couldn't separate the sentence");
            throw new ServiceException(exception);
        }
    }

    @Override
    public String recreateText(CustomText text) throws ServiceException {
        try {
            return RestorerImpl.getInstance().restore(text);
        } catch (UtilException exception) {
            logger.error("service.recreateText: got exception. couldn't recreate text");
            throw new ServiceException(exception);
        }
    }

    @Override
    public CustomText sortByWordsCount(String text) throws ServiceException {
        CustomText separatedText = this.splitText(text);
        ArrayList<Sentence> sentences = separatedText.getSentences();
        sentences.sort(Sentence::compareTo);
        return separatedText;
    }

    @Override
    public CustomText deleteWordsStartsWithVowels(String text) throws ServiceException {
        CustomText separatedText = this.splitText(text);
        for (Sentence sentence : separatedText.getSentences()) {
            for (Part part : sentence.getParts()) {
                char firstLetter = part.getLexeme().charAt(0);
                if (firstLetter == 'a' || firstLetter == 'e' ||
                        firstLetter == 'y' || firstLetter == 'u' ||
                        firstLetter == 'i' || firstLetter == 'o') {
                    sentence.getParts().remove(part);
                }
            }
        }

        return separatedText;
    }

    @Override
    public String findPalindrome(String text) throws ServiceException {
        if (text == null) {
            logger.error("service.find palindrome: given text is null");
            throw new ServiceException("text is null");
        }
        String largestPalindrome = null;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                StringBuilder substring =
                        new StringBuilder(text.substring(i, j));
                if (substring.equals(substring.reverse()) &&
                        largestPalindrome == null ||
                        largestPalindrome.length() < substring.length()) {
                    largestPalindrome = substring.toString();
                }
            }
        }

        return largestPalindrome;
    }
}
