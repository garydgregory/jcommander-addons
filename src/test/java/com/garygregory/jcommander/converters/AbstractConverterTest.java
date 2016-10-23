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

import org.junit.Assert;
import org.junit.Test;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

public abstract class AbstractConverterTest<T> {

    private final IStringConverter<T> stringConverter;

    public AbstractConverterTest(final IStringConverter<T> stringConverter) {
        this.stringConverter = stringConverter;
    }

    protected T convert(final String value) {
        return stringConverter.convert(value);
    }

    public IStringConverter<T> getStringConverter() {
        return stringConverter;
    }

    protected void test(final String value) {
        convert(value);
    }

    @Test(expected = ParameterException.class)
    public void testBadInput() {
        test("{ BAD INPUT ");
    }

    public void testBlankString() {
        test(" ");
    }

    @Test(expected = ParameterException.class)
    public void testEmptyString() {
        test("");
    }

    protected void testRoundtrip(final T expected) {
        Assert.assertEquals(expected, convert(expected.toString()));
    }

    protected void testRoundtrip(final T expected, final String value) {
        Assert.assertEquals(expected, convert(value));
    }

}
