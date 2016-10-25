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

import com.garygregory.jcommander.converters.AbstractBaseConverter;
import com.garygregory.jcommander.converters.sql.TypesConverter;

/**
 * Converts a {@link String} into a SQL Types {@link Integer}.
 * <p>
 * For a description of the format, see {@link Types}.
 * </p>
 * 
 * @see Types
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class OracleTypesConverter extends AbstractBaseConverter<Integer> {

    /**
     * Constructs a converter.
     */
    public OracleTypesConverter(final String optionName) {
        super(optionName, Integer.class);
    }

    @Override
    protected Integer convertImpl(final String value) {
        return Integer.valueOf(toType(value));
    }

    private int toType(final String value) {
        switch (value) {
        case "ARRAY":
            return 2003;
        case "BFILE":
            return -13;
        case "BIGINT":
            return -5;
        case "BINARY":
            return -2;
        case "BINARY_DOUBLE":
            return 101;
        case "BINARY_FLOAT":
            return 100;
        case "BIT":
            return -7;
        case "BLOB":
            return 2004;
        case "BOOLEAN":
            return 16;
        case "CHAR":
            return 1;
        case "CLOB":
            return 2005;
        case "CURSOR":
            return -10;
        case "DATALINK":
            return 70;
        case "DATE":
            return 91;
        case "DECIMAL":
            return 3;
        case "DOUBLE":
            return 8;
        case "FIXED_CHAR":
            return 999;
        case "FLOAT":
            return 6;
        case "INTEGER":
            return 4;
        case "INTERVALDS":
            return -104;
        case "INTERVALYM":
            return -103;
        case "JAVA_OBJECT":
            return 2000;
        case "JAVA_STRUCT":
            return 2008;
        case "LONGNVARCHAR":
            return -16;
        case "LONGVARBINARY":
            return -4;
        case "LONGVARCHAR":
            return -1;
        case "NCHAR":
            return -15;
        case "NCLOB":
            return 2011;
        case "NULL":
            return 0;
        case "NUMBER":
            return 2;
        case "NUMERIC":
            return 2;
        case "NVARCHAR":
            return -9;
        case "OPAQUE":
            return 2007;
        case "OTHER":
            return 1111;
        case "PLSQL_INDEX_TABLE":
            return -14;
        case "RAW":
            return -2;
        case "REAL":
            return 7;
        case "REF":
            return 2006;
        case "ROWID":
            return -8;
        case "SMALLINT":
            return 5;
        case "SQLXML":
            return 2009;
        case "STRUCT":
            return 2002;
        case "TIME":
            return 92;
        case "TIMESTAMP":
            return 93;
        case "TIMESTAMPLTZ":
            return -102;
        case "TIMESTAMPNS":
            return -100;
        case "TIMESTAMPTZ":
            return -101;
        case "TINYINT":
            return -6;
        case "VARBINARY":
            return -3;
        case "VARCHAR":
            return 12;
        default:
            return TypesConverter.toType(value);
        }
    }

}