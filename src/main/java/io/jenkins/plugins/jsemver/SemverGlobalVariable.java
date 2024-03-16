package io.jenkins.plugins.jsemver;

import hudson.Extension;
import edu.umd.cs.findbugs.annotations.NonNull;
import org.jenkinsci.plugins.workflow.cps.GlobalVariable;
import org.jenkinsci.plugins.workflow.cps.CpsScript;


import com.github.zafarkhaja.semver.Version;


@Extension public class SemverGlobalVariable extends GlobalVariable {
    private Class semver = Version.class;

    @NonNull
    @Override public String getName() {
        return "semver";
    }

    @NonNull
    @Override
    public Object getValue(CpsScript script) throws Exception {
        if(!script.getBinding().hasVariable(getName())) {
            script.getBinding().setVariable(getName(), this.semver);
        }
        return this.semver;
    }
}
