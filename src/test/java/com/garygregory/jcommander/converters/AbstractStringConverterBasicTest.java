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

import java.security.Provider;

import org.junit.Test;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

public abstract class AbstractStringConverterBasicTest<T> extends AbstractStringConverterTestWrapper<T> {

    protected static final String EMPTY_STRING = "";

    public AbstractStringConverterBasicTest(final IStringConverter<T> stringConverter) {
        super(stringConverter);
    }

    @Test(expected = ParameterException.class)
    public void testBadInput() {
        convert("{ BAD INPUT ");
    }

    public void testBlankString() {
        convert(" ");
    }

    @Test(expected = ParameterException.class)
    public void testEmptyString() {
        convert(EMPTY_STRING);
    }

    protected String toArguments(final String arg0, final Provider expectedProvider) {
        return arg0 + ConverterConstants.VALUE_SEPARATOR + expectedProvider.getName();
    }

}
