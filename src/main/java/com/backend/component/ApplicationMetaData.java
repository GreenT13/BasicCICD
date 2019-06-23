package com.backend.component;

import org.springframework.stereotype.Controller;

@Controller
public class ApplicationMetaData {

    public String getReleaseVersion() {
        return coalesce(System.getenv("HEROKU_RELEASE_VERSION"), "vX");
    }

    public String getReleaseTimestamp() {
        return coalesce(System.getenv("HEROKU_RELEASE_CREATED_AT"),"1970-01-01T00:00:00Z");

    }

    private String coalesce(String a, String b) {
        if (a != null) {
            return a;
        }

        return b;
    }

}
