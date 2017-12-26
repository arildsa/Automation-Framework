#!/usr/bin/env bash
TEST_TASK=${TEST_TASK:='clean testMulti testSingle testRestApi --max-workers=8'}
gradle $TEST_TASK