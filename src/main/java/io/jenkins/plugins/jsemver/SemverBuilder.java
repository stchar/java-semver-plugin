/** This class is just a wrapper to whitelist  com.github.zafarkhaja.semver.Version methods */

package io.jenkins.plugins.jsemver;

import com.github.zafarkhaja.semver.Version;

import java.io.Serializable;

public class SemverBuilder extends Version.Builder implements Serializable {

    public SemverBuilder() {
        super();
    }

    public SemverBuilder(String normal) {
        super(normal);
    }

}
