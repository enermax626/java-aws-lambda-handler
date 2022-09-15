package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class KinesisRequestHandler
        implements RequestHandler<KinesisEvent, KinesisEvent> {


    /*
    To send data to a kinesis stream that is linked as a producer to a lambda function, you can use
    an AWS CLI command:

        aws kinesis put-record \
            --stream-name samplestream \
            --data sampledatarecord \
            --partition-key samplepartitionkey

    */


    // Handler that get events from Kinesis
    public KinesisEvent handleRequest(KinesisEvent event, Context context) {
        context.getLogger().log("Input event: " + event + " ");
        return event;
    }

}