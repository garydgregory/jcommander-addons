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

package com.garygregory.jcommander.converters.net.ssl;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;

import javax.net.ssl.TrustManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;
import com.garygregory.jcommander.converters.ConverterConstants;

/**
 * Tests {@link TrustManagerFactoryConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class TrustManagerFactoryConverterTest extends AbstractStringConverterBasicTest<TrustManagerFactory> {

    public TrustManagerFactoryConverterTest() {
        super(new TrustManagerFactoryConverter(null));
    }

    @Test
    public void testTrustManagerFactory() throws NoSuchAlgorithmException {
        final String algorithm = "SunX509";
        final TrustManagerFactory expected = TrustManagerFactory.getInstance(algorithm);
        final TrustManagerFactory actual = convert(algorithm);
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expected.getProvider(), actual.getProvider());
    }

    @Test
    public void testTrustManagerFactoryWithProvider() throws NoSuchAlgorithmException {
        final String algorithm = "SunX509";
        final TrustManagerFactory expected = TrustManagerFactory.getInstance(algorithm);
        final Provider expectedProvider = expected.getProvider();
        final TrustManagerFactory actual = convert(algorithm + ConverterConstants.VALUE_SEPARATOR + expectedProvider.getName());
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
        Assert.assertEquals(expectedProvider, actual.getProvider());
    }

}
