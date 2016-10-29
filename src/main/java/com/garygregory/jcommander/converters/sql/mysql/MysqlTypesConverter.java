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

import com.garygregory.jcommander.converters.AbstractBaseConverter;
import com.garygregory.jcommander.converters.sql.TypesConverter;

/**
 * Converts a {@link String} into a SQL Types {@link Integer}.
 * <p>
 * For a description of the format, see {@link Types}.
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre class="prettyprint">
 * <code class="language-java">&#64;Parameter(names = { "--paramname" }, converter = TypesConverter.class)
 * private Types paramname;</code>
 * </pre>
 * <p>
 * 
 * @see Types
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class MysqlTypesConverter extends AbstractBaseConverter<Integer> {

    /**
     * Constructs a converter.
     * 
     * @param optionName
     *            The option name, may be null.
     */
    public MysqlTypesConverter(final String optionName) {
        super(optionName, Integer.class);
    }

    @Override
    protected Integer convertImpl(final String value) {
        return Integer.valueOf(toType(value));
    }

    private int toType(final String value) {
        switch (value) {
        case "BIGINT":
            return Types.BIGINT;
        case "BIGINT UNSIGNED":
        case "BIGINT_UNSIGNED":
            return Types.BIGINT;
        case "BINARY":
            return Types.BINARY;
        case "BIT":
            return Types.BIT;
        case "BLOB":
            return Types.LONGVARBINARY;
        case "BOOLEAN":
            return Types.BOOLEAN;
        case "CHAR":
            return Types.CHAR;
        case "DATE":
            return Types.DATE;
        case "DATETIME":
            return Types.TIMESTAMP;
        case "DECIMAL":
            return Types.DECIMAL;
        case "DECIMAL UNSIGNED":
        case "DECIMAL_UNSIGNED":
            return Types.DECIMAL;
        case "DOUBLE":
            return Types.DOUBLE;
        case "DOUBLE UNSIGNED":
        case "DOUBLE_UNSIGNED":
            return Types.DOUBLE;
        case "ENUM":
            return Types.CHAR;
        case "FLOAT":
            return Types.REAL;
        case "FLOAT UNSIGNED":
        case "FLOAT_UNSIGNED":
            return Types.REAL;
        case "GEOMETRY":
            return Types.BINARY;
        case "INT":
            return Types.INTEGER;
        case "INT UNSIGNED":
        case "INT_UNSIGNED":
            return Types.INTEGER;
        case "JSON":
            return Types.LONGVARCHAR;
        case "LONGBLOB":
            return Types.LONGVARBINARY;
        case "LONGTEXT":
            return Types.LONGVARCHAR;
        case "MEDIUMBLOB":
            return Types.LONGVARBINARY;
        case "MEDIUMINT UNSIGNED":
        case "MEDIUMINT_UNSIGNED":
            return Types.INTEGER;
        case "MEDIUMINT":
            return Types.INTEGER;
        case "MEDIUMTEXT":
            return Types.LONGVARCHAR;
        case "NULL":
            return Types.NULL;
        case "SET":
            return Types.CHAR;
        case "SMALLINT":
            return Types.SMALLINT;
        case "SMALLINT UNSIGNED":
        case "SMALLINT_UNSIGNED":
            return Types.SMALLINT;
        case "TEXT":
            return Types.LONGVARCHAR;
        case "TIME":
            return Types.TIME;
        case "TIMESTAMP":
            return Types.TIMESTAMP;
        case "TINYBLOB":
            return Types.VARBINARY;
        case "TINYINT":
            return Types.TINYINT;
        case "TINYINT UNSIGNED":
        case "TINYINT_UNSIGNED":
            return Types.TINYINT;
        case "TINYTEXT":
            return Types.VARCHAR;
        case "VARBINARY":
            return Types.VARBINARY;
        case "VARCHAR":
            return Types.VARCHAR;
        case "YEAR":
            return Types.DATE;
        default:
            return TypesConverter.toType(value);
        }
    }

}