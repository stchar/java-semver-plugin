/** This class is just a wrapper to whitelist com.github.zafarkhaja.semver.Version methods */

import hudson.Extension;
import org.jenkinsci.plugins.scriptsecurity.sandbox.Whitelist;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.ProxyWhitelist;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.StaticWhitelist;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

@Extension
public class SemverWhitelist extends Whitelist {

    private final Whitelist delegate;

    public SemverWhitelist() throws IOException {
        // Load the custom whitelist from the text file
        delegate = new ProxyWhitelist(StaticWhitelist.from(getClass().getResource("jsemver-whitelist.txt")));
    }

    @Override
    public boolean permitsMethod(Method method, Object receiver, Object[] args) {
        return delegate.permitsMethod(method, receiver, args);
    }

    @Override
    public boolean permitsConstructor(Constructor<?> constructor, Object[] args) {
        return delegate.permitsConstructor(constructor, args);
    }

    @Override
    public boolean permitsStaticMethod(Method method, Object[] args) {
        return delegate.permitsStaticMethod(method, args);
    }

    @Override
    public boolean permitsFieldGet(Field field, Object receiver) {
        return delegate.permitsFieldGet(field, receiver);
    }

    @Override
    public boolean permitsFieldSet(Field field, Object receiver, Object value) {
        return delegate.permitsFieldSet(field, receiver, value);
    }

    @Override
    public boolean permitsStaticFieldGet(Field field) {
        return delegate.permitsStaticFieldGet(field);
    }

    @Override
    public boolean permitsStaticFieldSet(Field field, Object value) {
        return delegate.permitsStaticFieldSet(field, value);
    }
}
