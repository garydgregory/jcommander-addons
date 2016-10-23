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

import java.util.Objects;

import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.BaseConverter;

/**
 * Provides common services for converters in this package
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public abstract class AbstractBaseConverter<T> extends BaseConverter<T> {

    protected final Class<T> targetClass;

    public AbstractBaseConverter(final String optionName, final Class<T> targetClass) {
        super(optionName);
        this.targetClass = Objects.requireNonNull(targetClass, "targetClass for " + getClass());
    }

    @Override
    public T convert(final String value) {
        try {
            return convertImpl(value);
        } catch (final Exception e) {
            throw newParameterException(value);
        }
    }

    protected abstract T convertImpl(String value);
    
    protected String getErrorString(final String value) {
        return getClass().getName() + " could not convert \"" + value + "\" to an instance of " + targetClass;
    }

    protected ParameterException newParameterException(final String value) {
        return new ParameterException(getErrorString(value));
    }

}
