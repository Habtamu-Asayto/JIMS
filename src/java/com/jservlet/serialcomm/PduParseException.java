package com.jservlet.serialcomm;

/*
 * @(#)PduParseException.java
 *
 * Copyright (C) Franck Andriano 2007
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * See GPL license : http://www.gnu.org/licenses/gpl.html
 * 
 */

/**
 * Exception definition class
 * 
 * Franck Andriano 2007
 * @version 1.0
 */
public class PduParseException extends Exception
{
	PduParseException(String msg)
	{
		super(msg);
	}

	public static void main(String[] args)
	{
		try
		{
			throw new PduParseException("exception test");
		}
		catch (PduParseException e)
		{
			System.err.println("parse error: " + e);
		}
	}
}
