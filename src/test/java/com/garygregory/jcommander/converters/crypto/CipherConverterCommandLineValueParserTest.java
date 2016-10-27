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

import com.beust.jcommander.Parameter;
import com.garygregory.jcommander.converters.AbstractCommandLineValueParserTest;
import com.garygregory.jcommander.converters.ConverterConstants;
import com.garygregory.jcommander.converters.security.ProviderUtils;

/**
 * Tests converters.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class CipherConverterCommandLineValueParserTest extends AbstractCommandLineValueParserTest {

    static class CommandLineArguments {

        @Parameter(names = { "--cipher" }, converter = CipherConverter.class)
        private Cipher cipher;

        public Cipher getCipher() {
            return cipher;
        }

    }

    @Test
    public void testCipher() {
        testParseCommandLineValue(CipherConverterTest.VALUE);
    }

    @Test
    public void testCipherWithProvider() throws NoSuchAlgorithmException, NoSuchPaddingException {
        final Cipher expected = Cipher.getInstance(CipherConverterTest.VALUE);
        final Provider expectedProvider = expected.getProvider();
        testParseCommandLineValue(ProviderUtils.toArguments(CipherConverterTest.VALUE, expectedProvider));
    }

    @Override
    protected void testParseCommandLineValue(final String value) {
        final CommandLineArguments commandLineArgs = parse(new CommandLineArguments(), "--cipher", value);
        if (value.contains(ConverterConstants.VALUE_SEPARATOR)) {
            Assert.assertEquals(value,
                    ProviderUtils.toArguments(commandLineArgs.getCipher().getAlgorithm(), commandLineArgs.getCipher().getProvider()));
        } else {
            Assert.assertEquals(value, commandLineArgs.getCipher().getAlgorithm());
        }
    }

}