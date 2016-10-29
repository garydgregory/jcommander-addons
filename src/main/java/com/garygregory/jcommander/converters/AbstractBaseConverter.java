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

import java.net.URI;
import java.util.Objects;

import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;
import com.beust.jcommander.converters.IntegerConverter;
import com.garygregory.jcommander.converters.net.URIConverter;

/**
 * Provides common services for converters in this package
 * 
 * @param <T>
 *            the target type of the conversion.
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public abstract class AbstractBaseConverter<T> extends BaseConverter<T> {

    /**
     * The target class to convert strings.
     */
    protected final Class<T> targetClass;

    /**
     * Whether or not a null conversion failure throws a ParameterException.
     */
    protected final boolean failOnNull;

    /**
     * Constructs a new instance for the given option and target class.
     * 
     * @param optionName
     *            The option name, may be null.
     * @param targetClass
     *            must not be null
     */
    public AbstractBaseConverter(final String optionName, final Class<T> targetClass) {
        this(optionName, targetClass, true);
    }

    /**
     * Constructs a new instance for the given option, target class and fail-on-null.
     * 
     * @param optionName
     *            may be null
     * @param targetClass
     *            must not be null
     * @param failOnNull
     *            if true, the converter fails when the conversion results in a null value
     */
    public AbstractBaseConverter(final String optionName, final Class<T> targetClass, final boolean failOnNull) {
        super(optionName);
        this.failOnNull = failOnNull;
        this.targetClass = Objects.requireNonNull(targetClass, "targetClass for " + getClass());
    }

    /**
     * Converts the given value or throws a {@link ParameterException}. Delegates the actual conversion to subclasses with
     * {@link #convertImpl(String)}.
     * 
     * @param value
     *            the value to convert.
     * @throws ParameterException
     *             for a conversion problem
     */
    @Override
    public T convert(final String value) {
        try {
            final T result = convertImpl(value);
            if (result == null && failOnNull) {
                throw newParameterException(value);
            }
            return result;
        } catch (final Exception e) {
            throw newParameterException(value, e);
        }
    }

    /**
     * Converts a value.
     * 
     * @param value
     *            the value to convert
     * @return the converted value
     * @throws Exception
     *             subclasses can throw any Exception
     */
    protected abstract T convertImpl(String value) throws Exception;

    /**
     * Builds an error message for the given value in error
     * 
     * @param value
     *            the value that cause the error
     * @return an error message
     */
    protected String getErrorString(final String value) {
        return getClass().getName() + " could not convert \"" + value + "\" to an instance of " + targetClass + " for option "
                + getOptionName();
    }

    /**
     * Returns true if the array is of size 1, false otherwise.
     * 
     * @param split
     *            an array
     * @return true if the array is of size 1, false otherwise.
     */
    protected boolean isSingle(final String[] split) {
        return split.length == 1;
    }

    /**
     * Creates a new {@link ParameterException} for the given value.
     * 
     * @param value
     *            the value in error
     * @return a new ParameterException
     */
    protected ParameterException newParameterException(final String value) {
        return new ParameterException(getErrorString(value));
    }

    /**
     * Creates a new {@link ParameterException} for the given value and throwable
     * 
     * @param value
     *            the value in error
     * @param t
     *            the throwable
     * @return a new ParameterException
     */
    protected ParameterException newParameterException(final String value, final Throwable t) {
        return new ParameterException(getErrorString(value), t);
    }

    /**
     * Splits the given string using {@link ConverterConstants#VALUE_SEPARATOR} as the boundary.
     * 
     * @param value
     *            the string to split
     * @return the split array result
     */
    protected String[] split(final String value) {
        return value.split(ConverterConstants.VALUE_SEPARATOR);
    }

    /**
     * Converts the given value to an int for the given option.
     * 
     * @param optionName
     *            the option name
     * @param value
     *            the value to parse
     * @return the int result
     */
    protected int toInt(final String optionName, final String value) {
        return new IntegerConverter(optionName).convert(value).intValue();
    }

    /**
     * Converts the given string into a URI
     * 
     * @param optionName
     *            the option name
     * @param value
     *            a string
     * 
     * @return a new URI
     * @see java.net.URI
     */
    protected URI toURI(final String optionName, final String value) {
        return new URIConverter(null).convert(value);
    }

}
