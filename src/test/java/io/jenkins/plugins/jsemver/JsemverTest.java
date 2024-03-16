package io.jenkins.plugins.jsemver;

import hudson.model.Result;
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.model.Statement;
import org.jvnet.hudson.test.RestartableJenkinsRule;

public class JsemverTest {

    @Rule
    public RestartableJenkinsRule story = new RestartableJenkinsRule();

    @Test
    public void verifyJsemverMethodsAvalible() {
        story.addStep(new Statement() {
            @Override public void evaluate() throws Throwable {

                WorkflowJob p = story.j.jenkins.createProject(WorkflowJob.class, "p");
                p.setDefinition(new CpsFlowDefinition(
                      "def v1 = semver.of(1, 2, 3, 'rc.1', 'build.1');\n" +
                      "echo \"Hello $v1\"\n",true));

                WorkflowRun b1 = p.scheduleBuild2(0).waitForStart();
                story.j.assertBuildStatus(Result.SUCCESS, story.j.waitForCompletion(b1));
            }
        });
    }
}
