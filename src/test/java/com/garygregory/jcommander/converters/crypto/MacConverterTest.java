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

import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link MacConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class MacConverterTest extends AbstractStringConverterBasicTest<Mac> {

    public MacConverterTest() {
        super(new MacConverter(null));
    }

    @Test
    @Ignore
    public void testMac() throws NoSuchAlgorithmException, NoSuchPaddingException {
        final String transformation = "HmacSHA1";
        final Mac expected = Mac.getInstance(transformation);
        final Mac actual = convert(transformation);
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expected.getProvider(), actual.getProvider());
    }

    @Test
    @Ignore
    public void testMacWithProvider() throws NoSuchAlgorithmException, NoSuchPaddingException {
        final String transformation = "HmacSHA1";
        final Mac expected = Mac.getInstance(transformation);
        final Provider expectedProvider = expected.getProvider();
        final Mac actual = convert(toArguments(transformation, expectedProvider));
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expectedProvider, actual.getProvider());
    }

}
