package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

public class DynamoDbEventRequestHandler
        implements RequestHandler<DynamodbEvent, DynamodbEvent> {

    // Handler that get events from Kinesis
    public DynamodbEvent handleRequest(DynamodbEvent event, Context context) {
        context.getLogger().log("Input event: " + event + " ");
        return event;
    }

    public static void main(String[] args) {
        System.out.println();
    }


}