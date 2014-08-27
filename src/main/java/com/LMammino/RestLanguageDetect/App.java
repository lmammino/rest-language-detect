package com.LMammino.RestLanguageDetect;

import com.LMammino.RestLanguageDetect.LanguageDetector.CybozuLanguageDetector;
import com.LMammino.RestLanguageDetect.Route.DetectLanguageRoute;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import spark.Spark;

import java.net.URISyntaxException;

public class App
{
    public static void main( String[] args ) throws LangDetectException, URISyntaxException {

        int port = 8811;
        String host = "localhost";

        if (args.length == 0) {
            System.err.println("Usage: `java -jar <file>.jar <profilesPath> [port] [host]`");
            throw new RuntimeException("Missing profiles path folder! provide it as first parameter");
        }

        String profilesPath = args[0];

        if (args.length > 1) {
            port = Integer.valueOf(args[1]);
        }

        if (args.length > 2) {
            host = args[2];
        }

        System.out.println("Loading profiles data from: " + profilesPath);

        DetectorFactory.loadProfile(profilesPath);

        Spark.setPort(port);
        Spark.setIpAddress(host);
        Spark.post("/", new DetectLanguageRoute(new CybozuLanguageDetector()));
    }
}
