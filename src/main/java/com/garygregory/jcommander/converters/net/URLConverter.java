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

package com.garygregory.jcommander.converters.net;

import java.net.MalformedURLException;
import java.net.URL;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a {@link String} into a SQL {@link URL}.
 * <p>
 * For a description of the format, see {@link URL#URL(String)}.
 * </p>
 * 
 * @see URL
 * @see URL#URL(String)
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class URLConverter extends AbstractBaseConverter<URL> {

    /**
     * Constructs a converter.
     */
    public URLConverter(final String optionName) {
        super(optionName, URL.class);
    }

    @Override
    protected URL convertImpl(final String value) throws MalformedURLException  {
        return new URL(value);
    }

}