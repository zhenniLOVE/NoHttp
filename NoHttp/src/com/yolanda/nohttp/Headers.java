/**
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolanda.nohttp;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import com.yolanda.nohttp.util.MultiValueMap;

/**
 * Created in Jan 10, 2016 2:29:42 PM
 * 
 * @author YOLANDA
 */
public interface Headers extends MultiValueMap<String, String> {

	static final String HEAD_KEY_RESPONSE_CODE = "ResponseCode";

	static final String HEAD_KEY_RESPONSE_MESSAGE = "ResponseMessage";

	public static final String HEAD_KEY_ACCEPT = "Accept";

	public static final String HEAD_KEY_ACCEPT_ENCODING = "Accept-Encoding";

	public static final String HEAD_VALUE_ACCEPT_ENCODING = "gzip, deflate";// no sdch

	public static final String HEAD_KEY_ACCEPT_LANGUAGE = "Accept-Language";

	public static final String HEAD_KEY_CONTENT_TYPE = "Content-Type";

	public static final String HEAD_KEY_CONTENT_LENGTH = "Content-Length";

	public static final String HEAD_KEY_CONTENT_ENCODING = "Content-Encoding";

	public static final String HEAD_KEY_CONTENT_RANGE = "Content-Range";

	public static final String HEAD_KEY_CACHE_CONTROL = "Cache-Control";

	public static final String HEAD_KEY_CONNECTION = "Connection";

	public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = "keep-alive";

	public static final String HEAD_VALUE_CONNECTION_CLOSE = "close";

	public static final String HEAD_KEY_DATE = "Date";

	public static final String HEAD_KEY_EXPIRES = "Expires";

	public static final String HEAD_KEY_ETAG = "ETag";

	public static final String HEAD_KEY_PRAGMA = "Pragma";

	public static final String HEAD_KEY_IF_MODIFIED_SINCE = "If-Modified-Since";

	public static final String HEAD_KEY_IF_NONE_MATCH = "If-None-Match";

	public static final String HEAD_KEY_LAST_MODIFIED = "Last-Modified";

	public static final String HEAD_KEY_LOCATION = "Location";

	public static final String HEAD_KEY_USER_AGENT = "User-Agent";

	public static final String HEAD_KEY_COOKIE = "Cookie";

	public static final String HEAD_KEY_COOKIE2 = "Cookie2";

	public static final String HEAD_KEY_SET_COOKIE = "Set-Cookie";

	public static final String HEAD_KEY_SET_COOKIE2 = "Set-Cookie2";

	/**
	 * Copy all head to Headers
	 */
	void addAll(Headers headers);

	/**
	 * Remove all of the head now, add a new head in
	 */
	void setAll(Headers headers);

	/**
	 * Conform to the URL of the Cookie is added to the head
	 * @param uri
	 * @param cookieHandler
	 * @throws IOException
	 */
	void addCookie(URI uri, CookieHandler cookieHandler) throws IOException;

	void setJSONString(String jsonString) throws JSONException;

	String toJSONString();

	Map<String, String> toRequestHeaders();

	Map<String, List<String>> toResponseHeaders();

	List<HttpCookie> getCookies();

	String getCacheControl();

	String getContentEncoding();

	int getContentLength();

	String getContentType();

	long getDate();

	String getETag();

	long getExpiration();

	long getLastModified();

	String getLocation();

	int getResponseCode();

	String getResponseMessage();
}
