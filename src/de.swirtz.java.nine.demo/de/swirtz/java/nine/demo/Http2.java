package de.swirtz.java.nine.demo;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;

public class Http2 {
    private static final SSLParameters SSL_PARAMS = new SSLParameters(new String[]{"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA"}, new String[]{"TLSv1.2"});

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, null, new SecureRandom());


        HttpClient client = HttpClient.newBuilder()
                .sslContext(sslContext)
                .sslParameters(SSL_PARAMS)
                .build();

        HttpRequest req = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .header("User-Agent", "Java")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> resp = client.sendAsync(req, HttpResponse.BodyHandler.asString());
        resp.thenAccept(r -> System.out.println(r.body()));
        resp.join();
    }
}
