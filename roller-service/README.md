# Roller Service

Unit Tests: ![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiclFrOE8wT3A2UlVSU2swcVVKTUZsT2RyV2hmWUVkTjB0WGRFU3NGOGJFMFFqK3NESUh2QW8rMlRKQUU4OFY1dWVmWjVyUkpMTkZRSmVoVTJCRXI4b000PSIsIml2UGFyYW1ldGVyU3BlYyI6IjZRSEVobm43T3lRZURvYUIiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)

## CodeBuild Setup

```
aws codebuild create-project --cli-input-json file://./hello-service/cb-unit-test.json
aws codebuild create-webhook --project-name mono-hello-unit-test
```