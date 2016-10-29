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

import java.time.OffsetTime;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a {@link OffsetTime}.
 * <p>
 * For a description of the format, see {@link OffsetTime#parse(CharSequence)}.
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre class="prettyprint">
 * <code class="language-java">&#64;Parameter(names = { "--paramname" }, converter = OffsetTimeConverter.class)
 * private OffsetTime paramname;</code>
 * </pre>
 * <p>
 * 
 * @see OffsetTime
 * @see OffsetTime#parse(CharSequence)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class OffsetTimeConverter extends AbstractBaseConverter<OffsetTime> {

    /**
     * Constructs a converter.
     * 
     * @param optionName
     *            The option name, may be null.
     */
    public OffsetTimeConverter(final String optionName) {
        super(optionName, OffsetTime.class);
    }

    @Override
    protected OffsetTime convertImpl(final String value) {
        return OffsetTime.parse(value);
    }

}