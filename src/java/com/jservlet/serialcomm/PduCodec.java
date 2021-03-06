package com.jservlet.serialcomm;

/*
 * @(#)PduCodec.java
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

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe permettant d'encoder ou de decoder le pdu SMS
 * (Based upon Java source code written by Stefan Moscibroda, 2001) 
 *
 * @author Franck Andriano 2007
 * @version 1.0
 */
public class PduCodec
{
	
	
	private static final char EMPTYCHAR = 0x100;
	private static final char EXTTABLEESCAPE = 0x1B;

	private static char[] gsmToIsoMap; // GSM ==> ISO88591
	private static char[] gsmToIsoExtMap;
	private static char[] isoToGsmMap; // ISO88591 ==> GSM

	private static char[] isoToGsmExtMap;

	private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	// display time and date of received SMS
	public static String displayTimeDate(Calendar cal)
	{
		String out = "";
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int zone = cal.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000) * 4;
		
		String year_str = String.valueOf(year);
		String month_str = String.valueOf(month);
		String day_str = String.valueOf(day);
		String hour_str = String.valueOf(hour);
		String minute_str = String.valueOf(minute);
		String second_str = String.valueOf(second);
		String zone_str = String.valueOf(zone);
		
		if (year_str.length() < 2) year_str = "0" + year_str;
		if (month_str.length() < 2) month_str = "0" + month_str;
		if (day_str.length() < 2) day_str = "0" + day_str;
		if (hour_str.length() < 2) hour_str = "0" + hour_str;
		if (minute_str.length() < 2) minute_str = "0" + minute_str;
		if (second_str.length() < 2) second_str = "0" + second_str;
		
