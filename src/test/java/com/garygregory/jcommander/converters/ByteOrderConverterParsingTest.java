/**
 * Copyright (C) 2010 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.garygregory.jcommander.converters;

import java.nio.ByteOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class ByteOrderConverterParsingTest {

	public class JCommanderExample {

		@Parameter(names = { "--byteOrder" }, converter = ByteOrderConverter.class)
		private ByteOrder byteOrder;;

	}

	private void test(final ByteOrder byteOrder) {
		final JCommanderExample jct = new JCommanderExample();
		final String[] argv = { "--byteOrder", byteOrder.toString() };
		new JCommander(jct, argv);
		Assert.assertEquals(jct.byteOrder, byteOrder);
	}

	@Test
	public void testBigEndian() {
		test(ByteOrder.BIG_ENDIAN);
	}

	@Test
	public void testLittleEndian() {
		test(ByteOrder.LITTLE_ENDIAN);
	}
}