package com.scopevisio.webservicekit.examples;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public static void main(String[] args) {
try {
// get args
String url = "https://appload.scopevisio.com/api/soap/accounting/RevertClearing.do";
String customer = "1000001";
String user = "test_user@scopevisio.com";
String pass = "test_password";
String language = "de_DE";
String organisation = "Scopevisio Demo AG";

// authorization parameter
String authentication = "";
authentication += "?" + "customer=" + URLEncoder.encode(customer);
authentication += "&" + "user=" + URLEncoder.encode(user);
authentication += "&" + "pass=" + URLEncoder.encode(pass);
authentication += "&" + "language=" + URLEncoder.encode(language);
authentication += "&" + "organisation=" + URLEncoder.encode(organisation);

// args/data parameter
String arguments = "";
arguments += "&" + "account=" + URLEncoder.encode("10008");

// get
url += authentication + arguments;
System.out.println("url: " + url);
HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
conn.setRequestMethod("GET");
conn.setDoInput(true);
int responseCode = conn.getResponseCode();
StringBuilder reply = new StringBuilder();
Reader in = new InputStreamReader(responseCode == HttpURLConnection.HTTP_OK ? conn.getInputStream() : conn.getErrorStream());
try {
char[] buffer = new char[8192];
for (;;) {
int charsRead = in.read(buffer, 0, buffer.length);
if (charsRead < 0)
break;
reply.append(buffer, 0, charsRead);
}
}
finally {
in.close();
}
System.out.println("responseCode: " + responseCode + ", reply: " + reply);
} catch (Exception e) {
// handle error
e.printStackTrace();
}
}
