# Java Test

[![License](https://img.shields.io/github/license/mabrarov/java_yatest)](https://github.com/mabrarov/java_yatest/tree/master/LICENSE)
[![Travis CI build status](https://travis-ci.org/mabrarov/java_yatest.svg?branch=master)](https://travis-ci.org/mabrarov/java_yatest)
[![AppVeyor CI build status](https://ci.appveyor.com/api/projects/status/t24dxibxfm259dfi/branch/master?svg=true)](https://ci.appveyor.com/project/mabrarov/java-yatest/branch/master)
[![Code coverage status](https://codecov.io/gh/mabrarov/java_yatest/branch/master/graph/badge.svg)](https://codecov.io/gh/mabrarov/java_yatest/branch/master)

Transforms text consisting of A-Z characters from text like:

```text
AABBBBCCAAARRRTMMMN
```

to text like:

```text
A2B4C2A3R3TM3N
```

## Building

### Requirements

1. JDK 1.8+

## Steps

Build with [Maven Wrapper](https://github.com/takari/maven-wrapper):

```bash
./mvnw clean package
```

or on Windows:

```cmd
mvnw.cmd clean package
```

## Usage

```bash
java -jar target/yatest-0.0.1-SNAPSHOT.jar AABBBBCCAAARRRTMMMN
```

Expected output:

```text
AABBBBCCAAARRRTMMMN
A2B4C2A3R3TM3N
```
