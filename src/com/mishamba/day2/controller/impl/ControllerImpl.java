package com.mishamba.day2.controller.impl;

import com.mishamba.day2.controller.Controller;
import com.mishamba.day2.controller.exception.ControllerException;
import com.mishamba.day2.model.CustomText;
import com.mishamba.day2.service.exception.ServiceException;
import com.mishamba.day2.service.impl.SentenceServiceImpl;
import org.apache.log4j.Logger;

public class ControllerImpl implements Controller {
    private static final Logger logger = Logger.getRootLogger();

    private ControllerImpl() {
    }

    private static class ControllerImplHolder {
        private static final ControllerImpl HOLDER_INSTANCE = new ControllerImpl();
    }

    public static ControllerImpl getInstance() {
        return ControllerImplHolder.HOLDER_INSTANCE;
    }

    @Override
    public CustomText splitText(String text) throws ControllerException {
        try {
            logger.info("controller: got text to split");
            return SentenceServiceImpl.getInstance().splitText(text);
        } catch (ServiceException exception) {
            throw new ControllerException(exception);
        }
    }
}
