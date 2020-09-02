package com.mishamba.day2.util.separator;

import com.mishamba.day2.model.Part;
import com.mishamba.day2.model.Sentence;
import com.mishamba.day2.util.exception.UtilException;

import java.util.ArrayList;

public interface Separator {
    ArrayList<Sentence> separateSentences(String text) throws UtilException;
    ArrayList<Part> separateParts(String sentence) throws UtilException;
}
