#!/usr/bin/env bash
set -ev
if [[ -z "$TRAVIS_TAG" && $TRAVIS_COMMIT_MESSAGE == *"[ci release]"* ]]; then
    #Explicitly switch to master to avoid detached HEAD
    git checkout master
    cd binjr
    echo "*** RELEASE ***"
    mvn --batch-mode release:prepare release:perform -Dresume=false --settings "./target/travis/settings.xml" -P binjr-release
else
    cd binjr
    echo "*** SNAPSHOT ***"
    mvn deploy --settings "./target/travis/settings.xml" -P binjr-snapshot
fi