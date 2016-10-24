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

package com.garygregory.jcommander.converters.sql;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.garygregory.jcommander.converters.AbstractStringConverterTestWrapper;

/**
 * Tests {@link TimeConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
@RunWith(Parameterized.class)
public class AllTypesConverterTest extends AbstractStringConverterTestWrapper<Integer> {

    public AllTypesConverterTest(int expectedType, String actualString) {
        super(new TypesConverter());
        this.expectedType = expectedType;
        this.actualString = actualString;
    }

    private final int expectedType;
    private final String actualString;

    @Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        // @formatter:off
        return Arrays.asList(new Object[][] {     
            { Types.ARRAY, "ARRAY" },
            { Types.BIGINT, "BIGINT" },
            { Types.BINARY, "BINARY" },
            { Types.BIT, "BIT" },
            { Types.BLOB, "BLOB" },
            { Types.BOOLEAN, "BOOLEAN" },
            { Types.CHAR, "CHAR" },
            { Types.CLOB, "CLOB" },
            { Types.DATALINK, "DATALINK" },
            { Types.DATE, "DATE" },
            { Types.DECIMAL, "DECIMAL" },
            { Types.DISTINCT, "DISTINCT" },
            { Types.DOUBLE, "DOUBLE" },
            { Types.FLOAT, "FLOAT" },
            { Types.INTEGER, "INTEGER" },
            { Types.JAVA_OBJECT, "JAVA_OBJECT" },
            { Types.LONGNVARCHAR, "LONGNVARCHAR" },
            { Types.LONGVARBINARY, "LONGVARBINARY" },
            { Types.LONGVARCHAR, "LONGVARCHAR" },
            { Types.NCHAR, "NCHAR" },
            { Types.NCLOB, "NCLOB" },
            { Types.NULL, "NULL" },
            { Types.NUMERIC, "NUMERIC" },
            { Types.NVARCHAR, "NVARCHAR" },
            { Types.OTHER, "OTHER" },
            { Types.REAL, "REAL" },
            { Types.REF, "REF" },
            { Types.REF_CURSOR, "REF_CURSOR" },
            { Types.ROWID, "ROWID" },
            { Types.SMALLINT, "SMALLINT" },
            { Types.SQLXML, "SQLXML" },
            { Types.STRUCT, "STRUCT" },
            { Types.TIME, "TIME" },
            { Types.TIME_WITH_TIMEZONE, "TIME_WITH_TIMEZONE" },
            { Types.TIMESTAMP, "TIMESTAMP" },
            { Types.TIMESTAMP_WITH_TIMEZONE, "TIMESTAMP_WITH_TIMEZONE" },
            { Types.TINYINT, "TINYINT" },
            { Types.VARBINARY, "VARBINARY" },
            { Types.VARCHAR, "VARCHAR" }
           });
        // @formatter:on
    }

    @Test
    public void testRoundtrip() {
        testRoundtrip(Integer.valueOf(expectedType), actualString);
    }

}
