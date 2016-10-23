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

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractConverterTest;


/**
 * Tests {@link ConnectionConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class ConnectionConverterTest extends AbstractConverterTest<Connection> {

    public ConnectionConverterTest() {
        super(new ConnectionConverter());
    }

    @Test
    public void testConnection() {
        Connection connection = convert("jdbc:h2:mem:test");
        Assert.assertNotNull(connection);
    }

}