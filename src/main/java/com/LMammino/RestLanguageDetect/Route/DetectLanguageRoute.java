package com.LMammino.RestLanguageDetect.Route;

import com.LMammino.RestLanguageDetect.LanguageDetector.LanguageDetector;
import spark.Request;
import spark.Response;
import spark.Route;

public class DetectLanguageRoute implements Route
{
    protected LanguageDetector detector;

    public DetectLanguageRoute(LanguageDetector detector)
    {
        this.detector = detector;
    }

    @Override
    public Object handle(Request request, Response response) {
        String text = request.body();
        if (text.isEmpty()) {
            response.status(400);
            return "Bad Request. Must provide some text within the request body";
        }

        return detector.detectLanguage(text);
    }
}
