package com.gu

import com.amazonaws.services.kinesis.AmazonKinesisAsyncClient
import com.amazonaws.services.sns.AmazonSNSAsyncClient
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient

import com.gu.awswrappers.macros.AwsClientWrapper.wrap

package object awswrappers {
  implicit def enrichDynamoDbClient(dynamoDbClient: AmazonDynamoDBAsyncClient) =
    wrap(dynamoDbClient)

  implicit def enrichSqsClient(sqsClient: AmazonSQSAsyncClient) =
    wrap(sqsClient)

  implicit def enrichSnsClient(snsClient: AmazonSNSAsyncClient) =
    wrap(snsClient)

  implicit def enrichKinesisClient(kinesisClient: AmazonKinesisAsyncClient) =
    wrap(kinesisClient)
}
