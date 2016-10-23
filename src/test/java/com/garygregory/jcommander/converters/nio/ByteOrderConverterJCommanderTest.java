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

package com.garygregory.jcommander.converters.nio;

import java.nio.ByteOrder;

import org.junit.Assert;
import org.junit.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.garygregory.jcommander.converters.nio.ByteOrderConverter;

/**
 * Tests {@link ByteOrderConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class ByteOrderConverterJCommanderTest {

    class CommandLineArguments {

        @Parameter(names = { "--byteOrder" }, converter = ByteOrderConverter.class)
        protected ByteOrder byteOrder;

    }

    private void test(final ByteOrder byteOrder) {
        testJCommander(byteOrder.toString());
    }

    public void testBadInput() {
        testJCommander("X");
    }

    @Test
    public void testBigEndian() {
        test(ByteOrder.BIG_ENDIAN);
    }

    @Test(expected = ParameterException.class)
    public void testEmptyString() {
        testJCommander("X");
    }

    private void testJCommander(final String byteOrder) {
        final CommandLineArguments commandLineArgs = new CommandLineArguments();
        final String[] argv = { "--byteOrder", byteOrder };
        new JCommander(commandLineArgs, argv);
        Assert.assertEquals(commandLineArgs.byteOrder.toString(), byteOrder);
    }

    @Test
    public void testLittleEndian() {
        test(ByteOrder.LITTLE_ENDIAN);
    }
}