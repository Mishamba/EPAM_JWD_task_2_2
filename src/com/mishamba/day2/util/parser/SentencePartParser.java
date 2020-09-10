package com.mishamba.day2.util.parser;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.util.exception.UtilException;

import java.util.ArrayList;

public interface SentencePartParser {
    ArrayList<Sentence> separateSentences(String text) throws UtilException;
    ArrayList<Part> separateParts(String sentence) throws UtilException;
}
