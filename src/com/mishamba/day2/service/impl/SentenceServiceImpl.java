package com.mishamba.day2.service.impl;

import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.model.Text;
import com.mishamba.day2.service.SentenceService;
import com.mishamba.day2.service.exception.ServiceException;
import com.mishamba.day2.util.exception.UtilException;
import com.mishamba.day2.util.separator.impl.SeparatorImpl;

import java.util.ArrayList;

public class SentenceServiceImpl implements SentenceService {

    public static class SentenceServiceImplHolder {
        private SentenceServiceImplHolder() {
        }

        private static final SentenceServiceImpl HOLDER_INSTANCE = new SentenceServiceImpl();
    }

    public static SentenceServiceImpl getInstance() {
        return SentenceServiceImplHolder.HOLDER_INSTANCE;
    }

    // TODO: 9/2/20 save test somewhere
    @Override
    public void splitText(String text) throws ServiceException {
        SeparatorImpl separator = SeparatorImpl.SeparatorImplFactory.createSeparator();
        try {
            ArrayList<Sentence> sentences = separator.separateSentences(text);
            Text separatedText = new Text(sentences);
        } catch (UtilException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public String recreateText() {
        return null;
    }
}
