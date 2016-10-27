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

package com.garygregory.jcommander.converters.nio.file.attribute;

import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link PosixFilePermissionSetConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class PosixFilePermissionSetConverterTest extends AbstractStringConverterBasicTest<Set> {

    public PosixFilePermissionSetConverterTest() {
        super(new PosixFilePermissionSetConverter(null));
    }

    @Test
    public void testPosixFilePermissions() {
        final String perms = "rwxr-x---";
        Assert.assertEquals(PosixFilePermissions.fromString(perms), convert(perms));
    }

}
