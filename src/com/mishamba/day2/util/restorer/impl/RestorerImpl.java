package com.mishamba.day2.util.restorer.impl;

import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.util.exception.UtilException;
import com.mishamba.day2.util.restorer.Restorer;
import org.apache.log4j.Logger;

public class RestorerImpl implements Restorer {
    private final Logger logger = Logger.getRootLogger();

    private RestorerImpl() {
    }

    private static class RestorerImplHandler {
        private static final RestorerImpl HANDLER_INSTANCE = new RestorerImpl();
    }

    public static RestorerImpl getInstance() {
        return RestorerImplHandler.HANDLER_INSTANCE;
    }

    @Override
    public String restore(CustomText text) throws UtilException {
        if (text == null) {
            logger.error("util.restore: given text is null");
            throw new UtilException("text is null");
        }

        StringBuilder restoredText = new StringBuilder();
        for (Sentence sentence : text.getSentences()) {
            for (Part part : sentence.getParts()) {
                restoredText.append(part.getLexeme());
            }
        }

        return restoredText.toString();
    }
}
