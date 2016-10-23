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

package com.garygregory.jcommander.converters.nio;

import java.nio.ByteOrder;

import com.garygregory.jcommander.converters.AbstractBaseConverter;

/**
 * Converts a String to a {@link ByteOrder}. Values are {@code "BIG_ENDIAN"} and {@code "LITTLE_ENDIAN"}.
 * 
 * @see ByteOrder
 * @see ByteOrder#BIG_ENDIAN
 * @see ByteOrder#LITTLE_ENDIAN
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public final class ByteOrderConverter extends AbstractBaseConverter<ByteOrder> {

    /**
     * Constructs a converter with the given options
     */
    public ByteOrderConverter() {
        super(null, ByteOrder.class);
    }

    @Override
    protected ByteOrder convertImpl(final String value) {
        if (value.equalsIgnoreCase(ByteOrder.BIG_ENDIAN.toString())) {
            return ByteOrder.BIG_ENDIAN;
        }
        if (value.equalsIgnoreCase(ByteOrder.LITTLE_ENDIAN.toString())) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        throw new IllegalArgumentException(value);
    }
}
