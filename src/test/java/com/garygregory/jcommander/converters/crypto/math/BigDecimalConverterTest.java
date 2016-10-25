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

package com.garygregory.jcommander.converters.crypto.math;

import java.math.BigDecimal;

import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;
import com.garygregory.jcommander.converters.math.BigDecimalConverter;

/**
 * Tests {@link BigDecimalConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class BigDecimalConverterTest extends AbstractStringConverterBasicTest<BigDecimal> {

    public BigDecimalConverterTest() {
        super(new BigDecimalConverter(null));
    }

    @Test
    public void testBigDecimal_BiggerThanDoubleMAX_VALUE() {
        BigDecimal val = BigDecimal.valueOf(Double.MAX_VALUE);
        val = val.multiply(val);
        testRoundtrip(val);
    }

    @Test
    public void testBigDecimal_BiggerThanLongMAX_VALUE() {
        BigDecimal val = BigDecimal.valueOf(Long.MAX_VALUE);
        val = val.multiply(val);
        testRoundtrip(val);
    }

    @Test
    public void testBigDecimal_DoubleMAX_VALUE() {
        testRoundtrip(BigDecimal.valueOf(Double.MAX_VALUE));
    }

    @Test
    public void testBigDecimal_LongMAX_VALUE() {
        testRoundtrip(BigDecimal.valueOf(Long.MAX_VALUE));
    }

    @Test
    public void testBigDecimalONE() {
        testRoundtrip(BigDecimal.ONE);
    }

    @Test
    public void testBigDecimalTEN() {
        testRoundtrip(BigDecimal.TEN);
    }

    @Test
    public void testBigDecimalZERO() {
        testRoundtrip(BigDecimal.ZERO);
    }

}
