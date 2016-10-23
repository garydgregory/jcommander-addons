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

package com.garygregory.jcommander.converters.time;

import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeParseException;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a {@link Duration}.
 * <p>
 * For a description of the format, see {@link Period#parse(CharSequence)}.
 * </p>
 * 
 * @see Period
 * @see Period#parse(CharSequence)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class DurationConverter extends AbstractBaseConverter<Duration> {

    /**
     * Constructs a converter.
     */
    public DurationConverter() {
        super(null);
    }

    @Override
    public Duration convert(final String value) {
        try {
            return Duration.parse(value);
        } catch (final DateTimeParseException e) {
            throw newParameterException(value, Duration.class);
        }
    }

}