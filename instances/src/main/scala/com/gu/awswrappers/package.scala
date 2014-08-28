package com.gu

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient

import com.gu.awswrappers.macros.AwsClientWrapper.wrap

package object awswrappers {

  wrap(new AmazonDynamoDBAsyncClient())



}
