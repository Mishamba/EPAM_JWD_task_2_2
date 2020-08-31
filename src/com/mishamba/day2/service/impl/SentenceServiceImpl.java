package com.mishamba.day2.service.impl;

import com.mishamba.day2.service.SentenceService;

public class SentenceServiceImpl implements SentenceService {

    public static class SentenceServiceImplHolder {
        private SentenceServiceImplHolder() {
        }

        private static final SentenceServiceImpl HOLDER_INSTANCE = new SentenceServiceImpl();
    }

    public static SentenceServiceImpl getInstance() {
        return SentenceServiceImplHolder.HOLDER_INSTANCE;
    }

    @Override
    public void splitText(String text) {

    }

    @Override
    public String recreateText() {
        return null;
    }
}
