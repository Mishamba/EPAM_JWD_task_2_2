package com.mishamba.day2.service.impl;

import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.service.SentenceService;
import com.mishamba.day2.service.exception.ServiceException;
import com.mishamba.day2.util.exception.UtilException;
import com.mishamba.day2.util.parser.impl.SentencePartParserImpl;
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
        logger.info("service: got text to split");
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
    public String recreateText() {
        return null;
    }
}
