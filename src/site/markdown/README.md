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

The goal of the JCommander-Addons project is to provide any and all [JCommander](http://jcommander.org/) 
converters and validators an advanced applications will need.

Feel free to submit a pull-request and examine the [sources](https://github.com/garydgregory/jcommander-addons) and 
[build site](https://garydgregory.github.io/jcommander-addons/).

[![Build Status](https://travis-ci.org/garydgregory/jcommander-addons.svg?branch=master)](https://travis-ci.org/garydgregory/jcommander-addons)
[![Coverage Status](https://coveralls.io/repos/github/garydgregory/jcommander-addons/badge.svg?branch=master)](https://coveralls.io/github/garydgregory/jcommander-addons?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons)

## Converters 
Converters include:

### Crypto Converters

- [CipherConverter](apidocs/com/garygregory/jcommander/converters/crypto/CipherConverter.html)
- [ExemptionMechanismConverter](apidocs/com/garygregory/jcommander/converters/crypto/ExemptionMechanismConverter.html)
- [KeyAgreementConverter](apidocs/com/garygregory/jcommander/converters/crypto/KeyAgreementConverter.html)
- [KeyGeneratorConverter](apidocs/com/garygregory/jcommander/converters/crypto/KeyGeneratorConverter.html)
- [MacConverter](apidocs/com/garygregory/jcommander/converters/crypto/MacConverter.html)
- [SecretKeyFactoryConverter](apidocs/com/garygregory/jcommander/converters/crypto/SecretKeyFactoryConverter.html)

### Lang  Converters
- [ClassConverter](apidocs/com/garygregory/jcommander/converters/lang/ClassConverter.html)

### Math Converters

- [BigDecimalConverter](apidocs/com/garygregory/jcommander/converters/math/BigDecimalConverter.html)
- [BigIntegerConverter](apidocs/com/garygregory/jcommander/converters/math/BigIntegerConverter.html)

### Net Converters

- [NetworkInterfaceIndexConverter](apidocs/com/garygregory/jcommander/converters/net/NetworkInterfaceIndexConverter.html)
- [NetworkInterfaceNameConverter](apidocs/com/garygregory/jcommander/converters/net/NetworkInterfaceNameConverter.html)
- [URIConverter](apidocs/com/garygregory/jcommander/converters/net/URIConverter.html)
- [URLConverter](apidocs/com/garygregory/jcommander/converters/net/URLConverter.html)

### Net SSL Converters

- [KeyManagerFactoryConverter](apidocs/com/garygregory/jcommander/converters/net/ssl/KeyManagerFactoryConverter.html)
- [TrustManagerFactoryConverter](apidocs/com/garygregory/jcommander/converters/net/ssl/TrustManagerFactoryConverter.html)

### NIO Converters

- [ByteOrderConverter](apidocs/com/garygregory/jcommander/converters/nio/ByteOrderConverter.html)
- [CharsetConverter](apidocs/com/garygregory/jcommander/converters/nio/charset/CharsetConverter.html)
- [PosixFilePermissionSetConverter](apidocs/com/garygregory/jcommander/converters/nio/file/attribute/PosixFilePermissionSetConverter.html)

### Security Converters

- [AlgorithmParameterGeneratorConverter](apidocs/com/garygregory/jcommander/converters/security/AlgorithmParameterGeneratorConverter.html)
- [AlgorithmParametersConverter](apidocs/com/garygregory/jcommander/converters/security/AlgorithmParametersConverter.html)
- [KeyFactoryConverter](apidocs/com/garygregory/jcommander/converters/security/KeyFactoryConverter.html)
- [KeyPairGeneratorConverter](apidocs/com/garygregory/jcommander/converters/security/KeyPairGeneratorConverter.html)
- [KeyStoreConverter](apidocs/com/garygregory/jcommander/converters/security/KeyStoreConverter.html)
- [MessageDigestConverter](apidocs/com/garygregory/jcommander/converters/security/MessageDigestConverter.html)
- [ProviderConverter](apidocs/com/garygregory/jcommander/converters/security/ProviderConverter.html)
- [SecureRandomConverter](apidocs/com/garygregory/jcommander/converters/security/SecureRandomConverter.html)
- [SignatureConverter](apidocs/com/garygregory/jcommander/converters/security/SignatureConverter.html)

### Security Certificate Converters

- [CertificateFactoryConverter](apidocs/com/garygregory/jcommander/converters/security/cert/CertificateFactoryConverter.html)
- [CertPathValidatorConverter](apidocs/com/garygregory/jcommander/converters/security/cert/CertPathValidatorConverter.html)

### SQL Converters
 
- [ConnectionConverter](apidocs/com/garygregory/jcommander/converters/sql/ConnectionConverter.html)
- [DateConverter](apidocs/com/garygregory/jcommander/converters/sql/DateConverter.html)
- [DriverConverter](apidocs/com/garygregory/jcommander/converters/sql/DriverConverter.html)
- [TimeConverter](apidocs/com/garygregory/jcommander/converters/sql/TimeConverter.html)
- [TimestampConverter](apidocs/com/garygregory/jcommander/converters/sql/TimestampConverter.html)
- [TypesConverter](apidocs/com/garygregory/jcommander/converters/sql/TypesConverter.html)
- [MicrosoftTypesConverter](apidocs/com/garygregory/jcommander/converters/sql/microsoft/MicrosoftTypesConverter.html)
- [MysqlTypesConverter](apidocs/com/garygregory/jcommander/converters/sql/mysql/MysqlTypesConverter.html)
- [OracleTypesConverter](apidocs/com/garygregory/jcommander/converters/sql/oracle/OracleTypesConverter.html)

### Time Converters

- [DurationConverter](apidocs/com/garygregory/jcommander/converters/time/DurationConverter.html)
- [InstantConverter](apidocs/com/garygregory/jcommander/converters/time/InstantConverter.html)
- [LocalDateConverter](apidocs/com/garygregory/jcommander/converters/time/LocalDateConverter.html)
- [LocalDateTimeConverter](apidocs/com/garygregory/jcommander/converters/time/LocalDateTimeConverter.html)
- [LocalTimeConverter](apidocs/com/garygregory/jcommander/converters/time/LocalTimeConverter.html)
- [MonthDayConverter](apidocs/com/garygregory/jcommander/converters/time/MonthDayConverter.html)
- [OffsetDateTimeConverter](apidocs/com/garygregory/jcommander/converters/time/OffsetDateTimeConverter.html)
- [OffsetTimeConverter](apidocs/com/garygregory/jcommander/converters/time/OffsetTimeConverter.html)
- [PeriodConverter](apidocs/com/garygregory/jcommander/converters/time/PeriodConverter.html)
- [YearConverter](apidocs/com/garygregory/jcommander/converters/time/YearConverter.html)
- [YearMonthConverter](apidocs/com/garygregory/jcommander/converters/time/YearMonthConverter.html)
- [ZonedDateTimeConverter](apidocs/com/garygregory/jcommander/converters/time/ZonedDateTimeConverter.html)
- [ZoneIdConverter](apidocs/com/garygregory/jcommander/converters/time/ZoneIdConverter.html)
- [ZoneOffsetConverter](apidocs/com/garygregory/jcommander/converters/time/ZoneOffsetConverter.html)

### Util Converters

- [CurrencyConverter](apidocs/com/garygregory/jcommander/converters/util/CurrencyConverter.html)
- [LocaleConverter](apidocs/com/garygregory/jcommander/converters/util/LocaleConverter.html)
- [TimeZoneConverter](apidocs/com/garygregory/jcommander/converters/util/TimeZoneConverter.html)
- [UUIDConverter](apidocs/com/garygregory/jcommander/converters/util/UUIDConverter.html)

### XML Converters

- [DurationConverter](apidocs/com/garygregory/jcommander/converters/xml/datatype/DurationConverter.html)
- [QNameConverter](apidocs/com/garygregory/jcommander/converters/xml/namespace/QNameConverter.html) 

## Status

[![Build Status](https://travis-ci.org/garydgregory/jcommander-addons.svg?branch=master)](https://travis-ci.org/garydgregory/jcommander-addons)
[![Coverage Status](https://coveralls.io/repos/github/garydgregory/jcommander-addons/badge.svg?branch=master)](https://coveralls.io/github/garydgregory/jcommander-addons?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.garygregory/jcommander-addons)


