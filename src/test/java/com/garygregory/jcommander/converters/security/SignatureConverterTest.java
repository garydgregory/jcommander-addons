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

package com.garygregory.jcommander.converters.security;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link SignatureConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class SignatureConverterTest
        extends AbstractStringConverterBasicTest<Signature> {

    public SignatureConverterTest() {
        super(new SignatureConverter());
    }
    
    @Test
    public void testSignature() throws NoSuchAlgorithmException  {
        final Signature expected = Signature.getInstance("NONEwithRSA");
        final Signature actual = convert("NONEwithRSA");
        Assert.assertEquals(expected.getAlgorithm(), actual.getAlgorithm());
    }

}