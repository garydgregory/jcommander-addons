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

package com.garygregory.jcommander.converters.sql.microsoft;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.garygregory.jcommander.converters.AbstractStringConverterTestWrapper;

/**
 * Tests {@link MicrosoftTypesConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
@RunWith(Parameterized.class)
public class AllMicrosoftTypesConverterTest extends AbstractStringConverterTestWrapper<Integer> {

    @Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        // @formatter:off
        return Arrays.asList(new Object[][] {     
            { -155, "DATETIMEOFFSET" }
           });
        // @formatter:on
    }

    private final int expectedType;
    private final String actualString;

    public AllMicrosoftTypesConverterTest(final int expectedType, final String actualString) {
        super(new MicrosoftTypesConverter());
        this.expectedType = expectedType;
        this.actualString = actualString;
    }

    @Test
    public void testRoundtrip() {
        testRoundtrip(Integer.valueOf(expectedType), actualString);
    }

}
