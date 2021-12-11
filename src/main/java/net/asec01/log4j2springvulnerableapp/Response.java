package net.asec01.log4j2springvulnerableapp;

public class Response {
    String method;
    String payload;

    public Response(String method, String payload) {
        this.method = method;
        this.payload = payload;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
