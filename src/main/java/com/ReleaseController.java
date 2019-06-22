package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class ReleaseController {

    @GetMapping(value = "/release")
    public Release getHerokuReleaseVersion() {
        String releaseVersion = coalesce(System.getenv("HEROKU_RELEASE_VERSION"),
                "vX");
        String releaseTimestamp = coalesce(System.getenv("HEROKU_RELEASE_CREATED_AT"),
                "1970-01-01T00:00:00Z");

        return new Release(releaseVersion, releaseTimestamp);
    }

    private String coalesce(String a, String b) {
        if (a != null) {
            return a;
        }

        return b;
    }

    class Release {
        private String version;
        private String timestamp;

        Release(String version, String timestamp) {
            this.version = version;
            this.timestamp = timestamp;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
