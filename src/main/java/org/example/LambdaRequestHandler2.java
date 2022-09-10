package org.example;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class LambdaRequestHandler2
        implements RequestHandler<Map<String, Object>, LambdaRequestHandler2.ResponseLambda> {


    // Request handler to send response to synchronous calls
    public ResponseLambda handleRequest(Map<String, Object> input, Context context) {
        context.getLogger().log("Input keys: " + input);

        ResponseLambda my_body_message = new ResponseLambda(201L, "My body message", "200 is ok", false);
        return my_body_message;
    }

    public static class ResponseLambda implements Serializable {

        private Long statusCode;

        private String statusDescription;

        private Boolean isBase64Encoded;

        private Map<String, String> headers;

        private String body;

        ResponseLambda(Long status, String body, String statusDescription, Boolean isBase64Encoded) {
            this.statusCode = status;
            this.statusDescription = statusDescription;
            this.isBase64Encoded = isBase64Encoded;
            this.body = body;
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("Content-Type", "text/html");
            this.headers = stringStringHashMap;
        }

        public Long getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Long statusCode) {
            this.statusCode = statusCode;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getStatusDescription() {
            return statusDescription;
        }

        public void setStatusDescription(String statusDescription) {
            this.statusDescription = statusDescription;
        }

        public Boolean getBase64Encoded() {
            return isBase64Encoded;
        }

        public void setBase64Encoded(Boolean base64Encoded) {
            isBase64Encoded = base64Encoded;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }
    }
}