<!--
    Copyright (C) 2016 Gary Gregory. All rights reserved.

    See the NOTICE.txt file distributed with this work for additional
    information regarding copyright ownership.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
-->
![jcommander-addons](https://github.com/garydgregory/jcommander-addons/raw/master/src/site/resources/images/logo.png "jcommander-addons")

[JCommander](http://jcommander.org/) is a small Java framework that makes it simple to parse command line parameters.

The goal of the JCommander-Addons project is to provide any and all [JCommander](http://jcommander.org/) 
converters and validators an advanced applications will need.

Feel free to submit a pull-request and examine the [sources](https://github.com/garydgregory/jcommander-addons) and 
[build site](https://garydgregory.github.io/jcommander-addons/README.html).

[![Build Status](https://travis-ci.org/garydgregory/jcommander-addons.svg?branch=master)](https://travis-ci.org/garydgregory/jcommander-addons)
[![Build status](https://ci.appveyor.com/api/projects/status/1faiwut5808fcndo?svg=true)](https://ci.appveyor.com/project/garydgregory/jcommander-addons)
[![Coverage Status](https://coveralls.io/repos/github/garydgregory/jcommander-addons/badge.svg?branch=master)](https://coveralls.io/github/garydgregory/jcommander-addons?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons)

## Examples

To convert a command line argument into a ```Duration``` object, you write:

```
@Parameter(names = { "--duration" }, converter = DurationConverter.class)
private Duration duration;
```

Here is a complete program using a ```LocalDate```:

```
package com.garygregory.jcommander.examples;

import java.time.LocalDate;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.garygregory.jcommander.converters.time.LocalDateConverter;

public class SimpleExample {

    @Parameter(
      names = { "--dob", "-d" }, 
      converter = LocalDateConverter.class, 
      required = true, 
      description = "Birthday in the format YYYY-MM-DD, for example 2007-12-03")
    LocalDate localDate;

    public static void main(String... args) {
        SimpleExample main = new SimpleExample();
        new JCommander(main, args);
        main.run();
    }

    public void run() {
        System.out.printf("You were born on a %s.", localDate.getDayOfWeek());
    }

}
```

## Converters 
Our Converters include:

### Crypto Converters

- [CipherConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/crypto/CipherConverter.html)
- [ExemptionMechanismConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/crypto/ExemptionMechanismConverter.html)
- [KeyAgreementConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/crypto/KeyAgreementConverter.html)
- [KeyGeneratorConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/crypto/KeyGeneratorConverter.html)
- [MacConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/crypto/MacConverter.html)
- [SecretKeyFactoryConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/crypto/SecretKeyFactoryConverter.html)

### Lang  Converters
- [ClassConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/lang/ClassConverter.html)

### Math Converters

- [BigDecimalConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/math/BigDecimalConverter.html)
- [BigIntegerConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/math/BigIntegerConverter.html)

### Net Converters

- [NetworkInterfaceIndexConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/net/NetworkInterfaceIndexConverter.html)
- [NetworkInterfaceNameConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/net/NetworkInterfaceNameConverter.html)
- [URIConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/net/URIConverter.html)
- [URLConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/net/URLConverter.html)

### Net SSL Converters

- [KeyManagerFactoryConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/net/ssl/KeyManagerFactoryConverter.html)
- [TrustManagerFactoryConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/net/ssl/TrustManagerFactoryConverter.html)

### NIO Converters

- [ByteOrderConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/nio/ByteOrderConverter.html)
- [CharsetConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/nio/charset/CharsetConverter.html)
- [PosixFilePermissionSetConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/nio/file/attribute/PosixFilePermissionSetConverter.html)

### Security Converters

- [AlgorithmParameterGeneratorConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/AlgorithmParameterGeneratorConverter.html)
- [AlgorithmParametersConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/AlgorithmParametersConverter.html)
- [KeyFactoryConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/KeyFactoryConverter.html)
- [KeyPairGeneratorConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/KeyPairGeneratorConverter.html)
- [KeyStoreConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/KeyStoreConverter.html)
- [MessageDigestConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/MessageDigestConverter.html)
- [ProviderConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/ProviderConverter.html)
- [SecureRandomConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/SecureRandomConverter.html)
- [SignatureConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/SignatureConverter.html)

### Security Certificate Converters

- [CertificateFactoryConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/cert/CertificateFactoryConverter.html)
- [CertPathValidatorConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/security/cert/CertPathValidatorConverter.html)

### SQL Converters
 
- [ConnectionConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/ConnectionConverter.html)
- [DateConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/DateConverter.html)
- [DriverConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/DriverConverter.html)
- [TimeConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/TimeConverter.html)
- [TimestampConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/TimestampConverter.html)
- [TypesConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/TypesConverter.html)
- [MicrosoftTypesConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/microsoft/MicrosoftTypesConverter.html)
- [MysqlTypesConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/mysql/MysqlTypesConverter.html)
- [OracleTypesConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/sql/oracle/OracleTypesConverter.html)

### Time Converters

- [DurationConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/DurationConverter.html)
- [InstantConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/InstantConverter.html)
- [LocalDateConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/LocalDateConverter.html)
- [LocalDateTimeConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/LocalDateTimeConverter.html)
- [LocalTimeConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/LocalTimeConverter.html)
- [MonthDayConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/MonthDayConverter.html)
- [OffsetDateTimeConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/OffsetDateTimeConverter.html)
- [OffsetTimeConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/OffsetTimeConverter.html)
- [PeriodConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/PeriodConverter.html)
- [YearConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/YearConverter.html)
- [YearMonthConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/YearMonthConverter.html)
- [ZonedDateTimeConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/ZonedDateTimeConverter.html)
- [ZoneIdConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/ZoneIdConverter.html)
- [ZoneOffsetConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/time/ZoneOffsetConverter.html)

### Util Converters

- [CurrencyConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/util/CurrencyConverter.html)
- [LocaleConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/util/LocaleConverter.html)
- [TimeZoneConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/util/TimeZoneConverter.html)
- [UUIDConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/util/UUIDConverter.html)

### XML Converters

- [DurationConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/xml/datatype/DurationConverter.html)
- [QNameConverter](https://garydgregory.github.io/jcommander-addons/apidocs/com/garygregory/jcommander/converters/xml/namespace/QNameConverter.html) 

## Status

[![Build Status](https://travis-ci.org/garydgregory/jcommander-addons.svg?branch=master)](https://travis-ci.org/garydgregory/jcommander-addons)
[![Coverage Status](https://coveralls.io/repos/github/garydgregory/jcommander-addons/badge.svg?branch=master)](https://coveralls.io/github/garydgregory/jcommander-addons?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons)

## Building

The site is generated in `target/docs` and manually copied to the `docs` folder for publication to GitHub Pages at 
[https://garydgregory.github.io/jcommander-addons](https://garydgregory.github.io/jcommander-addons). 

To generate the site run:

```mvn clean site site:stage -DstagingDirectory=target/docs```

## Versioning

This project follows [Semantic Versioning](http://semver.org/).