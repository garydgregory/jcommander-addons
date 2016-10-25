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

package com.garygregory.jcommander.converters.util;

import java.util.UUID;

import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link UUIDConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class UUIDConverterTest extends AbstractStringConverterBasicTest<UUID> {

    public UUIDConverterTest() {
        super(new UUIDConverter(null));
    }

    @Test
    public void testRandomUUID() {
        testRoundtrip(UUID.randomUUID());
    }

    @Test
    public void testUUID() {
        testRoundtrip(UUID.fromString("92c6deb1-1e63-4db4-8437-5f3e6c6f6e6e"));
    }

}
