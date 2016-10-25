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

package com.garygregory.jcommander.converters.time;

import java.time.Duration;

import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link DurationConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class DurationConverterTest extends AbstractStringConverterBasicTest<Duration> {

    public DurationConverterTest() {
        super(new DurationConverter(null));
    }

    @Test
    public void testDuration() {
        testRoundtrip(Duration.ofMinutes(15));
    }

    @Test
    public void testDurationMinusPT15M() {
        testRoundtrip(Duration.ofMinutes(15), "PT15M");
    }

    @Test
    public void testDurationZero() {
        testRoundtrip(Duration.ZERO, "PT0S");
    }

}
