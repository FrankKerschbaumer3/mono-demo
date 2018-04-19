# Hello Service

Unit Tests: ![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiLzB3NzJvOUdvcVdPd1FUM0lJTjFBMC9xcDlxa2tINE9JWmxLTFVjdG50NU5ackQyMVpqMnhyci9yYzRMM1d5dUtlSWxVS3dhbEJkYk5xaUZNZ3BaWUxRPSIsIml2UGFyYW1ldGVyU3BlYyI6ImZ6YklpQ2dNSlRWOHZOZngiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)

## CodeBuild Setup for Unit Tests

```
aws codebuild create-project --cli-input-json file://./hello-service/cb-unit-test.json
aws codebuild create-webhook --project-name mono-hello-unit-test
```

WebHook needs to be changed to just send Pull Request events
