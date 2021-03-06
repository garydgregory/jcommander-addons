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

package com.garygregory.jcommander.converters.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;
import com.garygregory.jcommander.converters.security.ProviderUtils;

/**
 * Tests {@link CipherConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class CipherConverterTest extends AbstractStringConverterBasicTest<Cipher> {

    static final String VALUE = "DES/CBC/PKCS5Padding";

    public CipherConverterTest() {
        super(new CipherConverter(null));
    }

    @Test
    public void testCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        final Cipher expected = Cipher.getInstance(VALUE);
        final Cipher actual = convert(VALUE);
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expected.getBlockSize(), actual.getBlockSize());
        Assert.assertEquals(expected.getProvider(), actual.getProvider());
    }

    @Test
    public void testCipherWithProvider() throws NoSuchAlgorithmException, NoSuchPaddingException {
        final Cipher expected = Cipher.getInstance(VALUE);
        final Provider expectedProvider = expected.getProvider();
        final Cipher actual = convert(ProviderUtils.toArguments(VALUE, expectedProvider));
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expected.getBlockSize(), actual.getBlockSize());
        Assert.assertEquals(expectedProvider, actual.getProvider());
    }

}
