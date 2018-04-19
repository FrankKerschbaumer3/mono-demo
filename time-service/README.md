# Timer Service

Unit Tests: ![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiak90c3M4Ukc2Ym90M0lVVmhrYk1mUllZYlFTQTZodUg2NXoxczdqVldPK1hQb2w1N0U4Z1hVZXBnMUR3TFZpYmIyL3krZDQxN25XYzNDaGUwMEZyRWkwPSIsIml2UGFyYW1ldGVyU3BlYyI6IkM2NmQvNmJWb3RQdkxwTlkiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)

## CodeBuild Setup

```
aws codebuild create-project --cli-input-json file://./time-service/cb-unit-test.json
aws codebuild create-webhook --project-name mono-timer-unit-test
```