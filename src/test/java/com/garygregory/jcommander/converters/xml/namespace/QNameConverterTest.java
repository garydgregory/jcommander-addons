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

package com.garygregory.jcommander.converters.xml.namespace;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Test;

import com.garygregory.jcommander.converters.AbstractStringConverterBasicTest;

/**
 * Tests {@link QNameConverter}.
 * 
 * @since 1.0.0
 * @author <a href="mailto:ggregory@garygregory.com">Gary Gregory</a>
 */
public class QNameConverterTest extends AbstractStringConverterBasicTest<QName> {

    private static final String EMPTY_STRING = "";

    public QNameConverterTest() {
        super(new QNameConverter(null));
    }

    @Override
    @Test
    public void testEmptyString() {
        final QName qname = convert(EMPTY_STRING);
        Assert.assertEquals(XMLConstants.DEFAULT_NS_PREFIX, qname.getPrefix());
        Assert.assertEquals(EMPTY_STRING, qname.getNamespaceURI());
        Assert.assertEquals(EMPTY_STRING, qname.getLocalPart());
    }

    @Test
    public void testLocalPart() {
        final QName qname = convert("ALocalPart");
        Assert.assertEquals(XMLConstants.DEFAULT_NS_PREFIX, qname.getPrefix());
        Assert.assertEquals(EMPTY_STRING, qname.getNamespaceURI());
        Assert.assertEquals("ALocalPart", qname.getLocalPart());
    }

    @Test
    public void testNamespaceUriLocalPart() {
        final QName qname = convert("{namespaceUri}ALocalPart");
        Assert.assertEquals(XMLConstants.DEFAULT_NS_PREFIX, qname.getPrefix());
        Assert.assertEquals("namespaceUri", qname.getNamespaceURI());
        Assert.assertEquals("ALocalPart", qname.getLocalPart());
    }

    @Test
    public void testPrefixNamespaceUriLocalPart() {
        final QName qname = convert("{abc:namespaceUri}ALocalPart");
        Assert.assertEquals(XMLConstants.DEFAULT_NS_PREFIX, qname.getPrefix());
        Assert.assertEquals("abc:namespaceUri", qname.getNamespaceURI());
        Assert.assertEquals("ALocalPart", qname.getLocalPart());
    }
}
