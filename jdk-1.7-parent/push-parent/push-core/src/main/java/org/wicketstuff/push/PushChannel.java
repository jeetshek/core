/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicketstuff.push;

import java.util.UUID;

/**
 * @author <a href="http://sebthom.de/">Sebastian Thomschke</a>
 */
public final class PushChannel<EventType> implements IPushChannel<EventType>
{
	private static final long serialVersionUID = 1L;

	private final UUID id = UUID.randomUUID();
	private final String label;
	private final String toString;

	PushChannel(final String label)
	{
		this.label = label;
		toString = getClass().getName() + "[id=" + id.toString() + ",label=" + label + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PushChannel<?> other = (PushChannel<?>)obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return toString;
	}
}