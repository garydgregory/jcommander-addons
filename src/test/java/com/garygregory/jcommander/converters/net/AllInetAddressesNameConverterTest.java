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

package com.garygregory.jcommander.converters.net;

import static org.hamcrest.MatcherAssert.assertThat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link AllInetAddressesNameConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class AllInetAddressesNameConverterTest extends AbstractStringConverterBasicTest<InetAddress[]> {

    public AllInetAddressesNameConverterTest() {
        super(new AllInetAddressesNameConverter(null));
    }

    @Override
    @Test
    public void testEmptyString() {
        final InetAddress expected = InetAddress.getLoopbackAddress();
        assertThat(convert(EMPTY_STRING), Matchers.hasItemInArray(expected));
    }

    @Test
    public void testInetAddressHostAddress() throws UnknownHostException {
        final InetAddress expected = InetAddress.getLoopbackAddress();
        assertThat(convert(expected.getHostName()), Matchers.hasItemInArray(expected));
    }

    @Test
    public void testInetAddressHostName() throws UnknownHostException {
        final InetAddress expected = InetAddress.getLoopbackAddress();
        assertThat(convert(expected.getHostAddress()), Matchers.hasItemInArray(expected));
    }

}
