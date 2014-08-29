package com.gu

import com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient
import com.amazonaws.services.cloudformation.AmazonCloudFormationAsyncClient
import com.amazonaws.services.cloudfront.AmazonCloudFrontAsyncClient
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainAsyncClient
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearchAsyncClient
import com.amazonaws.services.cloudtrail.AWSCloudTrailAsyncClient
import com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityAsyncClient
import com.amazonaws.services.cognitosync.AmazonCognitoSyncAsyncClient
import com.amazonaws.services.datapipeline.DataPipelineAsyncClient
import com.amazonaws.services.directconnect.AmazonDirectConnectAsyncClient
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient
import com.amazonaws.services.ec2.AmazonEC2AsyncClient
import com.amazonaws.services.elasticache.AmazonElastiCacheAsyncClient
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalkAsyncClient
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient
import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoderAsyncClient
import com.amazonaws.services.glacier.AmazonGlacierAsyncClient
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient
import com.amazonaws.services.importexport.AmazonImportExportAsyncClient
import com.amazonaws.services.kinesis.AmazonKinesisAsyncClient
import com.amazonaws.services.logs.AWSLogsAsyncClient
import com.amazonaws.services.opsworks.AWSOpsWorksAsyncClient
import com.amazonaws.services.rds.AmazonRDSAsyncClient
import com.amazonaws.services.redshift.AmazonRedshiftAsyncClient
import com.amazonaws.services.route53.AmazonRoute53AsyncClient
import com.amazonaws.services.route53domains.AmazonRoute53DomainsAsyncClient
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient
import com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowAsyncClient
import com.amazonaws.services.sns.AmazonSNSAsyncClient
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import com.amazonaws.services.storagegateway.AWSStorageGatewayAsyncClient
import com.amazonaws.services.support.AWSSupportAsyncClient

import com.gu.awswrappers.macros.AwsClientWrapper.wrap

package object awswrappers {
  implicit def enrichAutoscalingClient(autoscalingClient: AmazonAutoScalingAsyncClient) =
    wrap(autoscalingClient)

  implicit def enrichCloudFormationClient(cloudFormationClient: AmazonCloudFormationAsyncClient) =
    wrap(cloudFormationClient)

  implicit def enrichCloudFrontClient(cloudFrontClient: AmazonCloudFrontAsyncClient) =
    wrap(cloudFrontClient)

  implicit def enrichCloudSearchDomainClient(cloudSearchDomainClient: AmazonCloudSearchDomainAsyncClient) =
    wrap(cloudSearchDomainClient)

  implicit def enrichCloudSearchClient(cloudSearchClient: AmazonCloudSearchAsyncClient) =
    wrap(cloudSearchClient)

  implicit def enrichCloudTrailClient(cloudTrailClient: AWSCloudTrailAsyncClient) =
    wrap(cloudTrailClient)

  implicit def enrichCloudWatchClient(cloudWatchClient: AmazonCloudWatchAsyncClient) =
    wrap(cloudWatchClient)

  implicit def enrichCognitoIdentityClient(cognitoIdentityClient: AmazonCognitoIdentityAsyncClient) =
    wrap(cognitoIdentityClient)

  implicit def enrichCognitoSyncClient(cognitoSyncClient: AmazonCognitoSyncAsyncClient) =
    wrap(cognitoSyncClient)

  implicit def enrichDataPipelineClient(dataPipelineClient: DataPipelineAsyncClient) =
    wrap(dataPipelineClient)

  implicit def enrichDirectConnectClient(directConnectClient: AmazonDirectConnectAsyncClient) =
    wrap(directConnectClient)

  implicit def enrichDynamoDbClient(dynamoDbClient: AmazonDynamoDBAsyncClient) =
    wrap(dynamoDbClient)

  implicit def enrichEc2Client(ec2Client: AmazonEC2AsyncClient) =
    wrap(ec2Client)

  implicit def enrichElasticacheClient(elasticacheClient: AmazonElastiCacheAsyncClient) =
    wrap(elasticacheClient)

  implicit def enrichElasticBeanstalkClient(elasticBeanstalkClient: AWSElasticBeanstalkAsyncClient) =
    wrap(elasticBeanstalkClient)

  implicit def enrichElasticLoadBalancingClient(elasticLoadBalancingClient: AmazonElasticLoadBalancingAsyncClient) =
    wrap(elasticLoadBalancingClient)

  implicit def enrichElasticMapReduceClient(elasticMapReduceClient: AmazonElasticMapReduceAsyncClient) =
    wrap(elasticMapReduceClient)

  implicit def enrichElasticTranscoderClient(elasticTranscoderClient: AmazonElasticTranscoderAsyncClient) =
    wrap(elasticTranscoderClient)

  implicit def enrichGlacierClient(glacierClient: AmazonGlacierAsyncClient) =
    wrap(glacierClient)

  implicit def enrichIdentityManagementClient(identityManagementClient: AmazonIdentityManagementAsyncClient) =
    wrap(identityManagementClient)

  implicit def enrichImportExportClient(importExportClient: AmazonImportExportAsyncClient) =
    wrap(importExportClient)

  implicit def enrichKinesisClient(kinesisClient: AmazonKinesisAsyncClient) =
    wrap(kinesisClient)

  implicit def enrichLogsClient(logsClient: AWSLogsAsyncClient) =
    wrap(logsClient)

  implicit def enrichOpsWorksClient(opsWorksClient: AWSOpsWorksAsyncClient) =
    wrap(opsWorksClient)

  implicit def enrichAmazonRdsAsyncClient(rdsClient: AmazonRDSAsyncClient) =
    wrap(rdsClient)

  implicit def enrichAmazonRedShiftAsyncClient(redShiftClient: AmazonRedshiftAsyncClient) =
    wrap(redShiftClient)

  implicit def enrichRoute53Client(route53Client: AmazonRoute53AsyncClient) =
    wrap(route53Client)

  implicit def enrichRoute53DomainsClient(route53DomainsClient: AmazonRoute53DomainsAsyncClient) =
    wrap(route53DomainsClient)

  implicit def enrichSecurityTokenClient(securityTokenClient: AWSSecurityTokenServiceAsyncClient) =
    wrap(securityTokenClient)

  implicit def enrichSimpleDbClient(simpleDbClient: AmazonSimpleDBAsyncClient) =
    wrap(simpleDbClient)

  implicit def enrichSimpleEmailClient(simpleEmailClient: AmazonSimpleEmailServiceAsyncClient) =
    wrap(simpleEmailClient)

  implicit def enrichSimpleWorkFlowClient(simpleWorkFlowClient: AmazonSimpleWorkflowAsyncClient) =
    wrap(simpleWorkFlowClient)

  implicit def enrichSqsClient(sqsClient: AmazonSQSAsyncClient) =
    wrap(sqsClient)

  implicit def enrichSnsClient(snsClient: AmazonSNSAsyncClient) =
    wrap(snsClient)

  implicit def enrichStorageGatewayClient(storageGatewayClient: AWSStorageGatewayAsyncClient) =
    wrap(storageGatewayClient)

  implicit def enrichSupportclient(supportClient: AWSSupportAsyncClient) =
    wrap(supportClient)
}
