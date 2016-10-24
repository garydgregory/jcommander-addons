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

package com.garygregory.jcommander.converters.sql.oracle;

import java.sql.Types;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.garygregory.jcommander.converters.AbstractStringConverterTestWrapper;

/**
 * Tests {@link OracleTypesConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
@RunWith(Parameterized.class)
public class AllOracleTypesConverterTest extends AbstractStringConverterTestWrapper<Integer> {

    public AllOracleTypesConverterTest(int expectedType, String actualString) {
        super(new OracleTypesConverter());
        this.expectedType = expectedType;
        this.actualString = actualString;
    }

    private final int expectedType;
    private final String actualString;

    @Parameters(name = "{1}")
    public static Collection<Object[]> data() {
        // @formatter:off
        return Arrays.asList(new Object[][] {     
            { -1, "LONGVARCHAR" },
            { -10, "CURSOR" },
            { -100, "TIMESTAMPNS" },
            { -101, "TIMESTAMPTZ" },
            { -102, "TIMESTAMPLTZ" },
            { -103, "INTERVALYM" },
            { -104, "INTERVALDS" },
            { -13, "BFILE" },
            { -14, "PLSQL_INDEX_TABLE" },
            { -15, "NCHAR" },
            { -16, "LONGNVARCHAR" },
            { -2, "BINARY" },
            { -2, "RAW" },
            { -3, "VARBINARY" },
            { -4, "LONGVARBINARY" },
            { -5, "BIGINT" },
            { -6, "TINYINT" },
            { -7, "BIT" },
            { -8, "ROWID" },
            { -9, "NVARCHAR" },
            { 0, "NULL" },
            { 1, "CHAR" },
            { 100, "BINARY_FLOAT" },
            { 101, "BINARY_DOUBLE" },
            { 1111, "OTHER" },
            { 12, "VARCHAR" },
            { 16, "BOOLEAN" },
            { 2, "NUMBER" },
            { 2, "NUMERIC" },
            { 2000, "JAVA_OBJECT" },
            { 2002, "STRUCT" },
            { 2003, "ARRAY" },
            { 2004, "BLOB" },
            { 2005, "CLOB" },
            { 2006, "REF" },
            { 2007, "OPAQUE" },
            { 2008, "JAVA_STRUCT" },
            { 2009, "SQLXML" },
            { 2011, "NCLOB" },
            { 3, "DECIMAL" },
            { 4, "INTEGER" },
            { 5, "SMALLINT" },
            { 6, "FLOAT" },
            { 7, "REAL" },
            { 70, "DATALINK" },
            { 8, "DOUBLE" },
            { 91, "DATE" },
            { 92, "TIME" },
            { 93, "TIMESTAMP" },
            { 999, "FIXED_CHAR" }
           });
        // @formatter:on
    }

    @Test
    public void testRoundtrip() {
        testRoundtrip(Integer.valueOf(expectedType), actualString);
    }

}
