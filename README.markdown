AWS SDK Scala Wrappers
======================

Provides wrapper classes for the asynchronous clients in the AWS Java
SDK. These provide extra methods that return Scala futures (rather than having
to provide your own callbacks in the `AsyncHandler`).

## Adding as a dependency in SBT

```scala
libraryDependencies += "com.gu" %% "aws-sdk-scala-wrappers" % "0.1"
```

## Usage

Anywhere you're using an asynchronous AWS client, import
`com.gu.awswrappers._`. An implicit class will now be available that wraps the
client and provides extra methods that return Scala futures.
