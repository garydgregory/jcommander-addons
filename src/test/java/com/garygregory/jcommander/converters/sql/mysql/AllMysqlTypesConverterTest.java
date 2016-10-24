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

package com.garygregory.jcommander.converters.sql.mysql;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.garygregory.jcommander.converters.AbstractStringConverterTestWrapper;
import com.garygregory.jcommander.converters.sql.microsoft.MicrosoftTypesConverter;

/**
 * Tests {@link MicrosoftTypesConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
@RunWith(Parameterized.class)
public class AllMysqlTypesConverterTest extends AbstractStringConverterTestWrapper<Integer> {

    @Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        // @formatter:off
        return Arrays.asList(new Object[][] {     
            { Types.BIGINT, "BIGINT UNSIGNED" },
            { Types.BIGINT, "BIGINT_UNSIGNED" },
            { Types.BIGINT, "BIGINT" },
            { Types.BINARY, "BINARY" },
            { Types.BIT, "BIT" },
            { Types.LONGVARBINARY, "BLOB" },
            { Types.BOOLEAN, "BOOLEAN" },
            { Types.CHAR, "CHAR" },
            { Types.DATE, "DATE" },
            { Types.TIMESTAMP, "DATETIME" },
            { Types.DECIMAL, "DECIMAL UNSIGNED" },
            { Types.DECIMAL, "DECIMAL_UNSIGNED" },
            { Types.DECIMAL, "DECIMAL" },
            { Types.DOUBLE, "DOUBLE UNSIGNED" },
            { Types.DOUBLE, "DOUBLE_UNSIGNED" },
            { Types.DOUBLE, "DOUBLE" },
            { Types.CHAR, "ENUM" },
            { Types.REAL, "FLOAT UNSIGNED" },
            { Types.REAL, "FLOAT_UNSIGNED" },
            { Types.REAL, "FLOAT" },
            { Types.BINARY, "GEOMETRY" },
            { Types.INTEGER, "INT UNSIGNED" },
            { Types.INTEGER, "INT_UNSIGNED" },
            { Types.INTEGER, "INT" },
            { Types.LONGVARCHAR, "JSON" },
            { Types.LONGVARBINARY , "LONGBLOB" },
            { Types.LONGVARCHAR, "LONGTEXT" },
            { Types.LONGVARBINARY, "MEDIUMBLOB" },
            { Types.INTEGER, "MEDIUMINT UNSIGNED" },
            { Types.INTEGER, "MEDIUMINT_UNSIGNED" },
            { Types.INTEGER, "MEDIUMINT" },
            { Types.LONGVARCHAR, "MEDIUMTEXT" },
            { Types.NULL, "NULL" },
            { Types.CHAR , "SET" },
            { Types.SMALLINT, "SMALLINT UNSIGNED" },
            { Types.SMALLINT, "SMALLINT_UNSIGNED" },
            { Types.SMALLINT, "SMALLINT" },
            { Types.LONGVARCHAR, "TEXT" },
            { Types.TIME, "TIME" },
            { Types.TIMESTAMP, "TIMESTAMP" },
            { Types.VARBINARY, "TINYBLOB" },
            { Types.TINYINT, "TINYINT UNSIGNED" },
            { Types.TINYINT, "TINYINT_UNSIGNED" },
            { Types.TINYINT, "TINYINT" },
            { Types.VARCHAR, "TINYTEXT" },
            { Types.VARBINARY, "VARBINARY" },
            { Types.VARCHAR, "VARCHAR" },
            { Types.DATE, "YEAR" }
           });
        // @formatter:on
    }

    private final int expectedType;
    private final String actualString;

    public AllMysqlTypesConverterTest(final int expectedType, final String actualString) {
        super(new MysqlTypesConverter());
        this.expectedType = expectedType;
        this.actualString = actualString;
    }

    @Test
    public void testRoundtrip() {
        testRoundtrip(Integer.valueOf(expectedType), actualString);
    }

}
