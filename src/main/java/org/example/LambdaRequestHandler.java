package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class LambdaRequestHandler
        implements RequestHandler<SQSEvent, SQSEvent> {


    // Asynchronous handler that sends a response to a new SQS queue
    public SQSEvent handleRequest(SQSEvent event, Context context) {
        context.getLogger().log("Input event: " + event + " ");
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setQueueUrl("https://sqs.us-east-2.amazonaws.com/309281412191/aws-cert-SNS-notification-from-ALARM-instanceEC2");
        sendMessageRequest.setMessageBody(event.getRecords().get(0).getBody());
        amazonSQS.sendMessage(sendMessageRequest);
        return event;
    }

}