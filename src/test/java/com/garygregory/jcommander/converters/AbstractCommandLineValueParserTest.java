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

package com.garygregory.jcommander.converters;

import org.junit.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.garygregory.jcommander.converters.nio.ByteOrderConverter;

/**
 * Tests {@link ByteOrderConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public abstract class AbstractCommandLineValueParserTest {
    protected <T> T parse(final T commandLineArguments, final String paramName, final String argument) {
        new JCommander(commandLineArguments, new String[] { paramName, argument });
        return commandLineArguments;
    }

    public void testBadInput() {
        testParseCommandLineValue("X");
    }

    @Test(expected = ParameterException.class)
    public void testBlankString() {
        testParseCommandLineValue("  ");
    }

    @Test(expected = ParameterException.class)
    public void testEmptyString() {
        testParseCommandLineValue("X");
    }

    protected abstract void testParseCommandLineValue(String value);
}