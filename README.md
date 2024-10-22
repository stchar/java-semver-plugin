# java-semver-plugin

## Introduction

This plugin adds [https://github.com/zafarkhaja/jsemver](jsemver) support for pipelines and shared libraries.
It also lets other plugins use jsemver as a dependecy.

## Getting started
The plugin adds `semver` global variable so you can access it in the pipeline as it was `env` object.
```
def v1 = semver.parse("1.2.3-rc.1+build.1");
def v2 = semver.parse("1.2.3-rc.1+build.2");

assert v1.isHigherThan(v2) == false;
```

## Issues
Create github issue if you want to report a bug or suggest a new feature

## Contributing
Refer to jenkinsci [contribution guidelines](https://github.com/jenkinsci/.github/blob/master/CONTRIBUTING.md)

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)

