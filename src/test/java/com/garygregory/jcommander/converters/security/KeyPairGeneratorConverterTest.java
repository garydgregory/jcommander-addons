/**
 *  Copyright (C) 2016 Gary Gregory. All rights reserved.
 *
 *  See the NOTICE.txt file distributed with this work for additional
 *  information regarding copyright ownership.
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.garygregory.jcommander.converters.security;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link KeyPairGeneratorConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class KeyPairGeneratorConverterTest extends AbstractStringConverterBasicTest<KeyPairGenerator> {

    public KeyPairGeneratorConverterTest() {
        super(new KeyPairGeneratorConverter(null));
    }

    @Test
    public void testKeyPairGenerator() throws NoSuchAlgorithmException {
        final String algorithm = "DiffieHellman";
        final KeyPairGenerator expected = KeyPairGenerator.getInstance(algorithm);
        final KeyPairGenerator actual = convert(algorithm);
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expected.getProvider(), actual.getProvider());
    }

    @Test
    public void testKeyPairGeneratorWithProvider() throws NoSuchAlgorithmException {
        final String algorithm = "DiffieHellman";
        final KeyPairGenerator expected = KeyPairGenerator.getInstance(algorithm);
        final KeyPairGenerator actual = convert(ProviderUtils.toArguments(algorithm, expected.getProvider()));
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expected.getProvider(), actual.getProvider());
    }

}
