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

import com.garygregory.jcommander.converters.AbstractBaseConverter;

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
public class TypesConverter extends AbstractBaseConverter<Integer> {

    /**
     * Constructs a converter.
     */
    public TypesConverter() {
        super(null, Integer.class);
    }

    @Override
    protected Integer convertImpl(final String value) {
        return Integer.valueOf(toType(value));
    }

    private int toType(final String value) {
        switch (value) {
        case "ARRAY":
            return Types.ARRAY;
        case "BIGINT":
            return Types.BIGINT;
        case "BINARY":
            return Types.BINARY;
        case "BIT":
            return Types.BIT;
        case "BLOB":
            return Types.BLOB;
        case "BOOLEAN":
            return Types.BOOLEAN;
        case "CHAR":
            return Types.CHAR;
        case "CLOB":
            return Types.CLOB;
        case "DATALINK":
            return Types.DATALINK;
        case "DATE":
            return Types.DATE;
        case "DECIMAL":
            return Types.DECIMAL;
        case "DISTINCT":
            return Types.DISTINCT;
        case "DOUBLE":
            return Types.DOUBLE;
        case "FLOAT":
            return Types.FLOAT;
        case "INTEGER":
            return Types.INTEGER;
        case "JAVA_OBJECT":
            return Types.JAVA_OBJECT;
        case "LONGNVARCHAR":
            return Types.LONGNVARCHAR;
        case "LONGVARBINARY":
            return Types.LONGVARBINARY;
        case "LONGVARCHAR":
            return Types.LONGVARCHAR;
        case "NCHAR":
            return Types.NCHAR;
        case "NCLOB":
            return Types.NCLOB;
        case "NULL":
            return Types.NULL;
        case "NUMERIC":
            return Types.NUMERIC;
        case "NVARCHAR":
            return Types.NVARCHAR;
        case "OTHER":
            return Types.OTHER;
        case "REAL":
            return Types.REAL;
        case "REF":
            return Types.REF;
        case "REF_CURSOR":
            return Types.REF_CURSOR;
        case "ROWID":
            return Types.ROWID;
        case "SMALLINT":
            return Types.SMALLINT;
        case "SQLXML":
            return Types.SQLXML;
        case "STRUCT":
            return Types.STRUCT;
        case "TIME":
            return Types.TIME;
        case "TIME_WITH_TIMEZONE":
            return Types.TIME_WITH_TIMEZONE;
        case "TIMESTAMP":
            return Types.TIMESTAMP;
        case "TIMESTAMP_WITH_TIMEZONE":
            return Types.TIMESTAMP_WITH_TIMEZONE;
        case "TINYINT":
            return Types.TINYINT;
        case "VARBINARY":
            return Types.VARBINARY;
        case "VARCHAR":
            return Types.VARCHAR;
        default:
            throw newParameterException("Unknown JDBC SQL type '" + value + "'");
        }
    }

}