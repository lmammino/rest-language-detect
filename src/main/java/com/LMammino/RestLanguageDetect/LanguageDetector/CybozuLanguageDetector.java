package com.LMammino.RestLanguageDetect.LanguageDetector;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

public class CybozuLanguageDetector implements LanguageDetector {

    @Override
    public String detectLanguage(String text) {
        try {
            Detector detector = DetectorFactory.create();
            detector.append(text);

            return detector.detect();
        } catch (LangDetectException e) {
            e.printStackTrace();
        }

        return null;
    }
}