		out = hour_str + ":" + minute_str + ":" + second_str + " ";
		out = out + day_str + "-" + month_str + "-" + year_str; //+" GMT"+zone_str ;
		return out;
	}

	// Needed because of special time stamp coding
	// swaps characters of every two character substring of a string.
	public static String swapDigits(String str)
	{
		if (str == null) return str;
		int strlen = str.length();
		StringBuffer sb = new StringBuffer(strlen);
		for (int i = 0; (i + 1) < strlen; i = i + 2)
		{
			sb.append(str.charAt(i + 1));
			sb.append(str.charAt(i));
		}
		return new String(sb);
	}

	// converts an 8 bit integer into a hexadecimal string
	public static String toHexString(int b)
	{
		char[] digits = new char[2];
		b = b & 255;
		digits[0] = hexDigits[b / 0x10];
		digits[1] = hexDigits[b % 0x10];
		return new String(digits);
	}

	// Conversion: 7 bit character string --> 8 bit bytes as hex string
	public static String sevenBitEncode(String message)
	{
		if (message == null) return message;
		StringBuffer msg = new StringBuffer(message);
		StringBuffer encmsg = new StringBuffer(2 * 160);
		int bb = 0, bblen = 0, i;
		char o = 0, c = 0, tc;
		for (i = 0; i < msg.length() || bblen >= 8; i++)
		{
			if (i < msg.length())
			{
				c = msg.charAt(i);
				tc = isoToGsmMap[c];
				/*
				 * if(tc == EXTTABLEESCAPE) { //msg.insert(i+1, isoToGsmExtMap[c]); }
				 */
				c = tc;
				c &= ~(1 << 7); // clear (discard) eight bit.
				bb |= (c << bblen); // insert c to bb.
				bblen += 7;
			}
			while (bblen >= 8)
			{
				// we have a full octet.
				o = (char) (bb & 255); // take 8 bits.
				encmsg.append(PduCodec.toHexString(o));
				bb >>>= 8;
				bblen -= 8;
			}
		} // end: for(i=0; i<msglen || bblen>=8; i++) 
		if ((bblen > 0)) encmsg.append(PduCodec.toHexString(bb));
		return encmsg.toString();
	}

	public static String sevenBitDecode(String encmsg)
	{
		return sevenBitDecode(encmsg, encmsg.length());
	}

	// Conversion: 8 bit bytes as hex strings --> 7 bit characters string
	public static String sevenBitDecode(String encmsg, int msglen) throws NumberFormatException
	{
		// encmsg: encoded string to decode.
		// msglen: the requested number of characters to decode.
		int i, o, r = 0, rlen = 0, olen = 0, charcnt = 0; // ints are 32 bit long.
		StringBuffer msg = new StringBuffer(160);
		int encmsglen = encmsg.length();
		String ostr;
		boolean exttableescape = false;
		char c;
		
		// assumes even number of chars in octet string.
		for (i = 0; ((i + 1) < encmsglen) && (charcnt < msglen); i = i + 2)
		{
			ostr = encmsg.substring(i, i + 2);
			o = Integer.parseInt(ostr, 16);
			olen = 8;
			if (rlen >= 7)
			{
				// take a full char off remainder.
				c = (char) (r & 127);
				r >>>= 7;
				rlen -= 7;
				msg.append(c);
				charcnt++;
			}
			o <<= rlen; // push remainding bits from r to o.
			o |= r;
			olen += rlen;
			c = (char) (o & 127); // get first 7 bits from o.
			o >>>= 7;
			olen -= 7;
			r = o; // put remainding bits from o to r.
			rlen = olen;
		
			// handle character conversion.
			c = gsmToIsoMap[c];
			if (c == EXTTABLEESCAPE)
			{
				// ext table character handling.
				exttableescape = true;
				continue;
			}
			else if (exttableescape == true)
			{
				exttableescape = false;
				c = gsmToIsoExtMap[c];
			}
			msg.append(c);
			charcnt++;
		} 
		// end: for(i=0; ((i+1)<encmsglen) && (charcnt<msglen); i=i+2) {
		
		if ((rlen > 0) && (charcnt < msglen)) msg.append((char) r);
		return msg.toString();
	}

	// creates timestamp from given date/time information
	public static String TimeStampEncode(Calendar time)
	{
		int year = time.get(Calendar.YEAR);
		int month = time.get(Calendar.MONTH) + 1;
		int day = time.get(Calendar.DAY_OF_MONTH);
		int hour = time.get(Calendar.HOUR_OF_DAY);
		int minute = time.get(Calendar.MINUTE);
		int second = time.get(Calendar.SECOND);
		int zone = time.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000) * 4;
		
		String year_str = String.valueOf(year);
		String month_str = String.valueOf(month);
		String day_str = String.valueOf(day);
		String hour_str = String.valueOf(hour);
		String minute_str = String.valueOf(minute);
		String second_str = String.valueOf(second);
		String zone_str = String.valueOf(zone);
		year_str = year_str.substring(2, 4);
		
		if (month_str.length() < 2) month_str = "0" + month_str;
		if (day_str.length() < 2) day_str = "0" + day_str;
		if (hour_str.length() < 2) hour_str = "0" + hour_str;
		if (minute_str.length() < 2) minute_str = "0" + minute_str;
		if (second_str.length() < 2) second_str = "0" + second_str;
		if (zone_str.length() < 2) zone_str = "0" + zone_str;
		String out = year_str + month_str + day_str + hour_str + minute_str + second_str + zone_str;
		out = swapDigits(out);
		return out;
	}

	// decode timestamp from received sms
	public static GregorianCalendar TimeStampDecode(String timestamp)
	{
		timestamp = PduCodec.swapDigits(timestamp);
		int year = Integer.parseInt(timestamp.substring(0, 2));
		int month = Integer.parseInt(timestamp.substring(2, 4)) - 1;
		int day = Integer.parseInt(timestamp.substring(4, 6));
		int hour = Integer.parseInt(timestamp.substring(6, 8));
		int minute = Integer.parseInt(timestamp.substring(8, 10));
		int second = Integer.parseInt(timestamp.substring(10, 12));
		int zone = Integer.parseInt(timestamp.substring(10, 12)) * (60 * 60 * 1000) / 4;
		GregorianCalendar time = new GregorianCalendar(year, month, day, hour, minute, second);
		return time;
	}

	// Conversion: 8 bit bytes as hex strings --> 8 bit characters string
	public static String eightBitDecode(String encmsg) throws NumberFormatException
	{
		// encmsg: encoded string to decode.
		// msglen: the requested number of characters to decode.
		int i, o;
		StringBuffer msg = new StringBuffer(160);
		String ostr;
		char c;
		
		// assumes even number of chars in octet string.
		for (i = 0; i < encmsg.length(); i = i + 2)
		{
			ostr = encmsg.substring(i, i + 2);
			o = Integer.parseInt(ostr, 16);
			c = (char) o;
			c = gsmToIsoMap[c];
			msg.append(c);
		}
		return msg.toString();
	}

	// class initialization.
	static
	{
		// construct GSM alphabet to/from ISO mappings.
		char[] gsmiso = {0, '@', 1, '??', 2, '$', 14, '??', 15, '??', 17, '_', 91, '??', 92, '??', 94, '??', 95, '??', 123, '??',
				124, '??', 126, '??', 34, '"', 5, '??', 4, '??'};
		
		char[] gsmisoext = {0x14, '^', 0x28, '{', 0x29, '}', 0x2f, '\\', 0x3c, '[', 0x3d, '~', 0x3e, ']', 0x40, '|'};
		final int lastindex = 255;
		
		gsmToIsoMap = new char[lastindex + 1]; // one too many allocated
		gsmToIsoExtMap = new char[lastindex + 1];
		isoToGsmMap = new char[lastindex + 1];
		isoToGsmExtMap = new char[lastindex + 1];
		int i, gsmisolen, gsmisoextlen;
		
		for (i = 0; i <= lastindex; i++)
		{
			gsmToIsoMap[i] = gsmToIsoExtMap[i] = isoToGsmMap[i] = (char) i;
		}
		
		gsmisolen = gsmiso.length;
		for (i = 0; (i + 1) < gsmisolen; i = i + 2)
		{
			gsmToIsoMap[(int) gsmiso[i]] = gsmiso[i + 1];
			isoToGsmMap[(int) gsmiso[i + 1]] = gsmiso[i];
		}
		gsmisoextlen = gsmisoext.length;
		for (i = 0; (i + 1) < gsmisoextlen; i = i + 2)
		{
			gsmToIsoExtMap[gsmisoext[i]] = gsmisoext[i + 1];
			//isoToGsmExtMap[gsmisoext[i+1]] = gsmisoext[i];
			//isoToGsmMap[gsmisoext[i+1]] = EXTTABLEESCAPE;
		}
	}
}
