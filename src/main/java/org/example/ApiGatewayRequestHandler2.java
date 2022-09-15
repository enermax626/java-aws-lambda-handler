package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class ApiGatewayRequestHandler2
        implements RequestHandler<Map<String, Object>, APIGatewayProxyResponseEvent> {


    // Request handler to send response to synchronous calls
    public APIGatewayProxyResponseEvent handleRequest(Map<String, Object> input, Context context) {
        context.getLogger().log("Input keys: " + input);
        APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
        apiGatewayProxyResponseEvent.setStatusCode(200);
        apiGatewayProxyResponseEvent.setIsBase64Encoded(false);
        apiGatewayProxyResponseEvent.setBody("{ \"name\": \"murilo\", \"age\": 35}");

        context.getLogger().log("### RESPONSE: " + apiGatewayProxyResponseEvent);
        return apiGatewayProxyResponseEvent;
    }

}